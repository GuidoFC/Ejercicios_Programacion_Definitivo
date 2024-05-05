package Model;

import java.util.ArrayList;

public class Barco {
    private int longitud;
    private boolean posHorizontal;

    private final ArrayList<ParteBarco> parteBarco = new ArrayList<>();

    //private ParteBarco [] parteBarco;
    private boolean hundido;



    public Barco(int longitudBarco){
        this.posHorizontal = false;
        this.longitud = longitudBarco;
        construirBarco(longitudBarco);
        // creamos un método para añadir las partes del barco
        hundido = false;

    }

    public void construirBarco(int longitudBarco){
        for (int i = 0; i < longitudBarco; i++) {
            this.parteBarco.add(new ParteBarco(this));
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
            if (!this.parteBarco.get(i).isTocado()){
                return false;
            }
        }
        return true;
    }

    public int getLongitud() {
        return longitud;
    }

    public ParteBarco getParteBarco(int numero) {
        return parteBarco.get(numero);
    }

    public boolean isPosHorizontal() {
        return posHorizontal;
    }

    public void setPosHorizontal(boolean posHorizontal) {
        this.posHorizontal = posHorizontal;
    }
}
