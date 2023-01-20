package model;

import java.io.Serializable;
import java.util.UUID;

public class Aluguel implements Serializable {
    private String id;
    private String veiculoId;
    private String agenciaId;
    private String agenciaDevolucaoId;
    private String clienteId;
    private String dataRetirada;
    private String horaRetirada;

    public int getDiarias() {
        return diarias;
    }

    public void setDiarias(int diarias) {
        this.diarias = diarias;
    }

    private int diarias;

    public Aluguel() {
        this.id = UUID.randomUUID().toString();
    }

    public Aluguel(String agenciaId, String veiculoId, String clienteId, String agenciaDevolucaoId, String dataRetirada,
                   String horaRetirada, int diarias){
        this();
        this.veiculoId = veiculoId;
        this.agenciaId = agenciaId;
        this.clienteId = clienteId;
        this.agenciaDevolucaoId = agenciaDevolucaoId;
        this.dataRetirada = dataRetirada;
        this.horaRetirada = horaRetirada;
        this.diarias = diarias;
    }

    public String getId() {
        return id;
    }

    public String getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(String veiculoId) {
        this.veiculoId = veiculoId;
    }

    public String getAgenciaId() {
        return agenciaId;
    }

    public void setAgenciaId(String agenciaId) {
        this.agenciaId = agenciaId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getHoraRetirada() {
        return horaRetirada;
    }

    public void setHoraRetirada(String horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    public String getAgenciaDevolucaoId() {
        return agenciaDevolucaoId;
    }
    
}
