package cifra_exacta;

import java.util.Scanner;

public class funciones {
    

    /**
     * Genera un numero aleatorio entre 100 y 999 que será utilizado como objetivo
     * @return devuelve el numero objetivo generado aleatoriamente
     */
    public static int crearObjetivo(){

        int objetivo = (int)(Math.random()*900) + 100;

        return objetivo;
    }



    /**
     * Genera un array de 6 numeros aleatorios entre 1 y 10
     * @return devuelve el array con los 6 números generados
     */
    public static int [] numerosAuxi(){

        int numeros [] = new int[6];

        for (int i = 0; i < numeros.length; i++){

            numeros[i] = (int)(Math.random()*10)+1;

        }
        return numeros;
    }



    /**
     * Realiza una operacion matematica entre dos numeros segun el tipo de operacion indicada
     * @param num1 primer numero de la operacion
     * @param num2 segundo numero de la operacion
     * @param tipoOp indica el tipo de operacion deseada
     * @return devuelve el resultado de la operacion
     */
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



    /**
     * Permite al jugador introducir un numero inicial y realizar 5 operaciones consecutivas
     * @param sc usamos el scanner para leer los datos introducidos
     * @return devuelve el resultado final tras realizar las 5 operaciones
     */
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



    /**
     * Calcula la diferencia entre el resultado obtenido y el objetivo y la convierte en positiva
     * @param resultado es el resultado obtenido del jugador
     * @param objetivo es el numero objetivo que se quiere alcanzar
     * @return devuelve la diferencia positiva entre el resultado y el objetivo
     */
    public static int diferencia (int resultado, int objetivo){  //solo es para poner la diferencia en positivo

        int diferencia = resultado - objetivo;

        if (diferencia < 0) {
            diferencia = diferencia * -1;
        }
        return diferencia;
    } 



    /**
     * Compara las diferencias de los dos jugadores para determinar quien gana
     * @param diferencia1 es la diferencia del primer jugador respecto al objetivo
     * @param diferencia2 es la diferencia del segundo jugador respecto al objetivo
     */
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
