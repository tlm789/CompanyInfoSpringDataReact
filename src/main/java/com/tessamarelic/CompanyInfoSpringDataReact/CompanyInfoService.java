package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoService implements Services{

	private final CompanyInformationRepository repository;
	
	@Autowired
	public CompanyInfoService(CompanyInformationRepository repo) {
		repository = repo;
	}
	
	@Override
	public List<CompanyInformation> findAll() {
		return this.repository.findAll();
	}

	@Override
	public List<CompanyInformation> findByName(String name) {
		//no changes to the default method
		return null;
	}

	@Override
	public <T> List<T> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
