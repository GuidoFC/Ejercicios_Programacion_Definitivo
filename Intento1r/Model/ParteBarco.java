package Model;

public class ParteBarco implements Atacado{
    private boolean tocado;
    private Barco barco;
    private int posFila, posColumna;



    public ParteBarco(Barco barco, int fila, int columna){
        this.tocado = false;
        this.barco = barco;
        this.darCoordenadas(fila, columna);

    }


    public boolean isTocado(){
        return this.tocado;
    }

    public void hundirParteBarco(){
        this.tocado = true;
    }

    @Override
    public void serAtacado() {

    }

    public boolean shipIsAlive(int fila, int columna){
        int longitud = this.getBarco().getLongitud();
        if (longitud == 1){
            if(this.barco.getParteBarco(fila, columna).isTocado()){
                return false;
            }
            return true;
        }
        int contadorPartesTocadas = 0 ;

        for (int i = 0; i < longitud; i++) {
            if(this.barco.getParteBarco(fila, columna).isTocado()){
                contadorPartesTocadas++;
            }
            if (contadorPartesTocadas == longitud)
                return false;
        }
            return true;

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

    private void darCoordenadas(int fila, int columna){
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
