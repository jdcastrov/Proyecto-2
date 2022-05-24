package Proyecto2;

public class BN extends Bicho{
    public BN(){
        this.setTipoBicho("BN");
        this.setSalud(10);
    }
    public BN(String tipoBicho, int salud){

        super(tipoBicho, salud);
    }

}
