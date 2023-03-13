package com.vsu.education.springeducation.service;

import com.vsu.education.springeducation.data.model.Product;
import com.vsu.education.springeducation.data.storage.ProductStorage;
import org.springframework.stereotype.Service;

// @Controller == @service ~= @Repository == @Component
@Service
public class ProductService {
    private final ProductStorage productStorage;

    public ProductService(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public void addProduct(Product product){
        productStorage.addProduct(product);
    }
}
