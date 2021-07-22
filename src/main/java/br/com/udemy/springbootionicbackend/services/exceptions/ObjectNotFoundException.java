package br.com.udemy.springbootionicbackend.services.exceptions;

//Extende da que captura exceções em tempo de execução
public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String msg){
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
