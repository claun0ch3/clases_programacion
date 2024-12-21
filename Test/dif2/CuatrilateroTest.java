package Test.dif2;

import dif2.model.Cuadrilatero;
import dif2.model.Punto;

public class CuatrilateroTest {
    public static void main(String[] args) {
        Punto p1 = new Punto(10,20);
        Punto p2 = new Punto(10,20);
        Punto p3 = new Punto(10,20);
        Punto p4 = new Punto(10,20);

        Cuadrilatero c1 = new Cuadrilatero(p1,p2,p3,p4);
        System.out.println("Tiene lados iguales " + c1.ladosIguales());
        System.out.println("Es rectangulo " +c1.esRectangular());
    }
}
