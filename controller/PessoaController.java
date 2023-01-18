package controller;

import java.io.IOException;

import database.PessoaDAO;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import view.PessoaView;

public class PessoaController {
    private PessoaDAO pessoaDAO;

    public PessoaController(){
        pessoaDAO = PessoaDAO.getInstance();
    }

    public boolean ePessoaDuplicada(Pessoa pessoa) {
        return pessoaDAO.ePessoaDuplicada(pessoa);
    }

    public void alterarTipoPessoa() {
        if (pessoaDAO.eVazio()){
            PessoaView.listaVazia();
        } else{
            listarClientes();
            pessoaDAO.alterarTipoPessoa();
        }
    }

    public void addPessoa(Pessoa pessoa) {
        if(pessoa != null){
            pessoaDAO.addPessoa(pessoa);
        } else{
            PessoaView.addPessoa();
        }
    }

    public void listarClientes() {
        pessoaDAO.listarClientes();
    }

    public String getNomeById(String id) {
        for (Pessoa pessoa : pessoaDAO.getListaClientes()){
            if (pessoa.getClass() == PessoaFisica.class){
                if (String.valueOf(((PessoaFisica) pessoa).getCpf()) == id){
                    return pessoa.getNome();
                }
            } else if (pessoa.getClass() == PessoaJuridica.class){
                if (String.valueOf(((PessoaJuridica) pessoa).getCnpj()) == id){
                    return pessoa.getNome();
                }
            }
        }
        return null;
    }

    public void imprimirDadosPessoa() {
        if (pessoaDAO.eVazio()){
            PessoaView.listaVazia();
        }else {
            listarClientes();
            Pessoa pessoa = pessoaDAO.getListaClientes().get(PessoaView.askId());
            PessoaView.imprimirCliente(pessoa);
        }
    }

    public void salvarListaClientes() throws IOException {
        pessoaDAO.salvarListaClientes();
        //pessoaDAO.salvarListaClientesJSON();
    }

    public void carregarListaClientes() throws ClassNotFoundException, IOException {
        pessoaDAO.carregarListaClientes();
        //pessoaDAO.carregarListaClientesJSON();
    }

    public String retornaIdCliente(int posicao) {
        return pessoaDAO.retornaIdCliente(posicao);
    }
    
}
