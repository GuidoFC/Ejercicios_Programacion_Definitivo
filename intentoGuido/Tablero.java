package intentoGuido;

public class Tablero extends Ficha {
    private char[][] tableroFicha;

    public Tablero(int fila, int columna) {
        tableroFicha = new char[fila][columna];
    }

    public char getTableroFicha(int fila, int columna) {
        return tableroFicha[fila][columna];
    }

    public void setTableroFicha(int fila, int columna, char valor) {
        this.tableroFicha[fila][columna] = valor ;
    }

    public void RellenarFicha() {
        for (int i = 0; i < tableroFicha.length; i++) {
            for (int j = 0; j < tableroFicha[0].length; j++) {
                tableroFicha[i][j] = '-';
            }
        }
    }

    public void imprimirTablero() {
        for (int i = -1; i < tableroFicha.length; i++) {
            for (int j = 0; j < tableroFicha[0].length; j++) {
                if ((i == -1)) {
                    System.out.print("\t" + (j + 1) + " ");
                    if (j == tableroFicha[0].length - 1) {
                        System.out.println();
                    }
                }
                if (i >= 0) {
                    if (j == 0) {
                        System.out.print(i + 1 + "\t");
                    }
                    System.out.print(tableroFicha[i][j] + "\t");
                    if (j == tableroFicha[0].length - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }
}


