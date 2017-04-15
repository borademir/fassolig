package org.borademir.passolig.faces.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.borademir.passolig.faces.AbsFacesBean;
import org.borademir.passolig.json.model.GetAllFixturesForSeriesResult;
import org.borademir.passolig.json.model.GetFixtureResult;
import org.borademir.passolig.json.model.Product;
import org.borademir.passolig.json.model.ProductBlocksResult_;
import org.borademir.passolig.util.FixtureUtilGsonImpl;
import org.primefaces.component.progressbar.ProgressBar;

@ManagedBean(name="fixtureBean")
@ViewScoped
public class FixtureFacesBean extends AbsFacesBean{

	private static final long serialVersionUID = 1L;
	
//	@ManagedProperty("#{param.fixtureId}")
	private String fixtureId;
	
	private List<GetAllFixturesForSeriesResult> allFixtureList = null;
	
	private List<GetFixtureResult> allFixtureDetails = null;
	
	private GetAllFixturesForSeriesResult selectedFixture = null;
	
	private Product selectedProduct = null;
	
	private List<ProductBlocksResult_> selectedProductBlockList = null;
	
	private ProductBlocksResult_ selectedProductBlock = null;

	private List<List<Integer>> selectedBlockClasses = null;
	
	private List<String> emptyBlockList = null;
	
	private int ocupancyPercentage = 0;
	
	private boolean processEmptyBlocks = false;
	
	@PostConstruct
	public void initializePage() {
		processRequestParameters();
		loadFixtures();
	}

	private void loadFixtures() {
		try {
			allFixtureList = FixtureUtilGsonImpl.retrieveAllFixture();
			allFixtureDetails = new ArrayList<GetFixtureResult>();
			if(allFixtureList != null){
				boolean filterFixtureIdExists = fixtureId !=null;
				GetAllFixturesForSeriesResult filteredFixture = null;
				for(GetAllFixturesForSeriesResult fixture : allFixtureList){
					if(filterFixtureIdExists){
						if(!fixtureId.equals(fixture.getId())){
							System.out.println(fixture.getId());
							continue;
						}
					}
					
					if(filterFixtureIdExists){
						filteredFixture = fixture;
						allFixtureDetails.clear();
					}
					GetFixtureResult retrieveFixtureDetail = FixtureUtilGsonImpl.retrieveFixtureDetail(fixture.getId());
					if(retrieveFixtureDetail != null){
						allFixtureDetails.add(retrieveFixtureDetail);
					}
					
					if(filterFixtureIdExists){
						break;
					}
				}
				
				if(filterFixtureIdExists){
					allFixtureList.clear();
					allFixtureList.add(filteredFixture);
				}
			}
		} catch (IOException e) {
		}
	}
	
	private void processRequestParameters() {
		fixtureId = getRequestParam("fixtureId");
	}

	@Override
	public void clearPageValues() {
		this.allFixtureList.clear();
		fixtureId = null;
		allFixtureList = null;
		allFixtureDetails = null;
		selectedFixture = null;
		selectedProduct = null;
		selectedProductBlockList = null;
		selectedProductBlock = null;
		selectedBlockClasses = null;
	}
	
	
	public void showBlocksOfFixtureProduct(){
		if(selectedProduct != null && selectedFixture != null){
			try {
				selectedProductBlockList = FixtureUtilGsonImpl.productBlocks(selectedProduct.getId(), selectedFixture.getId(), selectedFixture.getOrganisation());
				updateComponent("pgBlocks" + selectedFixture.getId());
				addInfoMessage(null, selectedProductBlockList.size() + " adet blok var.");
			} catch (Exception e) {
				addErrorMessage(null, "Bloklar getirilirken hata oluştu(" + selectedFixture.getName() + ":" + selectedProduct.getName() +"):" + e.getMessage());
			}
			
		}else{
			addErrorMessage(null, "Fixtur/Product seçilemedi.");
		}
	}
	
	public void showBlockClasses(){
		if(selectedProduct != null && selectedFixture != null && selectedProductBlock !=null){
			try {
				selectedBlockClasses = FixtureUtilGsonImpl.blockData(selectedFixture.getId(), selectedProduct.getId(), selectedProductBlock.getId(), selectedFixture.getOrganisation());
				Collections.reverse(selectedBlockClasses);
			} catch (Exception e) {
				addErrorMessage(null, "Bloklar oturma planı getirilirken hata oluştu(" + selectedFixture.getName() + ":" + selectedProduct.getName() + ":" + selectedProductBlock.getName() +"):" + e.getMessage());
			}
		}else{
			addErrorMessage(null, "Fixtur/Product/Block seçilemedi.");
		}
	}
	
