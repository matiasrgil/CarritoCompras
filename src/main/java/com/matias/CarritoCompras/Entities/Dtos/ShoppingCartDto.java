package com.matias.CarritoCompras.Entities.Dtos;

import com.matias.CarritoCompras.Entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDto {

    private Long id;
    private Long user_id;
    private Long product_id;
    private Long amount;
    private BigDecimal pricePerQuantity;
    private List<Product> products;
    private BigDecimal totalCartPrice;
    private Boolean cartStatus;

}
