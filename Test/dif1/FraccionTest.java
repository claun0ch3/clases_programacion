package Test.dif1;

import dif1.model.Fraccion;

public class FraccionTest {
    public static void main(String[] args) {
        Fraccion fraccion1 = new Fraccion(4,6);
        Fraccion fraccion2 = new Fraccion(2,4);
        fraccion1.reducirFraccion();
        System.out.println("Fraccion 1 reducida:" + fraccion1.toString());
        System.out.println("Fraccion " + fraccion1.toString() + " es mayor que " + fraccion2.toString()+ "?" + Fraccion.compararFraccion(fraccion1, fraccion2));
        System.out.println(fraccion1.dividirFraccion());
    }
}