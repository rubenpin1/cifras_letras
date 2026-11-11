package cifra_exacta;

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







}
