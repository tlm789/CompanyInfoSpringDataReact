package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

//@JsonPropertyOrder({ "symbol", "name", "currency" })
@Data
@Entity
public class StockData {

		private @Id @GeneratedValue Long id;
		
		@Column
		private String name;
		
		//@Column
		//private String date;
		
		@ElementCollection
		@MapKeyClass(Integer.class)
		private Map<String, String[]> history;
		
		
		public void StockData() {
			
		}
		
		/*public void StockData(String name, String date, Map<String,Long> stockValues) {
			this.name = name;
			this.date = date;
			this.stockValues = stockValues;
		}*/
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Map<String, String[]> getHistory() {
			return history;
		}

		public void setHistory(Map<String, String[]> history) {
			this.history = history;
		}
		

		/*public Map<String,String> getHistory() {
			return date;
		}

		public void setHistory(Map<String,String> date) {
			this.date = date;
		}

		
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public Map<String, Long> getStockValues() {
			return stockValues;
		}

		public void setStockValues(Map<String, Long> stockValues) {
			this.stockValues = stockValues;
		}*/

		
		
		
}
