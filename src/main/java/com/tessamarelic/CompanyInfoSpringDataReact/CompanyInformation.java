package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private String wiki;
	private String location;
	private ArrayList<String> reviews = new ArrayList<String>();
	private String CEO;
	private String financialData;
	
	public CompanyInformation () {
		
	}
	
	public CompanyInformation(String name, ArrayList<Integer>types) {
		this.name = name;
		this.types = types;
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

	public void setCEO(String cEO) {
		CEO = cEO;
	}

	public String getFinancialData() {
		return financialData;
	}

	public void setFinancialData(String financialData) {
		this.financialData = financialData;
	}
	
}
