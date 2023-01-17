package com.javastudio.oag.service;

import com.javastudio.oag.api.ProductService;
import com.javastudio.oag.dto.ProductDto;
import com.javastudio.oag.mapper.ProductMapper;
import com.javastudio.oag.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public List<ProductDto> findProducts() {
        return mapper.map(repository.findAll());
    }
}
