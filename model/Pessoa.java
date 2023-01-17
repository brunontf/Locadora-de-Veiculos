package model;

import java.io.Serializable;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import com.fasterxml.jackson.databind.annotation.JsonSerialize;
// @JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Pessoa implements Serializable {

    private String nome;
    private String telefone;

    public Pessoa(){}

    public Pessoa(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    
}