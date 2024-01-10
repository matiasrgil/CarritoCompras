package com.matias.CarritoCompras.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

import java.math.BigDecimal;

@Entity
@Table(name= "Productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    @Size(max = 50)
    private String name;

    @Column(name = "tamaño")
    private String size; //tamaño de producto

    @Column(name = "precioUnit")
    private BigDecimal priceUnit; // precio de producto unitario

    @Column(name = "precioTotal")
    private BigDecimal priceTotal; // precio por cantidad de productos

    @Column(name = "cantidad")
    private Integer amount; //Cantidad de producto

    

}

