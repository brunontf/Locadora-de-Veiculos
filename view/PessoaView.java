package view;

import java.util.List;

import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;

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
            System.out.println(i + " - " + cliente.getNome());
            i++;
        }
        System.out.println();
    }
}
