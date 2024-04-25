package Model;
import java.util.Arrays;
public class Barco {
    private ParteBarco [] parteBarco;
    private boolean hundido;

    public Barco(int longitudBarco){
        parteBarco = new ParteBarco[longitudBarco];
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


}
