package segundoIntento;

public class Casilla {

    private char casillaVisible;
    private boolean mina;
    private boolean tapada;
    private boolean bandera;
    private int numBombasVecinas;



    public Casilla(char casillaValor){

        this.casillaVisible = casillaValor;
        this.tapada = true;
        this.mina = false;
        this.bandera = false;
        this.numBombasVecinas =0;


    }

    public char getCasillaVisible() {
        return casillaVisible;
    }

    public void setCasillaVisible(char casillaVisible) {
        this.casillaVisible = casillaVisible;
    }

    public void setNumBombasVecinas(int numBombasVecinas) {
        this.numBombasVecinas = numBombasVecinas;
    }

    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }

    public int getNumBombasVecinas() {
        return numBombasVecinas;
    }

    public void incrementoNumeroBomas() {
        this.numBombasVecinas ++;
    }

    public boolean esBandera() {
        return bandera;
    }

    public void switchFlag(boolean bandera) {
        this.bandera = ! this.bandera;
    }

    public boolean esMina() {
        return mina;
    }

    public void ponerMina() {
        this.mina = true;
    }
}
