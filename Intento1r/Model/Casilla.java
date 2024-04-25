package Model;

public class Casilla {
    private boolean vacio;
    private boolean tapada;

    // como puedo colocar una parte del Barco y que yo sepa que las otras
    // parte del barco se coloquen cerca de esta casilla????

    private ParteBarco parteBarco;


    public Casilla() {
        this.vacio = true;
        this.tapada = true;
        parteBarco = null;
    }

    public void colocarParteBarco(ParteBarco parteBarco) {
        this.parteBarco = parteBarco;
    }
    public boolean tieneBarco() {
        return parteBarco != null;
    }

    public boolean isVacio(){
        return this.vacio;
    }

    public void setVacio(){
        this.vacio = false;
    }

    public boolean isTapada() {
        return tapada;
    }

    public void setTapada(){
        this.tapada = false;
    }
}

