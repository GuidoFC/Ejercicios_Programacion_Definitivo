package Model;

public class Barco {
    private boolean posicionVertical;
    private boolean posicionHorizontal;
    private int longitudBarco;
    private boolean [] parteDelBarco;
    private boolean hundido;

    public Barco(int longitudBarco, int numAleatorio){
        vertical_Horizontal(numAleatorio);
        this.longitudBarco = longitudBarco;
        this.parteDelBarco = new boolean [longitudBarco];
        putAllBooleanArray_False(longitudBarco);
        this.hundido = false;
    }

    private void vertical_Horizontal(int numAleatorio){
        if (numAleatorio >= 0.5){
            this.posicionHorizontal = false;
            this.posicionVertical = true;
        }else {
            this.posicionHorizontal = true;
            this.posicionVertical = false;
        }
    }

    private void putAllBooleanArray_False(int longitudBarco){
        for (int i = 0; i < longitudBarco; i++) {
            this.parteDelBarco[i] = false;
        }
    }

    public boolean isPosicionVertical(){
        return this.posicionVertical;
    }

    public boolean isPosicionHorizontal(){
        return this.posicionHorizontal;
    }

    public boolean isHundido(){
        for (int i = 0; i < this.longitudBarco; i++) {
            if (this.parteDelBarco[i] == false){
                return false;
            }
        }
        return true;
    }

}
