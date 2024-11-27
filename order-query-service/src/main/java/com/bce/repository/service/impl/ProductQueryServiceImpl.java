package com.bce.repository.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.bce.dto.ProductEvent;
import com.bce.dto.ProductEventType;
import com.bce.entity.ProductQuery;
import com.bce.repository.ProductQueryRepository;
import com.bce.repository.service.ProductQueryService;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {

	@Autowired
	private ProductQueryRepository productQueryRepository;

	@Override
	public List<ProductQuery> getAllProduct() {
		return productQueryRepository.findAll();
	}

	@Override
	public Optional<ProductQuery> getProductByID(Long proUuid) {
		return productQueryRepository.findById(proUuid);
	}

	@KafkaListener(topics = "product-topic", groupId = "product-event-group")
	public void handleProductEvent(ProductEvent productEvent) {

		if (productEvent.getEventType() == ProductEventType.CREATED) {
			productQueryRepository.save(productEvent.getProduct());

		} else if (productEvent.getEventType() == ProductEventType.MODIFY) {
			productQueryRepository.save(productEvent.getProduct());
		} else if (productEvent.getEventType() == ProductEventType.DELETED) {
			productQueryRepository.delete(productEvent.getProduct());
		} else {
			System.err.println("No event!");
		}
	}

}
