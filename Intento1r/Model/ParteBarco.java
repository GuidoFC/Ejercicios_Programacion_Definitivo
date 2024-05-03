package Model;

public class ParteBarco implements Atacado{
    private boolean tocado;
    private Barco barco;
    private int posFila, posColumna;

    public ParteBarco(Barco barco){
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

    public void darCoordenadas(int fila, int columna){
        this.setPosFila(fila);
        this.setPosColumna(columna);
    }

    private void setPosFila(int posFila) {
        this.posFila = posFila;
    }

    public int getPosColumna() {
        return posColumna;
    }

    private void setPosColumna(int posColumna) {
        this.posColumna = posColumna;
    }
}
