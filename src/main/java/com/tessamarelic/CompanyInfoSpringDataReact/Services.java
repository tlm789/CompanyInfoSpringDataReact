package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface Services {
	
	<T> Iterable<T> findAll();
	
	<T> List<T>findByName(String name);
	
	<T> List<T> findByNameContaining(String name);
}
