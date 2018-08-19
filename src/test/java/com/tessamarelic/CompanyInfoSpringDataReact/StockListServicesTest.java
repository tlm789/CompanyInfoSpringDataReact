package com.tessamarelic.CompanyInfoSpringDataReact;


import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StockListServicesTest {

	//use TestConfiguration annotation to indicate that this class should not be picked up by scanning
		@TestConfiguration
		static class StockListServicesTestContextConfiguration {
			
			//create a mock of repository so by-passes the call to actual stocklist repo
			@Autowired
			private StockListRepository stockListRepo;
			
			//need an instance of Service class as a @Bean so we can autowire it in test class
			@Bean
			public Services stockListService() {
				return new StockListRepoService(stockListRepo);
			}
		}
			
		@MockBean
		private StockListRepository stockListRepo;	
		
		@Autowired
			private Services stockListService;
			
			
			@Before
			public void setUp() {
				
				StockList stock = new StockList();
				StockList stock2 = new StockList();
				stock.setCurrency("USD");
				stock.setName("Apple Inc.");
				stock.setSymbol("AAPL");
				
				stock2.setCurrency("MXD");
				stock2.setName("Apple Inc.");
				stock2.setSymbol("AAPL.MXD");
				
				List<StockList> st = new ArrayList<StockList>();
				st.add(stock);
				st.add(stock2);
				
				
				Mockito.when(stockListRepo.findByName("Apple Inc.")).thenReturn(st);
				
				StockList stock3 = new StockList();
				StockList stock4 = new StockList();
				stock3.setCurrency("USD");
				stock3.setName("Microsoft Corporation");
				stock3.setSymbol("MMC");
				
				stock4.setCurrency("MXD");
				stock4.setName("Microsoft Inc. Partial Test");
				stock4.setSymbol("MMC.MXD");
				
				List<StockList> sto = new ArrayList<StockList>();
				sto.add(stock3);
				sto.add(stock4);
				
				
				List<StockList> stoc = new ArrayList<StockList>();
				
				
				
				Mockito.when(stockListRepo.findByNameContaining("Microsoft")).thenReturn(sto);
				
			}
			
			@Test
			public void whenValidName_thenStockListFound() {
				String name = "Apple Inc.";
				
				List<StockList> stocks = stockListService.findByName(name);
				
				for(int i = 0; i< stocks.size(); i++) {
					assertThat(stocks.get(i).getName()).isEqualTo(name);
					System.out.println(stocks.get(i).getName() + " "+ stocks.get(i).getSymbol());
				}
				
			}
			
			@Test
			public void whenPartialName_thenListOfParialNamesReturned() {
				String name = "Microsoft";
				
				List<StockList> stocks = stockListService.findByNameContaining(name);
				
				for(int i = 0; i< stocks.size(); i++) {
					assertThat(stocks.get(i).getName()).contains(name);
					System.out.println(stocks.get(i).getName());
				}
			}
			
		
}
