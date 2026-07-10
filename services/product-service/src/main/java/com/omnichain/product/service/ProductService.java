package com.omnichain.product.service;

import com.omnichain.product.exception.ProductNotFoundException;
import com.omnichain.product.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    private final Map<String, ProductDTO> productCatalog = new HashMap<>();

    public ProductService() {
        productCatalog.put("LAPTOP-01", ProductDTO.builder()
                .sku("LAPTOP-01")
                .name("Omnichain Pro Book 15")
                .description("High-performance laptop for distributed systems engineering.")
                .price(new BigDecimal("1299.99"))
                .build());
    }

    public ProductDTO getProductBySku(String sku) {
        return Optional.ofNullable(productCatalog.get(sku))
                .orElseThrow(() -> new ProductNotFoundException(sku));
    }
}
