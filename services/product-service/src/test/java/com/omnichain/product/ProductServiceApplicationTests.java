package com.omnichain.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnProductWhenSkuExists() throws Exception {
        mockMvc.perform(get("/api/v1/products/LAPTOP-01"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.sku").value("LAPTOP-01"))
                .andExpect(jsonPath("$.name").value("Omnichain Pro Book 15"))
                .andExpect(jsonPath("$.price").value(1299.99));
    }

    @Test
    void shouldReturn404WhenSkuDoesNotExist() throws Exception {
        mockMvc.perform(get("/api/v1/products/INVALID-SKU"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("Not Found"))
                .andExpect(jsonPath("$.message").value("Product with SKU 'INVALID-SKU' does not exist."));
    }
}
