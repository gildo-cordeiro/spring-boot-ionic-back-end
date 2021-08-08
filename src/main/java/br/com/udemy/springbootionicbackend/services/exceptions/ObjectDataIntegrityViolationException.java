package br.com.udemy.springbootionicbackend.services.exceptions;

//Extende da que captura exceções em tempo de execução
public class ObjectDataIntegrityViolationException extends RuntimeException{

    public ObjectDataIntegrityViolationException(String msg){
        super(msg);
    }

    public ObjectDataIntegrityViolationException(String msg, Throwable cause){
        super(msg, cause);
    }
}
