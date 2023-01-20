package view;

import java.io.IOException;

import controller.AgenciaController;
import controller.AluguelController;
import controller.PessoaController;
import controller.VeiculoController;
import util.ConsoleUIHelper;

public class Menu {

    public static void menu() throws ClassNotFoundException, IOException {
        carregarDataBase();

        int opcao = ConsoleUIHelper.askChooseOption("Digite a operação desejada",
         "Menu clientes",
          "Menu veiculos",
          "Menu agencias",
          "Menu alugueis",
          "Sair");

        switch (opcao) {
            case 0 -> MenuPessoa.menu();
            case 1 -> VeiculoView.menu();
            case 2 -> AgenciaView.menu();
            case 3 -> AluguelView.menu();
            case 4 -> System.exit(0);
        }
    }

    private static void carregarDataBase() throws ClassNotFoundException, IOException {
        AluguelController aluguelController = new AluguelController();
        PessoaController pessoaController = new PessoaController();
        AgenciaController agenciaController = new AgenciaController();
        VeiculoController  veiculoController = new VeiculoController();

        pessoaController.carregarListaClientes();
        agenciaController.carregarListaAgencias();
        veiculoController.carregarVeiculos();
        aluguelController.carregarAlugueis();

    }
}
