package Model;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private String apellido;

    // es el jugador que tiene Tablero
    private Tablero tablero;

    // añadir que el jugador tenga un ArrayList de barcos
    // y asi pueda saber cuantos barcos tiene
    // cuando no tenga barcos, el juego se acabo

    private ArrayList<Barco> listaBarcos;

    public Jugador(String nombre, String apellido, int fila, int columna){
        this.nombre = nombre;
        this.apellido = apellido;
        this.tablero = new Tablero(fila,columna);
        listaBarcos = new ArrayList<>();
    }

    public Tablero getTableroJugador(){
        return this.tablero;
    }
    public void addBarco(Barco barco){
        this.listaBarcos.add(barco);
    }
    public String getNombre(){
        return this.nombre;
    }
    public  String getApellido(){
        return this.apellido;
    }
}
