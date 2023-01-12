package view;

import java.util.List;

import model.Pessoa;
import util.ConsoleUIHelper;

public class Menu {
    
    public static void menu() {
        int opcao = ConsoleUIHelper.askChooseOption("Digite a operação desejada",
         "Menu clientes",
          "Menu veiculos",
          "Menu agencias",
          "Menu alugueis",
          "Sair");

        switch (opcao) {
            case 0 -> { // chama menu pessoa
                MenuPessoa.menu();
            }
            case 1 -> { // chama menu veiculo
                VeiculoView.menu();
            }
            case 2 -> { // chama menu agencia
                System.exit(0);
            }
            case 3 -> { // chama menu aluguel
                System.exit(0);
            }
            case 4 -> { // sair
                System.exit(0);
            }

        }
    }
}
