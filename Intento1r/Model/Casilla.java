package Model;

public class Casilla implements Atacado {
    private boolean  vacio; // no es necessari de fet es un duplicitat
    private boolean tapada;


    private boolean atacado = false ;

    // como puedo colocar una parte del Barco y que yo sepa que las otras
    // parte del barco se coloquen cerca de esta casilla????

    private ParteBarco parteBarco; ;


    public Casilla() {
        this.vacio = true;
        this.tapada = true;
        parteBarco = null;
    }

    public void atacar(){
        this.atacado = true ;
        // si apunta a una part de vaixell
        // atacar aquesta part de vaixell
        // if ( parteBarco != null )
        //     parteBarco.

    }
    public void colocarParteBarco(ParteBarco parteBarco) {
        this.parteBarco = parteBarco;
    }
    public boolean tieneBarco() {
        return parteBarco != null;
    }

    public boolean isVacio(){
        // todo: el profesor me ha modificado el codigo aqui
        // todo: tengo que quitar  return this.vacio; por --> return ( parteBarco == null ) ;
        return this.vacio;
        // return ( parteBarco == null ) ;
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

    @Override
    public void serAtacado() {

    }

    public boolean isAtacado(){
        return this.atacado;
    }

    public boolean isParteBarco(){
        return (this.parteBarco != null) ? true : false;
    }

    public void setParteBarco(ParteBarco parteBarco) {
        this.parteBarco = parteBarco;
    }

    public ParteBarco getParteBarco() {
        return parteBarco;
    }

}

