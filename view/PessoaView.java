package view;

import java.util.List;

import controller.PessoaController;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import util.ConsoleUIHelper;

public class PessoaView {
    
    public static void imprimirCliente(Pessoa pessoa) {
        System.out.println("Nome: "+pessoa.getNome());
        System.out.println("Telefone: "+pessoa.getTelefone());
        System.out.println("Classe: "+pessoa.getClass().getSimpleName());
        if (pessoa.getClass() == PessoaFisica.class){
            System.out.println("CPF: "+((PessoaFisica) pessoa).getCpf());
        } else {
            System.out.println("CNPJ: "+((PessoaJuridica) pessoa).getCnpj());
        }
    }

    public static void listarClientes(List<Pessoa> listaClientes) {
        int i = 0;
        for (Pessoa cliente : listaClientes) {
            System.out.println(i + " - " + cliente.getNome() + " - " + cliente.getClass().getSimpleName());
            i++;
        }
        System.out.println();
    }

    public static void addPessoa() {
        PessoaController pessoaController = new PessoaController();
        int pessoaFisica = ConsoleUIHelper.askChooseOption("Escolha o tipo de pessoa", "Pessoa física", "Pessoa jurídica");
        String nome = ConsoleUIHelper.askNoEmptyInput("Digite o nome do contato:", 3);
        String telefone = ConsoleUIHelper.askNoEmptyInput("Digite o telefone do contato:", 3);
        
        if (pessoaFisica == 0){
            Integer cpf = ConsoleUIHelper.askInt("Digite o CPF do cliente");
            Pessoa pessoa = new PessoaFisica(nome, telefone, cpf);
            if (pessoaController.ePessoaDuplicada(pessoa)){
                System.out.println("Contato já adicionado");
            } else {
                pessoaController.addPessoa(pessoa);
            }
        } else {
            Integer cnpj = ConsoleUIHelper.askInt("Digite o CNPJ do cliente");
            Pessoa pessoa = new PessoaJuridica(nome, telefone, cnpj);
            if (pessoaController.ePessoaDuplicada(pessoa)){
                System.out.println("Contato já adicionado");
            } else {
                pessoaController.addPessoa(pessoa);
            }
        }
    }

    public static int askId() {
        return ConsoleUIHelper.askInt("Digite o ID da pessoa");
    }

    public static void listaVazia() {
        ConsoleUIHelper.drawWithPadding("A lista de pessoas está vazia", 80);
    }
    
}
