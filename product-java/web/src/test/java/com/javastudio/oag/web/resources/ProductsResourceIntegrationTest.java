package com.javastudio.oag.web.resources;

import com.javastudio.oag.integration.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.javastudio.oag.utils.MockDataLoader.ProductEnum.CREATE_PRODUCT_REQUEST;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
class ProductsResourceIntegrationTest {

    private static final String ENDPOINT_PRODUCTS = "/api/v1/products";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateProduct() throws Exception{
        mockMvc.perform(post(ENDPOINT_PRODUCTS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CREATE_PRODUCT_REQUEST.jsonString()))
                .andExpect(status().isCreated());
    }
}