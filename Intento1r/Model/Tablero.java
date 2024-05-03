package Model;

public class Tablero  {
    private Casilla [][] matrizCasilla;
    private int fila;
    private int columna;


    public Tablero (int fila, int columna){
        this.fila = fila;
        this.columna = columna;
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

    public boolean insideTable(int posFila, int posColumna){
        if ((posFila < 0) || (posColumna < 0)){
            return false;
        }

        if ((posFila > this.fila) || (posColumna > this.columna) ){
            return false;
        }
        return true;
    }

    public int getMaxFila() {
        return fila;
    }

    public int getMaxColumna() {
        return columna;
    }
}
