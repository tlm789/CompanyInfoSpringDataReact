package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockListRepoService implements Services{

	@Autowired
	private final StockListRepository repo;
	
	public StockListRepoService(StockListRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Iterable<StockList> findAll() {
		
		return this.repo.findAll();
	}

	@Override
	public List<StockList> findByName(String name) {
		return this.repo.findByName(name);
	}

	@Override
	public List<StockList> findByNameContaining(String name) {		
		return this.repo.findByNameContaining(name);
	}

}
