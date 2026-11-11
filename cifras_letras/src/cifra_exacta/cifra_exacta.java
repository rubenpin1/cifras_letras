package cifra_exacta;

import java.util.Arrays;

public class cifra_exacta {
    
    public static void cifra_exacta(){

        int objetivo = funciones.crearObjetivo();

        int [] auxiliares = funciones.numerosAuxi();

        System.out.println("PRUEBA 1. CIFRA EXACTA");
        System.out.println("El objetivo es: " + objetivo);
        System.out.println("Los numeros auxiliares son: " + Arrays.toString(auxiliares));
    }
}
