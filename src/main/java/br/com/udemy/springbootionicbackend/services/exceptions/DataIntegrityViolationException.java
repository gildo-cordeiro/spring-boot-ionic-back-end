package br.com.udemy.springbootionicbackend.services.exceptions;

//Extende da que captura exceções em tempo de execução
public class DataIntegrityViolationException extends RuntimeException{

    public DataIntegrityViolationException(String msg){
        super(msg);
    }

    public DataIntegrityViolationException(String msg, Throwable cause){
        super(msg, cause);
    }
}
