package com.bce.repository.service;

import java.util.List;
import java.util.Optional;

import com.bce.entity.ProductQuery;

public interface ProductQueryService {

	List<ProductQuery> getAllProduct();

	Optional<ProductQuery> getProductByID(Long proUuid);

}
