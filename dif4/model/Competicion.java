package dif4.model;

import dif5.model.Jugador;
import dif5.model.Partido;

import java.util.Random;

public class Competicion {
    private Jugador[] jugadores;
    private Partido[][] partidos;

    public Competicion(String[] nombresJugadores, int[] puntosIniciales) {
        int numJugadores = nombresJugadores.length;
        this.jugadores = new Jugador[numJugadores];

        for (int i = 0; i < numJugadores; i++) {
            jugadores[i] = new Jugador(nombresJugadores[i], puntosIniciales[i]);
        }

        int rondas = (int) (Math.log(numJugadores) / Math.log(2));
        this.partidos = new Partido[rondas][];

        for (int i = 0; i < rondas; i++) {
            this.partidos[i] = new Partido[numJugadores / (int) Math.pow(2, i + 1)];
        }
    }

    public void jugarCompeticion() {
        Random random = new Random();

        for (int ronda = 0; ronda < partidos.length; ronda++) {
            int partidosEnRonda = partidos[ronda].length;

            for (int i = 0; i < partidosEnRonda; i++) {
                if (ronda == 0) {
                    partidos[ronda][i] = new Partido(jugadores[2 * i], jugadores[2 * i + 1]);
                } else {
                    partidos[ronda][i] = new Partido(partidos[ronda - 1][2 * i].getGanador(),
                            partidos[ronda - 1][2 * i + 1].getGanador());
                }
            }
        }
    }

    public void mostrarResultados() {
        for (int ronda = 0; ronda < partidos.length; ronda++) {
            System.out.println("Resultados de la ronda " + (ronda + 1) + ":");
            for (Partido partido : partidos[ronda]) {
                System.out.println(partido);
            }
            System.out.println();
        }
    }
}

