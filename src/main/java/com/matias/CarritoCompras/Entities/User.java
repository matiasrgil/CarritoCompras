package com.matias.CarritoCompras.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nombre")
    @Size(max = 50)
    private String name;

    @Column(name="contrasenia")
    @Size(min = 8, max = 16)
    private String password;

    @Column(name = "correo")
    @Size(max = 100)
    private String email;

    @Size(max = 100)
    @Column(name = "direccion")
    private String adress;

    @Column(name = "codigo_Postal")
    @Size(max = 5)
    private String postal_Code;

    @Column(name = "telefono")
    @Size(max = 10)
    private String telephone;

    @Column(name = "edad")
    @Size(max = 5)
    private String age;

}
