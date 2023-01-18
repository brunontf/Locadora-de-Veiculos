package view;

import java.sql.Date;
import java.util.List;

import controller.AgenciaController;
import controller.AluguelController;
import controller.PessoaController;
import controller.VeiculoController;
import database.AgenciaDAO;
import database.PessoaDAO;
import database.VeiculoDAO;
import model.Aluguel;
import model.Pessoa;
import model.PessoaFisica;
import util.ConsoleUIHelper;

public class AluguelView {
    public static void menu() {
        AluguelController aluguelController = new AluguelController();
        boolean naoRetornarAoMenuPrincipal = true;

        do {
            int opcao = ConsoleUIHelper.askChooseOption("Digite a opção desejada",
                    "Alugar um veiculo",
                    "Devolver um veiculo",
                    "Listar alugueis ativos",
                    "Retornar ao menu");
            switch (opcao) {
                case 0 -> aluguelController.alugar(null);
                case 1 -> aluguelController.devolver(null);
                case 2 -> aluguelController.listar();
                case 3 -> naoRetornarAoMenuPrincipal = false;
            }

        } while (naoRetornarAoMenuPrincipal);

    }

    public static void alugar() {
        AluguelController aluguelController = new AluguelController();
        PessoaController pessoaController = new PessoaController();
        AgenciaController agenciaController = new AgenciaController();
        VeiculoController  veiculoController = new VeiculoController();


        // System.out.println("Listar os dados de cliente, agencia e cliente e escolher uma opcao");

        pessoaController.listarClientes();
        int clientePosicao = ConsoleUIHelper.askInt("Selecione um cliente\n");
        agenciaController.listar();
        int agenciaPosicao = ConsoleUIHelper.askInt("Selecione a agencia");
        veiculoController.listarVeiculosDisponiveis();
        int veiculoPosicao = ConsoleUIHelper.askInt("Selecione o veiculo");
        // selecionarData();
        agenciaController.listar();
        int agenciaDevolucaoPosicao = ConsoleUIHelper.askInt("Selecione a agencia de devolucao");
        
        aluguelController.alugar(new Aluguel(
            AgenciaDAO.getInstance().getAll().get(agenciaPosicao).getId(),
            VeiculoDAO.getInstance().getVeiculosDisponiveis().get(veiculoPosicao).getPlaca(),
            pessoaController.retornaIdCliente(clientePosicao),// cpf ou cnpj
            AgenciaDAO.getInstance().getAll().get(agenciaDevolucaoPosicao).getId() 
            ));
    }
        
    public static void devolver() {
        AluguelController aluguelController = new AluguelController();
            
        aluguelController.listar();
        int aluguelPosicao = ConsoleUIHelper.askInt("Selecione o aluguel de devolucao");
        aluguelController.devolverPorId(aluguelPosicao);
    }
    
    public static void selecionarData() {
        System.out.println("Selecione a data");
        System.out.println("Selecione o horario");
    }

    public static void listar(List<Aluguel> alugueis) {
        PessoaController pessoaController = new PessoaController();
        AgenciaController agenciaController = new AgenciaController();
        VeiculoController veiculoController = new VeiculoController();

        int i = 0;
        for (Aluguel aluguel : alugueis) {
            System.out.println(i + " - " + veiculoController.getNomeECorByPlaca(aluguel.getVeiculoId())
                + " - " + agenciaController.getEndereçoById(aluguel.getAgenciaId()) 
                + " - " + pessoaController.getNomeById(aluguel.getClienteId()));
            System.out.println(pessoaController.getNomeById(aluguel.getClienteId()));
            i++;
        }
        System.out.println();
    }
}
