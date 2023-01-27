package com.api.model.dao;
import com.api.model.entities.PriceDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPrice extends CrudRepository<Price, Long> {
    @Query("SELECT p FROM Price p " +
            "WHERE p.brandId = :brand_id AND p.productId = :product_id AND :date BETWEEN p.startDate AND p.endDate")
    List<PriceDTO> findPrices(@Param("date") LocalDateTime date,
                              @Param("product_id") long productId,
                              @Param("brand_id") int brandId);
}
