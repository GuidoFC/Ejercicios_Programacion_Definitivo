package segundoIntento;

public class TableroDef {
    private Casilla [][] casilla;
    private int numBombas;
    private int numBanderas;



    public TableroDef(int fila, int columna, int numBombas){
        casilla = new Casilla[fila][columna];
        this.numBombas = numBombas;
        numBanderas = 0;

    }

    public Casilla getTablero(int fila, int columna){
        return this.casilla[fila][columna];
    }

    public int numFilas(){
        int filas = this.casilla.length;
        return filas;
    }

    public int numColumnas(){
        int columnas = this.casilla[0].length;
        return columnas;
    }



    public void RellenarTableroAlInicio() {
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[0].length; j++) {
                casilla[i][j] = new Casilla(i,j,'-');
            }
        }
    }


}
