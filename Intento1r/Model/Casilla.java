package Model;

public class Casilla {
    private boolean vacio;
    private boolean tapada;
    private  int posicionX = 0;
    private  int posicionY = 0;

    // como puedo colocar una parte del Barco y que yo sepa que las otras
    // parte del barco se coloquen cerca de esta casilla????

    private ParteBarco parteBarco;

    public Casilla(int posX, int posY){
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
