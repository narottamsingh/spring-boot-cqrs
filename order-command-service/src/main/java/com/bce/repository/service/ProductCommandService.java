package com.bce.repository.service;

import com.bce.entity.ProductCommand;

public interface ProductCommandService {

	ProductCommand saveProduct(ProductCommand productCommand);
	void delProd(Long prodUUI);
	ProductCommand updateProduct(Long id, ProductCommand productCommand);
}
