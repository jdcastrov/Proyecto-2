package Proyecto2;

import java.util.Scanner;
public class PrincipalBichos{
    public static Scanner scan = new Scanner(System.in);
    public static Bicho[][] bichos = new Bicho[3][3];

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Metodos.CrearTablero(bichos);
        Bicho.random1();
        PrincipalBichos.MenuJuego(bichos);
        scan.close();
    }
    public static void MenuJuego(Bicho[][] bichos){
        boolean ejecutar = true;
        while(ejecutar){
            System.out.println("\nTablero de juego");
            Metodos.MostrarTablero(bichos);
            System.out.println("\nMenu de Juego");
            System.out.println("\nSi el numero a ingresar es 0 se detendra el programa");
            System.out.println("Ingrese 1 para dispararle a un bicho");
            System.out.println("Ingrese 2 para activar una bomba atómica y matar a un bicho aleatorio");
            System.out.println("Ingrese 3 para activar Bicho Mutante");
            System.out.println("Ingrese 4 para intercambiar la posicion entre dos bichos");
            System.out.println("Ingrese 5 para convertir el bicho con menos salud a bicho espacial");
            System.out.println("Ingrese 6 para lanzar una bomba a una fila");
            System.out.println("Ingrese 7 para ver el promedio tenebroso");
            System.out.println("Ingrese 8 para saber qué diría la abuela mientras juega");
            System.out.println("Ingrese la opcion que quiere ejecutar:");
            int opcion = scan.nextInt();
            switch(opcion){
                case 0:
                    ejecutar = false;
                    break;
                case 1:
                    Metodos.dispararBala(bichos);
                    break;
                case 2:
                    Metodos.BombaAtomica(bichos);
                    break;
                case 3:
                    Bicho.BichoMutante(bichos);
                    break;
                case 4:
                    Metodos.intercambioPosiciones(bichos);
                    break;
                case 5:
                    Metodos.ConversionSangre(bichos);
                    break;
                case 6:
                    Metodos.bombaFila(bichos);
                    break;
                case 7:
                    Metodos.PromTenebroso(bichos);
                    break;
                case 8:
                    Metodos.FraseAbuela();
                    break;
                default:
                    System.out.println("La opción no válida");
                    break;
            }
        }
    }
}