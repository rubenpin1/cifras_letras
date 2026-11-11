package palabra_larga;

public class funciones1 {
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
            int posicion = (int) (Math.random() * consonantes.length());
            letras[i] = consonantes.charAt(posicion);
        }

        for (int i = 8; i < 10; i++) {
            int posicion = (int) (Math.random() * todas.length());
            letras[i] = todas.charAt(posicion);
        }

        for (int i = 0; i < letras.length; i++) {

            int posicion = (int) (Math.random() * letras.length);

            char auxiliar = letras[i];
            letras[i] = letras[posicion];
            letras[posicion] = auxiliar;
        }

        return letras;
    }
}
