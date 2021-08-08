package br.com.udemy.springbootionicbackend.dto;

import br.com.udemy.springbootionicbackend.domain.Categoria;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @Length(max = 20, min = 3, message = "O tamanho deve ser entre 3 e 20 caracteres")
    @NotEmpty(message = "Por favor, insira algo")
    @NotNull(message = "Objeto vazio")
    private String nome;

    public CategoriaDTO(){}

    public CategoriaDTO(Categoria categoria){
        this.id   = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
