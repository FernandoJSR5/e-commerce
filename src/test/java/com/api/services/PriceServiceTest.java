package com.api.services;
import com.api.model.dao.IPrice;
import com.api.model.entities.PriceDTO;
import com.api.model.entities.PriceDetailDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
class PriceServiceTest {

    @Mock
    IPrice mockPrice;

    @Autowired
    IPrice priceDao;

    @InjectMocks
    PriceServiceImpl priceService;

    List<PriceDTO> prices = new ArrayList<>();
    PriceDetailDTO mockDetail;

    @BeforeEach
    void setUp() {
        prices = priceDao.findPrices(LocalDateTime.of(2020, Month.JUNE,16,21,00,00),
                35455, 1);

        mockDetail = new PriceDetailDTO.Builder().productId(35455L).brandId(1)
                .priceList(4).startDate(LocalDateTime.of(2020,06,15, 16, 00))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .price(38.95).build();

    }

    @Test
    @DisplayName("The mock object should be the same as the one obtained in the database")
    void serviceTest() {
        when(mockPrice.findPrices(LocalDateTime.of(2020, Month.JUNE,16,21,00,00),
                35455, 1)).thenReturn(prices);

        assertThat(
                priceService.getPriceDetail(LocalDateTime.of(2020, Month.JUNE,16, 21, 00, 00),
                        35455, 1)).isEqualTo(mockDetail);
    }
}