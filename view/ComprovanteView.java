package view;

import controller.AgenciaController;
import controller.AluguelController;
import database.AgenciaDAO;
import database.PessoaDAO;
import database.VeiculoDAO;
import model.Aluguel;
import model.Veiculo;
import util.ConsoleUIHelper;

public class ComprovanteView {
    public static void menuDevolucao(Aluguel aluguel) {
        AluguelController aluguelController = new AluguelController();

        /*
         * [COMPROVANTE DE ALUGUEL]
         * [DADOS DA PESSOA: nome, tipo de pessoa]
         * [DADOS DO VEÍCULO: dados do exibir]
         * [DADOS DA AGÊNCIA: nome, endereço]
         * [DATA e HORA: data e horário de retirada]
         * [VALOR: valor total pago para aluguel]
         * */
        /*
         * [COMPROVANTE DE DEVOLUÇÃO]
         * [DADOS DA PESSOA: nome, tipo de pessoa]
         * [DADOS DO VEÍCULO: dados do exibir]
         * [DADOS DA AGÊNCIA: nome, endereço]
         * [DATA e HORA: data e horário de devolução]
         * */

        String dataDevolucao = ConsoleUIHelper.askSimpleInput("Selecione a data de devolução");
        String horaDevolucao = ConsoleUIHelper.askSimpleInput("Selecione a hora de devolução");

        System.out.println("-=-=-=-=COMPROVANTE DE DEVOLUÇÃO-=-=-=-=");

        saidaComprovante(aluguel);

        System.out.printf("DATA DE DEVOLUÇÃO:\n\t\t");
        System.out.printf("%s - %s\n", dataDevolucao, horaDevolucao);

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

    }



    public static void menuAluguel(Aluguel aluguel) {
        AluguelController aluguelController = new AluguelController();


        System.out.println("-=-=-=-=COMPROVANTE DE ALUGUEL-=-=-=-=");

        saidaComprovante(aluguel);

        System.out.printf("DATA DE RETIRADA:\n\t\t");
        System.out.printf("%s - %s\n", aluguelController.getDataRetirada(aluguelController.getId(aluguel)),
                    aluguelController.getHoraRetirada(aluguelController.getId(aluguel))
                );

        System.out.printf("VALOR TOTAL DO ALUGUEL:\n\t\tR$ %s\n", aluguelController.valorTotalDiarias(aluguelController.getId(aluguel))        );

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");



    }

    private static void saidaComprovante(Aluguel aluguel) {
        System.out.print("Cliente:\n\t\t");
        PessoaView.exibirDadosPessoa(PessoaDAO.getInstance().getPessoaById(aluguel.getClienteId()));

        System.out.print("Veículo:\n\t\t");
        VeiculoView.exibir(VeiculoDAO.getInstance().getByPlaca(aluguel.getVeiculoId()), null);

        System.out.print("Agência:\n\t\t");
        AgenciaView.exibir(AgenciaDAO.getInstance().getAgenciaById(aluguel.getAgenciaId()), null);
    }

}
