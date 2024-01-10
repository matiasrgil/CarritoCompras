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
    private Long barCode;
    private String name;
    private String brand;
    private String size;
    private String category;
    private BigDecimal price;
    private Long stock;

}
