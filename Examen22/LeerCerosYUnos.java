package Examen22;

import java.util.Scanner;

public class LeerCerosYUnos {
    public static int contCeros = 0;
    public static int contUnos = 0;
    public static int maxCeros = 0;
    public static int maxUnos = 0;

    public LeerCerosYUnos() {
        this.contCeros = contCeros;
        this.contUnos = contUnos;
    }

    public static int introducirNumeros(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa un numero binario (numero entero para finalizar): ");
        int numero = sc.nextInt();
        while (numero == 0 || numero == 1) {
            System.out.println("Ingresa un numero: ");
            numero = sc.nextInt();
            if (numero == 0) {
                contCeros++;
                contUnos = 0;
            } else if (numero == 1) {
                contUnos++;
                contCeros = 0;
            } else {
                System.out.println("Ha finalizado");
            }
            if (contCeros > maxCeros) {
                maxCeros = contCeros;
            }
            if (contUnos > maxUnos) {
                maxUnos = contUnos;
            }
        }
        System.out.println("la cantidad de unos más larga es: " + maxUnos + " y de ceros es: " + maxCeros);
        return numero;
    }

    public static void main (String [] args) {
        introducirNumeros();
    }
}
