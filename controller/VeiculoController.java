package controller;

import java.io.IOException;

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

    public String getNomeECorByPlaca(String placa){
        for (Veiculo veiculo : veiculoDAO.getAll()) {
            if (veiculo.getPlaca() == placa){
                return veiculo.getModelo() + " " + veiculo.getModelo()  + " - " + veiculo.getCor();
            }
        }
        return null;
    }

    public void listar() {
        VeiculoView.listar(veiculoDAO.getAll());
    }

    public void listarVeiculosDisponiveis() {
        VeiculoView.listar(veiculoDAO.getVeiculosDisponiveis());
    }

    public void salvarVeiculos() throws IOException {
        veiculoDAO.salvarVeiculos();
    }

    public void carregarVeiculos() throws IOException, ClassNotFoundException {
        veiculoDAO.carregarVeiculos();

    }
}
