package model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Agencia implements Serializable {
    //private List<Veiculo> veiculos;
    private String nome;
    private String id;
    private Endereco endereco;

    public Agencia(){
        String uniqueId = UUID.randomUUID().toString();
        id = uniqueId;
    }

    public Agencia(String nome){
        this();
        this.nome = nome;
    }
    public Agencia(String nome, Endereco endereco){
        this();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "id="+id +", "+"nome='" + nome +", "+"endereço=" + endereco ;
    }
}
