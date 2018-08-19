package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CompanyInformationRepository extends PagingAndSortingRepository<CompanyInformation, Long>{

	List<CompanyInformation> findAll();
	
	CompanyInformation findByName(String name);
	
	List<CompanyInformation> findByNameContaining(String name);
}
