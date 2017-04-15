package org.borademir.passolig.util;

import java.io.IOException;

import org.borademir.passolig.json.model.AllFixtureResponseJson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;

public class FixtureUtil {
	
	private static final String ALL_FIXTURE_URL 		= "https://www.passo.com.tr/services/AktifBankService.svc/GetAllFixturesForSeries?seriesId=00000000-0000-0000-0000-000000000000";
	private static final String FIXTURE_DETAIL_URL 		= "https://www.passo.com.tr/services/AktifBankService.svc/GetFixture?fixtureId=";
	
	static int bosKoltukSayisi = 0;

	public static void main(String[] args) throws IOException {
		retrieveAllFixture();
		
		System.out.println("Toplam bos koltuk sayisi" + bosKoltukSayisi);
		
	}


	private static int blockData(String pFixtureId, String pProducId, String pBlockId, String pOrganization) throws IOException {
		String postData = "{\"productIdRef\":\""+pProducId+"\",\"blockId\":\""+pBlockId+"\",\"fixtureIdRef\":\""+pFixtureId+"\",\"seriesIdRef\":\"00000000-0000-0000-0000-000000000000\",\"bookingIdRef\":\"\"}";
		Document post = Jsoup.connect("https://www.passo.com.tr/services/TicketingService.svc/BlockData").
			data(postData,"").ignoreContentType(true).
			requestBody(postData).//header("Mime Type", "application/json").
			header("X-Requested-With","XMLHttpRequest").
			header("X-TS-AJAX-Request","true").
			header("Accept","application/json, text/javascript, */*; q=0.01").
			header("Content-type","application/json").
			header("Referer","https://www.passo.com.tr/tr/clubs/"+pOrganization+"/ticket.aspx?fixture=" + pFixtureId).post();
			
//			System.out.println("          " + post.body().text());
			
			JSONObject blockJson = new JSONObject(post.body().text()).getJSONObject("BlockDataResult");
			
			JSONArray classArr = blockJson.getJSONArray("classes");
//			System.out.println("           " + post.body().text());
			int available = 0;
			for(int i=classArr.length()-1;i>=0;i--){
				JSONArray classJsonArr = 	(JSONArray) classArr.get(i);
				System.out.print("           ");
				for(int j=0;j<classJsonArr.length();j++){
					Integer val =  classJsonArr.getInt(j);
					System.out.print((val == 0 ? " " : val)+"  ");
					if(val == 3){
						available++;
					}
				}
				System.out.println();

			}
			
//			System.exit(1);
			
			return available;
	}
	
	
	private static void productBlocks(String pProductId,String pFixtureId, String pOrganization) throws IOException {
		String postData = "{\"productIdRef\":\""+pProductId+"\",\"fixtureIdRef\":\""+pFixtureId+"\",\"seriesIdRef\":\"00000000-0000-0000-0000-000000000000\"}";
		Document post = Jsoup.connect("https://www.passo.com.tr/services/TicketingService.svc/ProductBlocks").
			data(postData,"").ignoreContentType(true).
			requestBody(postData).//header("Mime Type", "application/json").
			header("X-Requested-With","XMLHttpRequest").
			header("X-TS-AJAX-Request","true").
			header("Accept","application/json, text/javascript, */*; q=0.01").
			header("Content-type","application/json").
			header("Referer","https://www.passo.com.tr/tr/clubs/"+pOrganization+"/ticket.aspx?fixture=" + pFixtureId).post();
		System.out.println(postData);
		JSONArray productBlocks = new JSONObject(post.body().text()).getJSONArray("ProductBlocksResult");
		for(int i=0;i<productBlocks.length();i++){
			JSONObject productBlock = (JSONObject) productBlocks.get(i);
//			if(!"MARATON ÜST H BLOK".equals(productBlock.getString("Name"))){
//				continue;
//			}
			if(!productBlock.getBoolean("Seated")){
				System.out.println();
			}
			System.out.println("         " + productBlock.getString("Name") + "(" + productBlock.getString("Id") + ")" + " Available:" + productBlock.getInt("Available"));
			int totoalAvailable = productBlock.getInt("Available");
			totoalAvailable = blockData(pFixtureId, pProductId, productBlock.getString("Id"),pOrganization);
			System.out.println("           Calculated Seat Count:" + totoalAvailable);
//			
			bosKoltukSayisi = bosKoltukSayisi + totoalAvailable;
		}
		
	}
	
	
	private static void retrieveAllFixture() throws IOException {
		String jsonResponse = Jsoup.connect(ALL_FIXTURE_URL).ignoreContentType(true).execute().body();
		
		Gson gson = new Gson();
		AllFixtureResponseJson allFixturesForSeriesResult = gson.fromJson(jsonResponse, AllFixtureResponseJson.class);
		JSONObject jsonResponseObject = new JSONObject(jsonResponse);
		JSONArray allFixtureJsonArray = jsonResponseObject.getJSONArray("GetAllFixturesForSeriesResult");
		if(allFixtureJsonArray != null) {
			for(int i=0;i<allFixtureJsonArray.length();i++){
				JSONObject fixtureJsonObject = (JSONObject) allFixtureJsonArray.get(i);
				if(fixtureJsonObject.getString("Name").contains("ÇAYKUR RİZESPOR A.Ş. - FENERBAHÇE A.Ş.")) {// - BEŞİKTAŞ"
					System.out.println(fixtureJsonObject.getString("Name") + " / " + fixtureJsonObject.getString("VenueName"));
					retrieveFixtureDetail(fixtureJsonObject.getString("Id"));
				}

			}
		}
	}
	
	
	private static void retrieveFixtureDetail(String fixtureId) throws IOException {
		try {
//			System.out.println("Fixture id :"+ fixtureId);
			String jsonResponse = Jsoup.connect(FIXTURE_DETAIL_URL + fixtureId).ignoreContentType(true).execute().body();
			JSONObject jsonResponseObject = new JSONObject(jsonResponse);
			if(!jsonResponseObject.isNull("GetFixtureResult")){
				JSONObject fixtureResultJsonObject = jsonResponseObject.getJSONObject("GetFixtureResult");
//				System.out.println(fixtureResultJsonObject.toString());
				parsePrioritySalesInfo(fixtureResultJsonObject);
				parseProductsOfFixture(fixtureResultJsonObject,fixtureId,fixtureResultJsonObject.getString("Organisation"));
			}
		} catch (Exception e) {
			System.out.println(FIXTURE_DETAIL_URL + fixtureId + " " + e.getMessage());
		}
	}

