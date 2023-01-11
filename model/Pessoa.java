package model;

public abstract class Pessoa {

    private String nome;
    private String telefone;

    Pessoa(String nome, String telefone){
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