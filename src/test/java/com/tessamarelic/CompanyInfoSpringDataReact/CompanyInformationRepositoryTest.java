package com.tessamarelic.CompanyInfoSpringDataReact;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.json.JsonObject;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyInformationRepositoryTest {

		@Autowired
		private TestEntityManager entityManager;
		
		@Autowired
		private CompanyInformationRepository companyRepository;
		
		private Logger logger;
		
		@Test
		public void whenFindByName_thenReturnCompanyInfo() {
			CompanyInformation company = new CompanyInformation();
			ArrayList<Integer> types = new ArrayList<Integer>();
			ArrayList<String> reviews = new ArrayList<String>();
			reviews.add("good company");
			reviews.add("bad company");
			List<String> testList = new ArrayList<String>();
			Map<String,List<String>> testMap = new HashMap<String, List<String>>();
			testMap.put("key1", testList);
			//String jsonOb = "{\"results\":[{\"lat\":\"value\",\"lon\":\"value\" }, { \"lat\":\"value\", \"lon\":\"value\"}]}";
			JsonObject mainObject = null;
			types.add(1);
			types.add(2);
			company.setName("IBM");
			company.setTypes(types);
			//company.setStock(mainObject);
			company.setCEO("Jack Taggart");
			company.setFinancialData("test financial data");
			company.setLocation("44 Vermont Rd");
			company.setWiki("test wiki");
			company.setReviews(reviews);
			
			entityManager.persist(company);
			entityManager.flush();
			
			CompanyInformation comp = companyRepository.findByName(company.getName());
			
			assertThat(comp.getId() > 0);
			
			assertThat(company.getName()).isEqualTo(comp.getName());
				
		}
		
		@Test
		public void whenFindAll_thenReturnAllCompanyInfo() {
			CompanyInformation comp1 = new CompanyInformation();
			CompanyInformation comp2 = new CompanyInformation();
			CompanyInformation comp3 = new CompanyInformation();
			comp1.setName("company1");
			comp2.setName("company2");
			comp3.setName("company3");
			List<CompanyInformation> newCompany = new ArrayList<CompanyInformation>();
			newCompany.add(comp1);
			newCompany.add(comp2);
			newCompany.add(comp3);
			
			entityManager.persist(comp1);
			entityManager.persist(comp2);
			entityManager.persist(comp3);
			
			entityManager.flush();
			List<CompanyInformation> companies = companyRepository.findAll();
			for(int i = 0; i< companies.size(); i++) {
				assertThat(companies.get(i).getName()).isEqualTo(newCompany.get(i).getName());
				System.out.println(companies.get(i).getName());
			}
			
		}
}
