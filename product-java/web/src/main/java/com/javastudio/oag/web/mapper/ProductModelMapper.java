package com.javastudio.oag.web.mapper;

import com.javastudio.oag.dto.ProductDto;
import com.javastudio.openapigenerator.generated.v1.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductModelMapper {
    Product map(ProductDto productDto);
    List<Product> map(List<ProductDto> products);
}
