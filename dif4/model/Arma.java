package dif4.model;

public class Arma {
    private int potenciaAtaque;
    private int potenciaDefensa;

    public Arma(int potenciaAtaque, int potenciaDefensa) {
        this.potenciaAtaque = potenciaAtaque;
        this.potenciaDefensa = potenciaDefensa;
    }

    public int getPotenciaAtaque() {return potenciaAtaque;}
    public int getPotenciaDefensa() {return potenciaDefensa;}

    @Override
    public String toString() {
        return "Arma {Ataque = " + potenciaAtaque + ", Defensa = " + potenciaDefensa + '}';
    }
}
