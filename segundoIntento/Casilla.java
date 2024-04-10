package segundoIntento;

public class Casilla {

    private char casillaVisible;
    // Estado de una Casilla:
        // 'x' bomba
        // '-' casilla tapada
        // 'n' numeroBombas
        // 'b' bandera
    private char estado;
    private int fila;
    private int columna;
    private boolean tapada;
    private int numBombasVecinas;
    private boolean bandera;


    public Casilla(int fila, int columna, char casillaValor){
        this.fila = fila;
        this.columna = columna;
        this.casillaVisible = casillaValor;
        this.tapada = true;
        this.numBombasVecinas =0;
        this.estado = casillaValor;
        this.bandera = false;
    }

    public char getCasillaVisible() {
        return casillaVisible;
    }

    public void setCasillaVisible(char casillaVisible) {
        this.casillaVisible = casillaVisible;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isTapada() {
        return tapada;
    }

    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }

    public int getNumBombasVecinas() {
        return numBombasVecinas;
    }

    public void setNumBombasVecinas(int numBombasVecinas) {
        this.numBombasVecinas = numBombasVecinas;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
}
