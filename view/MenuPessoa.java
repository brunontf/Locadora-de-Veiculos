package view;

import java.util.List;

import controller.PessoaController;
import model.Pessoa;
import model.PessoaFisica;
import util.ConsoleUIHelper;

public class MenuPessoa {
    
    public static void menu(List<Pessoa> listaClientes) {
        int opcao = ConsoleUIHelper.askChooseOption("Digite a operação desejada",
         "Adicionar um novo cliente",
          "Editar cliente",
          "Imprimir cliente",
          "Retornar ao menu");

        switch (opcao) {
            case 0 -> { // add cliente
                PessoaController.addPessoa(listaClientes);
            }

            case 1 ->{ // editar cliente
                PessoaView.listarClientes(listaClientes);
                int id = ConsoleUIHelper.askInt("Digite o ID da pessoa");
                PessoaController.alterarTipoPessoa(listaClientes, listaClientes.get(id));
            }
            
            case 2 ->{ // imprimir pessoa
                PessoaView.listarClientes(listaClientes);
                int id = ConsoleUIHelper.askInt("Digite o ID da pessoa");
                PessoaView.imprimirCliente(listaClientes.get(id));
            }

            case 3 ->{ // menu
                return;
            }
        }
    }
}
