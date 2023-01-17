package controller;

import database.AgenciaDAO;
import model.Agencia;
import view.AgenciaView;

import java.io.IOException;

public class AgenciaController {
    private AgenciaDAO agenciaDAO;

    public AgenciaController(){
        agenciaDAO = AgenciaDAO.getInstance();
    }

    public void adicionar(Agencia agencia){
        if(agencia != null){
            agenciaDAO.add(agencia);
        } else {
            AgenciaView.adicionar();
        }
    }

    public void editar(Agencia agencia){
        if(agencia != null){
            agenciaDAO.edit(agencia);
        } else {
            AgenciaView.editar();
        }
    }
    public void buscar(String nome, String logradouro){
        if(nome != null || logradouro != null){
            AgenciaView.listar(agenciaDAO.search(nome, logradouro));
        } else {
            AgenciaView.buscar();
        }
    }
    public void listar(){
        AgenciaView.listar(agenciaDAO.getAll());
    }

    public void salvarListaAgencias() throws IOException {
        agenciaDAO.salvarListaAgencias();
    }
    public void carregarListaAgencias() throws IOException, ClassNotFoundException {
        agenciaDAO.carregarListaAgencias();
    }
}
