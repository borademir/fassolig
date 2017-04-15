package org.borademir.passolig.util;

import java.io.IOException;
import java.util.List;

import org.borademir.passolig.json.model.AllFixtureResponseJson;
import org.borademir.passolig.json.model.BlockDataResultResponse;
import org.borademir.passolig.json.model.GetAllFixturesForSeriesResult;
import org.borademir.passolig.json.model.GetFixture;
import org.borademir.passolig.json.model.GetFixtureResult;
import org.borademir.passolig.json.model.Info;
import org.borademir.passolig.json.model.PrioritySalesProvidersInfo;
import org.borademir.passolig.json.model.Product;
import org.borademir.passolig.json.model.ProductBlocksResult;
import org.borademir.passolig.json.model.ProductBlocksResult_;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;

public class FixtureUtilGsonImpl {
	
	private static final String ALL_FIXTURE_URL 		= "https://www.passo.com.tr/services/AktifBankService.svc/GetAllFixturesForSeries?seriesId=00000000-0000-0000-0000-000000000000";
	private static final String FIXTURE_DETAIL_URL 		= "https://www.passo.com.tr/services/AktifBankService.svc/GetFixture?fixtureId=";
	
	static int bosKoltukSayisi = 0;

	public static void main(String[] args) throws IOException {
		retrieveAllFixture();
		System.out.println("Toplam bos koltuk sayisi" + bosKoltukSayisi);
		
	}


	public static List<List<Integer>> blockData(String pFixtureId, String pProducId, String pBlockId, String pOrganization) throws IOException {
		String postData = "{\"productIdRef\":\""+pProducId+"\",\"blockId\":\""+pBlockId+"\",\"fixtureIdRef\":\""+pFixtureId+"\",\"seriesIdRef\":\"00000000-0000-0000-0000-000000000000\",\"bookingIdRef\":\"\"}";
		Document post = Jsoup.connect("https://www.passo.com.tr/services/TicketingService.svc/BlockData").
			data(postData,"").ignoreContentType(true).
			requestBody(postData).
			header("X-Requested-With","XMLHttpRequest").
			header("X-TS-AJAX-Request","true").
			header("Accept","application/json, text/javascript, */*; q=0.01").
			header("Content-type","application/json").
			header("Referer","https://www.passo.com.tr/tr/clubs/"+pOrganization+"/ticket.aspx?fixture=" + pFixtureId).post();
			
			Gson gson = new Gson();
			System.out.println("Block Classes:" + post.body().text());
			BlockDataResultResponse blockDataResult = gson.fromJson(post.body().text(), BlockDataResultResponse.class);
			
			List<List<Integer>> classes = blockDataResult.getBlockDataResult().getClasses();
			
			return classes;
			
	}
	
	
	public static List<ProductBlocksResult_> productBlocks(String pProductId,String pFixtureId, String pOrganization) throws IOException {
		String postData = "{\"productIdRef\":\""+pProductId+"\",\"fixtureIdRef\":\""+pFixtureId+"\",\"seriesIdRef\":\"00000000-0000-0000-0000-000000000000\"}";
		Document post = Jsoup.connect("https://www.passo.com.tr/services/TicketingService.svc/ProductBlocks").
			data(postData,"").ignoreContentType(true).
			requestBody(postData).//header("Mime Type", "application/json").
			header("X-Requested-With","XMLHttpRequest").
			header("X-TS-AJAX-Request","true").
			header("Accept","application/json, text/javascript, */*; q=0.01").
			header("Content-type","application/json").
			header("Referer","https://www.passo.com.tr/tr/clubs/"+pOrganization+"/ticket.aspx?fixture=" + pFixtureId).post();
		System.out.println(post.body().text());
		
		Gson gson = new Gson();
		
		ProductBlocksResult productBlocks = gson.fromJson(post.body().text(), ProductBlocksResult.class);
		
		return productBlocks.getProductBlocksResult();
		
	}
	
	
	public static List<GetAllFixturesForSeriesResult> retrieveAllFixture() throws IOException {
		String jsonResponse = Jsoup.connect(ALL_FIXTURE_URL).ignoreContentType(true).execute().body();
		Gson gson = new Gson();
		AllFixtureResponseJson allFixturesForSeriesResult = gson.fromJson(jsonResponse, AllFixtureResponseJson.class);
		if(allFixturesForSeriesResult != null && allFixturesForSeriesResult.getGetAllFixturesForSeriesResult() != null && allFixturesForSeriesResult.getGetAllFixturesForSeriesResult().size() > 0) {
			for(GetAllFixturesForSeriesResult fixture : allFixturesForSeriesResult.getGetAllFixturesForSeriesResult()){
				System.out.println(fixture.getName() + " / " + fixture.getVenueName());
			}
		}
		return allFixturesForSeriesResult.getGetAllFixturesForSeriesResult();
	}
	
	public static GetFixtureResult retrieveFixtureDetail(String fixtureId) throws IOException {
		try {
			String jsonResponse = Jsoup.connect(FIXTURE_DETAIL_URL + fixtureId).ignoreContentType(true).execute().body();
			Gson gson = new Gson();
			GetFixture getFixture = gson.fromJson(jsonResponse, GetFixture.class);
			if(getFixture != null && getFixture.getGetFixtureResult() != null){
				parsePrioritySalesInfo(getFixture.getGetFixtureResult());
			}
			return getFixture.getGetFixtureResult();
		} catch (Exception e) {
			System.out.println(FIXTURE_DETAIL_URL + fixtureId + " " + e.getMessage());
		}
		
		return null;
	}
	
	private static void parsePrioritySalesInfo(GetFixtureResult getFixtureResult) {
		if(getFixtureResult.getPrioritySalesProvidersInfo() != null && getFixtureResult.getPrioritySalesProvidersInfo().size() > 0){
			for(PrioritySalesProvidersInfo provider : getFixtureResult.getPrioritySalesProvidersInfo()){
				Info providerInfo = provider.getInfo();
				String name = providerInfo.getName();
				String caption = providerInfo.getCaption();
				System.out.println("      " + name + "(" + caption + ")");
			}
		}else{
			System.out.println("      Biletler herkese açık.");
		}
	}

	public static void parseProductsOfFixture(GetFixtureResult getFixtureResult, String pFixtureId, String pOrganization) throws IOException {
		if(getFixtureResult.getProducts() == null || getFixtureResult.getProducts().size() == 0) {
			System.out.println("Products kalmamiş.");
			return;
		}
		
		for(Product product : getFixtureResult.getProducts()){
			System.out.println("      " + product.getName() + "(" + product.getId() + ")" + " MaxPrice:" + product.getMaxPrice());
			productBlocks( product.getId(), pFixtureId,pOrganization);
		}
	}

}
