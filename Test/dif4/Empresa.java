package Test.dif4;

import java.util.Random;
import java.util.Scanner;

public class Empresa {
    private static double [][] ventas;

    public Empresa() {
        ventas = new double[10][12];
    }

    public static void populate() {
        Random random = new Random();
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = random.nextDouble() * 1000;
            }
        }
        System.out.println("Datos de ventas generados automáticamente.");
    }

    public static void anadirVentas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad vendida: ");
        double cantidad = sc.nextDouble();
        System.out.println("Introduce el numero de vendedor (0-9): ");
        int numeroVendedor = sc.nextInt();
        System.out.println("Introduce el mes de la venta (1-12): ");
        int mesVenta = sc.nextInt();

        if (numeroVendedor >= 0 && numeroVendedor < 10 && mesVenta >= 1 && mesVenta <= 12) {
            ventas[numeroVendedor][mesVenta -1] += cantidad;
            System.out.println("Venta añadida: ");
        } else {
            System.out.println("Datos invalidos");
        }
    }

    public static void mostrarCasilla(){
        double max = 0;
        int vendedorMaximo = -1;
        int mesMaximo = -1;
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                if (ventas[i][j] > max) {
                    max = ventas[i][j];
                    vendedorMaximo = i;
                    mesMaximo = j;
                }
            }
        }
        System.out.println("El valor maximo de ventas es: " + max + " el vendedor maximo es: " + vendedorMaximo + " el mes maximo es: " + (mesMaximo + 1));
    }

    private void calcularTotalVentas() {
        double total = 0;
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                total += ventas[i][j];
            }
        }
        System.out.println("El total de ventas es: " + total);
    }

    private void mostrarVentasVendedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero de vendedor: ");
        int numeroVendedor = sc.nextInt();
        if (numeroVendedor >= 0 && numeroVendedor < 10) {
            double totalVentas = 0;
            System.out.println("Ventas del vendedor: " + numeroVendedor + ": ");
            for (int i = 0; i < ventas[numeroVendedor].length; i++) {
                System.out.println("Mes " + (i + 1) + ": " + ventas[numeroVendedor][i]);
                totalVentas += ventas[numeroVendedor][i];
            }
            System.out.println("El total de ventas es: " + totalVentas);
        } else {
            System.out.println("Datos invalidos");
        }
    }

    private void mostrarVentasMes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el mes de la venta: ");
        int mesVenta = scanner.nextInt();
        if (mesVenta >= 1 && mesVenta <= 12) {
            System.out.println("Ventas del mes " +mesVenta + ": ");
            for (int i = 0; i < ventas.length; i++) {
                System.out.println("El vendedor " + i + ": " + ventas[i][mesVenta - 1]);
            }
        }
    }

    private void vendedorMenorVentas() {
        double min = Double.MAX_VALUE;
        int vendedorMinimo = -1;
        for (int i = 0; i < ventas.length; i++) {
            double totalVentas = 0;
            for (int j = 0; j < ventas[i].length; j++) {
                totalVentas += ventas[i][j];
            }
            if (totalVentas < min) {
                min = totalVentas;
                vendedorMinimo = i;
            }
        }
        System.out.println("El vendedor con menor cantidad en ventas es " + vendedorMinimo + " con un total de " + min);
    }

    private void mesMayorVentas() {
        double max = 0;
        int mesMaximo = -1;
        for (int i = 0; i < 12; i++) {
            double totalVentas = 0;
            for (int j = 0; j < ventas.length; j++) {
                totalVentas += ventas[j][i];
            }
            if (totalVentas >= max) {
                max = totalVentas;
                mesMaximo = i;
            }
        }
        System.out.println("El mes con la mayor cantidad de venta es " + (mesMaximo +1) + " con un total de " + max);
    }

    private void mejorRachaVentas() {
        double maxRacha = 0;
        int vendedorMax = -1;
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length - 2; j++) {
                double racha = ventas[i][j] + ventas[i][j + 1] + ventas[i][j + 2];
                if (racha > maxRacha) {
                    maxRacha = racha;
                    vendedorMax = i;
                }
            }
        }
        System.out.println("El vendedor con la mejor racha de ventas en 3 meses es " + vendedorMax + " con un total de " + maxRacha);
    }

    private void mostrarMatriz() {
        System.out.println("Ventas por vendedor y mes:");
        System.out.printf("%12s", "");
        for (int mes = 1; mes <= 12; mes++) {
            System.out.printf("Mes %2d ", mes);
        }
        System.out.println("  Total");
        double totalEmpresa = 0;

        for (int i = 0; i < ventas.length; i++) {
            double totalVendedor = 0;
            System.out.printf("Vendedor %2d: ", i);
            for (int j = 0; j < ventas[i].length; j++) {
                System.out.printf("%8.2f ", ventas[i][j]);
                totalVendedor += ventas[i][j];
            }
            totalEmpresa += totalVendedor;
            System.out.printf("| %8.2f\n", totalVendedor);
        }

        System.out.printf("%12s", "Totales: ");
        for (int j = 0; j < 12; j++) {
            double totalMes = 0;
            for (int i = 0; i < ventas.length; i++) {
                totalMes += ventas[i][j];
            }
            System.out.printf("%8.2f ", totalMes);
        }
        System.out.printf("| %8.2f\n", totalEmpresa);
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1.- Añadir una venta");
            System.out.println("2.- Mostrar la casilla con el valor de ventas más alto");
            System.out.println("3.- Calcular el total de ventas de la empresa");
            System.out.println("4.- Mostrar ventas de un vendedor");
            System.out.println("5.- Mostrar ventas de un mes");
            System.out.println("6.- Vendedor con menor cantidad en ventas");
            System.out.println("7.- Mes con mayor cantidad de ventas");
            System.out.println("8.- Mejor racha de ventas en 3 meses consecutivos");
            System.out.println("9.- Mostrar la matriz");
            System.out.println("0.- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    anadirVentas();
                    break;
                case 2:
                    mostrarCasilla();
                    break;
                case 3:
                    calcularTotalVentas();
                    break;
                case 4:
                    mostrarVentasVendedor();
                    break;
                case 5:
                    mostrarVentasMes();
                    break;
                case 6:
                    vendedorMenorVentas();
                    break;
                case 7:
                    mesMayorVentas();
                    break;
                case 8:
                    mejorRachaVentas();
                    break;
                case 9:
                    mostrarMatriz();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        populate();
        empresa.menu();
    }
}
