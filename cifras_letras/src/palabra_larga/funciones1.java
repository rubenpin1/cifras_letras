package palabra_larga;

import java.util.Scanner;

public class funciones1 {

    /**
     * Genera un array de 10 letras formado por 4 vocales, 4 consonantes 
     * y 2 letras que pueden ser vocales o consonantes. Despues mezcla 
     * las letras para que no aparezcan siempre en el mismo orden
     * 
     * @return devuelve un array con las 10 letras generadas
     */
    public static char[] crearLetras(){

        char letras [] = new char[10];

        String vocales = "AEIOU";
        String consonantes = "BCDFGHJKLMNÑPQRSTVWXYZ";
        String todas = vocales + consonantes;

        for (int i = 0; i < 4; i++) {
            int posicion = (int) (Math.random()*vocales.length());
            letras[i] = vocales.charAt(posicion);
        }

        for (int i = 4; i < 8; i++) {
            int posicion = (int) (Math.random()*consonantes.length());
            letras[i] = consonantes.charAt(posicion);
        }

        for (int i = 8; i < 10; i++) {
            int posicion = (int) (Math.random()*todas.length());
            letras[i] = todas.charAt(posicion);
        }

        for (int i = 0; i < letras.length; i++) {

            int posicion = (int) (Math.random()*letras.length);

            char auxiliar = letras[i];
            letras[i] = letras[posicion];  // Lo hacemos para mezclar las letras y que no salgan siempre en el mismo orden
            letras[posicion] = auxiliar;
        }

        return letras;
    }



    /**
     * Muestra por pantalla las letras que pueden utilizar los jugadores
     * 
     * @param letras es un array que contiene las letras disponibles para jugar
     */
    public static void enseniarLetras (char letras[]){

        System.out.println("Se pueden usar las siguientes letras: ");

        for (int i = 0; i < letras.length; i++){
            System.out.println(letras[i]);
        }
    }



    /**
     * Permite al jugador introducir la palabra que quiere utilizar
     * @param sc se usa para leer la palabra introducida
     * @param jugador es el numero del jugador que tiene que insertar la palabra
     * @return devuelve la palabra introducida por el jugador
     */
    public static String ponerPalabra (Scanner sc, int jugador){
        System.out.println("El jugador " + jugador + "tiene que poner su palabra");

        String palabra = sc.nextLine();

        return palabra;
    }



    /**
     * Comprueba que la palabra se pueda formar utilizando las letras disponibles
     * y que no se utilice ninguna letra mas veces de la cuenta
     * @param palabra palabra introducida por el jugador
     * @param letras array con las letras disponibles
     * @return devuelve true si la palabra se puede formar y false si no se puede
     */
    public static boolean comprobarLetras(String palabra, char letras[]){

        String usables = new String (letras);

        for (int i = 0; i < palabra.length(); i++){

            char letra = palabra.charAt(i);

            int posicion = usables.indexOf(letra);  //indexOf para saber en que posicion aparece

            if (posicion == -1) {   //si no aparece no se podria formar
                return false;    
            }

            //ahora vamos a eliminar la letra del conjunto usables una vez se haya usado
            usables = usables.substring(0, posicion) + usables.substring(posicion + 1);
        }
        return true;
    }



    /**
     * Pide al jugador que confirme si la palabra del otro jugador es valida o no
     * @param sc para leer la respuesta del jugador
     * @param palabra es la palabra que se quiere comprobar
     * @param jugador es el numero del jugador que tiene que hacer la comprobacion
     * @return devuelve si la respuesta es "si" o "no"
     */
    public static boolean comprobacionDos(Scanner sc, String palabra, int jugador){

        String respuesta;

        do {
            System.out.println("El jugador " + jugador + "autoriza que la palabra" + palabra + "es valida? (si/no)");

            respuesta = sc.nextLine();

        } while (!respuesta.equals("si") && !respuesta.equals("no"));
    return respuesta.equals("si");
    }



    /**
     * Compara las palabras de los dos jugadores y determina quien ha ganado
     * segun la validez y la longitud de las palabras
     * @param palabra1 palabra introducida por el primer jugador
     * @param valida1 indica si la palabra del primer jugador es valida
     * @param palabra2 palabra introducida por el segundo jugador
     * @param valida2 indica si la palabra del segundo jugador es valida
     */
    public static void ganador(String palabra1, boolean valida1, String palabra2, boolean valida2){
        System.out.println("RESULTADO: ");

        if (!valida1 && !valida2) {

            System.out.println("Ningún jugador ha conseguido una palabra usable");
        }

        else if (valida1 && !valida2) {

            System.out.println("Ha ganado el Jugador 1");
            System.out.println("Su palabra es: " + palabra1);
        }

        else if (!valida1 && valida2) {

            System.out.println("Ha ganado el Jugador 2");
            System.out.println("Su palabra es: " + palabra2);
        }

        else {
                if (palabra1.length() > palabra2.length()) {
                System.out.println("Ha ganado el Jugador 1");
                System.out.println("Su palabra es: " + palabra1);
                }

                else if (palabra2.length() > palabra1.length()) {
                System.out.println("Ha ganado el Jugador 2");
                System.out.println("Su palabra es: " + palabra2);
                }

                else {
                System.out.println("Se queda en empate");
                System.out.println("Ambos han formado palabras de" + palabra1.length() + " letras");
                }
        }
    }
}

