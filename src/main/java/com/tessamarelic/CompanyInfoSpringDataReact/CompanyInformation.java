package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data; //auto generates getters, setters, constructors etc

/*
 * this class is the domain object. It holds all information chosen by a user 
 */

@Data
@Entity //JPA annotation that denotes whole class for storage
public class CompanyInformation {
	
	//@EmbeddedId
	//private CompanyIdentity compIdentity;
	private @Id @GeneratedValue Long id; //auto generated primary key
	//private @GeneratedValue Long id;
	private ArrayList<Integer> types = new ArrayList<Integer>();
	private String name;
	/*private String wiki = findWikiInfo(name);
	private String financialData = findFinancialData(name) ;
	private String location = findLocation(name);
	private String CEO = findCEO(name);
	private ArrayList<String> reviews = findReviews(name);*/
	@Column(length = 2000)
	private String wiki;
	
	@ElementCollection(targetClass=StockList.class)
	private List<StockList> stockCodes;
	
	@Column
	private JSONObject stock;
	
	private String financialData;
	private String location;
	private String CEO;
	private ArrayList<String> reviews = new ArrayList<String>();
	
	
	public CompanyInformation () {
		
	
	}
	
	//public CompanyInformation(String name, ArrayList<Integer>types, String wiki, String financialData, String location, String CEO, ArrayList<String>reviews) {
	
	public CompanyInformation(String name, ArrayList<Integer>types)
	{
		this.name = name;
		this.types = types;
		
	}

	
	public List<StockList> getStockCodes() {
		return stockCodes;
	}

	public void setStockCodes(List<StockList> stockCodes) {
		this.stockCodes = stockCodes;
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
	
	
	public JSONObject getStock() {
		return stock;
	}

	public void setStock(JSONObject obj) {
		this.stock = obj;
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
