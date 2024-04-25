package Model;

public class Jugador {
    private String nombre;
    private String apellido;

    private Tablero tablero;

    // añadir que el jugador tenga una matriz de barcos
    // y asi pueda saber cuantos barcos tiene
    // cuando no tenga barcos, el juego se acabo

    public Jugador(String nombre, String apellido, Tablero tablero){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre(){
        return this.nombre;
    }
    public  String getApellido(){
        return this.apellido;
    }
}
