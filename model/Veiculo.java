package model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Veiculo implements Serializable {
    private String placa;
    private String cor;
    private String nome;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome=nome;
    }

    public abstract float precoDiaria();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(placa.toLowerCase(), veiculo.placa.toLowerCase());
    }
}
