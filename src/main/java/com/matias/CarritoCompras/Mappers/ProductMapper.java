package com.matias.CarritoCompras.Mappers;

import com.matias.CarritoCompras.Entities.Dtos.ProductDto;
import com.matias.CarritoCompras.Entities.Product;

public class ProductMapper {

    public static Product dtoToProduct(ProductDto dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setSize(dto.getSize());
        product.setPriceUnit(dto.getPriceUnit());
        product.setAmount(dto.getAmount());

        return product;
    }

    public static ProductDto productToDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setSize(product.getSize());
        dto.setPriceUnit(product.getPriceUnit());
        dto.setAmount(product.getAmount());
        dto.setPriceTotal(product.getPriceTotal());

        return dto;
    }

}
