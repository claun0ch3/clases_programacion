package Examen22;

import java.util.Scanner;

public class NumerosAbajoArribaMedia {
    public static int [] numeros;
    public static int cont;

    public NumerosAbajoArribaMedia() {
        numeros = new int[10];
        cont = 0;
    }

    public static boolean anadirNumero(int num) {
        if (cont < numeros.length - 1) {
            numeros[cont++] = num;
            return true;
        } else {
            System.out.println("No se pueden añadir más números");
            return false;
        }
    }

    public static double media(){
        double suma = 0;
        for (int i = 0; i < cont; i++) {
            suma += numeros[i];
        }
        return suma = suma/cont;
    }

    public static void mostrarMayores50(){
        double media = media() * 1.5;
        System.out.println("Los numeros que estan un 50% por encima de la media son: ");
        for (int i = 0; i < cont; i++) {
            if (numeros[i] > media) {
                System.out.println(numeros[i] + " ");
            }
        }
        System.out.println();
    }

    public static void mostrarMenores50() {
        double media = media() * 0.5;
        System.out.println("Los numeros que estan un 50% por debajo de la media son: ");
        for (int i = 0; i < cont; i++) {
            if (numeros[i] < media) {
                System.out.println(numeros[i] + " ");
            }
        }
        System.out.println();
    }



    public static void main (String [] args) {
        Scanner sc= new Scanner (System.in);
        int n;
        boolean seguir = true;
        NumerosAbajoArribaMedia m = new NumerosAbajoArribaMedia();
        do {
            System.out.print("Número: ");
            n = sc.nextInt();
            if (n!=0)
                seguir = m.anadirNumero(n);
            else
                seguir = false;
        } while (seguir);

        m.mostrarMayores50();
        m.mostrarMenores50();
    }
}
