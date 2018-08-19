package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public interface StockListRepository extends PagingAndSortingRepository<StockList, Long> {
	//void saveAll(Iterable<StockList> stocks);
	List<StockList> findByName(String name);
	List<StockList> findByNameContaining(String name);
}


