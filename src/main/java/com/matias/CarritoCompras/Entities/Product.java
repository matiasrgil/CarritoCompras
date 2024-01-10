package com.matias.CarritoCompras.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "codigo_de_barras")
    @Size(max = 13)
    private Long barCode;

    @Column(name = "nombre")
    @Size(max = 50)
    private String name;

    @Column(name = "marca")
    @Size(max = 50)
    private String brand;

    @Column(name = "tamaño")
    private String size; //tamaño de producto

    @Column(name = "categoria")
    @Size(max = 20)
    private String category;

    @Column(name = "precio")
    private BigDecimal price; // precio de producto unitario

    @Column(name = "stock")
    private Long stock; //Cantidad de producto

    

}

