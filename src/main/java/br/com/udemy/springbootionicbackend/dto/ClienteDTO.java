package br.com.udemy.springbootionicbackend.dto;

import br.com.udemy.springbootionicbackend.domain.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    @NotEmpty(message = "Preenchimento obrigatorio")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Email(message = "Email invalido")
    private String email;

    public ClienteDTO(){}

    public ClienteDTO(Cliente cliente){
        this.id    = cliente.getId();
        this.nome  = cliente.getNome();
        this.email = cliente.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
