package menu_programa;

import java.util.Scanner;

//Vamos a poner las distintas funciones que usaremos a lo largo del programa

public class menu_programa {

    public static void menuInicio(){

        Scanner sc = new Scanner(System.in);

        System.out.println("BIENVENIDO A CIFRAS Y LETRAS");
        System.out.println("1 modo concurso");
        System.out.println("2 modo rapido");
        System.out.println("3 configuracion");
        System.out.println("4 marcador");
        System.out.println("0 salir");
        System.out.println("Elije una de las opciones: ");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Su eleccion fue modo concurso");
                break;
        
            case 2:
                System.out.println("Su eleccion fue modo rapido");
                break;

            case 3:
                System.out.println("Su eleccion fue configuracion");
                break;

            case 4:
                System.out.println("Su eleccion fue marcador");
                break;

            case 0:
                System.out.println("Su eleccion fue salir del programa");
                break;

            default:
                System.out.println("Opcion no valida");
        }


        
    }
}
