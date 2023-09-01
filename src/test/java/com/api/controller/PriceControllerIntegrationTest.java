package com.api.controller;

import com.api.model.dao.IPrice;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IPrice priceDao;

    @Transactional
    @Before
    public void findData() {
        priceDao.findAll();
    }

    @Test
    @DisplayName("[Test 1]: Should be return a product with price 35.50 €")
    void test1() throws  Exception {
        mockMvc.perform(get("/api/price").param("date", "2020-06-14T10:00:00")
                        .param("product_id", "35455").param("brand_id","1")
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.productId").value(35455))
                .andExpect(jsonPath("$.data.brandId").value(1))
                .andExpect(jsonPath("$.data.priceList").value(1))
                .andExpect(jsonPath("$.data.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.data.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.data.price").value(35.50));
    }

    @Test
    @DisplayName("[Test 2]: Should be return a product with price 25.45 €")
    void test2() throws  Exception {
        mockMvc.perform(get("/api/price").param("date", "2020-06-14T16:00:00")
                        .param("product_id", "35455").param("brand_id","1")
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.productId").value(35455))
                .andExpect(jsonPath("$.data.brandId").value(1))
                .andExpect(jsonPath("$.data.priceList").value(2))
                .andExpect(jsonPath("$.data.startDate").value("2020-06-14T15:00:00"))
                .andExpect(jsonPath("$.data.endDate").value("2020-06-14T18:30:00"))
                .andExpect(jsonPath("$.data.price").value(25.45));
    }

    @Test
    @DisplayName("[Test 3]: Should be return a product with price 35.50 €")
    void test3() throws  Exception {
        mockMvc.perform(get("/api/price").param("date", "2020-06-14T21:00:00")
                        .param("product_id", "35455").param("brand_id","1")
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.productId").value(35455))
                .andExpect(jsonPath("$.data.brandId").value(1))
                .andExpect(jsonPath("$.data.priceList").value(1))
                .andExpect(jsonPath("$.data.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.data.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.data.price").value(35.50));
    }

    @Test
    @DisplayName("[Test 4]: Should be return a product with price 30.50 €")
    void test4() throws  Exception {
        mockMvc.perform(get("/api/price").param("date", "2020-06-15T10:00:00")
                        .param("product_id", "35455").param("brand_id","1")
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.productId").value(35455))
                .andExpect(jsonPath("$.data.brandId").value(1))
                .andExpect(jsonPath("$.data.priceList").value(3))
                .andExpect(jsonPath("$.data.startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$.data.endDate").value("2020-06-15T11:00:00"))
                .andExpect(jsonPath("$.data.price").value(30.50));
    }

    @Test
    @DisplayName("[Test 5]: Should be return a product with price 38.95 €")
    void test5() throws  Exception {
        mockMvc.perform(get("/api/price").param("date", "2020-06-16T21:00:00")
                .param("product_id", "35455").param("brand_id","1")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.productId").value(35455))
                .andExpect(jsonPath("$.data.brandId").value(1))
                .andExpect(jsonPath("$.data.priceList").value(4))
                .andExpect(jsonPath("$.data.startDate").value("2020-06-15T16:00:00"))
                .andExpect(jsonPath("$.data.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.data.price").value(38.95));
    }
}