package com.javanauta.usuario.infrastructure.exceptions;


import org.springframework.security.core.AuthenticationException;

public class UnauthorizeException extends AuthenticationException {

    public UnauthorizeException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }

    public UnauthorizeException(String mensagem){
        super(mensagem);
    }
}
