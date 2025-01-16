package dif5.model;

import java.util.Arrays;

public class Partido {
    private Jugador jugador1;
    private Jugador jugador2;
    Set[]sets;
    private Jugador ganador;

    public Partido(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.sets = new Set[3];

        jugarPartido();
    }

    private void jugarPartido() {
        int setsGanadosJugador1 = 0;
        int setsGanadosJugador2 = 0;

        for (int i = 0; i < 3; i++) {
            sets[i] = new Set(jugador1, jugador2);
            if (sets[i].getPuntosJugador1() > sets[i].getPuntosJugador2()) {
                setsGanadosJugador1++;
            } else {
                setsGanadosJugador2++;
            }
            if (setsGanadosJugador1 == 2 || setsGanadosJugador2 == 2) {
                break;
            }
        }

        if (setsGanadosJugador1 > setsGanadosJugador2) {
            ganador = jugador1;
            jugador1.actualizarPuntosRanking(100);
            jugador2.actualizarPuntosRanking(-100);
        } else {
            ganador = jugador2;
            jugador1.actualizarPuntosRanking(-100);
            jugador2.actualizarPuntosRanking(100);
        }
    }

    public Jugador getGanador() {
        return ganador;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Resultado del Partido:\n");
        resultado.append(jugador1.getNombre()).append(" vs ").append(jugador2.getNombre()).append("\n\n");
        resultado.append("Puntos iniciales:\n");
        resultado.append(jugador1.getNombre()).append(": ").append(jugador1.getPuntosRanking() - (ganador == jugador1 ? 100 : -100)).append("\n");
        resultado.append(jugador2.getNombre()).append(": ").append(jugador2.getPuntosRanking() - (ganador == jugador2 ? 100 : -100)).append("\n\n");

        resultado.append("Sets:\n");
        for (Set set : sets) {
            if (set != null) {
                resultado.append(set).append(" ");
            }
        }
        resultado.append("\n\n");

        resultado.append("Ganador: ").append(ganador.getNombre()).append("\n\n");
        resultado.append("Puntos finales:\n");
        resultado.append(jugador1.getNombre()).append(": ").append(jugador1.getPuntosRanking()).append("\n");
        resultado.append(jugador2.getNombre()).append(": ").append(jugador2.getPuntosRanking()).append("\n");

        return resultado.toString();
    }
}
