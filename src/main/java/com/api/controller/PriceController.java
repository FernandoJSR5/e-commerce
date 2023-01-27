package com.api.controller;

import com.api.model.entities.PriceDetailDTO;
import com.api.response.ResponseHandler;
import com.api.services.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api")

public class PriceController {

    private PriceServiceImpl priceService;

    @Autowired
    public PriceController(PriceServiceImpl priceService) {
        this.priceService = priceService;
    }

    @GetMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPriceDetail(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                                 @RequestParam(value = "date") LocalDateTime date,
                                                 @RequestParam(value = "product_id") long productId,
                                                 @RequestParam(value = "brand_id") int brandId) {
        return ResponseHandler.responseBuilder("The product was found successfully",
                HttpStatus.OK, LocalDateTime.now(), priceService.getPriceDetail(date, productId, brandId));
    }
}
