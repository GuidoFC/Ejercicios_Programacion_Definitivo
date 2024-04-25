package Logica;

import Model.Jugador;

import Model.Tablero;
import Vista.Print;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> listaJugadores;
    private Jugador jugador;
    private Print presentacion;


    // se puede aplicar algun patron como Factory, Singleton o DAO?
    // como aplicar este concepto:
        // Program to an interface, not an implemetation

    // Jugador1 Vs Maquina

    public Juego(Jugador jugador1){
        this.jugador = jugador1;
    }

    // jugar Jugador1 Vs Jugador2
    public Juego(Jugador jugador1, Jugador jugador2){
        listaJugadores = new ArrayList<>();
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        Tablero tablero1 = jugador1.getTableroJugador();
        Tablero tablero2 = jugador2.getTableroJugador();

        presentacion = new Print(tablero1, tablero2);
    }


    // insertarBarcos en el Juego

}
