package view;

import controller.AgenciaController;
import model.Agencia;
import model.Endereco;
import util.ConsoleUIHelper;

import java.io.IOException;
import java.util.List;

public class AgenciaView {
    public static void menu() throws IOException, ClassNotFoundException {
        AgenciaController agenciaController = new AgenciaController();
        boolean naoRetornarAoMenuPrincipal = true;

        do{
            int opcao = ConsoleUIHelper.askChooseOption("Digite a opção desejada",
            "Adicionar uma nova agência",
            "Editar agência",
            "Buscar agência",
            "Listar agências",
            "Salvar lista de agências",
            "Carregar lista de agências",
            "Retornar ao menu"
            );
            switch (opcao){
                case 0 -> agenciaController.adicionar(null);
                case 1 -> agenciaController.editar(null);
                case 2 -> agenciaController.buscar(null, null);
                case 3 -> agenciaController.listar();
                case 4 -> agenciaController.salvarListaAgencias();
                case 5 -> agenciaController.carregarListaAgencias();
                case 6 -> naoRetornarAoMenuPrincipal = false;
            }
        } while (naoRetornarAoMenuPrincipal);
    }

    public static void adicionar(){
        Agencia agencia = new Agencia();
        Endereco endereco = new Endereco();
        AgenciaController agenciaController = new AgenciaController();

        String nome = ConsoleUIHelper.askSimpleInput("Digite o nome da agência");
        agencia.setNome(nome);

        String cep = ConsoleUIHelper.askSimpleInput("Digite seu cep").replace("-", "");
        String logradouro = ConsoleUIHelper.askSimpleInput("Digite seu logradouro");
        String numero = ConsoleUIHelper.askSimpleInput("Digite seu numero");
        String cidade = ConsoleUIHelper.askSimpleInput("Digite sua cidade");
        String estado = ConsoleUIHelper.askSimpleInput("Digite seu estado");

        endereco.setCep(cep);
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);

        agencia.setEndereco(endereco);

        agenciaController.adicionar(agencia);
    }

    public static void editar() {
        String nome = ConsoleUIHelper.askSimpleInput("Digite o nome da agência");
        String logradouro = ConsoleUIHelper.askSimpleInput("Digite seu logradouro");
    }

    public static void buscar() {
        AgenciaController agenciaController = new AgenciaController();
        String nome = ConsoleUIHelper.askSimpleInput("Digite o nome da agência");
        String logradouro = ConsoleUIHelper.askSimpleInput("Digite seu logradouro");

        agenciaController.buscar(nome, logradouro);

    }

    public static void listar(List<Agencia> agencias) {
        int i = 0;
        for(Agencia agencia: agencias){
            System.out.println(i + " - " + agencia.toString());
            i++;
        }
        System.out.println();
    }




}
