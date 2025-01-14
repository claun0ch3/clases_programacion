package Examen;

import java.util.Arrays;
import java.util.Scanner;

public class BinarioADecimal {
    static int cont = 0;
    public static int [] leerNumeros(){
        Scanner sc = new Scanner(System.in);
        int [] numeros = new int [10];
        System.out.println("Introduce números binarios (0 o 1). Introduce un número negativo para finalizar");
        while (cont < 10) {
            int numero = sc.nextInt();
            if(numero < 0) break;
            if(numero == 0 || numero == 1){
                numeros[cont++] = numero;
            }
        }
        return numeros;
    }

    public static int convertirABase10(int[] numeros){
        int numeroDecimal = 0;
        for(int i = cont -1, j = 0; i>= 0; j++ ,i-- ){
            numeroDecimal += numeros[i] * Math.pow(2, j);
        }
        return numeroDecimal;
    }
    public static void mostrarArray(int [] numeros){
        System.out.print("Array de números binarios: [" );
        for (int i = 0; i<numeros.length; i++){
            if (i>0) {
                System.out.print("," );
            }
            System.out.print(numeros[i]);
        }
        System.out.println("]");
    }
    public static void main (String [] args){
        int [] numeros = leerNumeros();
        int decimal = convertirABase10(numeros);
        mostrarArray(numeros);
        System.out.print("El número en base 10 es: " + decimal);
    }
}
