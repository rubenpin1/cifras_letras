package palabra_larga;

import java.util.Scanner;

public class palabra_larga {
    public static void palabra_larga(Scanner sc){

        char letras[] = funciones1.crearLetras();

        funciones1.enseniarLetras(letras);

        String palabra1 = funciones1.ponerPalabra(sc, 1);
        String palabra2 = funciones1.ponerPalabra(sc, 2);

        boolean usable1 = funciones1.comprobarLetras(palabra1, letras);
        boolean usable2 = funciones1.comprobarLetras(palabra2, letras);

        boolean valida1 = false;
        boolean valida2 = false;

        if (usable1){
        valida1 = funciones1.comprobacionDos(sc, palabra1, 2);
        }

        if (usable2){
        valida2 = funciones1.comprobacionDos(sc, palabra2, 1);
        }

        funciones1.ganador(palabra1, valida1, palabra2, valida2);
    }
}
