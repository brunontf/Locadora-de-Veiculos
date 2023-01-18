import util.ConsoleUIHelper;
import view.Menu;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        do {
            ConsoleUIHelper.drawHeader("LOCA-CAR", 80);
            Menu.menu();
            System.out.println();
        } while (true);
    }

}
