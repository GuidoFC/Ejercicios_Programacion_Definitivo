package Model;

public class Tablero  {
    Casilla [][] matrizCasilla;

    public Tablero (int fila, int columna){
        this.matrizCasilla = new Casilla [fila][columna];
    }

    public Casilla obtenerCasilla(int fila, int columna){
        return matrizCasilla[fila][columna];
    }

}
