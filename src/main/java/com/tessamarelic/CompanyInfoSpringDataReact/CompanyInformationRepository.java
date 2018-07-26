package com.tessamarelic.CompanyInfoSpringDataReact;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CompanyInformationRepository extends PagingAndSortingRepository<CompanyInformation, Long>{

		
}
