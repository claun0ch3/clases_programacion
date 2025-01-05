package Test.dif2;

import java.util.Scanner;

public class MenuTest {
    public static void menuOpciones () {
        Scanner sc = new Scanner(System.in);
        double[] valores = new double[100];
        int tamaño = 0;
        int opcion;
        do {
            System.out.println("\n Menu de opciones: ");
            System.out.println("1. Agnadir numero real");
            System.out.println("2. Listar numeros leidos");
            System.out.println("3. Modificar número");
            System.out.println("4. Borrar número");
            System.out.println("5. Consultar posición");
            System.out.println("6. Consultar número");
            System.out.println("7. Media");
            System.out.println("0. Finalizar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (tamaño < valores.length) {
                        System.out.println("Ingrese un numero real: ");
                        valores[tamaño++] = sc.nextDouble();
                    } else {
                        System.out.println("No se pueden añadir mas numeros.");
                    }
                    break;
                case 2:
                    System.out.println("Numeros leidos: ");
                    for (int i = 0; i < tamaño; i++) {
                        System.out.println("Posicion " + i + ": " + valores[i]);
                    } break;
                case 3:
                    System.out.println("Introduce la posicion a modificar: ");
                    int posicionModificar = sc.nextInt();
                    if (posicionModificar >= 0 && posicionModificar < tamaño) {
                        System.out.println("Introduce el numero: ");
                        valores[posicionModificar] = sc.nextDouble();
                    } else {
                        System.out.println("No se puede modificar por posicion invalida.");
                    } break;
                case 4:
                    System.out.println("Introduce la posicion a borrar: ");
                    int posicionBorrar = sc.nextInt();
                    if (posicionBorrar >= 0 && posicionBorrar < tamaño) {
                        for (int i = posicionBorrar; i < tamaño - 1; i++) {
                            valores[i] = valores[i + 1];
                        }
                        tamaño--;
                    } else {
                        System.out.println("No se puede borrar por posicion invalida.");
                    } break;
                case 5:
                    System.out.println("Introduce la posicion a consultar: ");
                    int posicionConsultar = sc.nextInt();
                    if (posicionConsultar >= 0 && posicionConsultar < tamaño) {
                        System.out.println("Numero en posicion: " + posicionConsultar + ": " + valores[posicionConsultar]);
                    } else {
                        System.out.println("No se puede consultar por posicion invalida.");
                    } break;
                case 6:
                    System.out.println("Introduce un numero a buscar: ");
                    double numeroBuscar = sc.nextDouble();
                    int contador = 0;
                    for (int i = 0; i < tamaño; i++) {
                        if (valores[i] == numeroBuscar) {
                            contador++;
                        }
                    }
                    if (contador > 0) {
                        System.out.println("El numero " + numeroBuscar + " aparece " + contador + " veces.");
                    } else {
                        System.out.println("El numero " + numeroBuscar + " no existe en el array.");
                    } break;
                case 7:
                    if (tamaño > 0) {
                        double suma = 0;
                        for (int i = 0; i < tamaño; i++) {
                            suma += valores[i];
                        }
                        System.out.println("La media es: " + (suma / tamaño));
                    } else {
                        System.out.println("No hay numeros para calcular la media.");
                    } break;
                case 0:
                    System.out.println("Termina el programa."); break;
                default:
                    System.out.println("Opcion invalida."); break;
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        menuOpciones();
    }
}
