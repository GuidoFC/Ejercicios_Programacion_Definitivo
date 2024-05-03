package Logica;

import Model.Barco;
import Model.Jugador;

import Model.ParteBarco;
import Model.Tablero;
import Vista.Print;

import java.util.Scanner;

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
            int longitudBarco = arrayBarcos[i];
            // primero comprobamos que entre el barco 
            // y luego creamos el barco
            putShipRightPlace(longitudBarco);
        }
    }

    // colocar los barcos
    private void putShipRightPlace(int longitudBarco){

        // 1r las casillas tiene que estar vacias
        int fila;
        int columna;
        int numeroAleatorio;
        boolean randoHorizontalOrVertical;
        while (true) {
                fila = generateRandomNumber();
                columna = generateRandomNumber();
                numeroAleatorio = generateRandomNumber();
                randoHorizontalOrVertical = randomPosition(numeroAleatorio);

            // Falta por hacer: Determinar si el barco esta en
            // posicion vertical u horizontal

            if (squareIsEmpty(fila, columna)) {
                // 2n ese barco entra en el tablero
                if(shipNotFitTable(fila, columna, longitudBarco, randoHorizontalOrVertical)){
                    continue;
                }
                // FALTA MIRAR TODA LA LONGITUD DEL BARCO
                if (isShipsAround(fila, columna, longitudBarco, randoHorizontalOrVertical)){
                    continue;
                }
                // cremos el barco
                Barco barco = new Barco(longitudBarco);
                this.jugador.addBarco(barco);
                choosePositionShip(randoHorizontalOrVertical, barco);
                // createPartShip(fila, columna, barco);
                putShipTable(fila, columna, barco);
                return;
                // 3r Los diferentes partes del barco tiene que estar con 1 casilla de distancia

            }
        }

    }

    private void putShipTable(int fila, int columna, Barco barco){
        // si el barco solo tiene una parte

        if (barco.getLongitud() == 1){
            tablero.obtenerCasilla(fila,columna).colocarParteBarco(barco.getParteBarco(0));
            return;
        }
        // si el barco esta compuesto con más de una parte

        // posicion horizontal
        if (shipIsHorizontal(randoHorizontalOrVertical)){
            for (int i = 0; i < barco.getLongitud(); i++) {
             tablero.obtenerCasilla(fila,columna +i).colocarParteBarco(barco.getParteBarco(i));
            }
            return;
        }

        // posicion vertical
        for (int i = 0; i < barco.getLongitud(); i++) {
            tablero.obtenerCasilla(fila+i,columna ).colocarParteBarco(barco.getParteBarco(i));
        }


    }


    private void choosePositionShip(boolean posHorizontal, Barco barco){
        barco.isPosHorizontal(posHorizontal);
    }
    private boolean randomPosition(int numeroAleatorio){
        // termino si la posicion en Vertical u Horizontal.
        // si el resultado es TRUE será posición PosHorizontal
        return ((numeroAleatorio % 2) == 0) ? true : false;
    }
    private boolean shipNotFitTable(int fila, int columna, int longitudBarco, boolean randoHorizontalOrVertical){

        if (shipIsHorizontal(randoHorizontalOrVertical)){
            if (tablero.getMaxColumna() > columna + longitudBarco){
                return false;
            }
            return true;
        }
        if (tablero.getMaxFila() > fila + longitudBarco){
            return false;
        }
        return true;


        // en que casilla me encuentro ? (lo obtengo por parametro)
        // cuanto mide el barco = (lo tengo en longitud)
        // cuantas casillas hay disponibles


    }

    private boolean shipIsHorizontal(boolean randoHorizontalOrVertical) {
        return (randoHorizontalOrVertical == true) ? true : false;
    }

    private boolean isShipsAround(int fila, int columna, int longitudBarco,  boolean randoHorizontalOrVertical){
        // en que casilla me encuetro (lo recibo por parametro)
        // TENGO QUE MIRAR SI EL BARCO ES HORIZONTAL O VERTICAL
        // comprobar si hay barcos alrededor (is vacio False)
            // aplicar esta logica por cada parte del barco
        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 1; j++) {
                if ((i == 0) && (j == 0)){
                    continue;
                }
                if(!squareIsEmpty(fila-i,columna-j) ){
                    return true;
                }
            }
        }
        return false;
    }

    // este método de createPartShip no me hace falta porque ya lo tengo
    // construido en el momento que construi el Barco
//    private void createPartShip(int fila, int columna, Barco barco){
//
//        barco.construirBarco();
//
//        //OTRA MANERA, CUAL ES MAS CORRECTA????
//        // si el barco solo tiene una parte
//        if (barco.getLongitud() == 1){
//            ParteBarco parteBarco = new ParteBarco(barco,fila,columna);
//            return;
//        }
//
//        // crear el barco horizontalmente
//        if (shipIsHorizontal(barco)){
//            for (int i = 0; i < barco.getLongitud(); i++) {
//                ParteBarco parteBarco = new ParteBarco(barco,fila,columna + i);
//            }
//            return;
//        }
//        // crear el barco verticalmente
//        for (int i = 0; i < barco.getLongitud(); i++) {
//            ParteBarco parteBarco = new ParteBarco(barco,fila+i,columna);
//        }
//    }




    private boolean squareIsEmpty(int fila, int columna){
        return tablero.obtenerCasilla(fila,columna).isVacio();
    }

    private int generateRandomNumber(){
        return (int) (Math.random() * 11);
    }



    private void atacar(){

        int fila;
        int columna;

        // atacar mientras el jugador tenga Barcos
        while (jugador.stillAlive()){
            fila = presentacion.elegir("Fila");
            columna = presentacion.elegir("Columna");
            // atacar una casilla que ya esta abierta

            if(squareIsOpen(fila,columna)){
                // casilla abierta previamente, volver a elegir row and column
                presentacion.posicionAbierta();
                continue;
            }
            // que este vacio la casilla, y lo tengamos que revelar
            if(squareIsEmpty(fila,columna)){
                tablero.obtenerCasilla(fila,columna).setTapada();
                return;
            }
            // ME HE QUEDADO AQUI!!!!!!!!
            
            // que haya una parte del barco y la toquemos
            // ponerlo en un método
            ParteBarco parteBarco = tablero.obtenerCasilla(fila,columna).getParteBarco();
            parteBarco.HundirParteBarco();

            // que hayamos tocado todas las partes del barco y hundamos el barco
            // COMO CONECTO ESTA PARTEBARCO CON EL BARCO?

            // Si el barco no esta hundido y solo hemos tocado una parte
            // tenemos que revelar las casilla de las esquinas
            revelarEsquinaCasillaAtacada(fila,columna);
        }



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