	public void calculateStaduiumOcupancy(){
		if(selectedFixture != null){
			GetFixtureResult fixtureDetail = getFixtureDetail(selectedFixture.getId());
			if(fixtureDetail != null && fixtureDetail.getProducts() != null){
				int inUse = 0;
				int available = 0;
				for(Product product : fixtureDetail.getProducts()){
					try {
						List<ProductBlocksResult_> productBlocks = FixtureUtilGsonImpl.productBlocks(product.getId(), fixtureDetail.getId(), fixtureDetail.getOrganisation());
						if(productBlocks != null){
							for(ProductBlocksResult_ productBlock : productBlocks){
								int blockAvailable = 0;
								List<List<Integer>> blockData = FixtureUtilGsonImpl.blockData(fixtureDetail.getId(), product.getId(), productBlock.getId(), fixtureDetail.getOrganisation());
								if(blockData != null){
									for(List<Integer> classes : blockData){
										for(Integer status : classes){
											if(status == null || status.intValue() == 0){
												continue;
											}
											if(status.intValue() == 3){
												available++;
												blockAvailable++;
											}else{
												inUse++;
											}
										}
									}
								}else{
									addErrorMessage(null, "Blok bilgilerine ulaşamadık");
									return;
								}
								
								if(blockAvailable > 0 && emptyBlockList != null){
									emptyBlockList.add(product.getName() + " / " + productBlock.getName() + " ( " + blockAvailable + " boş koltuk)");
								}
							}
						}else{
							addErrorMessage(null, "Ürün bilgilerine ulaşamadık");
							return;
						}
					} catch (Exception e) {e.printStackTrace();
						addErrorMessage(null, "Hesaplayamadık :(");
						return;
					}
				}
				if(!processEmptyBlocks){
					ocupancyPercentage = (inUse*100) / (inUse+available);
					openDialog("staduiumOcupancyDialog");
					addInfoMessage(null, "Toplam " + inUse + " adet koltuk dolu ve " + available + " adet koltuk boş görünmektedir.");
				}
			}
		}
	}
	
	public void showEmptyBlocks(){
		emptyBlockList = new ArrayList<String>();
		processEmptyBlocks = true;
		calculateStaduiumOcupancy();
		updateComponent(":passoForm:emptyBlocks");
		openDialog("emptyBlocksDialog");
		processEmptyBlocks = false;
	}
	
	public String homeAction(){
		clearPageValues();
		loadFixtures();
		return "pretty:fixtures";
	}
	
	public String gotoFixture(String pFixtureId){
		this.fixtureId = pFixtureId;
		return "pretty:fixture";
	}
	public GetFixtureResult getFixtureDetail(String pFixtureId){
		for(GetFixtureResult fixtureDetail : allFixtureDetails){
			if(pFixtureId.equals(fixtureDetail.getId())){
				return fixtureDetail;
			}
		}
		return new GetFixtureResult();
	}
	
	public String getSelectedStadiumImageLocation(){
		String imageLocation = "https://www.passo.com.tr/handler/crmImage.ashx?id="+selectedFixture.getId()+"&name=venue_image&c=transparent&org="+selectedFixture.getOrganisation();
		return "<img src=\""+ imageLocation +"\"></img>";
	}
	
	
	public List<GetAllFixturesForSeriesResult> getAllFixtureList() {
		return allFixtureList;
	}

	public GetAllFixturesForSeriesResult getSelectedFixture() {
		return selectedFixture;
	}

	public void setSelectedFixture(GetAllFixturesForSeriesResult selectedFixture) {
		this.selectedFixture = selectedFixture;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public List<ProductBlocksResult_> getSelectedProductBlockList() {
		return selectedProductBlockList;
	}

	public void setSelectedProductBlockList(
			List<ProductBlocksResult_> selectedProductBlockList) {
		this.selectedProductBlockList = selectedProductBlockList;
	}

	public String getFixtureId() {
		return fixtureId;
	}

	public void setFixtureId(String fixtureId) {
		this.fixtureId = fixtureId;
	}

	public ProductBlocksResult_ getSelectedProductBlock() {
		return selectedProductBlock;
	}

	public void setSelectedProductBlock(ProductBlocksResult_ selectedProductBlock) {
		this.selectedProductBlock = selectedProductBlock;
	}

	public List<List<Integer>> getSelectedBlockClasses() {
		return selectedBlockClasses;
	}

	public void setSelectedBlockClasses(List<List<Integer>> selectedBlockClasses) {
		this.selectedBlockClasses = selectedBlockClasses;
	}

	public int getOcupancyPercentage() {
		return ocupancyPercentage;
	}

	public void setOcupancyPercentage(int ocupancyPercentage) {
		this.ocupancyPercentage = ocupancyPercentage;
	}

	public List<String> getEmptyBlockList() {
		return emptyBlockList;
	}

	public void setEmptyBlockList(List<String> emptyBlockList) {
		this.emptyBlockList = emptyBlockList;
	}
	
}
