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

    public void buscar(String termo) {
        if (termo != null) {
            VeiculoView.listar(veiculoDAO.search(termo));
        } else {
            VeiculoView.buscar();
        }
    }

    public void listar() {
        VeiculoView.listar(veiculoDAO.getAll());
    }

    public void exportar() {
        try {
            veiculoDAO.exportar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void importar() {
        try {
            veiculoDAO.importar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
