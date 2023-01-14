package database;

import model.Agencia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AgenciaDAO {
    private static AgenciaDAO instance;
    private List<Agencia> agencias;

    private AgenciaDAO(){
        agencias = new ArrayList<>();
    }

    public static AgenciaDAO getInstance(){
        if(instance == null){
            instance = new AgenciaDAO();
        }
        return instance;
    }

    public List<Agencia> getAll(){
        return this.agencias;
    }
    public void add(Agencia agencia){
        if(!agencias.stream().anyMatch(ag -> ag.equals(agencia))){
            this.agencias.add(agencia);
            return ;
        }
        System.out.println("[ERRO] - Agência já existe");
    }

    public void edit(Agencia agencia){

    }

    public List<Agencia> search(String nome, String logradouro){
        return agencias.stream()
                .filter(v -> v.getNome().toLowerCase()
                        .contains(nome.toLowerCase())
                ).filter(v -> v.getEndereco().getLogradouro().toLowerCase()
                        .contains(logradouro.toLowerCase())
                )
                .collect(Collectors.toList());
    }
}
