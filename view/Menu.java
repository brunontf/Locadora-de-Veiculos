package view;

import java.util.List;

import model.Pessoa;
import util.ConsoleUIHelper;

public class Menu {
    
    public static void menu(List<Pessoa> listaClientes) {
        int opcao = ConsoleUIHelper.askChooseOption("Digite a operação desejada",
         "Menu clientes",
          "Menu veiculos",
          "Menu agencias",
          "Menu alugueis",
          "Sair");

        switch (opcao) {
            case 0 -> { // chama menu pessoa
                MenuPessoa.menu(listaClientes);
            }
            case 1 -> { // sair
                VeiculoView.menu();
            }
            case 2 -> { // sair
                System.exit(0);
            }
            case 3 -> { // sair
                System.exit(0);
            }
            case 4 -> { // sair
                System.exit(0);
            }

        }
    }
}
