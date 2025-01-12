package Test.dif4;

import dif4.model.GrupoMonedas;
import dif4.model.MaquinaBebidas;

import java.util.Scanner;

public class MaquinaBebidasTest {

    public static void main(String[] args) {
        MaquinaBebidas maquina = new MaquinaBebidas();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Menú usuario");
            System.out.println("2. Menú repartidor");
            System.out.println("3. Salir");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    menuUsuario(maquina, sc);
                    break;
                case 2:
                    menuRepartidor(maquina, sc);
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuUsuario(MaquinaBebidas maquina, Scanner sc) {
        maquina.mostrarBebidas();
        System.out.println("Seleccione una bebida (0 a 5):");
        int bebida = sc.nextInt();

        System.out.println("Introduce las monedas (formato: 1c, 2c, 5c, 10c, 20c, 50c, 1€, 2€):");
        int[] monedas = new int[8];
        for (int i = 0; i < monedas.length; i++) {
            monedas[i] = sc.nextInt();
        }
        GrupoMonedas pago = new GrupoMonedas(monedas);

        GrupoMonedas cambio = maquina.compraBebida(pago, bebida);
        if (cambio != null) {
            System.out.println("Tu cambio es:");
            double[] valores = {2.00, 1.00, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};
            for (int i = 0; i < cambio.monedas.length; i++) {
                System.out.println(cambio.monedas[i] + " monedas de " + valores[i] + "€");
            }
        } else {
            System.out.println("No se pudo realizar la compra o no hay suficiente cambio.");
        }
    }

    private static void menuRepartidor(MaquinaBebidas maquina, Scanner sc) {
        System.out.println("1. Agregar bebidas");
        System.out.println("2. Ver dinero almacenado");
        int opcion = sc.nextInt();

        if (opcion == 1) {
            maquina.mostrarBebidas();
            System.out.println("Seleccione una bebida (0 a 5):");
            int bebida = sc.nextInt();
            System.out.println("Cantidad a agregar:");
            int cantidad = sc.nextInt();
            maquina.agregarBebidas(bebida, cantidad);
        } else if (opcion == 2) {
            System.out.println("Dinero almacenado: " + maquina.cantidadTotalAlmacenada() + "€");
        } else {
            System.out.println("Opción no válida.");
        }
    }
}