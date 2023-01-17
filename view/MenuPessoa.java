package view;

import java.io.IOException;
import java.util.List;

import controller.PessoaController;
import model.Pessoa;
import model.PessoaFisica;
import util.ConsoleUIHelper;

public class MenuPessoa {
    
    public static void menu() throws IOException, ClassNotFoundException {
        PessoaController pessoaController = new PessoaController();
        boolean retornarAoMenuPrincipal = true;

        do{
                int opcao = ConsoleUIHelper.askChooseOption("Digite a operação desejada",
                "Adicionar um novo cliente",
                "Alterar tipo de cliente",
                "Imprimir cliente",
                "Retornar ao menu principal",
                "Salvar lista de clientes",
                "Carregar lista de clientes");
                
                switch (opcao) {
                case 0 -> { // add cliente
                    pessoaController.addPessoa(null);
                }
                
                case 1 ->{ // alterar Tipo Pessoa
                    pessoaController.alterarTipoPessoa();
                }
                
                case 2 ->{ // imprimir pessoa
                    pessoaController.imprimirDadosPessoa();
                }
                
                case 3 ->{ // menu
                    retornarAoMenuPrincipal = false;
                }
                
                case 4 ->{ // menu
                    pessoaController.salvarListaClientes();
                }
                
                case 5 ->{ // menu
                    pessoaController.carregarListaClientes();
                }
            }
        } while (retornarAoMenuPrincipal);
    }
}
