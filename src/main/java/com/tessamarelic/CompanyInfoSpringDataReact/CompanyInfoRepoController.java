package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RepositoryRestController
@RequestMapping("/api/companyInformations")
public class CompanyInfoRepoController {

	
	private final CompanyInformationRepository repository;
	
	@Autowired
	private CompanyInfoService service;
	
	@Autowired
	private APIService apiService;
		
	@Autowired
	public CompanyInfoRepoController(CompanyInformationRepository repo) {
		repository = repo;
	}
	
	@RequestMapping(value = "/findInfo", method = RequestMethod.POST)
	//@ResponseBody
	//public @ResponseBody ResponseEntity<?> findInfo(@RequestParam("companyInfo") CompanyInformation companyInfo) {
		public @ResponseBody ResponseEntity<?> findInfo(@RequestBody CompanyInformation companyInfo) {	
		//APIService apiService = new APIService();
		//Iterable<CompanyInformation> companies = repository.findAll();
		List<CompanyInformation> companies = this.service.findAll();
		
		Boolean doesExist = false;
		String name = companyInfo.getName();
		for(CompanyInformation c : companies) {
			if(c.getName().equals(name)) {
				doesExist = true;
				repository.delete(c);
			}
				
		}
		
		for(int type : companyInfo.getTypes()) {
			if(type == 1) {
				companyInfo.setWiki(apiService.findWikiInfo(name));
			}
			if(type == 2) {		
				companyInfo.setStockCodes(apiService.getStockDataCodes(name));
				//companyInfo.setFinancialData(apiService.findFinancialData(name));
			}
			if(type == 3) {
				companyInfo.setLocation(apiService.findLocation(name));
			}
			if(type == 4) {		
				companyInfo.setCEO(apiService.findCEO(name));
			}
			if(type == 5) { 
				companyInfo.setReviews(apiService.findReviews(name));
			}
		}
		repository.save(companyInfo);
		
		Resource<CompanyInformation> resource = new Resource<CompanyInformation>(companyInfo);
		return ResponseEntity.ok(resource);
		//return repository.save(companyInfo);
	}
	
	@RequestMapping(value = "/findStockData", method = RequestMethod.POST)
	
		public @ResponseBody ResponseEntity<?>  findStockData(@RequestBody String code, CompanyInformation compInfo) {	
		
		JSONObject stocks = new JSONObject();
		CompanyInformation comp = apiService.getStockData(code,compInfo);
		
		Resource<CompanyInformation> resource = new Resource<CompanyInformation>(comp);
		return ResponseEntity.ok(resource);
	}
}



