package com.javastudio.oag.web.resources;

import com.javastudio.oag.api.ProductService;
import com.javastudio.oag.web.mapper.ProductModelMapperImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductsResource.class)
@Import(ProductModelMapperImpl.class)
class ProductsResourceTest {

    public static final String ENDPOINT_PRODUCTS = "/api/v1/products";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void shouldWork() throws Exception {
        mockMvc.perform(get(ENDPOINT_PRODUCTS)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}