package dif4.model;

public class GrupoMonedas {
    public int [] monedas;

    public GrupoMonedas(int[] monedas) {
        this.monedas = monedas;
    }

    public GrupoMonedas() {
        monedas = new int[8];
    }

    public double calcularTotal () {
        double [] valores = {0.01,0.02,0.05,0.10,0.20,0.50,1.00,2.00};
        double total = 0;
        for (int i = 0; i < monedas.length; i++) {
            total += monedas[i] * valores[i];
        }
        return total;
    }

    public void sumarMonedas(GrupoMonedas otroMonedas) {
        for (int i = 0; i < monedas.length; i++) {
            this.monedas[i] += otroMonedas.monedas[i];
        }
    }

    public void restarMonedas(GrupoMonedas otroMonedas) {
        for (int i = 0; i < monedas.length; i++) {
            this.monedas[i] -= otroMonedas.monedas[i];
        }
    }
}
