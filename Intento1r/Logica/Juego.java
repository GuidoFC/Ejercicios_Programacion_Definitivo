package Logica;

import Model.Jugador;

import Model.Tablero;
import Vista.Print;

import java.util.ArrayList;

public class Juego {

    private Jugador jugador;
    private Print presentacion;
    private Tablero tablero;


    // se puede aplicar algun patron como Factory, Singleton o DAO?
    // como aplicar este concepto:
        // Program to an interface, not an implemetation

    // Jugador1 Vs Maquina

    public Juego(Jugador jugador1){
        this.jugador = jugador1;
         tablero = jugador.getTableroJugador();
         presentacion = new Print(tablero);
    }


    // insertarBarcos en el Juego

}
