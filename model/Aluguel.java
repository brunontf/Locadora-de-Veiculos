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
    private String dataDevolucao;
    private String horaRetirada;
    private String horaDevolucao;

    public Aluguel() {
        this.id = UUID.randomUUID().toString();
    }

    public Aluguel(String agenciaId, String veiculoId, String clienteId, String agenciaDevolucaoId){
        this();
        this.veiculoId = veiculoId;
        this.agenciaId = agenciaId;
        this.clienteId = clienteId;
        this.agenciaDevolucaoId = agenciaDevolucaoId;
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

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getHoraRetirada() {
        return horaRetirada;
    }

    public void setHoraRetirada(String horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    public String getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(String horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }
}
