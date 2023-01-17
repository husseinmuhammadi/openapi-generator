package com.javastudio.oag.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Product {

    @Id
    private String id;
    private String name;
    private String category;
    private String manufacturer;
    private String brand;

}
