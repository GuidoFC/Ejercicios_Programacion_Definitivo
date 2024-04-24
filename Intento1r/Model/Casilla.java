package Model;

public class Casilla {
    private Barco barcos;
    private boolean hayBarco;
    private boolean vacio;
    private boolean tapada;
    private  int posicionX = 0;
    private  int posicionY = 0;


    public Casilla(){
        hayBarco = false;
        vacio = true;
        tapada = true;
        posicionX = 0;
        posicionY = 0;

    }

    public  int getPosicionX() {
        return posicionX;
    }

    public  void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
}
