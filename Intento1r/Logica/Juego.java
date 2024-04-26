package Logica;

import Model.Barco;
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
         this.tablero = jugador.getTableroJugador();
         presentacion = new Print(tablero);
    }

    // crear barcos
    private void createShip(){
        final int MAX_LONGITUD_BARCO = 4;
        int auxiliar = 0;
        int numBarcoCreado = MAX_LONGITUD_BARCO - auxiliar;

        int tamanoBarco = MAX_LONGITUD_BARCO - (MAX_LONGITUD_BARCO -1);
        int contadorBarcos = 0;

        for (int i = MAX_LONGITUD_BARCO; i > 0 ; i--) {
            while (numBarcoCreado > contadorBarcos ){
                Barco barcoTamano = new Barco(tamanoBarco);
                this.jugador.addBarco(barcoTamano);
                contadorBarcos++;
            }
            contadorBarcos = 0;
            tamanoBarco++;
            auxiliar--;

        }






        int resta = 3;
        int barcosCreados = 1;
        for (int i = MAX_LONGITUD_BARCO; i > 0; i--) {

            resta --;
            barcosCreados = 1;
        }
    }

    // crear el tablero para jugador

    private void crearTablero


}
