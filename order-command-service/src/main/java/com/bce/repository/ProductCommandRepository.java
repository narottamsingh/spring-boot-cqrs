package com.bce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bce.entity.ProductCommand;

@Repository
public interface ProductCommandRepository extends JpaRepository<ProductCommand, Long>{
	
}
