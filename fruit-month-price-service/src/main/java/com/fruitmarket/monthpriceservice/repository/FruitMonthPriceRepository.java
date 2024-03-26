package com.fruitmarket.monthpriceservice.repository;

import com.fruitmarket.monthpriceservice.dto.FruitPriceAndIdResponse;
import com.fruitmarket.monthpriceservice.model.FruitMonthPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FruitMonthPriceRepository extends JpaRepository<FruitMonthPrice, Long> {
    @Query("SELECT new com.fruitmarket" +
            ".monthpriceservice.dto" +
            ".FruitPriceAndIdResponse(" +
            "f.id, " +
            "CASE :monthName " +
            "    WHEN 'jan' THEN f.jan " +
            "    WHEN 'feb' THEN f.feb " +
            "    WHEN 'mar' THEN f.mar " +
            "    WHEN 'apr' THEN f.apr " +
            "    WHEN 'may' THEN f.may " +
            "    WHEN 'jun' THEN f.jun " +
            "    WHEN 'jul' THEN f.jul " +
            "    WHEN 'aug' THEN f.aug " +
            "    WHEN 'sep' THEN f.sep " +
            "    WHEN 'oct' THEN f.oct " +
            "    WHEN 'nov' THEN f.nov " +
            "    WHEN 'dec' THEN f.dec " +
            "END )" +
            "FROM FruitMonthPrice f " +
            "WHERE LOWER(f.fruit) = LOWER" +
            "(:fruitName)")
    FruitPriceAndIdResponse fetchFruitMonthPriceByFruitAndMonth(String fruitName, String monthName);
}
