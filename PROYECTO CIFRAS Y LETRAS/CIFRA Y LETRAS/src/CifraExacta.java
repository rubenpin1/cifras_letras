import java.util.Random;
import java.util.Scanner;

public class CifraExacta {

    // Devuelve: 1 si gana el jugador 1, 2 si gana el jugador 2, 0 si empatan.
    public static int jugar(String jugador1, String jugador2, Scanner sc) {
        Random rnd = new Random();

        // Numero objetivo de tres cifras (100 a 999)
        int objetivo = 100 + rnd.nextInt(900);

        // Seis numeros auxiliares entre 1 y 10
        int[] numeros = new int[6];
        for (int i = 0; i < 6; i++) {
            numeros[i] = 1 + rnd.nextInt(10);
        }

        System.out.println("=== LA CIFRA EXACTA ===");
        System.out.println("Numero objetivo: " + objetivo);

        // Cada jugador juega su turno con los mismos numeros
        int resultado1 = turno(jugador1, objetivo, numeros, sc);
        int resultado2 = turno(jugador2, objetivo, numeros, sc);

        // Diferencia entre el resultado de cada uno y el objetivo
        int dif1 = Math.abs(objetivo - resultado1);
        int dif2 = Math.abs(objetivo - resultado2);

        System.out.println();
        System.out.println(jugador1 + ": " + resultado1 + " (diferencia " + dif1 + ")");
        System.out.println(jugador2 + ": " + resultado2 + " (diferencia " + dif2 + ")");

        if (dif1 < dif2) {
            System.out.println("Gana " + jugador1);
            return 1;
        } else if (dif2 < dif1) {
            System.out.println("Gana " + jugador2);
            return 2;
        } else {
            System.out.println("Empate");
            return 0;
        }
    }

    // Turno de un jugador: elige un numero para empezar y hace 5 operaciones.
    // Devuelve el resultado final.
    static int turno(String nombre, int objetivo, int[] numeros, Scanner sc) {
        boolean[] usados = new boolean[6]; // true = ese numero ya se ha usado

        System.out.println();
        System.out.println("--- Turno de " + nombre + " (objetivo " + objetivo + ") ---");

        // Numero con el que empieza
        mostrarNumeros(numeros, usados);
        System.out.println("Elige el numero con el que empezar.");
        int pos = pedirNumero(sc, usados);
        int resultado = numeros[pos];
        usados[pos] = true;

        // Las 5 operaciones
        for (int i = 1; i <= 5; i++) {
            System.out.println();
            System.out.println("Operacion " + i + " de 5. Resultado actual: " + resultado);
            mostrarNumeros(numeros, usados);

            boolean valida = false;
            while (!valida) {
                pos = pedirNumero(sc, usados);
                char op = pedirOperacion(sc);

                // La division solo es valida si no se divide entre 0 y es exacta
                if (op == '/' && (numeros[pos] == 0 || resultado % numeros[pos] != 0)) {
                    System.out.println("Division no valida. Elige otra vez.");
                } else {
                    int nuevo = calcular(resultado, numeros[pos], op);
                    System.out.println(resultado + " " + op + " " + numeros[pos] + " = " + nuevo);
                    resultado = nuevo;
                    usados[pos] = true;
                    valida = true;
                }
            }
        }

        return resultado;
    }

    // Hace la operacion entre dos numeros
    static int calcular(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    // Muestra los numeros; los ya usados salen como "--"
    static void mostrarNumeros(int[] numeros, boolean[] usados) {
        System.out.print("Numeros: ");
        for (int i = 0; i < numeros.length; i++) {
            if (usados[i]) {
                System.out.print("[" + (i + 1) + ": --] ");
            } else {
                System.out.print("[" + (i + 1) + ": " + numeros[i] + "] ");
            }
        }
        System.out.println();
    }

    // Pide la posicion (1 a 6) de un numero que no se haya usado.
    // Devuelve la posicion del array (0 a 5).
    static int pedirNumero(Scanner sc, boolean[] usados) {
        while (true) {
            System.out.print("Posicion del numero (1-6): ");
            String texto = sc.nextLine().trim();
            try {
                int pos = Integer.parseInt(texto);
                if (pos < 1 || pos > 6) {
                    System.out.println("Tiene que ser entre 1 y 6.");
                } else if (usados[pos - 1]) {
                    System.out.println("Ese numero ya esta usado.");
                } else {
                    return pos - 1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un numero.");
            }
        }
    }

    // Pide una operacion hasta que sea + - * /
    static char pedirOperacion(Scanner sc) {
        while (true) {
            System.out.print("Operacion (+ - * /): ");
            String texto = sc.nextLine().trim();
            if (texto.equals("+") || texto.equals("-") || texto.equals("*") || texto.equals("/")) {
                return texto.charAt(0);
            }
            System.out.println("Operacion no valida.");
        }
    }

}