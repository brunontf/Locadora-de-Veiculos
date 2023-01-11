package controller;

import model.Veiculo;
import view.VeiculoView;

import java.util.List;

public class VeiculoController {
    private List<Veiculo> veiculos;

    public void adicionar(Veiculo veiculo) {
        if (veiculo != null) {
            veiculos.add(veiculo);
        } else {
            VeiculoView.adicionar();
        }
    }

    public void editar(Veiculo veiculo) {
        if (veiculo != null) {

        }

        VeiculoView.editar();
    }

    public void buscar(String termo) {
        if (termo != null) {

        }

        VeiculoView.buscar();
    }

    public void listar() {
        VeiculoView.listar(veiculos);
    }
}