	private static void parseProductsOfFixture(JSONObject fixtureResultJsonObject, String pFixtureId, String pOrganization) throws IOException {
		if(fixtureResultJsonObject.isNull("Products")) {
			System.out.println("Products kalmamiş.");
			return;
		}
		JSONArray productssJsonArray = fixtureResultJsonObject.getJSONArray("Products");
		
		for(int i=0;i<productssJsonArray.length();i++){
			JSONObject productJsonObject = (JSONObject) productssJsonArray.get(i);
//			if(!"MARATON ÜST H BLOK".equals(productJsonObject.getString("Name"))){
//				continue;
//			}
			System.out.println("      " + productJsonObject.getString("Name") + "(" + productJsonObject.getString("Id") + ")" + " MaxPrice:" + productJsonObject.getDouble("MaxPrice"));
			
			productBlocks( productJsonObject.getString("Id"), pFixtureId,pOrganization);
		}
	}

	private static void parsePrioritySalesInfo(JSONObject fixtureResultJsonObject) {
		JSONArray salesProviderInfoArray = fixtureResultJsonObject.getJSONArray("PrioritySalesProvidersInfo");
		if(salesProviderInfoArray != null && salesProviderInfoArray.length() > 0){
			for(int i=0;i<salesProviderInfoArray.length();i++){
				JSONObject provider = (JSONObject) salesProviderInfoArray.get(i);
				JSONObject providerInfo = provider.getJSONObject("Info");
				String name = providerInfo.getString("Name");
				String caption = providerInfo.getString("Caption");
				System.out.println("      " + name + "(" + caption + ")");
			}
		}else{
			System.out.println("      Biletler herkese açık.");
		}
	}
	
//	private static void parseBlocks(JSONObject fixtureResultJsonObject) throws IOException {
//	if(fixtureResultJsonObject.isNull("Blocks")) {
//		System.out.println("Blok kalmamiş.");
//		return;
//	}
//	JSONArray blocksJsonArray = fixtureResultJsonObject.getJSONArray("Blocks");
//	
//	for(int i=0;i<blocksJsonArray.length();i++){
//		JSONObject blockJsonObject = (JSONObject) blocksJsonArray.get(i);
//		if(!"MARATON ÜST H BLOK".equals(blockJsonObject.getString("Name"))){
//			continue;
//		}
//		System.out.println("      " + blockJsonObject.getString("Name") + "(" + blockJsonObject.getString("Id") + ")" + " Seated:" + blockJsonObject.getBoolean("Seated"));
////		blockData(blockJsonObject.getString("Id"));
//	}
//}

}
