package com.api.services;

import com.api.exception.ErrorResponse;
import com.api.model.entities.PriceDTO;
import com.api.model.entities.PriceDetailDTO;
import com.api.model.dao.IPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceServiceImpl {

    @Autowired
    private IPrice priceDao;

    /**
     * Method to get all prices filtered by date, productId and brandId
     *
     * @return
     */

    public PriceDetailDTO getPriceDetail(LocalDateTime date, long productId, int brandId) {
        List<PriceDTO> prices = priceDao.findPrices(date, productId, brandId);

        PriceDTO price = prices.stream().max(Comparator.comparing(PriceDTO::getPriority))
                .orElseThrow(() -> new ErrorResponse("The record for prices does not exist"));
        PriceDetailDTO detail = new PriceDetailDTO.Builder().productId(price.getProductId()).brandId(price.getBrandId())
                .priceList(price.getPriceList()).startDate(price.getStartDate()).endDate(price.getEndDate())
                .price(price.getPrice()).build();
        return detail;
    }
}
