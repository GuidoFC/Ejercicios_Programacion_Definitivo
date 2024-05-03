package Model;

public class ParteBarco implements Atacado{
    private boolean tocado;
    private Barco barco;
    private int posFila, posColumna;
    public ParteBarco(Barco barco, int posFila, int posColumna){
        this.tocado = false;
        this.posFila = posFila;
        this.posColumna = posColumna;

    }

    public ParteBarco(){
        this.tocado = false;
    }


    public boolean isTocado(){
        return this.tocado;
    }

    public void HundirParteBarco(){
        this.tocado = true;
    }

    @Override
    public void serAtacado() {

    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public int getPosFila() {
        return posFila;
    }

    public void setPosFila(int posFila) {
        this.posFila = posFila;
    }

    public int getPosColumna() {
        return posColumna;
    }

    public void setPosColumna(int posColumna) {
        this.posColumna = posColumna;
    }
}
