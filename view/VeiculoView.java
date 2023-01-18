package view;

import controller.VeiculoController;
import database.VeiculoDAO;
import model.*;
import util.ConsoleUIHelper;

import java.io.IOException;
import java.util.List;

public class VeiculoView {

    public static void menu() throws IOException, ClassNotFoundException {
        VeiculoController veiculoController = new VeiculoController();

        boolean naoRetornarAoMenuPrincipal = true;

        do {
            int opcao = ConsoleUIHelper.askChooseOption("Digite a operação desejada",
            "Adicionar um novo veiculo",
            "Editar veiculo",
            "Buscar veiculo",
            "Listar veiculos",
            "Salvar veiculos",
            "Carregar veículos",
            "Retornar ao menu");
            
            switch (opcao) {
                case 0 -> veiculoController.adicionar(null);
                case 1 -> veiculoController.editar(null);
                case 2 -> veiculoController.buscar(null);
                case 3 -> veiculoController.listar();
                case 4 -> veiculoController.salvarVeiculos();
                case 5 -> veiculoController.carregarVeiculos();
                case 6 -> naoRetornarAoMenuPrincipal = false;
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
        String marca = ConsoleUIHelper.askSimpleInput("Digite a marca do veiculo");
        String modelo = ConsoleUIHelper.askSimpleInput("Digite o modelo do veiculo");
        int ano = ConsoleUIHelper.askInt("Digite o ano do veiculo");

        veiculo.setPlaca(placa);
        veiculo.setCor(cor);
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculo.setAno(ano);
        veiculoController.adicionar(veiculo);
    }

    public static void editar() {
        VeiculoController veiculoController = new VeiculoController();
        VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
        Veiculo veiculo;

        String placa = ConsoleUIHelper.askSimpleInput("Digite a placa do veiculo");
        veiculo = veiculoDAO.getByPlaca(placa);

        if (veiculo == null) return;
        exibir(veiculo, null);

        String cor = ConsoleUIHelper.askSimpleInput("Digite a nova cor do veiculo");
        String marca = ConsoleUIHelper.askSimpleInput("Digite a marca do veiculo");
        String modelo = ConsoleUIHelper.askSimpleInput("Digite o modelo do veiculo");
        int ano = ConsoleUIHelper.askInt("Digite o ano do veiculo");
        veiculo.setCor(cor);
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculo.setAno(ano);

        veiculoController.editar(veiculo);
    }

    public static void buscar() {
        VeiculoController veiculoController = new VeiculoController();

        String termo = ConsoleUIHelper.askSimpleInput("Digite o termo da busca");
        veiculoController.buscar(termo);
    }

    public static void listar(List<Veiculo> veiculos) {
        int i = 0;
        for (Veiculo veiculo : veiculos) {
            exibir(veiculo, i++);
        }
        System.out.println();
    }

    public static void exibir(Veiculo veiculo, Integer index) {
        if(index != null) {
            System.out.print(index + ": ");
        }
        System.out.println("[" + veiculo.getPlaca() + "] " + veiculo.getMarca() + " " + veiculo.getModelo() + " " + veiculo.getCor() + " Diaria: " + veiculo.precoDiaria());
    }
}
