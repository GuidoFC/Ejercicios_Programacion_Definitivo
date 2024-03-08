public class Tablero {
    private int filas;
    private int columnas;


    public Tablero(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public static void dibujarTablero(int filas, int columnas){

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // en esta parte hacemos la primera fila, y especificamos los nombres de las columnnas
                if (i == 0 && j ==0){
                    char ABC = 'A';
                    for (int k = 0; k < columnas; k++) {
                        if (k == 0){
                            System.out.print(" ");
                        }else {
                            System.out.print("|" +ABC + "|" + " ");
                            ABC ++;
                            if (k == columnas -1 ){
                                System.out.println();
                            }
                        }
                    }
                }

                if (j == 0){
                    System.out.print(i + " " + "hola");
                }
                if ( i > 0){
                    char imprimir = JuegoMain.fichas[i][j].getCasilla();
                    System.out.print("pepe" +"| " + imprimir + " |");
                }

            }

        }
    }








}
