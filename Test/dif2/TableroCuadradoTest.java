package Test.dif2;

import java.util.Scanner;

public class TableroCuadradoTest {
    public static void mostrarTablero () {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca un numero entero");
        int numero = teclado.nextInt();
        for (int i = 0; i < numero; i++) {
            for (int j = 0; j < numero; j++) {
                if (i == 0 || i == numero - 1 || j == 0 || j == numero - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        mostrarTablero();
    }
}
