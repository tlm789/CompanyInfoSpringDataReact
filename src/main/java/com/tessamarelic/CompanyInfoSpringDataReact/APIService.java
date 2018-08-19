package com.tessamarelic.CompanyInfoSpringDataReact;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;




@Component
public class APIService {
	
	//private URL url;
	//private HttpURLConnection con;
	
	@Autowired
	private StockListRepository repo;
	
	@Autowired
	private CompanyInfoService companyService;
	
	@Autowired
	private StockListRepoService stockListService;
	
	
	//private StockList stockList;
	
	public APIService() {
		
	}
	
		public String findWikiInfo(String name) {
			String endpoint = "https://en.wikipedia.org/api/rest_v1/page/summary/"+name;
			String wiki ="";
			ArrayList<String> newWiki = new ArrayList<String>() ;
			StringBuffer response = new StringBuffer();
			JSONObject wikiObj = new JSONObject();
			JSONParser parser = new JSONParser();
			
			
			try {
				URL url = new URL(endpoint);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				int responseCode = con.getResponseCode();
				
				if (responseCode == HttpURLConnection.HTTP_OK) { // success
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					//char readInput[];
					//in.read(readInput);
					Object obj = parser.parse(in.readLine());

		            JSONObject jsonObject = (JSONObject) obj;
		            System.out.println("this is the jsonObject "+jsonObject);
		           
		          
		           wiki = (String) jsonObject.get("extract");
		           				
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
						newWiki.add(inputLine);
					}
				
					in.close();

					// print result
					System.out.println("wiki is "+ wiki);
				} else {
					System.out.println("GET request not worked");
				}	
				
				//wiki = response.toString();
			}
			
			catch(IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			return wiki;	
					
		}
		
		
		
		//public ArrayList<StockData> getStockData(String name){
		public List<StockList> getStockDataCodes(String name){
			System.out.println("in getStockData");
			JSONObject jsonObject = new JSONObject();
			System.out.println("about to load stocks");
			List<StockList> stockCodes = null;
			//List<StockList> stockcodes = getStockCodes(name);
			stockCodes = this.stockListService.findByNameContaining(name);	
			for(StockList s: stockCodes)
			System.out.println(s.getName()+" " +s.getSymbol()+" "+ s.getCurrency());
			//now connect to worldtrade endpoint and return the jsonobject
			return stockCodes;	
		}
		
		public CompanyInformation getStockData(String code, CompanyInformation compInfo) {
			JSONObject stocks = new JSONObject();
			JSONParser parser = new JSONParser();
			JSONArray st = new JSONArray();
			String endpoint = "https://www.worldtradingdata.com/api/v1/history?symbol="+code+"&sort=newest&date_from=2013-01-01&api_token=VmOBMNET2yGQC66i6vVFsu88vhLSj9rLk9kOZDaaIXUUMBvRxDnApmvzA44v";
			
			
			/*try {
			URL url = new URL(endpoint);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			
			if (responseCode == HttpsURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				String result = "";
				
				while((inputLine = in.readLine()) != null) {
					result+=inputLine;
					
				}
				
				st.add(result);		
				in.close();
				stocks.put("stocks",st.get(0));	
				compInfo.setStock(stocks);
				//JSONObject json = (JSONObject) parser.parse(st.get(0).toString());
				System.out.println("the jsn object is " +stocks);
			} else {
				System.out.println("GET request not worked");
				throw new RuntimeException("HttpResponseCode: " + responseCode);
				
			}	
			
			}catch(IOException e) {
				e.printStackTrace();
			} /*catch (ParseException e) {
				e.printStackTrace();
			}*/
			/*RestTemplate restTemplate = new RestTemplate();
			StockData stocks1 = restTemplate.getForObject(endpoint, StockData.class);
			System.out.println("the stocks are "+ stocks1.getName() + " "+ stocks1.getHistory());
			
			
			try {
				URL url = new URL(endpoint);
				HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				int responseCode = con.getResponseCode();
				
				if (responseCode == HttpsURLConnection.HTTP_OK) { // success
					InputStream in = con.getInputStream();
					JsonReader rdr = Json.createReader(in);
					JsonObject obj = rdr.readObject();
					//String name = obj.getString("name");
					//List temp = (List) obj.get("history");
					//String date = (String) temp.get(0);
					//Map<String,Long>stockData = new HashMap<String,Long>();
					//stockData.put(temp.get(0). value)
					
					
					System.out.println("stockdata json object read in name" + obj.get("name") + "history"+ obj.get("history"));
					//compInfo.setStock(obj);
					System.out.println("compInfo stocks are "+ compInfo.getStock());
					in.close();
				}else {
					System.out.println("GET request not worked");
					throw new RuntimeException("HttpResponseCode: " + responseCode);
				}
			}catch(IOException e){
				e.printStackTrace();
			}*/
			
			return compInfo;
		}
		
		public String findFinancialData(String name){
			String data = "test data";
			return data;				
		}
		
		public String findLocation(String name){
			String location = "test location";
			return location;
					
		}
		
		public String findCEO(String name){
			String CEO = "test ceo";
			return CEO;
					
		}
		
		public ArrayList<String> findReviews(String name){
			ArrayList<String> reviews = new ArrayList<String>();
			reviews.add("test review - bad company");
			reviews.add("test review -good company");
			return reviews;
					
		}
		
		//get request in case world Trade data makes an endpoint to retrieve company stock codes
		public String encodeURLQueryString(String query) {
			
			String encodedQuery = null;
			try {
			    encodedQuery = URLEncoder.encode(query, "UTF-8").replace("+", "%20");
			} catch (UnsupportedEncodingException ignored) {
			    // Can be safely ignored because UTF-8 is always supported
			}
			System.out.println("the encodedQuery is " +encodedQuery);
			return encodedQuery;
		}
		
		public List<StockList> getStockCodes(String name) {
			
			String n  = encodeURLQueryString(name);	
			String endpoint = "http://localhost:8080/api/stockLists/findCodes/"+n;
			
			List<StockList> stocks = null;
			//JSONObject stockListObject = new JSONObject();
			JSONParser parser = new JSONParser();
			
			try {
				URL url = new URL(endpoint);
				HttpURLConnection  con= (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				int responseCode = con.getResponseCode();
				
				
				if (responseCode == HttpURLConnection.HTTP_OK) { // success
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					Object obj = parser.parse(in);
					//JSONObject jsonObject = (JSONObject) obj;
		            System.out.println("this is the jsonObject "+obj);    
		            ObjectMapper objectMapper = new ObjectMapper();
		            
		            stocks = objectMapper.readValue(
		            		obj.toString(),
		                    objectMapper.getTypeFactory().constructCollectionType(
		                            List.class, StockList.class));
				
					in.close();

					// print result
					System.out.println("wiki is stock codes");
				} else {
					System.out.println("GET request not worked");
				}	
				
			}
			
			catch(IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("the stocks in getStockData are");
			for(StockList s: stocks) {
				System.out.println(s.getSymbol()+ " "+ s.getName() + " "+ s.getCurrency());
			}
			return stocks;
		}
		
		
		
}
