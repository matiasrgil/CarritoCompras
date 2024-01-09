package com.matias.CarritoCompras.Exceptions.Users;

public class NameInvalid extends RuntimeException{

    public NameInvalid(String message) {super(message);}


    public NameInvalid() {super("Nombre invalido");}

}
