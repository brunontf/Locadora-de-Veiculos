package view;

import controller.VeiculoController;
import model.*;
import util.ConsoleUIHelper;

import java.util.List;

public class VeiculoView {

    public static void menu() {
        VeiculoController veiculoController = new VeiculoController();

        int opcao = ConsoleUIHelper.askChooseOption("Digite a operação desejada",
                "Adicionar um novo veiculo",
                "Editar veiculo",
                "Buscar veiculo",
                "Listar veiculos",
                "Retornar ao menu");

        switch (opcao) {
            case 0 -> veiculoController.adicionar(null);
            case 1 -> veiculoController.editar(null);
            case 2 -> veiculoController.buscar(null);
        }
    }

    public static void adicionar() {
        Veiculo veiculo;
        VeiculoController veiculoController = new VeiculoController();

        int opcao = ConsoleUIHelper.askChooseOption("Digite o tipo de veiculo",
                "Carro",
                "Caminhao",
                "Moto",
                "Retornar ao menu");

        switch (opcao) {
            case 0 -> veiculo = new Carro();
            case 1 -> veiculo = new Caminhao();
            case 2 -> veiculo = new Moto();
            default -> veiculo = new Carro();
        }

        String placa = ConsoleUIHelper.askSimpleInput("Digite a placa do veiculo");
        veiculo.setPlaca(placa);
        veiculoController.adicionar(veiculo);
    }

    public static void editar() {
        int id = ConsoleUIHelper.askInt("Digite a placa do veiculo");
    }

    public static void buscar() {
        int id = ConsoleUIHelper.askInt("Digite a placa do veiculo");
    }

    public static void listar(List<Veiculo> veiculos) {
        int i = 0;
        for (Veiculo veiculo : veiculos) {
            System.out.println(i + " - " + veiculo.getPlaca());
            i++;
        }
        System.out.println();
    }
}
