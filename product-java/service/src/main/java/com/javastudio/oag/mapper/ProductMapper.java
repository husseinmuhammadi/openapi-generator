package com.javastudio.oag.mapper;

import com.javastudio.oag.dto.ProductDto;
import com.javastudio.oag.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductDto map(Product product);

    List<ProductDto> map(List<Product> products);

    Product map(ProductDto productDto);
}
