package com.Proyecto.ONU.Exceptions;


public class NombreInvalidoException extends RuntimeException {
    public NombreInvalidoException(String message) {
        super(message);
    }
}