package com.fruitmarket.totalpriceservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fmp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FruitMonthPrice {
    @Id
    private int id;
    private String fruit;
    private String month;
    private double fmp;
    private String environment;
}
