package Model;

import java.util.ArrayList;

public class Barco {
    private int longitud;
    private boolean posHorizontal;

    private final ArrayList<ParteBarco> listaParteBarco = new ArrayList<>();

    //private ParteBarco [] parteBarco;
    private boolean hundido;



    public Barco(int longitudBarco, int fila, int columna, boolean ramdomHorizontal){
        this.longitud = longitudBarco;
        this.posHorizontal = ramdomHorizontal;
        construirBarco(longitudBarco, fila, columna);
        // creamos un método para añadir las partes del barco
        hundido = false;

    }

    public void construirBarco(int longitudBarco, int fila, int columna){
        for (int i = 0; i < longitudBarco; i++) {
            if (isPosHorizontal()){
                this.listaParteBarco.add(new ParteBarco(this, fila, columna+i));
            }else {
                this.listaParteBarco.add(new ParteBarco(this, fila+i, columna));
            }

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
            if (this.listaParteBarco.get(i).isTocado() == false){
                return false;
            }
        }
        this.hundirBarco();
        return true;
    }

    public int getLongitud() {
        return longitud;
    }

    public ParteBarco getParteBarco(int fila, int columna) {
        int longitudBarco =this.getLongitud();
        for (int i = 0; i < longitudBarco ; i++) {
            if ( (listaParteBarco.get(i).getPosFila() == fila) && (listaParteBarco.get(i).getPosColumna() == columna) ){
                return listaParteBarco.get(i);
            }
        }
        // TODO: si se que va a encontrar el barco que puedo poner aqui? Porque no tengo ningun barco de longitud 110
        return listaParteBarco.get(0);
    }

    public boolean isPosHorizontal() {
        return posHorizontal;
    }

    public void setPosHorizontal(boolean posHorizontal) {
        this.posHorizontal = posHorizontal;
    }

    public int filaPrimeraParteBarco(){
        return listaParteBarco.get(0).getPosFila();
    }

    public int columnaPrimeraParteBarco(){
        return listaParteBarco.get(0).getPosColumna();
    }
}
