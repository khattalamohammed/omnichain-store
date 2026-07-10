package com.omnichain.product.controller;

import com.omnichain.product.dto.ProductDTO;
import com.omnichain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{sku}")
    public ProductDTO getProduct(@PathVariable String sku) {
        return productService.getProductBySku(sku);
    }
}
