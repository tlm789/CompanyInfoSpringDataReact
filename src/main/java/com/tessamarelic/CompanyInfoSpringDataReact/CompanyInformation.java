package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data; //auto generates getters, setters, constructors etc

/*
 * this class is the domain object. It holds all information chosen by a user 
 */

@Data
@Entity //JPA annotation that denotes whole class for storage
public class CompanyInformation {
	
	private @Id @GeneratedValue Long id; //auto generated primary key
	private ArrayList<Integer> types = new ArrayList<Integer>();
	private String name;
	private String wiki = findWikiInfo(name);
	private String financialData = findFinancialData(name) ;
	private String location = findLocation(name);
	private String CEO = findCEO(name);
	private ArrayList<String> reviews = findReviews(name);
	/*private String wiki;
	private String financialData;
	private String location;
	private String CEO;
	private ArrayList<String> reviews = new ArrayList<String>();*/
	
	
	public CompanyInformation () {
		
	
	}
	
	//public CompanyInformation(String name, ArrayList<Integer>types, String wiki, String financialData, String location, String CEO, ArrayList<String>reviews) {
	
	public CompanyInformation(String name, ArrayList<Integer>types)
	{
		
		this.name = name;
		this.types = types;
		/*this.wiki = wiki;
		this.financialData = financialData;
		this.location = location;
		this.CEO = CEO;
		this.reviews = reviews;*/
		//APIService apiService = new APIService();
		
		//APIService apiService = new APIService();
		/*for(int type : this.types) {
			if(type == 1) {
				this.wiki = findWikiInfo(name);
				//setWiki(wiki);
			}
			if(type == 2) {
				this.financialData = findFinancialData(name);
				//setFinancialData(financialData);
			}
			if(type == 3) {
				this.location = findLocation(name);
				//setLocation(location);
			}
			if(type == 4) {		
				this.CEO=findCEO(name);
				//setCEO(CEO);
			}
			if(type == 5) { 
				this.reviews=findReviews(name);
				//setReviews(reviews);
			}
		}*/
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Integer> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<Integer> types) {
		this.types = types;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<String> getReviews() {
		return reviews;
	}
	
	public void setReviews(ArrayList<String> reviews) {
		this.reviews = reviews;
	}



	public String getCEO() {
		return CEO;
	}

	public void setCEO(String CEO) {
		this.CEO = CEO;
	}

	public String getFinancialData() {
		return financialData;
	}

	public void setFinancialData(String financialData) {
		this.financialData = financialData;
	}
	
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
