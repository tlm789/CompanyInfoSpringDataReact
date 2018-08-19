package com.tessamarelic.CompanyInfoSpringDataReact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonPropertyOrder({ "symbol", "name", "currency" })
@Data
@Entity
public class StockList {

	private @Id @GeneratedValue Long id; //auto generated primary key
	
		@Column
		private String symbol;
	
		@Column
		private String name;
		
		@Column
		private String currency;
		
		
		
		public StockList() {
			
		}
		
		
		
		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		
		
		
		
}
