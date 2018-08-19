package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RepositoryRestController
@RequestMapping("/api/stockLists")
public class StockListRepositoryController {

	
	@Autowired
	private final StockListRepository repo;
	
	public StockListRepositoryController(StockListRepository repo) {
		this.repo = repo;
	}
	/*@Autowired
	APIService apiObject;	
	@RequestMapping(value = "findCodes", method = RequestMethod.GET)
	//@ResponseBody
	//public @ResponseBody ResponseEntity<?> findInfo(@RequestParam("companyInfo") CompanyInformation companyInfo) {
		public List<StockList> findCodes() {
		apiObject.getStockCodes("name");
		List<StockList> stocks = null;
		return stocks;
	}*/
	
	
	
	@RequestMapping(value = "/findCodes/{name}", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<StockList> findCodes(@PathVariable("name") String name) {	
		List<StockList> stocks = this.repo.findByName(name);
		return stocks;
	}
}


 