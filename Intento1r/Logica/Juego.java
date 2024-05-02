package Logica;

import Model.Barco;
import Model.Jugador;

import Model.ParteBarco;
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
             fila = generateRandomNumber();
             columna = generateRandomNumber();
             // Falta por hacer: Determinar si el barco esta en
            // posicion vertical u horizontal

            if (squareIsEmpty(fila, columna)) {
                // 2n ese barco entra en el tablero
                if(shipNotFitTable(fila, columna, barco)){
                    continue;
                }
                if (isShipsAround(fila, columna, barco)){
                    continue;
                }
                putShipTable(fila, columna, barco);
                return;
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
    private boolean isShipsAround(int fila, int columna, Barco barco){
        // en que casilla me encuetro (lo recibo por parametro)
        // comprobar si hay barcos al rededor (is vacio False)
            // aplicar esta logica por cada parte del barco
        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 1; j++) {
                if ((i == 0) && (j == 0)){
                    continue;
                }
                if(squareIsEmpty(fila-i,columna-j) ){
                     continue;
                }else {
                    return true;
                }
            }

        }
        return false;
    }

    private void putShipTable(int fila, int columna, Barco barco){
        int longitud = barco.getLongitud();
        int posicionBarco = 0;
        for (int i = fila; i < fila + longitud; i++) {
            ParteBarco parteBarco = barco.getParteBarco(posicionBarco);
            tablero.obtenerCasilla(i,columna).colocarParteBarco(parteBarco);
            tablero.obtenerCasilla(i,columna).setVacio();

            posicionBarco ++;
        }
    }

    private boolean squareIsEmpty(int fila, int columna){
        return tablero.obtenerCasilla(fila,columna).isVacio();
    }

    private int generateRandomNumber(){
        return (int) (Math.random() * 11);
    }

    private void atacar(int fila, int columna){
        // atacar una casilla que ya esta abierta
        if(squareIsOpen(fila,columna)){
            // volver a llamar al método atacar indicando que esa casilla
            // ya esta abierta

            // tengo que introducir otra fila y columna
            atacar(fila,columna);
        }
        // que este vacio la casilla, y lo tengamos que revelar
        if(squareIsEmpty(fila,columna)){
            tablero.obtenerCasilla(fila,columna).setTapada();
            return;
        }
        // que haya una parte del barco y la toquemos
        ParteBarco parteBarco = tablero.obtenerCasilla(fila,columna).getParteBarco();
        parteBarco.HundirParteBarco();

        // que hayamos tocado todas las partes del barco y hundamos el barco
        // COMO CONECTO ESTA PARTEBARCO CON EL BARCO?

        // Si el barco no esta hundido y solo hemos tocado una parte
        // tenemos que revelar las casilla de las esquinas
        revelarEsquinaCasillaAtacada(fila,columna);


    }

    public void revelarEsquinaCasillaAtacada(int fila, int columna){
        // las esquinas estan dentro del tablero
        for (int modFila = -1; modFila < 1; modFila++) {
            for (int modColumn = -1; modColumn < 1; modColumn++) {

                if ( (modFila == 0) && (modColumn == 0) ){
                    continue;
                }
                // estamos fuera del tablero
                if (outsideTable(fila, modFila, columna, modColumn){
                    continue;
                }

                tablero.obtenerCasilla(fila+modFila,columna+1).setTapada();
            }

        }

    }

    public boolean outsideTable(int fila, int modFila, int columna, int modColumna){
        if ( outsideRow(fila,modFila) ||
                (columna + modColumn < 0) ||
                (tablero.getMaxColumna() > columna + modColumn ) ) ){
                    return true;
        }
        return false;
    }

    public boolean outsideRow(int fila, int modFila){
        if ((fila + modFila < 0) ||
                (tablero.getMaxFila() < fila + modFila) ){
            return true;
        }
        return false;
    } //

    public boolean outsideColumn(int fila, int modFila){
        if ((fila + modFila < 0) ||
                (tablero.getMaxFila() < fila + modFila) ){
            return true;
        }
        return false;
    }



    private boolean squareIsOpen(int fila, int columna){
        if (tablero.obtenerCasilla(fila,columna).isTapada()){
            return true;
        }
        return false;
    }

}





