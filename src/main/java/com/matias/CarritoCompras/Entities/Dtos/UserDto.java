package com.matias.CarritoCompras.Entities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String adress;
    private String postal_Code;
    private String telephone;
    private String  age;

}

