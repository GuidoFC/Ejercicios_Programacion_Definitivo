package segundoIntento;

public class Casilla {
    private boolean mina;
    private boolean tapada;
    private boolean bandera;
    private int numBombasVecinas;


    public Casilla(){
        this.tapada = true;
        this.mina = false;
        this.bandera = false;
        this.numBombasVecinas =0;
    }

    public void setNumBombasVecinas(int numBombasVecinas) {
        this.numBombasVecinas = numBombasVecinas;
    }

    public void casillaTapada() {
        this.tapada = false;
    }

    public boolean estaTapada() {
        return tapada;
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
