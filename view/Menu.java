package view;

import java.io.IOException;
import java.util.List;

import model.Pessoa;
import util.ConsoleUIHelper;

public class Menu {
    
    public static void menu() throws ClassNotFoundException, IOException {
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
                AgenciaView.menu();
            }
            case 3 -> { // chama menu aluguel
                AluguelView.menu();
            }
            case 4 -> { // sair
                System.exit(0);
            }

        }
    }
}
