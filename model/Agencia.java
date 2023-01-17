package model;

import java.io.Serializable;
import java.util.Objects;

public class Agencia implements Serializable {
    //private List<Veiculo> veiculos;
    private String nome;
    private Endereco endereco;

    public Agencia(){

    }

    public Agencia(String nome){
        this.nome = nome;
    }
    public Agencia(String nome, Endereco endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agencia agencia = (Agencia) o;
        return Objects.equals(nome.toLowerCase(), agencia.nome.toLowerCase())
                && Objects.equals(endereco, agencia.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, endereco);
    }

    @Override
    public String toString() {
        return "nome='" + nome +", "+"endereço=" + endereco ;
    }
}
