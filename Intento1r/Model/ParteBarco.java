package Model;

public class ParteBarco implements Atacado{
    private boolean tocado;
    public ParteBarco(){
        this.tocado = false;
    }

    public boolean isTocado(){
        return this.tocado;
    }

    public void HundirParteBarco(){
        this.tocado = true;
    }

    @Override
    public void serAtacado() {

    }
}
