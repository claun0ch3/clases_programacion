package Examen;

import java.util.Scanner;

public class Fecha {
    private final int dia;
    private final int mes;
    private final int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Fecha diaSiguiente (){
        int [] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(esBisiesto()) diasMes[1] = 29;

        int nuevoDia = dia + 1;
        int nuevoMes = mes;
        int nuevoAnio = anio;
        if(nuevoDia > diasMes[mes -1]){
            nuevoDia = 1;
            nuevoMes ++;
            if (nuevoMes > 12){
                nuevoMes = 1;
                nuevoAnio++;
            }
        }
        return new Fecha(nuevoDia,nuevoMes, nuevoAnio);
    }

    public boolean esBisiesto(){
        return (anio % 4 == 0 && anio % 100 !=0) || (anio % 400 == 0);
    }

    public static int diferenciaDias(Fecha inicio, Fecha fin){
        int dias = 0;

        if(inicio.compareTo(fin)>0){
            Fecha fechaAux = inicio;
            inicio = fin;
            fin = fechaAux;
        }
        while(!inicio.equals(fin)){
            inicio = inicio.diaSiguiente();
            dias++;
        }
        return dias + 1;

    }
    public int compareTo(Fecha fecha){
        if (this.anio != fecha.anio) return this.anio-fecha.anio;
        if(this.mes!=fecha.mes) return this.mes -fecha.mes;
        return this.dia - fecha.dia;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Fecha fecha)) return false;
        return dia == fecha.dia && mes == fecha.mes && anio == fecha.anio;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", año=" + anio +
                '}';
    }

    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la primera fecha (dia,mes,año):");
        int dia1 = sc.nextInt();
        int mes1 = sc.nextInt();
        int anio1 = sc.nextInt();
        Fecha fecha1 = new Fecha(dia1,mes1,anio1);

        System.out.println("Introduce la segunda fecha (dia,mes,año):");
        int dia2 = sc.nextInt();
        int mes2 = sc.nextInt();
        int anio2 = sc.nextInt();
        Fecha fecha2 = new Fecha(dia2,mes2,anio2);

        int diferenciaDias = Fecha.diferenciaDias(fecha1, fecha2);
        System.out.print("La diferencia de días entre las fechas es: " + diferenciaDias);
    }
}
