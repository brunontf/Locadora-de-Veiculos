package database;

import exceptions.DuplicatedRegisterException;
import model.Veiculo;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.io.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import controller.AluguelController;

public class VeiculoDAO implements Serializable {
    private static VeiculoDAO instance;
    private List<Veiculo> veiculos;

    private VeiculoDAO() {
        veiculos = new ArrayList<>();
        try {
            importar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static VeiculoDAO getInstance() {
        if (instance == null) {
            instance = new VeiculoDAO();
        }
        return instance;
    }

    public List<Veiculo> getAll() {
        return this.veiculos;
    }

    public void add(Veiculo veiculo) throws DuplicatedRegisterException {
        if (veiculos.stream().anyMatch(v -> v.equals(veiculo)))
            throw new DuplicatedRegisterException(" Erro: Veiculo duplicado");
        this.veiculos.add(veiculo);
    }

    public void edit(Veiculo veiculo) {
        this.veiculos = veiculos.stream()
                .map(v -> v.getPlaca().equalsIgnoreCase(veiculo.getPlaca()) ? veiculo : v)
                .collect(Collectors.toList());
    }

    public List<Veiculo> search(String termo) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().toLowerCase().contains(termo.toLowerCase()) ||
                        v.getMarca().toLowerCase().contains(termo.toLowerCase()) ||
                        v.getModelo().toLowerCase().contains(termo.toLowerCase())
                )
                .collect(Collectors.toList());
    }

    public Veiculo getByPlaca(String placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    
    public List<Veiculo> getVeiculosDisponiveis() {
        AluguelController aluguelController = new AluguelController();
        List<String> listaDePlacasAlugadas = new ArrayList<>();
        List<Veiculo> veiculosDisponiveis = new ArrayList<>();
        veiculosDisponiveis = veiculos;

        listaDePlacasAlugadas = aluguelController.placasAlugadas(listaDePlacasAlugadas);

        for (Veiculo veiculo : veiculos) {
            for (String alugado : listaDePlacasAlugadas) {
                if (veiculo.getPlaca() == alugado){
                    veiculosDisponiveis.remove(veiculo);
                }
            }
        }
        
        return veiculosDisponiveis;
    }


    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void salvarVeiculos() throws IOException {
        FileOutputStream fos = new FileOutputStream("database\\lista_de_veiculos.ser");


    //public void exportar() throws IOException {
        //FileOutputStream fos = new FileOutputStream("database/lista_de_veiculos.ser");

        //ObjectOutputStream oos = new ObjectOutputStream(fos);
        //oos.writeObject(veiculos);
        //oos.close();
    //}


    public void carregarVeiculos() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("database\\lista_de_veiculos.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        setVeiculos((List<Veiculo>) ois.readObject());

    //public void importar() throws IOException, ClassNotFoundException {
        //FileInputStream fis = new FileInputStream("database/lista_de_veiculos.ser");
        //ObjectInputStream ois = new ObjectInputStream(fis);
        //this.veiculos = (List<Veiculo>) ois.readObject();

        //ois.close();
    //}
}
