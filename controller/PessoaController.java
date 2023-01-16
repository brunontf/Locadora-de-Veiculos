package controller;

import java.io.IOException;

import database.PessoaDAO;
import model.Pessoa;
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
        pessoaDAO.salvarListaClientesJSON();
    }

    public void carregarListaClientes() throws ClassNotFoundException, IOException {
        // pessoaDAO.carregarListaClientes();
        pessoaDAO.carregarListaClientesJSON();
    }
    
}
