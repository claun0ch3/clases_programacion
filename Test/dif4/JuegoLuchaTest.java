package Test.dif4;

import dif4.model.Arma;
import dif4.model.Personaje;

import java.util.Random;
import java.util.Scanner;

public class JuegoLuchaTest {
    private static Personaje[] personajes;
    private static Arma[] armas;
    private int numeroPersonajes;
    private int numeroArmas;

    public JuegoLuchaTest() {
        personajes = new Personaje[10];
        armas = new Arma[10];
        numeroPersonajes = 0;
        numeroArmas = 0;
    }

    public void crearPersonajes(Scanner scanner) {
        if (numeroPersonajes >= personajes.length) {
            System.out.println("No se pueden añadir más personajes");
            return;
        }
        System.out.println("Crear un nuevo personaje: ");
        System.out.println("Nombre: ");
        String nombre = scanner.next();
        System.out.println("Fuerza (0 a 100): ");
        int fuerza = scanner.nextInt();
        personajes[numeroPersonajes] = new Personaje(nombre, fuerza);
        System.out.println("Personaje creado: " + personajes[numeroPersonajes]);
        numeroPersonajes++;
    }

    public void crearArmas(Scanner scanner) {
        if (numeroArmas >= armas.length) {
            System.out.println("No se pueden añadir más armas");
            return;
        }
        System.out.println("Crear un nuevo arma: ");
        System.out.println("Potencia de ataque (0 a 100): ");
        int ataque = scanner.nextInt();
        System.out.println("Potencia de defensa (0 a 100): ");
        int defensa = scanner.nextInt();
        armas[numeroArmas] = new Arma(ataque, defensa);
        System.out.println("Arma creada: " + armas[numeroArmas]);
        numeroArmas++;
    }

    public void asignarArma(Scanner scanner) {
        if (numeroPersonajes == 0 || numeroArmas == 0) {
            System.out.println("No hay personajes o armas");
            return;
        }
        System.out.println("Selecciona un personaje: ");
        for (int i = 0; i < numeroPersonajes; i++) {
            System.out.println(i + ": " + personajes[i].getNombre());
        }
        int indicePersonaje = scanner.nextInt();
        System.out.println("Selecciona un arma: ");
        for (int i = 0; i < numeroArmas; i++) {
            System.out.println(i + ": " + armas[i]);
        }
        int indiceArma = scanner.nextInt();
        System.out.println("Asignar como (0) arma 1 o (1) arma 2");
        int posicion = scanner.nextInt();
        personajes[indicePersonaje].asignarArma(armas[indiceArma],posicion);
        System.out.println("Arma asignada con exito");
    }

    public void luchar(Scanner scanner) {
        if (numeroPersonajes < 2) {
            System.out.println("No hay suficientes personajes");
            return;
        }
        System.out.println("Selecciona el primer personaje: ");
        for (int i = 0; i < numeroPersonajes; i++) {
            System.out.println(i + ": " + personajes[i].getNombre());
        }
        int indicePersonaje1 = scanner.nextInt();
        System.out.println("Selecciona el segundo personaje: ");
        for (int i = 0; i < numeroPersonajes; i++) {
            if (i != indicePersonaje1) {
                System.out.println(i + ": " + personajes[i].getNombre());
            }
        }
        int indicePersonaje2 = scanner.nextInt();
        int poder1 = calcularPoder(personajes[indicePersonaje1], personajes[indicePersonaje2]);
        int poder2 = calcularPoder(personajes[indicePersonaje2], personajes[indicePersonaje1]);
        System.out.println(personajes[indicePersonaje1].getNombre() + " tiene un poder de " + poder1);
        System.out.println(personajes[indicePersonaje2].getNombre() + " tiene un poder de " + poder2);
        if (poder1 > poder2) {
            System.out.println(personajes[indicePersonaje1].getNombre() + " gana la lucha");
            personajes[indicePersonaje2].reducirVida(20);
        } else if (poder2 > poder1) {
            System.out.println(personajes[indicePersonaje2].getNombre() + " gana la lucha");
            personajes[indicePersonaje1].reducirVida(20);
        } else {
            System.out.println("Empate");
        }
    }

    public int calcularPoder(Personaje atacante, Personaje defensor) {
        int fuerza = atacante.getFuerza();
        for (Arma arma : atacante.getArmas()) {
            if (arma != null) {
                fuerza += arma.getPotenciaAtaque();
            }
        }
        for (Arma arma : defensor.getArmas()) {
            if (arma != null) {
                fuerza -= arma.getPotenciaDefensa();
            }
        }
        if (fuerza < 0) {
            fuerza = 0;
        }
        return fuerza + new Random().nextInt(10);
    }

    public void mostrarPersonajes() {
        System.out.println("Personajes: ");
        for (int i = 0; i < numeroPersonajes; i++) {
            System.out.println(i + ": " + personajes[i]);
        }
    }

    public static void main(String[] args) {
        JuegoLuchaTest juego = new JuegoLuchaTest();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Crear arma");
            System.out.println("2. Crear personaje");
            System.out.println("3. Asignar arma a personaje");
            System.out.println("4. Realizar lucha");
            System.out.println("5. Mostrar personajes");
            System.out.println("6. Salir");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1: juego.crearArmas(sc);break;
                case 2: juego.crearPersonajes(sc);break;
                case 3: juego.asignarArma(sc);break;
                case 4: juego.luchar(sc);break;
                case 5: juego.mostrarPersonajes();break;
                case 6: salir = true;break;
                default: System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
