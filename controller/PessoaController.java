package controller;

import java.util.List;

import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import util.ConsoleUIHelper;

public class PessoaController {

    public static boolean ePessoaDuplicada(List<Pessoa> listaClientes, Pessoa pessoa) {
        return listaClientes.stream().anyMatch(cliente -> cliente.equals(pessoa));
    }

    public static void alterarTipoPessoa(List<Pessoa> listaClientes, Pessoa pessoa) {
        if (pessoa.getClass() == PessoaFisica.class){
            Pessoa clienteFisico = new PessoaJuridica(pessoa.getNome(), pessoa.getTelefone(), ConsoleUIHelper.askInt("Digite o CNPJ:"));
            if (ePessoaDuplicada(listaClientes, clienteFisico)){ // verificacao de duplicidade
                System.out.println("Essa pessoa física já existe");
                return;
            }
            listaClientes.remove(pessoa);
            listaClientes.add(clienteFisico);
        } else {
            Pessoa clienteJuridico = new PessoaFisica(pessoa.getNome(), pessoa.getTelefone(), ConsoleUIHelper.askInt("Digite o CPF: "));
            if (ePessoaDuplicada(listaClientes, clienteJuridico)){ // verificacao de duplicidade
                System.out.println("Essa pessoa juridica já existe");
                return;
            }
            listaClientes.remove(pessoa);
            listaClientes.add(clienteJuridico);
        }
    }

    public static void addPessoa(List<Pessoa> listaClientes) {
        boolean clienteFisico = (ConsoleUIHelper.askChooseOption("É cliente físico ?", "sim","não")) == 0 ? true : false;
        String nome = ConsoleUIHelper.askNoEmptyInput("Digite o nome do contato:", 3);
        String telefone = ConsoleUIHelper.askNoEmptyInput("Digite o telefone do contato:", 3);
        
        if (clienteFisico){
            Integer cpf = ConsoleUIHelper.askInt("Digite o CPF do cliente");
            Pessoa pessoa = new PessoaFisica(nome, telefone, cpf);
            if (ePessoaDuplicada(listaClientes, pessoa)){
                System.out.println("Contato já adicionado");
            } else {
                listaClientes.add(pessoa);
            }
        } else {
            Integer cnpj = ConsoleUIHelper.askInt("Digite o CNPJ do cliente");
            Pessoa pessoa = new PessoaJuridica(nome, telefone, cnpj);
            if (ePessoaDuplicada(listaClientes, pessoa)){
                System.out.println("Contato já adicionado");
            } else {
                listaClientes.add(pessoa);
            }
        }
    }


    
}
