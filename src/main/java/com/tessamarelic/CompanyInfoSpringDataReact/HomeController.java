package com.tessamarelic.CompanyInfoSpringDataReact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //marks class as Spring MVC controller
public class HomeController {
	
	private DatabaseLoader dataLoader;
	
	
	@RequestMapping(value = "/") //flags index() method to support / route
	public String index() {
		return "index"; //src/main/resources/templates/index.html
	}
	
	/*@RequestMapping(value ="api/companyinformations/findInfo", method = RequestMethod.POST)
	@ResponseBody
	public CompanyInformation findInfo(@RequestParam("companyInfo") CompanyInformation companyInfo) {
		APIService apiService = new APIService();
		String name = companyInfo.getName();
		for(int type : companyInfo.getTypes()) {
			if(type == 1) {
				companyInfo.setWiki(apiService.findWikiInfo(name));
			}
			if(type == 2) {
				companyInfo.setFinancialData(apiService.findFinancialData(name));
			}
			if(type == 3) {
				companyInfo.setLocation(apiService.findLocationInfo(name));
			}
			if(type == 4) {		
				companyInfo.setCEO(apiService.findCEO(name));
			}
			if(type == 5) { 
				companyInfo.setReviews(apiService.findReviews(name));
			}
		}
		dataLoader.setNewCompany(companyInfo);
		return companyInfo;
	}*/
	
}
