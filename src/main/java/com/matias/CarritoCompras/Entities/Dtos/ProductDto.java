package com.matias.CarritoCompras.Entities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {

    private Long id;
    private String name;
    private String size;
    private BigDecimal priceUnit;
    private BigDecimal priceTotal;
    private Integer amount;

}
