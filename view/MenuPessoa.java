package view;

import java.util.List;

import controller.PessoaController;
import model.Pessoa;
import model.PessoaFisica;
import util.ConsoleUIHelper;

public class MenuPessoa {
    
    public static void menu() {
        PessoaController pessoaController = new PessoaController();
        boolean retornarAoMenuPrincipal = true;

        do{
                int opcao = ConsoleUIHelper.askChooseOption("Digite a operação desejada",
                "Adicionar um novo cliente",
                "Alterar tipo de cliente",
                "Imprimir cliente",
                "Retornar ao menu principal");
                
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
            }
        } while (retornarAoMenuPrincipal);
    }
}
