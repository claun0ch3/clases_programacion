package dif5.model;

import java.util.Random;

public class Set {
    private int puntosJugador1;
    private int puntosJugador2;
    private static final Random random = new Random();

    public Set(Jugador jugador1, Jugador jugador2) {
        generarSet(jugador1, jugador2);
    }

    private void generarSet(Jugador jugador1, Jugador jugador2) {
        puntosJugador1 = 0;
        puntosJugador2 = 0;
        while (!esValido()) {
            if (random.nextDouble() < probabilidad(jugador1, jugador2)) {
                puntosJugador1++;
            } else {
                puntosJugador2++;
            }
        }

    }

    private boolean esValido () {
        if (puntosJugador1 == 6 && puntosJugador2 <=4) {return true;}
        if (puntosJugador2 == 6 && puntosJugador1 <= 4) {return true;}
        if (puntosJugador1 == 7 && (puntosJugador2 == 5 || puntosJugador2 == 6)) {return true;}
        if (puntosJugador2 == 7 && (puntosJugador1 == 5 || puntosJugador1 == 6)) {return true;}
        return false;
    }

    private double probabilidad(Jugador jugador1, Jugador jugador2) {
        int rankingTotal = jugador1.getPuntosRanking() + jugador2.getPuntosRanking();
        return (double)  jugador1.getPuntosRanking() / rankingTotal;
    }

    public int getPuntosJugador1() {return puntosJugador1;}
    public int getPuntosJugador2() {return puntosJugador2;}

    @Override
    public String toString() {
        return puntosJugador1 + "-" + puntosJugador2;
    }
}
