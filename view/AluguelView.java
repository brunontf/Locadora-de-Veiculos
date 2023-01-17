package view;

import controller.AluguelController;
import model.Aluguel;
import util.ConsoleUIHelper;

public class AluguelView {
    public static void menu(){
        AluguelController aluguelController = new AluguelController();

        int opcao = ConsoleUIHelper.askChooseOption("Digite a opção desejada",
                "Alugar um veiculo",
                "Devolver um veiculo",
                "Retornar ao menu"
        );
        switch (opcao){
            case 0 -> aluguelController.alugar(null);
            case 1 -> aluguelController.devolver(null);
        }
    }

    public static void alugar() {
        AluguelController aluguelController = new AluguelController();

        System.out.println("Listar os dados de cliente, agencia e cliente e escolher uma opcao");
        System.out.println("Selecione um cliente");
        System.out.println("Selecione a agencia");
        System.out.println("Selecione o veiculo");
        System.out.println("Selecione a data");
        System.out.println("Selecione o horario");
        System.out.println("Selecione a agencia de devolucao");

        aluguelController.alugar(new Aluguel());
    }

    public static void devolver() {
        AluguelController aluguelController = new AluguelController();

        System.out.println("listar alugueis abertos e escolher um pra devolver");

        aluguelController.devolver(new Aluguel());
    }
}
