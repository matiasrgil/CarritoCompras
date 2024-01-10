package com.matias.CarritoCompras.Controllers;

import com.matias.CarritoCompras.Entities.Dtos.ProductDto;
import com.matias.CarritoCompras.Servicies.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getProducts());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDto product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(product));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable @Valid Long id, @RequestBody ProductDto product){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateProduct(id, product));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteProduct(id));
    }


}
