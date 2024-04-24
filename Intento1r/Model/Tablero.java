package Model;

public class Tablero extends {
    Casilla [][] matrizCasilla;

    public Tablero (int fila, int columna){
        this.matrizCasilla = new Casilla [fila][columna];
        crearObjetosMatrizCasilla(fila,columna);
    }

    public void crearObjetosMatrizCasilla(int fila, int columna){
        for (int i = 0; i < this.matrizCasilla.length; i++) {
            for (int j = 0; j < this.matrizCasilla[0].length; j++) {
                this.matrizCasilla[i][j] = new Casilla();

            }

        }

    }

}
