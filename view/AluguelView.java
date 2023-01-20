package view;

import java.sql.Date;
import java.util.List;

import controller.AgenciaController;
import controller.AluguelController;
import controller.PessoaController;
import controller.VeiculoController;
import database.AgenciaDAO;
import database.AluguelDAO;
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



        pessoaController.listarClientes();
        int clientePosicao = ConsoleUIHelper.askInt("Selecione um cliente\n");
        agenciaController.listar();
        int agenciaPosicao = ConsoleUIHelper.askInt("Selecione a agencia");
        veiculoController.listarVeiculosDisponiveis(AgenciaDAO.getInstance().getIdByPosition(agenciaPosicao));
        int veiculoPosicao = ConsoleUIHelper.askInt("Selecione o veiculo");
        String dataRetirada = ConsoleUIHelper.askSimpleInput("Selecione a data de retirada");
        String horaRetirada = ConsoleUIHelper.askSimpleInput("Selecione a hora de retirada");
        int diarias = ConsoleUIHelper.askInt("Quantos dias você irá alugar: ");
        agenciaController.listar();
        int agenciaDevolucaoPosicao = ConsoleUIHelper.askInt("Selecione a agencia de devolucao");

        Aluguel aluguel = new Aluguel(
                AgenciaDAO.getInstance().getAll().get(agenciaPosicao).getId(),
                VeiculoDAO.getInstance().getVeiculosDisponiveis(AgenciaDAO.getInstance().getIdByPosition(agenciaPosicao)).get(veiculoPosicao).getPlaca(),
                pessoaController.retornaIdCliente(clientePosicao),// cpf ou cnpj
                AgenciaDAO.getInstance().getAll().get(agenciaDevolucaoPosicao).getId(),
                dataRetirada, horaRetirada, diarias
        );
        
        aluguelController.alugar(aluguel);

        ComprovanteView.menuAluguel(aluguel);


    }
        
    public static void devolver() {
        AluguelController aluguelController = new AluguelController();
        aluguelController.listar();
        int aluguelPosicao = ConsoleUIHelper.askInt("Selecione o aluguel de devolucao");
        ComprovanteView.menuDevolucao(AluguelDAO.getInstance().getAll().get(aluguelPosicao));
        aluguelController.devolverPorId(aluguelPosicao);


    }

    public static void listar(List<Aluguel> alugueis) {
        int i = 0;
        for (Aluguel aluguel : alugueis) {
            System.out.println("Aluguel "+i+":");
            AgenciaView.exibir(AgenciaDAO.getInstance().getAgenciaById(aluguel.getAgenciaId()), null);
            PessoaView.exibirDadosPessoa(PessoaDAO.getInstance().getPessoaById(aluguel.getClienteId()));
            VeiculoView.exibir(VeiculoDAO.getInstance().getByPlaca(aluguel.getVeiculoId()), null);
            i++;
        }
        System.out.println();
    }
}
