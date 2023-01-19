package view;

import controller.AluguelController;
import util.ConsoleUIHelper;

public class ComprovanteView {
    public static void menuDevolucao(AluguelController aluguelController) {
        boolean naoRetornarAoMenuPrincipal = true;

        do {
            int diasAlugado = ConsoleUIHelper.askInt("Quantos dias você alugou: ");
            naoRetornarAoMenuPrincipal = false;
        } while (naoRetornarAoMenuPrincipal);
        aluguelController.

    }
}
