package dif1.model;

public class Fraccion {
    int numerador;
    int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void reducirFraccion() {
        int cont = 2;

        while (cont <= numerador && cont <= denominador) {
            if (numerador % cont == 0 && denominador % cont == 0) {
                numerador = numerador / cont;
                denominador = denominador / cont;
            } else {
                cont++;
            }
        }
    }

    public double dividirFraccion() {
        return (double) numerador / denominador;
    }

    public static boolean compararFraccion(Fraccion fraccion1, Fraccion fraccion2) {
        return fraccion1.dividirFraccion() >= fraccion2.dividirFraccion();
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}