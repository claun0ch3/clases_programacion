package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerTest {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un numero");
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) {
                list.add(n);
                break;
            } else {
                list.add(n);
            }
        }
        sc.close();
        System.out.println(list);
    }
}
