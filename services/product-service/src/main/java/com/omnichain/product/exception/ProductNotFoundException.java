package com.omnichain.product.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String sku) {
        super(String.format("Product with SKU '%s' does not exist.", sku));
    }
}
