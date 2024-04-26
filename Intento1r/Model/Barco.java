package Model;
import java.util.Arrays;
public class Barco {
    private int longitud;
    private ParteBarco [] parteBarco;
    private boolean hundido;

    public Barco(int longitudBarco){
        this.longitud = longitudBarco;
        parteBarco = new ParteBarco[longitud];
        // creamos un método para añadir las partes del barco
        construirBarco(longitudBarco);
        hundido = false;
    }

    public void construirBarco(int longitud){
        for (int i = 0; i < longitud; i++) {
            parteBarco[i] = new ParteBarco();
        }
    }
    public void HundirBarco(){
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




}
