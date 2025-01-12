package dif4.model;

public class MaquinaBebidas {
    private GrupoMonedas monedas;
    private int [] bebidas;
    private double [] preciosBebidas;

    public MaquinaBebidas() {
        monedas = new GrupoMonedas(new int [] {10,10,10,10,10,10,10,10});
        bebidas = new int [] {10,10,10,10,10,10};
        preciosBebidas = new double [] {2.60,2.75,1.80,1.75,3.80,2.50};
    }

    public double cantidadTotalAlmacenada () {
        return monedas.calcularTotal();
    }

    public GrupoMonedas compraBebida (GrupoMonedas pago, int bebidaSeleccionada) {
        if (bebidaSeleccionada < 0 || bebidaSeleccionada >= bebidas.length || bebidas [bebidaSeleccionada] <= 0) {
            System.out.println("Bebida no disponible");
            return null;
        }
        double precio = preciosBebidas [bebidaSeleccionada];
        if (pago.calcularTotal() < precio) {
            System.out.println("Pago insuficiente");
            return null;
        }
        bebidas [bebidaSeleccionada] --;
        monedas.sumarMonedas(pago);
        double cambioTotal = pago.calcularTotal() - precio;
        GrupoMonedas cambio = calcularCambio (cambioTotal);
        monedas.restarMonedas(cambio);
        return cambio;
    }

    private GrupoMonedas calcularCambio(double cambioTotal) {
        double[] valores = {2.00, 1.00, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};
        GrupoMonedas cambio = new GrupoMonedas(new int [8]);
        for (int i = 0; i < valores.length; i++) {
            while (cambioTotal >= valores[i] && monedas.monedas[i] > 0) {
                cambio.monedas[i]++;
                monedas.monedas[i]--;
                cambioTotal -= valores[i];
                cambioTotal = Math.round(cambioTotal * 100.0) / 100.0;
            }
        }
        if (cambioTotal > 0) {
            System.out.println("Cambio insuficiente");
        }
        return cambio;
    }

    public void agregarBebidas (int bebida, int cantidad) {
        if (bebida >= 0 && bebida < bebidas.length) {
            bebidas[bebida] += cantidad;
        }
    }
    public void mostrarBebidas () {
        String [] nombres = {"Refresco 1", "Refresco 2", "Refresco 3", "Agua", "Energética", "Cerveza"};
        for (int i = 0; i < bebidas.length; i++) {
            System.out.println(nombres[i] + ": " + bebidas[i] + " unidades - precio: " + preciosBebidas[i] + "€");
        }
    }
}
