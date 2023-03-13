package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.model.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class ProductStorage {
    private HashMap<Integer, Product> productHashMap = new HashMap<Integer, Product>();

    public void addProduct(Product product) {
        productHashMap.put(product.getId(), product);
    }

    public List<Product> getAllProducts() {
        return productHashMap.values().stream().toList();
    }
}
