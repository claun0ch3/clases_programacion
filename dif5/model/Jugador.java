package dif5.model;

public class Jugador {
    private String nombre;
    private int puntosRanking;

    public Jugador(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntosRanking = puntos;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public int getPuntosRanking() {return puntosRanking;}
    public void actualizarPuntosRanking(int puntosRanking) {this.puntosRanking += puntosRanking;}

    @Override
    public String toString() {
        return nombre + "(Ranking: " + puntosRanking + ")";
    }


}
