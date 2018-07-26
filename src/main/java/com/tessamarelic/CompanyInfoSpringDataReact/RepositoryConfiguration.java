package com.tessamarelic.CompanyInfoSpringDataReact;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

	public RepositoryConfiguration(){
        super();
    }
 
	@Bean CompanyInfoHandler companyInfoHandler() {
		return new CompanyInfoHandler();
	}
}


