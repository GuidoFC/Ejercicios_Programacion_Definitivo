package Model;

public class Barco {
    private boolean posicionVertical;
    private boolean posicionHorizontal;
    private boolean [] tamanoBarco;
    private boolean hundido;

    public Barco(int longitudBarco, int numAleatorio){
        vertical_Horizontal(numAleatorio);
        this.tamanoBarco = new boolean [longitudBarco];
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
            this.tamanoBarco [i] = false;
        }
    }

}
