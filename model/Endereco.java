package model;

import java.io.Serializable;
import java.util.Objects;

public class Endereco implements Serializable {
    private String cep;
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;

    public Endereco(){

    }
    public Endereco(String logradouro){
        this.logradouro = logradouro;
    }

    public Endereco(String cep, String logradouro, String numero, String cidade, String estado){
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(cep.toLowerCase(), endereco.cep.toLowerCase())
                && Objects.equals(logradouro.toLowerCase(), endereco.logradouro.toLowerCase())
                && Objects.equals(numero.toLowerCase(), endereco.numero.toLowerCase())
                && Objects.equals(cidade.toLowerCase(), endereco.cidade.toLowerCase())
                && Objects.equals(estado.toLowerCase(), endereco.estado.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, logradouro, numero, cidade, estado);
    }

    @Override
    public String toString() {
        return ("cidade=" + cidade + ", estado=" + estado);
    }
}
