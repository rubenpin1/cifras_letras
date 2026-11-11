package cifra_exacta;

import java.util.Arrays;
import java.util.Scanner;

public class cifra_exacta {
    
    public static void cifra_exacta(){

        Scanner sc = new Scanner(System.in);

        int objetivo = funciones.crearObjetivo();

        int [] auxiliares = funciones.numerosAuxi();

        System.out.println("PRUEBA 1. CIFRA EXACTA");
        System.out.println("El objetivo es: " + objetivo);
        System.out.println("Los numeros auxiliares son: " + Arrays.toString(auxiliares));


        System.out.println("PRIMER JUGADOR");
        int resultadoPrimerJugador = funciones.resultadoCifraExacta(sc);
        System.out.println("El resultado del primer jugador es: " + resultadoPrimerJugador);

        System.out.println("SEGUNDO JUGADOR");
        int resultadoSegundoJugador = funciones.resultadoCifraExacta(sc);
        System.out.println("El resultado del segundo jugador es: " + resultadoSegundoJugador);


        System.out.println("RESULTADO");
        int diferencia1 = funciones.diferencia(resultadoPrimerJugador, objetivo);
        int diferencia2 = funciones.diferencia(resultadoSegundoJugador, objetivo);

        System.out.println("El objetivo es: " + objetivo);

        System.out.println("El primer jugador " + resultadoPrimerJugador);
        System.out.println("La diferencia del primer jugador es " + diferencia1);

        System.out.println("El segundo jugador " + resultadoSegundoJugador);
        System.out.println("La diferencia del segundo jugador es " + diferencia2);

        funciones.ganador(diferencia1, diferencia2);
    }
}
