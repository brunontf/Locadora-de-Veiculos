package database;

import model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VeiculoDAO {
    private static VeiculoDAO instance;
    private List<Veiculo> veiculos;
    private VeiculoDAO() {
        veiculos = new ArrayList<>();
    }

    public static VeiculoDAO getInstance() {
        if(instance == null) {
            instance = new VeiculoDAO();
        }
        return instance;
    }

    public List<Veiculo> getAll() {
        return this.veiculos;
    }

    public void add(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void edit(Veiculo veiculo) {

    }

    public List<Veiculo> search(String placa) {
        return veiculos.stream().filter(v -> v.getPlaca().toLowerCase().contains(placa.toLowerCase())).collect(Collectors.toList());
    }
}
