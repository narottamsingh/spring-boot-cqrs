package com.bce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bce.entity.ProductQuery;

@Repository
public interface ProductQueryRepository extends JpaRepository<ProductQuery, Long>{
	
}
