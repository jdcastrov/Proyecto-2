package Proyecto2;

public class BE extends Bicho{

    public BE(){
        this.setTipoBicho("BE");
        this.setSalud(30);
    }
    public BE(String tipoBicho, int salud){

        super(tipoBicho, salud);
    }

}
