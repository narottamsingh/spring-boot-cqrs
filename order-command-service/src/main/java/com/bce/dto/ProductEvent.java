package com.bce.dto;

import com.bce.entity.ProductCommand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEvent {
    private ProductEventType eventType;
    private ProductCommand product;
}
