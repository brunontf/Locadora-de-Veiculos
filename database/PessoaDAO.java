package database;

import java.util.ArrayList;
import java.util.List;

import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import util.ConsoleUIHelper;
import view.PessoaView;

public class PessoaDAO {
    private static PessoaDAO instance;
    private List<Pessoa> listaClientes;

    private PessoaDAO(){
        listaClientes = new ArrayList<>();
    }

    public static PessoaDAO getInstance() {
        if ( instance == null){
            instance = new PessoaDAO();
        }
        return instance;
    }

    public boolean eVazio() {
        return listaClientes.isEmpty();
    }

    public List<Pessoa> getListaClientes() {
        return listaClientes;
    }

    public void addPessoa(Pessoa pessoa) {
        listaClientes.add(pessoa);
    }
    
    public void removerPessoa(Pessoa pessoa) {
        listaClientes.remove(pessoa);
    }

    public boolean ePessoaDuplicada(Pessoa pessoa){
        return listaClientes.stream().anyMatch(cliente -> cliente.equals(pessoa));
    }

    public void alterarTipoPessoa() {
        Pessoa pessoa = listaClientes.get(PessoaView.askId());

        if (pessoa.getClass() == PessoaFisica.class){
            Pessoa clienteFisico = new PessoaJuridica(pessoa.getNome(), pessoa.getTelefone(), ConsoleUIHelper.askInt("Digite o CNPJ:"));
            if (ePessoaDuplicada(clienteFisico)){ // verificacao de duplicidade
                System.out.println("Essa pessoa física já existe");
            } else {
                addPessoa(clienteFisico);
                removerPessoa(pessoa);
            }
        } else {
            Pessoa clienteJuridico = new PessoaFisica(pessoa.getNome(), pessoa.getTelefone(), ConsoleUIHelper.askInt("Digite o CPF: "));
            if (ePessoaDuplicada(clienteJuridico)){ // verificacao de duplicidade
                System.out.println("Essa pessoa juridica já existe");
            } else {
                addPessoa(clienteJuridico);
                removerPessoa(pessoa);
            }
        }
    }

    public void listarClientes() {
        PessoaView.listarClientes(listaClientes);
    }
}
