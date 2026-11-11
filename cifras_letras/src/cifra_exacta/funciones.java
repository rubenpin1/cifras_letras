package cifra_exacta;

import java.util.Scanner;

public class funciones {
    
    public static int crearObjetivo(){

        int objetivo = (int)(Math.random()*900) + 100;

        return objetivo;
    }



    public static int [] numerosAuxi(){

        int numeros [] = new int[6];

        for (int i = 0; i < numeros.length; i++){

            numeros[i] = (int)(Math.random()*10)+1;

        }
        return numeros;
    }



    public static int operacion(int num1, int num2, char tipoOp){  //Es una funcion de logica porque solo calcula

        int resultado = 0;

        switch (tipoOp) {

            case '+':
                resultado = num1 + num2;
                break;
        
            case '-':
                resultado = num1 - num2;
                break;

            case '*':
                resultado = num1 * num2;
            break;

            case '/':
                resultado = num1 / num2;
            break;

            default:
                break;
        }
        return resultado;
    }



    public static int resultadoCifraExacta(Scanner sc){  //Esta funcion la usamos tanto para el primerJugador como para el segundo

        System.out.println("Introduzca el primer numero: ");
        int num1 = sc.nextInt();

        for (int i = 1; i <= 5; i++){

            System.out.println("operacion: " + i);

            System.out.println("Introduzca el tipo de operacion entre (+,-,*,/): ");
            char tipoOp = sc.next().charAt(0);

            System.out.println("Introduzca el segundo numero: ");
            int num2 = sc.nextInt();

            num1 = operacion(num1, num2, tipoOp);
            System.out.println("El resultado es: " + num1);
        }
        return num1;
    }



    public static int diferencia (int resultado, int objetivo){  //solo es para poner la diferencia en positivo

        int diferencia = resultado - objetivo;

        if (diferencia < 0) {
            diferencia = diferencia * -1;
        }
        return diferencia;
    } 



    public static void ganador(int diferencia1, int diferencia2){  //comparamos las diferencias para dar el ganador

        if (diferencia1 < diferencia2) {
            System.out.println("El ganador será el primer jugador");
        }

        else if (diferencia2 < diferencia1) {
            System.out.println("El ganador sera el segundo jugador");
        }

        else {
            System.out.println("Sera empate");
        }
    }
}

/*Creo que hay un problema de que puede no coger unicamente los numeros del array [6]
pero no  se como solucionarlo
 */
