package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import util.ConsoleUIHelper;
import view.PessoaView;

public class PessoaDAO implements Serializable {
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
        FileOutputStream fos = new FileOutputStream("database\\lista_de_clientes.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(listaClientes);
        oos.close();
    }

    public void carregarListaClientes() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("database\\lista_de_clientes.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        setListaClientes((List<Pessoa>) ois.readObject()); 
        ois.close();
    }

    //public void salvarListaClientesJSON() throws IOException {
        // ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        // Java object to JSON file
        // mapper.writeValue(new File("database\\lista_de_clientes.json"), listaClientes);
    //}

    //public void carregarListaClientesJSON() throws StreamReadException, DatabindException, IOException {
        // ObjectMapper mapper = new ObjectMapper();

        // //JSON file to Java object
        // List<Pessoa> listaPessoas = mapper.readValue(new File("database\\lista_de_clientes.json"), 
        // mapper.getTypeFactory().constructCollectionType(List.class, Pessoa.class));
        // System.out.println(listaPessoas);
        // setListaClientes(listaPessoas);

        // // //JSON string to Java Object
        // Staff obj = mapper.readValue("{'name' : 'mkyong'}", Staff.class);
    //}
}
