import model.Agencia;
import model.Endereco;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import util.ConsoleUIHelper;
import view.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        List<Agencia> listaAgencias = new ArrayList<Agencia>();

        Endereco endereco1 = new Endereco("Rua XV de novembro");
        Endereco endereco2 = new Endereco("Rua Episcopal");
        Agencia samamVeiculos1 = new Agencia("SAMAM Veículos", endereco1);
        Agencia samamVeiculos2 = new Agencia("SAMAM Veículos", endereco2);

        listaAgencias.add(samamVeiculos1);
        // System.out.println(temAgenciasDuplicadas(listaAgencias, samamVeiculos1));
        // System.out.println(temAgenciasDuplicadas(listaAgencias, samamVeiculos2));

        
        
        do  {
            ConsoleUIHelper.drawHeader("LOCA-CAR", 80);
            Menu.menu();
            System.out.println();
        }
        while (true);
        
    }
    
    public static boolean temAgenciasDuplicadas(List<Agencia> listaAgencias, Agencia agencia){
        return listaAgencias.stream().anyMatch(ag -> ag.equals(agencia));
    }
    
    // Pessoa joao = new PessoaFisica("joao","111",123);
    // Pessoa jose = new PessoaJuridica("jose","222",321);
}
