package Test.dif4;

public class CompeticionTest {
    public static void main(String[] args) {
        String[] nombresJugadores = {"Jugador 1", "Jugador 2", "Jugador 3", "Jugador 4", "Jugador 5", "Jugador 6", "Jugador 7", "Jugador 8"};
        int[] puntosIniciales = {1200, 1100, 1150, 1130, 1120, 1140, 1160, 1110};

        dif4.model.Competicion competicion = new dif4.model.Competicion(nombresJugadores, puntosIniciales);
        competicion.jugarCompeticion();
        competicion.mostrarResultados();
    }
}
