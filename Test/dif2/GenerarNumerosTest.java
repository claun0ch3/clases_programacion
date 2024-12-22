package Test.dif2;

import java.util.Random;
import java.util.Scanner;

public class GenerarNumerosTest {

    public static void numerosAleatorios () {
        int[]numeros = new int[10];
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Array generado: ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(10) + 1;
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
        System.out.println("Introduce un numero (1 a 10): ");
        int numero1 = -1;

        while (numero1 != 0) {
            numero1 = sc.nextInt();
            if (numero1 != 0) {
                int contador = 0;
                for (int i = 0; i < numeros.length; i++) {
                    if (numeros[i] == numero1) {
                        contador++;
                    }
                }
                System.out.println("El numero " + numero1 + " aparece " + contador + " veces en el Array");
            }
        }
    }

    public static void main(String[] args) {
        numerosAleatorios();
    }
}