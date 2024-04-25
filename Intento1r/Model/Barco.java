package Model;
import java.util.Arrays;
public class Barco {
    private int longitudBarco;
    private ParteBarco [] parteBarco;
    private boolean hundido;

    public Barco(int longitudBarco){
        this.longitudBarco = longitudBarco;
        // añadir que el barco sepa si esta hunido o no
        parteBarco = new boolean[longitudBarco];
        Arrays.fill(parteBarco, false);
        hundido = false;
    }

    public void HundirParteBarco(int posicion){
        parteBarco[posicion] = true;
    }

    public boolean isParteBarcoTocado(int posicion){
        return parteBarco[posicion];
    }

    public void HundirBarco(){
        this.hundido = true;
    };

    public boolean isHundido(){
        return this.hundido;
    }


}
