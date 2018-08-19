package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.List;

import org.json.simple.JSONObject;
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
@RequestMapping("/api/stockData")
public class StockDataRepositoryController {

	
	@Autowired
	private final StockDataRepository repo;
	
	
	public StockDataRepositoryController(StockDataRepository repo) {
		this.repo = repo;
	}
	
	
	/*@RequestMapping(value = "/getStockData", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?>  getStockData(@RequestBody String code, CompanyInformation compInfo) {	
	
	JSONObject stocks = new JSONObject();
	CompanyInformation comp = apiService.getStockData(code,compInfo);
	
	Resource<CompanyInformation> resource = new Resource<CompanyInformation>(comp);
	return ResponseEntity.ok(resource);
}*/
}





	
	
