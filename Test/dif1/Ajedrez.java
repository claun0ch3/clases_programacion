package Test.dif1;

public class Ajedrez {
        private static String [][] tablero = new String [8][8];
        private static String [] piezas = {"R", "C", "A", "D", "R", "A", "C", "R"};

        public static void main (String [] args) {
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    if ((i + j) % 2 == 0) {
                        tablero[i][j] = "□";
                    } else {
                        tablero[i][j] = "■";
                    }
                }
            }
            for (int i = 0; i < tablero.length; i++) {
                tablero[0][i] = piezas[i] + "N";
                tablero[1][i] = "PN";
                tablero[6][i] = "PB";
                tablero[7][i] = piezas[i] + "B";
            }

            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    System.out.print(tablero[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
