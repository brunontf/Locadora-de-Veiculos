package view;

import java.io.IOException;

import controller.PessoaController;
import util.ConsoleUIHelper;

public class MenuPessoa {

    public static void menu() throws IOException, ClassNotFoundException {
        PessoaController pessoaController = new PessoaController();
        boolean naoRetornarAoMenuPrincipal = true;

        do {
            int opcao = ConsoleUIHelper.askChooseOption("Digite a operação desejada",
                    "Adicionar um novo cliente",
                    "Alterar tipo de cliente",
                    "Imprimir cliente",
                    "Salvar lista de clientes",
                    "Carregar lista de clientes",
                    "Retornar ao menu principal");

            switch (opcao) {
                case 0 -> pessoaController.addPessoa(null);
                case 1 -> pessoaController.alterarTipoPessoa();
                case 2 -> pessoaController.imprimirDadosPessoa();
                case 3 -> pessoaController.salvarListaClientes();
                case 4 -> pessoaController.carregarListaClientes();
                case 5 -> naoRetornarAoMenuPrincipal = false;
            }
        } while (naoRetornarAoMenuPrincipal);
    }
}
