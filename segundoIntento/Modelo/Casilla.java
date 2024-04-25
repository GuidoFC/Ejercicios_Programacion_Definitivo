package Modelo;

public class Casilla  {
    private boolean mina;
    private boolean tapada;
    private boolean bandera;
    private int numBombasVecinas;

    // constructor
    public Casilla(){
        this.tapada = true;
        this.mina = false;
        this.bandera = false;
        this.numBombasVecinas =0;
    }

    public int getNumBombasVecinas() {
        return numBombasVecinas;
    }

    public void incrementoNumeroBomas() {
        this.numBombasVecinas ++;
    }

    public void abrirCasilla() {
        this.tapada = false;
    }

    public boolean esTapada() {
        return tapada;
    }

    public boolean esBandera() {
        return bandera;
    }


    public void switchFlag() {
        this.bandera = ! this.bandera;
    }


    public boolean esMina() {
        return mina;
    }


    public void ponerMina() {
        this.mina = true;
    }


}
