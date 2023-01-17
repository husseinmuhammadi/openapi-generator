package com.javastudio.oag.api;

import com.javastudio.oag.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findProducts();
}
