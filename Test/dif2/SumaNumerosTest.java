package Test.dif2;

public class SumaNumerosTest {
    public static int suma() {
        int n = (int) ((Math.random() * (10000 - 5000)) + 5000);
        System.out.println(n);
        int suma = 0;
        while (n > 0) {
            suma += n%10;
            n = n/10;
        }

        return suma;
    }
    public static void main(String[] args) {
        System.out.println(suma());

    }
}
