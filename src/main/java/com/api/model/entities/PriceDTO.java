package com.api.model.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PriceDTO {
    private long id;

    private int brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int priceList;
    private long productId;

    private int priority;

    private double price;

    private String curr;

    private PriceDTO(PriceDTO.Builder builder) {
        this.id = builder.id;
        this.productId = builder.productId;
        this.brandId = builder.brandId;
        this.priceList = builder.priceList;
        this.startDate =  builder.startDate;
        this.endDate = builder.endDate;
        this.price = builder.price;
        this.priority = builder.priority;
        this.curr = builder.curr;
    };

    public static class Builder {
        private long id;
        private long productId;
        private int brandId;
        private int priceList;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private double price;
        private int priority;
        private String curr;

        public PriceDTO.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public PriceDTO.Builder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public PriceDTO.Builder brandId(int brandId) {
            this.brandId = brandId;
            return this;
        }

        public PriceDTO.Builder priceList(int priceList) {
            this.priceList = priceList;
            return this;
        }

        public PriceDTO.Builder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public PriceDTO.Builder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public PriceDTO.Builder price(double price) {
            this.price = price;
            return this;
        }

        public PriceDTO.Builder priority(int priority) {
            this.priority = priority;
            return this;
        }

        public PriceDTO.Builder curr(String curr) {
            this.curr = curr;
            return this;
        }

        public PriceDTO build() {
            return new PriceDTO(this);
        }

    }

}