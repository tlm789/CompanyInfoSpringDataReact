package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.ArrayList;

public class APIService {

		public String findWikiInfo(String name){
			String wiki = "test wiki";
			return wiki;
					
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
		
		
		
}
