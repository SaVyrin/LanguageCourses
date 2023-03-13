package com.vsu.education.springeducation.data.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private final Integer id;
    private final String name;
    private final Double price;

    public Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
