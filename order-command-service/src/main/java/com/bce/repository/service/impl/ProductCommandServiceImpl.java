package com.bce.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bce.dto.ProductEvent;
import com.bce.dto.ProductEventType;
import com.bce.entity.ProductCommand;
import com.bce.repository.ProductCommandRepository;
import com.bce.repository.service.ProductCommandService;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

	@Autowired
	private ProductCommandRepository productCommandRepository;

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Override
	public ProductCommand saveProduct(ProductCommand productCommand) {
		ProductCommand command = productCommandRepository.save(productCommand);
		ProductEvent event = new ProductEvent(ProductEventType.CREATED, command);
		kafkaTemplate.send("product-topic", event);
		return command;
	}

	@Override
	public void delProd(Long uuid) {
		ProductCommand command = productCommandRepository.findById(uuid).get();
		productCommandRepository.delete(command);
		ProductEvent event = new ProductEvent(ProductEventType.DELETED, command);
		kafkaTemplate.send("product-topic", event);
	}

	@Override
	public ProductCommand updateProduct(Long id, ProductCommand productCommand) {
		ProductCommand command = productCommandRepository.findById(id).get();
		command.setDescription(productCommand.getDescription());
		command.setName(productCommand.getName());
		command.setPrice(productCommand.getPrice());
		productCommandRepository.save(command);
		ProductEvent event = new ProductEvent(ProductEventType.MODIFY, command);
		kafkaTemplate.send("product-topic", event);
		return command;
	}

}
