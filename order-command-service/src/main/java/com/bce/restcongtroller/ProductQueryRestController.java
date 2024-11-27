package com.bce.restcongtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bce.entity.ProductCommand;
import com.bce.repository.service.ProductCommandService;

@RestController
@RequestMapping("/product/command")
public class ProductQueryRestController {

	@Autowired
	private ProductCommandService productCommandService;

	@PostMapping("/save")
	public ProductCommand saveProduct(ProductCommand productCommand) {
		return productCommandService.saveProduct(productCommand);

	}

	@DeleteMapping("/del/{uuid}")
	public void delEmp(@PathVariable Long uuid) {
		productCommandService.delProd(uuid);

	}

	@PutMapping("/{id}")
	public ProductCommand updateProduct(@PathVariable Long id, @RequestBody ProductCommand productCommand) {
		return productCommandService.updateProduct(id, productCommand);
	}

}
