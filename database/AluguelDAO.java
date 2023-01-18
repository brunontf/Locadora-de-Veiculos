package database;

import model.Aluguel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AluguelDAO implements Serializable {
    private static AluguelDAO instance;
    private List<Aluguel> alugueis;

    private AluguelDAO() {
        alugueis = new ArrayList<>();
        carregarAlugueis();
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

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public void alugar(Aluguel aluguel) {
        this.alugueis.add(aluguel);
    }

    public void devolver(Aluguel aluguel) {
        alugueis =  this.alugueis.stream().filter(a -> a != aluguel).collect(Collectors.toList());
    }

    public void salvarAlugueis() throws IOException {
        FileOutputStream fos = new FileOutputStream("database\\lista_de_alugueis.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(alugueis);
        oos.close();
    }

    public void carregarAlugueis() {
        try {
            FileInputStream fis = new FileInputStream("database\\lista_de_alugueis.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            setAlugueis((List<Aluguel>) ois.readObject());
            ois.close();
        } catch (Exception e) {

        }
    }

}
