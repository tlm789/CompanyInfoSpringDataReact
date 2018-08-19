package com.tessamarelic.CompanyInfoSpringDataReact;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface StockDataRepository extends PagingAndSortingRepository<StockData, Long>{

}



