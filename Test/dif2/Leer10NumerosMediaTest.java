package Test.dif2;

import java.util.Scanner;

public class Leer10NumerosMediaTest {
    public static void leer10NumerosMedia() {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];
        int suma = 0;
        System.out.println("Ingrese 10 numeros enteros: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
            suma += numeros[i];
        }
        double media = (double) suma / numeros.length;
        System.out.println("La media de los numeros es: " + media);
        System.out.println("Numeros por encima de la media: ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > media) {
                System.out.print(numeros[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        leer10NumerosMedia();
    }
}
