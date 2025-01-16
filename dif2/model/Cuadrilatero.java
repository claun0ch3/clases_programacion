package dif2.model;

public class Cuadrilatero {
    private Punto p1,p2,p3,p4;

    public Cuadrilatero(Punto p1, Punto p2, Punto p3, Punto p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public boolean esRectangular() {
        double lado1 = p1.distancia(p2);
        double lado2 = p2.distancia(p3);
        double lado3 = p3.distancia(p4);
        double lado4 = p4.distancia(p1);
        return lado1 == lado3 && lado2 == lado4;
    }

    public boolean ladosIguales() {
        double lado1 = p1.distancia(p2);
        double lado2 = p2.distancia(p3);
        double lado3 = p3.distancia(p4);
        double lado4 = p4.distancia(p1);
        return lado1 == lado2 && lado2 == lado3 && lado3 == lado4;
    }
}