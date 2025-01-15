package Examen;

import java.util.Scanner;

public class AgenciaViajesTest {

    public static class CosteViajes {
        private String []destinos= {"Madrid", "Londres", "Roma", "Paris", "Berlin"};
        private double[][] coste ={
                {0,33,34,66,76},
                {100,0,43,45,99},
                {96,100,0,34,87},
                {54,123,145,0,54},
                {125,78,13,68,0}};

        public int getIndiceDestino (String ciudad){
            for(int i = 0; i<destinos.length; i++){
                if(destinos[i].equalsIgnoreCase(ciudad)){
                    return i;
                }
            }
            return -1;
        }

        public double getCoste(int indiceOrigen, int indiceDestino) {
            return coste[indiceOrigen][indiceDestino];
        }
        public String getCiudad(int indice){
            return destinos[indice];
        }

        public int [] viajeIdaYVueltaMasCaro(){
            double maxCoste = 0;
            int origen = -1;
            int destino = -1;
            for (int i = 0; i<coste.length; i++){
                for (int j = 0; j <coste[i].length; j ++){
                    double costeIV = coste[i][j] + coste [j][i];
                    if(costeIV > maxCoste){
                        maxCoste = costeIV;
                        origen = i;
                        destino = j;
                    }
                }
            }
            return new int[]{origen, destino};
        }


    }
    public static class Viajero {
        private Viaje[] viajes;//se supondrá que no hace más de 100 viajes.
        private int contViajes; //cuenta los viajes que ha contratado el cliente.
        private int identificador;

        public Viajero(int identificador) {
            this.identificador = identificador;
            contViajes=0;
            viajes=new Viaje[100];
        }

        public void addViaje(Viaje viaje) {
            if(contViajes<viajes.length){
                viajes[contViajes++] = viaje;
            }
        }

        public int getNumeroViajes() {
            return contViajes;
        }

        public int getIdentificador() {
            return identificador;
        }

        public double getGastoTotal() {
            double costeTotal = 0;
            for(int i = 0; i<contViajes; i++){
                costeTotal+= viajes[i].getCoste();
            }
            return costeTotal;
        }
    }
    public static class Viaje {
        private int origen; //número de orden del array destinos de CosteViajes
        private int destino; //número de orden del array destinos de CosteViajes
        private double coste;

        public Viaje(int origen, int destino, double coste) {
            this.origen = origen;
            this.destino = destino;
            this.coste = coste;
        }

        public double getCoste() {
            return coste;
        }
    }
    public static class AgenciaViajes {
        Viajero[] clientes; //se supondrá que no hay más de 200 clientes.
        int contClientes; //Cuenta los clientes dados de alta.
        CosteViajes costes;
        AgenciaViajes(){
            costes= new CosteViajes();
            clientes = new Viajero[100];
            contClientes=0;
        }
        public void altaCliente(int identificador) {
            if(buscarCliente(identificador)== null){
                clientes[contClientes++] = new Viajero(identificador);
                System.out.println("Cliente dado de alta con éxito");
            } else {
                System.out.println("El cliente ya está dado de alta");
            }
        }

        private Viajero buscarCliente(int identificador){
            for (Viajero cliente : clientes) {
                if (cliente != null && cliente.identificador == identificador) {
                    return cliente;
                }
            }
            return null;
        }

        public void contratarViaje(int identificador, String origen, String destino) {
            Viajero cliente = buscarCliente(identificador);
            if(cliente!=null){
                int indiceOrigen = costes.getIndiceDestino(origen);
                int indiceDestino = costes.getIndiceDestino(destino);
                if(indiceOrigen != -1 && indiceDestino!=-1){
                    double coste = costes.getCoste(indiceOrigen, indiceDestino);
                    cliente.addViaje(new Viaje(indiceOrigen, indiceDestino, coste));
                }
            }
        }

        public void verViajeMasCaro() {
            int [] indices = costes.viajeIdaYVueltaMasCaro();
            if(indices[0] !=-1  && indices[1]!=-1){
                System.out.println("El viaje de ida y vuelta más caro es de "
                        + costes.getCiudad(indices[0])
                        + " a " +costes.getCiudad(indices[1])
                        + " con un coste total de "
                        + (costes.getCoste(indices[0], indices[1])
                        + costes.getCoste(indices[1], indices[0]))
                        + "€.");
            }else{
                System.out.println("No hay datos suficientes");
            }

        }

        public void viajeroMasViajes() {
            Viajero viajeroMasViajes = null;
            for(int i = 0; i<contClientes; i++){
                if(viajeroMasViajes == null || clientes[i].getNumeroViajes()> viajeroMasViajes.getNumeroViajes()){
                    viajeroMasViajes = clientes[i];
                }
            }
            if(viajeroMasViajes !=null){
                System.out.println("El viajero con más viajes es "+ viajeroMasViajes.getIdentificador());
            }
        }

        public void viajeroMayorGasto() {
            Viajero viajeroMasGastos = null;
            for(int i = 0; i<contClientes; i++){
                if(viajeroMasGastos == null || clientes[i].getGastoTotal()> viajeroMasGastos.getGastoTotal()){
                    viajeroMasGastos = clientes[i];
                }
            }
            if(viajeroMasGastos !=null){
                System.out.println("El viajero con mayor gasto de viajes es "+ viajeroMasGastos.getIdentificador() + " con un total de: " +viajeroMasGastos.getGastoTotal());
            }
        }

        public void mostrarViajerosYViajes() {
            for (int i = 0; i < contClientes; i++) {
                Viajero viajero = clientes[i];
                System.out.println("Viajero ID: " + viajero.getIdentificador());
                System.out.println("Número de viajes: " + viajero.getNumeroViajes());
                for (int j = 0; j < viajero.getNumeroViajes(); j++) {
                    Viaje viaje = viajero.viajes[j];
                    System.out.println("  Viaje " + (j + 1) + ": Origen - " + costes.getCiudad(viaje.origen) + ", Destino - " + costes.getCiudad(viaje.destino) + ", Coste - " + viaje.getCoste() + "€");
                }
            }
        }
    }

    public static void main(String[] args) {
        int opcion;
        AgenciaViajes agencia = new AgenciaViajes();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Alta Cliente");
            System.out.println("2. Contratar viaje");
            System.out.println("3. Ver viaje ida y vuelta más caro");
            System.out.println("4. Viajero con más viajes");
            System.out.println("5. Viajero que más dinero se ha gastado");
            System.out.println("6. Mostrar viajeros y viajes");
            System.out.println("0. Finalizar programa");
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, introduzca un número válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();
            int identificador;
            switch (opcion) {
                case 1:
                    System.out.print("Introduzca el identificador del cliente: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, introduzca un número válido.");
                        sc.next();
                    }
                    identificador = sc.nextInt();
                    agencia.altaCliente(identificador);
                    break;
                case 2:
                    System.out.print("Introduzca el identificador del cliente: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, introduzca un número válido.");
                        sc.next();
                    }
                    identificador = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduzca la ciudad de origen: ");
                    String origen = sc.nextLine();
                    System.out.print("Introduzca la ciudad de destino: ");
                    String destino = sc.nextLine();
                    agencia.contratarViaje(identificador, origen, destino);
                    break;
                case 3:
                    agencia.verViajeMasCaro();
                    break;
                case 4:
                    agencia.viajeroMasViajes();
                    break;
                case 5:
                    agencia.viajeroMayorGasto();
                    break;
                case 6:
                    agencia.mostrarViajerosYViajes();
                    break;
                case 0:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
        sc.close();
    }
}
