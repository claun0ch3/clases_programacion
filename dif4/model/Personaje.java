package dif4.model;

import java.util.Arrays;

public class Personaje {
    private String nombre;
    private int porcentajeVida;
    private int fuerza;
    private Arma [] armas;

    public Personaje(String nombre, int fuerza) {
        this.nombre = nombre;
        this.porcentajeVida = 100;
        this.fuerza = fuerza;
        this.armas = new Arma [2];
    }

    public String getNombre() {return nombre;}
    public int getPorcentajeVida() {return porcentajeVida;}
    public int getFuerza() {return fuerza;}
    public Arma[] getArmas() {return armas;}

    public void asignarArma(Arma arma, int posicion) {
        if (posicion >= 0 && posicion < armas.length) {
            armas[posicion] = arma;
        } else {
            System.out.println("Posicion invalida");
        }
    }

    public void reducirVida (int porcentajeVida) {
        this.porcentajeVida -= porcentajeVida;
        if (porcentajeVida < 0) {
            this.porcentajeVida = 0;
        }
    }

    @Override
    public String toString() {
        return "Personaje {" + "Nombre = '" + nombre + '\'' + ", PorcentajeVida = " + porcentajeVida + ", Fuerza = " + fuerza + ", Arma = " +
                Arrays.toString(armas) + '}';
    }
}
