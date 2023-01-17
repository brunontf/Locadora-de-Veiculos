package database;

import model.Aluguel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AluguelDAO {
    private static AluguelDAO instance;
    private List<Aluguel> alugueis;

    private AluguelDAO() {
        alugueis = new ArrayList<>();
    }

    public static AluguelDAO getInstance() {
        if (instance == null) {
            instance = new AluguelDAO();
        }
        return instance;
    }

    public List<Aluguel> getAll() {
        return this.alugueis;
    }

    public void alugar(Aluguel aluguel) {
        this.alugueis.add(aluguel);
    }

    public void devolver(Aluguel aluguel) {
        this.alugueis.stream()
                .map(a -> a.equals(aluguel) ? aluguel : null)
                .collect(Collectors.toList());
    }
}
