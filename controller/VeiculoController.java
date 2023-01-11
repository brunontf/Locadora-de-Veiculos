package controller;

import database.VeiculoDAO;
import model.Veiculo;
import view.VeiculoView;

import java.util.ArrayList;
import java.util.List;

public class VeiculoController {
    private VeiculoDAO veiculoDAO;

    public VeiculoController() {
        veiculoDAO = VeiculoDAO.getInstance();
    }

    public void adicionar(Veiculo veiculo) {
        if (veiculo != null) {
            veiculoDAO.add(veiculo);
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
