package database;

import model.Agencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AgenciaDAO implements Serializable {
    private static AgenciaDAO instance;
    private List<Agencia> agencias;

    private AgenciaDAO(){
        agencias = new ArrayList<>();
        carregarListaAgencias();
    }

    public static AgenciaDAO getInstance(){
        if(instance == null){
            instance = new AgenciaDAO();
        }
        return instance;
    }

    public Agencia getAgenciaById(String id){
        return agencias.stream()
                .filter(agencia -> agencia.getId().equals(id))
                .toList()
                .get(0);
    }

    public List<Agencia> getAll(){
        return this.agencias;
    }
    public void add(Agencia agencia){
        if(agencias.stream().noneMatch(ag -> ag.equals(agencia))){
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

    public void salvarListaAgencias() throws IOException {
        FileOutputStream fos = new FileOutputStream("./database/lista_de_agencias.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(agencias);
        oos.close();
    }

    public void carregarListaAgencias() {
        try {
            FileInputStream fis = new FileInputStream("./database/lista_de_agencias.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            setListaAgencias((List<Agencia>) ois.readObject());
            ois.close();
        } catch (Exception e) {

        }
    }

    public List<Agencia> getListaAgencias() {
        return agencias;
    }
    public void setListaAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }

    public String getIdByPosition(int agencia) {
        return agencias.get(agencia).getId();
    }
}
