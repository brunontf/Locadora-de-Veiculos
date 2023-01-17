package view;

import controller.VeiculoController;
import database.VeiculoDAO;
import model.*;
import util.ConsoleUIHelper;

import java.util.List;

public class VeiculoView {

    public static void menu() {
        VeiculoController veiculoController = new VeiculoController();
        boolean naoRetornarAoMenuPrincipal = true;

        do {
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
                case 3 -> veiculoController.listar();
                case 4 -> naoRetornarAoMenuPrincipal = false;
            }
        } while (naoRetornarAoMenuPrincipal);
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
        String cor = ConsoleUIHelper.askSimpleInput("Digite a cor do veiculo");
        veiculo.setPlaca(placa);
        veiculo.setCor(cor);
        veiculoController.adicionar(veiculo);
    }

    public static void editar() {
        VeiculoController veiculoController = new VeiculoController();
        VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
        Veiculo veiculo;

        String placa = ConsoleUIHelper.askSimpleInput("Digite a placa do veiculo");
        veiculo = veiculoDAO.getByPlaca(placa);

        if (veiculo == null) return;
        exibir(veiculo);

        String cor = ConsoleUIHelper.askSimpleInput("Digite a nova cor do veiculo");
        veiculo.setCor(cor);

        veiculoController.editar(veiculo);
    }

    public static void buscar() {
        VeiculoController veiculoController = new VeiculoController();

        String placa = ConsoleUIHelper.askSimpleInput("Digite a placa do veiculo");
        veiculoController.buscar(placa);
    }

    public static void listar(List<Veiculo> veiculos) {
        int i = 0;
        for (Veiculo veiculo : veiculos) {
            System.out.println(i + " - " + veiculo.getPlaca() + " " + veiculo.getCor() + " : " + veiculo.precoDiaria());
            i++;
        }
        System.out.println();
    }

    public static void exibir(Veiculo veiculo) {
        System.out.println(veiculo.getPlaca() + " " + veiculo.getCor() + " : " + veiculo.precoDiaria());
    }
}
