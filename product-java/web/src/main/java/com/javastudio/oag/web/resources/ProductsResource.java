package com.javastudio.oag.web.resources;

import com.javastudio.oag.api.ProductService;
import com.javastudio.oag.dto.ProductDto;
import com.javastudio.oag.web.mapper.ProductModelMapper;
import com.javastudio.openapigenerator.generated.v1.api.ProductsApi;
import com.javastudio.openapigenerator.generated.v1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class ProductsResource implements ProductsApi {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductModelMapper mapper;

    @Override
    public ResponseEntity<List<Product>> findProducts(String productName, String productCategory) {
        return ResponseEntity.ok(mapper.map(service.findProducts()));
    }

    @Override
    public ResponseEntity<Void> createProduct(Product product) {
        ProductDto savedProduct = service.saveProduct(mapper.map(product));

        URI location = URI.create(String.format("/persons/%s", savedProduct.getId()));
        return ResponseEntity.created(location).build();
    }
}
