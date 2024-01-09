package com.matias.CarritoCompras.Exceptions.Users;

public class UserMailDuplicated extends RuntimeException{
    public UserMailDuplicated(String message){
        super(message);
    }

    public UserMailDuplicated() {super("Correo duplicado. Ya existe en la base de datos");}

}
