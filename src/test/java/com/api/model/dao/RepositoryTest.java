package com.api.model.dao;

import com.api.model.entities.PriceDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@DataJpaTest
class RepositoryTest {

    @Autowired
    private IPrice priceDao;

    PriceDTO price;

    @BeforeEach
    void setUp() {
        price = new PriceDTO.Builder().id(1L).brandId(1)
                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 00, 00, 00))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                .price(35.50).priority(0).priceList(1).productId(35455L).curr("EUR").build();
    }

    @Test
    @DisplayName("It should be empty prices list")
    void validateSuccessComparison() {
       List<PriceDTO> prices = priceDao.findPrices(LocalDateTime.of(2020, Month.JUNE, 12, 10, 00, 00),
                35455, 1);
        assertThat(prices).isEmpty();
    }

    @Test
    @DisplayName("The list must have two elements")
    void validateFailComparison() {
        List<PriceDTO> prices = priceDao.findPrices(LocalDateTime.of(2020, Month.JUNE, 18, 10, 00, 00),
                35455, 1);
        assertThat(prices.size()).isEqualTo(2);
    }
}