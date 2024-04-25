package Model;
import java.util.Arrays;
public class Barco {
    private ParteBarco [] parteBarco;
    private boolean hundido;

    public Barco(int longitudBarco){
        parteBarco = new ParteBarco[longitudBarco];
        hundido = false;
    }

    public void HundirBarco(){
        this.hundido = true;
    };

    public boolean isHundido(){
        return this.hundido;
    }


}
