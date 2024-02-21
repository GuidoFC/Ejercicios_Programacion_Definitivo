public class Ficha {
    private String color;
    private TipoFicha tipoFicha;

    public Ficha(String color, TipoFicha tipoFicha){
        color = this.color;
        tipoFicha = this.tipoFicha;

    }

    public String pintarFicha(TipoFicha tipoFicha){
        return System.out.println(tipoFicha);
    }

}
