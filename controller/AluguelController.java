package controller;

import java.io.IOException;

import database.AluguelDAO;
import model.Aluguel;
import view.AluguelView;

public class AluguelController {
    private AluguelDAO aluguelDAO;

    public AluguelController() {
        aluguelDAO = AluguelDAO.getInstance();
    }

    public void alugar(Aluguel aluguel) {
        if (aluguel != null) {
            aluguelDAO.alugar(aluguel);
        } else {
            AluguelView.alugar();
        }
    }

    public void devolver(Aluguel aluguel) {
        if (aluguel != null) {
            aluguelDAO.devolver(aluguel);
        } else {
            AluguelView.devolver();
        }
    }

    public void salvarAlugueis() throws IOException {
        aluguelDAO.salvarAlugueis();
    }

    public void carregarAlugueis() throws IOException, ClassNotFoundException {
        aluguelDAO.carregarAlugueis();
    }

    public void listar() {
        AluguelView.listar(aluguelDAO.getAll());
    }
}
