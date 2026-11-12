import menu_programa.menu_programa;
import cifra_exacta.cifra_exacta;
import palabra_larga.palabra_larga;

import java.util.Scanner;

public class App {



    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        menu_programa.menuInicio();
        cifra_exacta.cifra_exacta();
        palabra_larga.palabra_larga(sc);
    }
}
