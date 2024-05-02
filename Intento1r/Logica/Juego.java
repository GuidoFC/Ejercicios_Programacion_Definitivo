package Logica;

import Model.Barco;
import Model.Jugador;

import Model.Tablero;
import Vista.Print;

public class Juego {

    private Jugador jugador;
    private Print presentacion;
    private Tablero tablero;


    // se puede aplicar algun patron como Factory, Singleton o DAO?
    // como aplicar este concepto:
    // Program to an interface, not an implemetation

    // Jugador1 Vs Maquina

    public Juego(Jugador jugador1) {
        this.jugador = jugador1;
        this.tablero = jugador.getTableroJugador();
        presentacion = new Print(tablero);
    }

    // crear barcos con un ARRAY { {1,1,1,1}, {2,2,2}, {4,4} }
    // implica crear 4 barcos que tienen tamaño 1
    // crear 3 barcos de tamaño 2
    // crear 2 barcos de tamaño 2
    private void createShip() {
        int[] arrayBarcos = {1, 1, 1, 1, 2, 2, 2, 4, 4};

        for (int i = 0; i < arrayBarcos.length; i++) {
            Barco barco = new Barco(i);
            this.jugador.addBarco(barco);
            putShipRightPlace(barco);
        }
    }

    // colocar los barcos
    private void putShipRightPlace(Barco barco){
        // 1r las casillas tiene que estar vacias
        int fila;
        int columna;
        while (true) {
            int fila = generateRandomNumber();
            int columna = generateRandomNumber();

            if (checkSquareIsEmpty(fila, columna)) {
                // 2n ese barco entra en el tablero
                if(shipNotFitTable(fila, columna, barco)){
                    continue;
                }
                if (checkIsShipsAround(fila, columna, barco)){
                    continue;
                }

                // 3r Los diferentes partes del barco tiene que estar con 1 casilla de distancia

            }
        }

    }

    private boolean shipNotFitTable(int fila, int columna, Barco barco){
        int longitud = barco.getLongitud();

        // en que casilla me encuentro ? (lo obtengo por parametro)
        // cuanto mide el barco = (lo tengo en longitud)
        // cuantas casillas hay disponibles

        if (tablero.getMaxFila() > columna + longitud){
            return false;
        }
        return true;
    }
    private boolean checkIsShipsAround(int fila, int columna, Barco barco){
        // en que casilla me encuetro (lo recibo por parametro)
        // comprobar si hay barcos al rededor (is vacio False)
            // aplicar esta logica por cada parte del barco
        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 1; j++) {
                if ((i == 0) && (j == 0)){
                    continue;
                }
                if(checkSquareIsEmpty (fila-i,columna-j) ){
                     continue;
                }else {
                    return true;
                }
            }

        }
        return false;
    }


    private boolean checkSquareIsEmpty(int fila, int columna){
        return tablero.obtenerCasilla(fila,columna).isVacio();
    }

    private int generateRandomNumber(){
        return (int) (Math.random() * 11);
    }
}





