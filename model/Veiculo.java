package model;

public abstract class Veiculo {
    private String placa;
    private float valor;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public abstract float precoDiaria();
}
