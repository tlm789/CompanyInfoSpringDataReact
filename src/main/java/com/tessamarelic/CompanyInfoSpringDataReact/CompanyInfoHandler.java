package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CompanyInfoHandler {

		private CompanyInformationRepository repository;
		private APIService apiService;
	
		/*@Autowired
		public CompanyInfoHandler(CompanyInformationRepository repository) {
			this.repository = repository;
		}*/
		
		/*@HandleBeforeSave(CompanyInformation.class) public void handleBeforeSave(CompanyInformation company) {
			
			
			String name = company.getName();
			if(name != "") {
			
				for(int type : company.getTypes()) {
					if(type == 1) {
						
						company.setWiki(apiService.findWikiInfo(name));
						System.out.println("in type 1 in handle before save event wiki is "+ company.getWiki());
						//setWiki(wiki);
					}
					if(type == 2) {
						company.setFinancialData(apiService.findFinancialData(name));
						//setFinancialData(financialData);
					}
					if(type == 3) {
						company.setLocation(apiService.findLocation(name));
						//setLocation(location);
					}
					if(type == 4) {		
						company.setCEO(apiService.findCEO(name));
						//setCEO(CEO);
					}
					if(type == 5) { 
						company.setReviews(apiService.findReviews(name));
						//setReviews(reviews);
					}
			}
			}
				//repository.save(company);
		}*/

		
}
