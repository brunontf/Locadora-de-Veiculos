package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import util.ConsoleUIHelper;
import view.PessoaView;

public class PessoaDAO implements Serializable {
    private static PessoaDAO instance;
    private List<Pessoa> listaClientes;
    private Pessoa cliente;

    private PessoaDAO(){
        listaClientes = new ArrayList<>();
        carregarListaClientes();
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

    public void setListaClientes(List<Pessoa> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public static void setInstance(PessoaDAO instance) {
        PessoaDAO.instance = instance;
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

    public void salvarListaClientes() throws IOException {
        FileOutputStream fos = new FileOutputStream("./database/lista_de_clientes.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(listaClientes);
        oos.close();
    }

    public void carregarListaClientes() {
        try {
            FileInputStream fis = new FileInputStream("./database/lista_de_clientes.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            setListaClientes((List<Pessoa>) ois.readObject());
            ois.close();
        } catch (Exception e) {

        }
    }

    public String retornaIdCliente(int posicao) { // retorna cpf ou cnpj
        cliente = listaClientes.get(posicao);
        String id = String.valueOf((cliente.getClass() == PessoaFisica.class ) ?
            ((PessoaFisica) listaClientes.get(posicao)).getCpf() :
            ((PessoaJuridica) listaClientes.get(posicao)).getCnpj());
        return id;
    }
}
