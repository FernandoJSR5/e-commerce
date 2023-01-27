package com.api.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDetailDTO {

    private long productId;
    private int brandId;
    private int priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;

    private PriceDetailDTO(Builder builder) {
        this.productId = builder.productId;
        this.brandId = builder.brandId;
        this.priceList = builder.priceList;
        this.startDate =  builder.startDate;
        this.endDate = builder.endDate;
        this.price = builder.price;
    };

    public static class Builder {
        private long productId;
        private int brandId;
        private int priceList;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private double price;

        public Builder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public Builder brandId(int brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder priceList(int priceList) {
            this.priceList = priceList;
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public PriceDetailDTO build() {
            return new PriceDetailDTO(this);
        }

    }

}
