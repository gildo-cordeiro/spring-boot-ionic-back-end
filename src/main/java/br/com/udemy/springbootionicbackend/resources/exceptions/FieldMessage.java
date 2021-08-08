package br.com.udemy.springbootionicbackend.resources.exceptions;

public class FieldMessage {

    private String nome;
    private String message;

    public FieldMessage(){

    }

    public FieldMessage(String nome, String message) {
        this.nome = nome;
        this.message = message;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
