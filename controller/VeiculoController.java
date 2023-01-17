package controller;

import database.VeiculoDAO;
import exceptions.DuplicatedRegisterException;
import model.Veiculo;
import view.VeiculoView;

public class VeiculoController {
    private VeiculoDAO veiculoDAO;

    public VeiculoController() {
        veiculoDAO = VeiculoDAO.getInstance();
    }

    public void adicionar(Veiculo veiculo) {
        if (veiculo != null) {
            try {
                veiculoDAO.add(veiculo);
            } catch (DuplicatedRegisterException e) {
                System.out.println("!!! " + e.getMessage() + " !!!");
            }
        } else {
            VeiculoView.adicionar();
        }
    }

    public void editar(Veiculo veiculo) {
        if (veiculo != null) {
            veiculoDAO.edit(veiculo);
        } else {
            VeiculoView.editar();
        }
    }

    public void buscar(String placa) {
        if (placa != null) {
            VeiculoView.listar(veiculoDAO.search(placa));
        } else {
            VeiculoView.buscar();
        }
    }

    public void listar() {
        VeiculoView.listar(veiculoDAO.getAll());
    }
}
