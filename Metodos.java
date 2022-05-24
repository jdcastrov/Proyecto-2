package Proyecto2;
import java.util.ArrayList;
import java.util.Scanner;

public class Metodos extends Bicho{

    public static Scanner scan = new Scanner(System.in);
    


    public static void MostrarTablero(Bicho[][] bichos) {
        for (int r = 0; r < bichos.length; r++) {
            System.out.print("-----------------------\n");
            for (int c = 0; c < bichos[r].length; c++) {
                if (bichos[r][c] != null) {
                    System.out.print(bichos[r][c] + " | ");

                } else {
                    System.out.print("    - | ");
                }
            }
            System.out.println();
        }
        System.out.print("-----------------------\n");
    }

    public static void CrearTablero(Bicho[][] bichos) {
        int cantidadBichos = random1();
        int pos1 = 0;
        int pos2 = 0;
        for(int i = 0; i < cantidadBichos; i++){
            int numero = Bicho.random2();
            if (numero == 1){
                BN b3 = new BN();
                bichos[pos1][pos2] = b3;
            } else if (numero == 2){
                BA b2 = new BA();
                bichos[pos1][pos2] = b2;
            } else if (numero == 3){
                BE b3 = new BE();
                bichos[pos1][pos2] = b3;
            }
            if(pos2 == 2){
                pos2 = 0;
                pos1 = pos1 + 1;
            }else{
                pos2 = pos2 + 1;
            }
        }
    }

    public static int conteoDeBichos(Bicho[][] bichos){
        int cantBichos = 0;
        for (int i = 0; i < bichos.length; i++) {
            for (int j = 0; j < bichos[i].length; j++) {
                if (bichos[i][j] != null) {
                    cantBichos = cantBichos + 1;
                }
            }
        }
        return cantBichos;
    }

    public static void dispararBala(Bicho[][] bichos){
        System.out.println("Ingrese el número de la fila (entre 0 y 2)");
        int fila = scan.nextInt();
        System.out.println("Ingrese el número de la posicion en la fila (entre 0 y 2)");
        int posición = scan.nextInt();
        if (bichos[fila][posición] != null) {
            PrincipalBichos.bichos[fila][posición].setSalud(PrincipalBichos.bichos[fila][posición].getSalud() - 5);
        }          
        System.out.println("El bicho en la pocicion: " + fila + "." + posición + " impactado");
    }

    public static void BombaAtomica(Bicho[][] bichos) {
        int fAleatoria = Bicho.random3();
        int cAleatoria = Bicho.random3();
        Bicho posicionAleatoria = bichos[fAleatoria][cAleatoria];
        if (posicionAleatoria != null) {
            System.out.println("Posición aleatoria: | " + fAleatoria + "." + cAleatoria + " |");
            bichos[fAleatoria][cAleatoria] = null;

        } else {
            Metodos.BombaAtomica(bichos);
        }
    }

    public static Bicho BichoMenor(Bicho[][] bichos) {
        Bicho menor = null;
        int Smenor = 0;
        for (int i = 0; i < bichos.length; i++) {
            for (int columnas = 0; columnas < bichos[i].length; columnas++) {
                if (bichos[i][columnas] != null) {
                    Smenor = bichos[i][columnas].getSalud();
                    menor = bichos[i][columnas];
                    break;
                }
            }
        }
        for (int i = 0; i < bichos.length; i++) {
            for (int j = 0; j < bichos[i].length; j++) {
                if (bichos[i][j] != null) {
                    if (Smenor > bichos[i][j].getSalud()) {
                        Smenor = bichos[i][j].getSalud();
                        menor = bichos[i][j];
                    }
                }
            }
        }
        return menor;
    }

    public static void activarBichoMutante(Bicho[][] bichos){
        Bicho posMenor = Bicho.BichoMenorSalud(bichos);
        System.out.println("La salud de " + posMenor + " se duplicó.");
        posMenor.setSalud(posMenor.getSalud() * 2);
    }

    public static void intercambioPosiciones(Bicho[][] bichos){
        int filaPos1 = Bicho.random3();
        int columnaPos1 = Bicho.random3();
        int filaPos2 = Bicho.random3();
        int columnaPos2 = Bicho.random3();
        Metodos.MostrarTablero(bichos);
        Bicho temp;
        temp = bichos[filaPos1][columnaPos1];
        bichos[filaPos1][columnaPos1] = bichos[filaPos2][columnaPos2];
        bichos[filaPos2][columnaPos2] = temp;
        System.out.println("Se han intercambiado las posiciones: " + " | " + filaPos1 + "." +
        columnaPos1 + " |" + " | " + filaPos2 + "." + columnaPos2 + " |");
        Metodos.MostrarTablero(bichos);
    }

    public static void ConversionSangre(Bicho[][] bichos){
        Bicho pMenor = Bicho.BichoMenorSalud(bichos);
        System.out.println(pMenor + " ahora es un Bicho Espacial.\n");
        pMenor.setTipoBicho("BE");
    }

    public static void bombaFila(Bicho[][] bichos){
        int filaAleatoria = Bicho.random3();
        System.out.println("Fila: " + filaAleatoria);
                for (int i = 0; i < 3; i++) {
                    bichos[filaAleatoria][i] = null;
                }
    }

    public static void PromTenebroso(Bicho[][] bichos) {
        int suma = 0;
        for (int i = 0; i < bichos.length; i++) {
            for (int j = 0; j < bichos[i].length; j++) {
                if (bichos[i][j] != null) {
                    suma = suma + bichos[i][j].getSalud();
                }
            }
        }
        int cantBichos = Metodos.conteoDeBichos(bichos);
        int promedio = suma/cantBichos;
        System.out.println("El promedio de salud de los bichos vivos es de: " + promedio);
    }

    public static void FraseAbuela(){
        ArrayList frases = new ArrayList();
                    frases.add("Matemos a esos Sapos(Bichos)");
                    frases.add("Se las voy a estallar");
                    frases.add("Bien Hptaaa");
                    frases.add("Ya me tocan las pastillas...");
                    frases.add("Uno mas y me voy a dormir");
                    frases.add("Gas de Ping");
                    int a = (int) (Math. random() * 5);
                    System. out.println (frases.get (a)) ;
    }

}
