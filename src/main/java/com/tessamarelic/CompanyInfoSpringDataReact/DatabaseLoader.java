package com.tessamarelic.CompanyInfoSpringDataReact;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

//use commandlinerunner so it gets run after all the beans are created and registered
@Component  //use so automatically picked up by SpringBootApplication
public class DatabaseLoader implements CommandLineRunner{

		//private static final Class StockList = null;
		//private final CompanyInformationRepository repository;
		private final StockListRepository repo;
		private List<StockList> stockCodes;
		
		/*@Autowired
		public DatabaseLoader(CompanyInformationRepository repository) {
			this.repository = repository;
		}*/
		
		@Autowired
		private StockListRepoService stockListService;
		
		@Autowired
		public DatabaseLoader(StockListRepository repo) {
			this.repo = repo;
		}
		
		
		@Override
		public void run(String...strings) throws Exception {
			/*
			 * CompanyInformation company = getPostedInfo();
			 * 
			 */
			/*CompanyInformation company = new CompanyInformation();
			company.setWiki("this is a test wikipedia article");
			company.setFinancialData("this is a test financial data");
			ArrayList<String>reviews = new ArrayList<String>();
			reviews.add("bad company");
			reviews.add("good company");
			company.setLocation("Sydney");
			company.setReviews(reviews);
			company.setName("IBM");
			company.setCEO("Kay Francis");
			//this.repository.save(this.newCompany);
			this.repository.save(company);
			this.repository.save(newCompany);*/
			//Iterable<CompanyInformation> compInfo = repository.findAll();
			//Iterable<StockList> stocks = loadObjectList(StockList.class, "/worldtradingdata-stocklist.csv");
			//List<StockList> st = loadObjectList(StockList.class, "/worldtradingdata-stocklist.csv");
			Iterable<StockList> stocks = read(StockList.class, "/worldtradingdata-stocklist.csv");
			List<StockList> st = (List)stocks;
			System.out.println("the data is ");
			for(int i = 0; i<10; i++) {
				System.out.println(st.get(i).getSymbol()+" "+st.get(i).getName() + " "+ st.get(i).getCurrency());
			}
			
			
			
			
			this.repo.saveAll(stocks);
		
			
			/*List<StockList> sto = repo.findByName("Apple Inc.");
			for(StockList s : sto) {
				System.out.println(s.getSymbol() + " " + s.getName() + " " + s.getCurrency());
			}*/
			/*st = findStocks("Apple Inc.");
			for(StockList s : st) {
				System.out.println(s.getSymbol() + " " + s.getName() + " " + s.getCurrency());
			}*/
		}
		
		public <T> List<T> read(Class<T> clazz, String fileName) throws IOException {
			
			CsvSchema schema = CsvSchema.emptySchema().withHeader();
			File file = new ClassPathResource(fileName).getFile();
			System.out.println("the file exists is "+ file.exists());
			CsvMapper mapper = new CsvMapper();
			
	        schema = mapper.schemaFor(clazz);
	        
	        MappingIterator<T> it = mapper.readerFor(clazz).with(schema).readValues(file);
	        //ObjectReader reader = mapper.readerFor(clazz).with(schema);
	        //return reader.<T>readValues(file).readAll();
	        return it.readAll();
	    }
		
		public List<StockList> findStocks(String name){
			List<StockList> stock = this.stockListService.findByName(name);
			return stock;
		}



		public List<StockList> getStockCodes() {
			return stockCodes;
		}



		public void setStockCodes(List<StockList> stockCodes) {
			this.stockCodes = stockCodes;
		}



		public StockListRepository getRepo() {
			return repo;
		}
		
		
		
		/*public <T> List<T> loadObjectList(Class<T> type, String fileName){
			
			try {
				CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();//reading in header of file as column names
				CsvMapper mapper = new CsvMapper();
				File file = new ClassPathResource(fileName).getFile();
				System.out.println("the file exists is "+ file.exists());
				MappingIterator<T> readValues =
						mapper.readerFor(type).with(bootstrapSchema).readValues(file);
				System.out.println("the file consists of "+readValues.readAll());
				
				return readValues.readAll();
			}catch(Exception e) {
				System.out.println("Error occurred while loading object list from file" + fileName + e);
				return Collections.emptyList();
			}
		}*/

		
		
}
