package com.matias.CarritoCompras.Mappers;

import com.matias.CarritoCompras.Entities.Dtos.ProductDto;
import com.matias.CarritoCompras.Entities.Product;

public class ProductMapper {

    public static Product dtoToProduct(ProductDto dto){
        Product product = new Product();
        product.setBarCode(dto.getBarCode());
        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setSize(dto.getSize());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());

        return product;
    }

    public static ProductDto productToDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setBarCode(product.getBarCode());
        dto.setName(product.getName());
        dto.setBrand(product.getBrand());
        dto.setSize(product.getSize());
        dto.setCategory(product.getCategory());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());

        return dto;
    }

}
