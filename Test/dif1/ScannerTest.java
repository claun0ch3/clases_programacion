package Test.dif1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerTest {
    private static List<Integer> list = new ArrayList<>();
    private static int sumaPares = 0;

    public static int suma (List<Integer> list) {
        int suma = 0;
        for (int i = 0; i < list.size(); i++) {
            suma += list.get(i);
        }
        System.out.println("Suma: "+suma);
        return suma;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un numero");
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n % 2 == 0) {
                sumaPares = sumaPares + n;
            }
            if (n == 0) {
                list.add(n);
                suma(list);
                break;
            } else {
                list.add(n);
                suma(list);
            }
        }

        sc.close();
        System.out.println("Suma pares " + sumaPares);
        System.out.println(list);
    }
}
