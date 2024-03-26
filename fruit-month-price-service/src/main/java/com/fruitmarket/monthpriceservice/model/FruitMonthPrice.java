package com.fruitmarket.monthpriceservice.model;

import jakarta.persistence.*;
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
    private double jan;
    private double feb;
    private double mar;
    private double apr;
    private double may;
    private double jun;
    private double jul;
    private double aug;
    private double sep;
    private double oct;
    private double nov;
    private double dec;
}
