package Test.dif5;

import dif5.model.Jugador;
import dif5.model.Partido;

public class PartidoTenisTest {

    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Juan",1200);
        Jugador jugador2 = new Jugador("Pedro",1500);

        Partido partido = new Partido(jugador1, jugador2);

        System.out.println(partido);
    }
}
