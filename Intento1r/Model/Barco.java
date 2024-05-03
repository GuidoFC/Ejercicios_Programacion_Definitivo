package Model;

public class Barco {
    private int longitud;
    private boolean posHorizontal;

    private ParteBarco [] parteBarco;
    private boolean hundido;



    public Barco(int longitudBarco){
        this.posHorizontal = false;
        this.longitud = longitudBarco;
        parteBarco = new ParteBarco[longitud];
        // creamos un método para añadir las partes del barco
        construirBarco();
        hundido = false;
    }

    public void construirBarco(){
        for (int i = 0; i < this.longitud; i++) {
            parteBarco[i] = new ParteBarco(this);
        }
    }
    public void hundirBarco(){
        this.hundido = true;
    };

    public boolean isHundido(){
        return this.hundido;
    }

    // BOOLEAN comprobar si todas las partes estan tocadas (metodo)

    public boolean todasPartesBarcoTocadas(){
        for (int i = 0; i < this.longitud; i++) {
            if (this.parteBarco[i].isTocado() == false){
                return false;
            }
        }
        return true;
    }

    public int getLongitud() {
        return longitud;
    }

    public ParteBarco getParteBarco(int numero) {
        return parteBarco[numero];
    }

    public boolean isPosHorizontal() {
        return posHorizontal;
    }

    public void setPosHorizontal(boolean posHorizontal) {
        this.posHorizontal = posHorizontal;
    }
}
