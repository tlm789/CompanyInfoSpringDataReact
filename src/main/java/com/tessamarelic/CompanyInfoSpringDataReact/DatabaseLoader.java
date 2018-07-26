package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//use commandlinerunner so it gets run after all the beans are created and registered
@Component  //use so automatically picked up by SpringBootApplication
public class DatabaseLoader implements CommandLineRunner{

		private final CompanyInformationRepository repository;
		
	
		@Autowired
		public DatabaseLoader(CompanyInformationRepository repository) {
			this.repository = repository;
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
			
		}

		
		
}
