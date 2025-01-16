package Test.dif2;

import java.util.Scanner;

public class NumerosEnterosTest {
    public static boolean contieneDigito (int numero, int digito) {
        while (numero > 0) {
            if (numero % 10 == digito) {
                return true;
            }
            numero = numero / 10;
        }
        return false;
    }

    public static void mostrarNumero () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un digito (0 a 9):");
        int digito = sc.nextInt();
        if (digito < 0 || digito > 9) {
            System.out.println("El digito debe estar entre 0 y 9");
            return;
        }
        System.out.println("Numeros entre 1000 y 3000 que contienen el digito " + digito);
        for (int i = 1000; i <= 3000; i++) {
            if (contieneDigito(i, digito)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        mostrarNumero();
    }
}