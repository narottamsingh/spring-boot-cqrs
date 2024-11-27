package com.bce.restcongtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bce.entity.ProductQuery;
import com.bce.repository.service.ProductQueryService;

@RestController
@RequestMapping("/product/query")
public class ProductQueryRestController {

	@Autowired
	private ProductQueryService productQueryService;

	@GetMapping("/all")
	public List<ProductQuery> getAllEmp() {
		return productQueryService.getAllProduct();
	}

	@GetMapping("/get/{UUID}")
	public ProductQuery getOneEMp(Long uuid) {
		return productQueryService.getProductByID(uuid).get();
	}


}
