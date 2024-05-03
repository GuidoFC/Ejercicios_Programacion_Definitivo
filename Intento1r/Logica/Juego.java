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
            int longitudBarco = arrayBarcos[i];
            // primero comprobamos que entre el barco 
            // y luego creamos el barco
            createShipIfEnter(longitudBarco);
        }
    }

    // colocar los barcos
    private void createShipIfEnter(int longitudBarco){

        // 1r las casillas tiene que estar vacias
        int fila;
        int columna;
        int numeroAleatorio;
        boolean ramdomHorizontal;
        while (true) {
                fila = generateRandomNumber();
                columna = generateRandomNumber();
                numeroAleatorio = generateRandomNumber();
                ramdomHorizontal = randomPosition(numeroAleatorio);

            if (squareIsEmpty(fila, columna)) {
                // 2n ese barco entra en el tablero
                if(shipNotFitTable(fila, columna, longitudBarco, ramdomHorizontal)){
                    continue;
                }
                // FALTA MIRAR TODA LA LONGITUD DEL BARCO
                if (isShipsAround(fila, columna, longitudBarco, ramdomHorizontal)){
                    continue;
                }
                // cremos el barco
                Barco barco = new Barco(longitudBarco);
                this.jugador.addBarco(barco);
                putPositionShip(ramdomHorizontal, barco);
                // createPartShip(fila, columna, barco);
                putShipTable(fila, columna, barco);
                return;
                // 3r Los diferentes partes del barco tiene que estar con 1 casilla de distancia

            }
        }

    }

    private void putShipTable(int fila, int columna, Barco barco){
        // si el barco solo tiene una parte

        if (shipHasOnly1Part(barco)){
            tablero.obtenerCasilla(fila,columna).colocarParteBarco(barco.getParteBarco(0));
            // decir en que parte esta esa parte del barco
            ParteBarco parteBarco = barco.getParteBarco(0);
            darLocalizacionParteDelBarco(fila, columna, parteBarco);
            return;
        }
        // si el barco esta compuesto con más de una parte

        // posicion horizontal
        if (barco.isPosHorizontal()){
            for (int i = 0; i < barco.getLongitud(); i++) {
             tablero.obtenerCasilla(fila,columna +i).colocarParteBarco(barco.getParteBarco(i));
             ParteBarco parteBarco = barco.getParteBarco(i);
             darLocalizacionParteDelBarco(fila,columna+i,parteBarco);
            }
            return;
        }

        // posicion vertical
        for (int i = 0; i < barco.getLongitud(); i++) {
            tablero.obtenerCasilla(fila+i,columna ).colocarParteBarco(barco.getParteBarco(i));
        }


    }

    public boolean shipHasOnly1Part(Barco barco){
        return (barco.getLongitud() == 1) ? true : false;
    }

    public void darLocalizacionParteDelBarco(int fila, int columna, ParteBarco parteBarco){
        parteBarco.darCoordenadas(fila,columna);
    }


    private void putPositionShip(boolean posHorizontal, Barco barco){
        barco.isPosHorizontal(posHorizontal);
    }
    private boolean randomPosition(int numeroAleatorio){
        // termino si la posicion en Vertical u Horizontal.
        // si el resultado es TRUE será posición PosHorizontal
        return ((numeroAleatorio % 2) == 0) ? true : false;
    }
    private boolean shipNotFitTable(int fila, int columna, int longitudBarco, boolean ramdomHorizontal){

        if (shipIsHorizontal(ramdomHorizontal)){
            return (tablero.getMaxColumna() > columna + longitudBarco) ? false : true;
        }
        return (tablero.getMaxFila() > fila + longitudBarco) ? false : true;

    }

    private boolean shipIsHorizontal(boolean ramdomHorizontal) {
        return (ramdomHorizontal == true) ? true : false;
    }

    private boolean isShipsAround(int fila, int columna, int longitudBarco, boolean ramdomHorizontal){
        // ME HE QUEDADO AQUI MIRAR LA LOGICA


        // en que casilla me encuetro (lo recibo por parametro)
        // TENGO QUE MIRAR SI EL BARCO ES HORIZONTAL O VERTICAL
        // comprobar si hay barcos alrededor (is vacio False)
            // aplicar esta logica por cada parte del barco
        int filaModificada;
        int columnaModificada;
        if (shipIsHorizontal(ramdomHorizontal)){
                for (int j = columna; j < columna + longitudBarco; j++) {
                    for (int k = -1; k <= 1 ; k++) {
                        for (int l = -1; l <=  1; l++) {
                            if ( (k == 0) && (l == 0)){
                                continue;
                            }
                            filaModificada = fila + k;
                            columnaModificada = j +l;
                            if (!tablero.insideTable(filaModificada, columnaModificada)){
                                // no me interesa comprobar casillas fuera del tablero
                                continue;
                            }
                            if (squareIsEmpty(filaModificada,columnaModificada)){
                                continue;
                            }else {
                                return true;
                            }
                        }

                    }
                }

            }

        for (int j = fila; j < fila + longitudBarco; j++) {
            for (int k = -1; k <= 1 ; k++) {
                for (int l = -1; l <=  1; l++) {
                    if ( (k == 0) && (l == 0)){
                        continue;
                    }
                    filaModificada = fila + k;
                    columnaModificada = j +l;
                    if (!tablero.insideTable(filaModificada, columnaModificada)){
                        // no me interesa comprobar casillas fuera del tablero
                        continue;
                    }
                    if (squareIsEmpty(filaModificada,columnaModificada)){
                        continue;
                    }else {
                        return true;
                    }
                }

            }
        }

        return false;
        }









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





