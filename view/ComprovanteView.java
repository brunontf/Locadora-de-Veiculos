package view;

import controller.AgenciaController;
import controller.AluguelController;
import model.Aluguel;
import model.Veiculo;
import util.ConsoleUIHelper;

public class ComprovanteView {
    public static void menuDevolucao() {
        AluguelController aluguelController = new AluguelController();




//        PessoaView.exibir();
//        VeiculoView.exibir();
//        AgenciaView.exibir();



        /*
        * [COMPROVANTE DE ALUGUEL]
        * [DADOS DA PESSOA: nome, tipo de pessoa]
        * [DADOS DO VEÍCULO: dados do exibir]
        * [DADOS DA AGÊNCIA: nome, endereço]
        * [DATA: somar com data do aluguel]
        * [
        * */
        /*
        * [COMPROVANTE DE DEVOLUÇÃO]
        * [DADOS DA PESSOA: nome, tipo de pessoa]
        * [DADOS DO VEÍCULO: dados do exibir]
        * [DADOS DA AGÊNCIA: nome, endereço]
        * [DATA: somar com data do aluguel]
        * */

    }

    public static void menuAluguel(Aluguel aluguel) {
        AluguelController aluguelController = new AluguelController();



//        PessoaView.exibir();
//        VeiculoView.exibir();
//        AgenciaView.exibir();
        System.out.println("DATA DE RETIRADA");

        System.out.printf("VALOR TOTAL DO ALUGUEL: R$ %s\n", aluguelController.valorTotalDiarias()        );


        /*
         * [COMPROVANTE DE ALUGUEL]
         * [DADOS DA PESSOA: nome, tipo de pessoa]
         * [DADOS DO VEÍCULO: dados do exibir]
         * [DADOS DA AGÊNCIA: nome, endereço]
         * [DATA: somar com data do aluguel]
         * [
         * */
        /*
         * [COMPROVANTE DE DEVOLUÇÃO]
         * [DADOS DA PESSOA: nome, tipo de pessoa]
         * [DADOS DO VEÍCULO: dados do exibir]
         * [DADOS DA AGÊNCIA: nome, endereço]
         * [DATA: somar com data do aluguel]
         * */

    }

}
