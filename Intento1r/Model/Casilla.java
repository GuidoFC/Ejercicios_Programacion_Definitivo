package Model;

public class Casilla {
    private Barco barcos;
    private boolean vacio;
    private boolean tapada;
    private  int posicionX = 0;
    private  int posicionY = 0;


    public Casilla(int posX, int posY, Barco barcos){
        this.barcos = barcos.isParteBarcoTocado();
        this.vacio = true;
        this.tapada = true;
        setPosicionX(posX);
        setPosicionY(posY);

    }

    public  int getPosicionX() {
        return posicionX;
    }

    private  void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    private void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
}
