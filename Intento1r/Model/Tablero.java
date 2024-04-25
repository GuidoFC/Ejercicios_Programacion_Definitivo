package Model;

public class Tablero  {
    Casilla [][] matrizCasilla;

    public Tablero (int fila, int columna){
        this.matrizCasilla = new Casilla [fila][columna];
        // rellenar la matriz de Casilla con Objeto de Casillas
        rellenarMatrizCasilla();
    }

    public Casilla obtenerCasilla(int fila, int columna){
        return matrizCasilla[fila][columna];
    }
    public void rellenarMatrizCasilla(){
        for (int i = 0; i < matrizCasilla.length; i++) {
            for (int j = 0; j < matrizCasilla[0].length; j++) {
                matrizCasilla[i][j] = new Casilla();
            }

        }
    }

}
