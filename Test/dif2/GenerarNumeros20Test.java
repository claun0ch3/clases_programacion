package Test.dif2;

import java.util.Random;

public class GenerarNumeros20Test {
    public static void numerosAleatoriosHasta20 () {
        int[]numerosAleatorios = new int[20];
        int[]apariciones = new int[11];
        Random rand = new Random();
        System.out.println("Array generado: ");
        for (int i = 0; i < numerosAleatorios.length; i++) {
            numerosAleatorios[i] = rand.nextInt(10) + 1;
            apariciones[numerosAleatorios[i]]++;
            System.out.print(numerosAleatorios[i] + " ");
        }
        System.out.println();
        int contador = 0;
        int numeroFrecuente = 0;
        for (int i = 1; i <= 10; i++) {
            if(apariciones[i] > contador) {
                contador = apariciones[i];
                numeroFrecuente = i;
            }
        }
        System.out.println("El numero que mas veces aparece es " + numeroFrecuente + " con " + contador + " veces");
    }
    public static void main(String[] args) {
        numerosAleatoriosHasta20();
    }
}