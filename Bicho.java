package Proyecto2;

import java.util.Scanner;
public class Bicho {
    public static Scanner scan = new Scanner(System.in);
    private String tipoBicho;
    private int salud;

    public Bicho(){}

    public Bicho(String tipoBicho, int salud) {
        this.tipoBicho = tipoBicho;
        this.salud = salud;
    }
    public void setTipoBicho(String tipoBicho) {
        this.tipoBicho = tipoBicho;
    }
    public String getTipoBicho() {

        return this.tipoBicho;
    }
    public void setSalud(int salud) {

        this.salud = salud;
    }
    public int getSalud() {

        return this.salud;
    }

    @Override
    public String toString() {
        String text = this.tipoBicho + "-" + this.salud;
        return text;
    }

    public static int random1(){
        int num = (int) ((Math.random() * 9) + 1);
        return num;
    }
    public static int random2(){
        int num = (int) ((Math.random() * 3) + 1);
        return num;
    }
    public static int random3(){
        int num = (int) (Math.random() * 3);
        return num;
    }

    public static Bicho BichoMenorSalud(Bicho[][] bichos){
        Bicho posMenor = null;
        int menorSalud = 0;
        for (int i = 0; i < bichos.length; i++) {
            for (int j = 0; j < bichos[i].length; j++) {
                if (bichos[i][j] != null) {
                    menorSalud = bichos[i][j].salud;
                    posMenor = bichos[i][j];
                    break;
                }
            }
        }
        for (int i = 0; i < bichos.length; i++) {
            for (int j = 0; j < bichos[i].length; j++) {
                if (bichos[i][j] != null) {
                    if (menorSalud > bichos[i][j].salud) {
                        menorSalud = bichos[i][j].salud;
                        posMenor = bichos[i][j];
                    }
                }
            }
        }
        return posMenor;
    }

    public static void BichoMutante(Bicho[][] bichos){
        Bicho posMenor = Bicho.BichoMenorSalud(bichos);
        System.out.println("La salud de " + posMenor + " se duplicó.");
        posMenor.setSalud(posMenor.getSalud() * 2);
    }

    public static void ConversionSangre(Bicho[][] bichos){
        Bicho pMenor = Bicho.BichoMenorSalud(bichos);
        System.out.println(pMenor + " ahora es un Bicho Espacial.\n");
        pMenor.setTipoBicho("BE");
    }

}
