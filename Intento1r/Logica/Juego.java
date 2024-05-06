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

    private ParteBarco parteBarco;

    // como aplicar este concepto:
    // Program to an interface, not an implemetation

    // Jugador1 Vs Maquina

    public Juego(Jugador jugador1) {
        this.jugador = jugador1;
        this.tablero = jugador.getTableroJugador();
        presentacion = new Print(tablero);

    }

    public void starGame(){
        createShip();
        atacar();
    }
    // crear barcos con un ARRAY { {1,1,1,1}, {2,2,2}, {4,4} }
    // implica crear 4 barcos que tienen tamaño 1
    // crear 3 barcos de tamaño 2
    // crear 2 barcos de tamaño 2
    public void createShip() {
        int[] arrayBarcos = {2, 2, 3, 4, 3, 1, 4};

        for (int i = 0; i < arrayBarcos.length; i++) {
            int longitudBarco = arrayBarcos[i];
            // primero comprobamos que entre el barco 
            // y luego creamos el barco
            createShipIfEnter(longitudBarco);
        }
    }

    // colocar los barcos
    private void createShipIfEnter(int longitudBarco){


        int fila;
        int columna;
        int numeroAleatorio;
        boolean ramdomHorizontal;
        while (true) {

                // Para refactorizaer esto debería crear una clase de GeneradorCoordenadas y ponerle atributos?
                // hay alguna otra manera de refactorizar?
                fila = generateRandomNumber();
                columna = generateRandomNumber();
                numeroAleatorio = generateRandomNumber();
                ramdomHorizontal =  randomPosition(numeroAleatorio);

            // 1r las casillas tiene que estar vacias
            if (squareIsEmpty(fila, columna)) {
                // 2n ese barco entra en el tablero
                // todo: tengo que hacer posible que un barco de una longitud de 1 se pueda poner en los bordes
                if(shipNotFitTable(fila, columna, longitudBarco, ramdomHorizontal)){
                    continue;
                }
                // FALTA MIRAR TODA LA LONGITUD DEL BARCO
                if (isShipsAround(fila, columna, longitudBarco, ramdomHorizontal)){
                    continue;
                }
                // cremos el barco
                Barco barco = new Barco(longitudBarco, fila, columna, ramdomHorizontal);
                // decimos que ese barco pertenece al jugador
                this.jugador.addBarco(barco);

                // ponemos el barco en el tablero
                putShipTable(fila, columna, barco);
                return;
                // 3r Los diferentes partes del barco tiene que estar con 1 casilla de distancia

            }
        }

    }

    private void putShipTable(int fila, int columna, Barco barco){
        // si el barco solo tiene una parte

        ParteBarco parteBarco;
        if (shipHasOnly1Part(barco)){

            parteBarco = barco.getParteBarco(fila,columna);
            tablero.obtenerCasilla(fila,columna).colocarParteBarco(parteBarco);
            // decir en que parte esta esa parte del barco


            tablero.obtenerCasilla(fila,columna).setVacio();
            return;
        }
        // si el barco esta compuesto con más de una parte

        // posicion horizontal
        if (barco.isPosHorizontal()){
            for (int i = 0; i < barco.getLongitud(); i++) {
            parteBarco = barco.getParteBarco(fila,columna+i);
            tablero.obtenerCasilla(fila,columna +i).colocarParteBarco(parteBarco);
            tablero.obtenerCasilla(fila,columna+i).setVacio();
            }
            return;
        }

        // posicion vertical
        for (int i = 0; i < barco.getLongitud(); i++) {
            parteBarco = barco.getParteBarco(fila+i,columna);
            tablero.obtenerCasilla(fila+i,columna ).colocarParteBarco(parteBarco);
            tablero.obtenerCasilla(fila+i,columna).setVacio();
        }


    }

    public boolean shipHasOnly1Part(Barco barco){
        return (barco.getLongitud() == 1) ? true : false;
    }


    private boolean randomPosition(int numeroAleatorio){
        // termino si la posicion en Vertical u Horizontal.
        // si el resultado es TRUE será posición PosHorizontal
        return ((numeroAleatorio % 2) == 0) ? true : false;
    }
    private boolean shipNotFitTable(int fila, int columna, int longitudBarco, boolean ramdomHorizontal){

        if (shipIsHorizontal(ramdomHorizontal)){
            return (tablero.getMaxColumna() >= columna + longitudBarco) ? false : true;
        }
        return (tablero.getMaxFila() >= fila + longitudBarco) ? false : true;

    }

    private boolean shipIsHorizontal(boolean ramdomHorizontal) {
        return (ramdomHorizontal == true) ? true : false;
    }

    private boolean isShipsAround(int fila, int columna, int longitudBarco, boolean ramdomHorizontal){

        // en que casilla me encuetro (lo recibo por parametro)
        // TENGO QUE MIRAR SI EL BARCO ES HORIZONTAL O VERTICAL
        // comprobar si hay barcos alrededor (is vacio False)
            // todo: aplicar esta logica por cada parte del barco --> Lo miro con la int longitudBarco
        // todo: mirar que cuando creo el barco pongo que esa casilla ya no este vacia

        int filaModificada;
        int columnaModificada;
        if (shipIsHorizontal(ramdomHorizontal)){
                for (int recorrerColumna = columna; recorrerColumna <= columna + longitudBarco; recorrerColumna++) {
                    for (int modFila = -1; modFila <= 1 ; modFila++) {
                        for (int modColumn = -1; modColumn <=  1; modColumn++) {
                            if ( (modFila == 0) && (modColumn == 0)){
                                continue;
                            }
                            // En este caso la fila es FIJA
                            filaModificada = fila + modFila;
                            columnaModificada = recorrerColumna + modColumn;
                            if (!tablero.insideTable(filaModificada, columnaModificada)){
                                // no me interesa comprobar casillas fuera del tablero
                                continue;
                            }
                            if (!squareIsEmpty(filaModificada,columnaModificada)){
                                return true;
                            }
                        }

                    }
                }

            }

        for (int recorreFila = fila; recorreFila <= fila + longitudBarco; recorreFila++) {
            for (int modFila = -1; modFila <= 1 ; modFila++) {
                for (int modColumna = -1; modColumna <=  1; modColumna++) {
                    if ( (modFila == 0) && (modColumna == 0)){
                        continue;
                    }
                    // En este caso la Columna es FIJA
                    filaModificada = recorreFila + modFila;
                    columnaModificada = columna + modColumna;
                    if (!tablero.insideTable(filaModificada, columnaModificada)){
                        // no me interesa comprobar casillas fuera del tablero
                        continue;
                    }
                    if (!squareIsEmpty(filaModificada,columnaModificada)){
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
        return (int) (Math.random() * 10);
    }



    public void atacar(){

        int fila;
        int columna;

        // atacar mientras el jugador tenga Barcos
        while (jugador.stillAlive()){

            imprimirTablero();

            fila = presentacion.elegir("Fila") -1;
            columna = presentacion.elegir("Columna") -1;
            // atacar una casilla que ya esta abierta

            if(squareIsOpen(fila,columna)){
                // casilla abierta previamente, volver a elegir row and column
                presentacion.mensajeCasillaAbierta();
                continue;
            }
            // que este vacio la casilla, y no haya barco
                // tenemos que destapar casilla
            if(squareIsEmpty(fila,columna) && !(tablero.obtenerCasilla(fila,columna).tieneBarco())){
                tablero.obtenerCasilla(fila,columna).setTapada();
                // TODO: LUEGO TENGO QUE CAMBIAR ESTE continue por RETURN
                continue;
            }

            
            // el barco este compuesto de solo una parte y la toquemos. Tocado y hundido
            // ponerlo en un método

            Barco barco = tablero.obtenerCasilla(fila,columna).getParteBarco().getBarco();
            // todo: TENGO QUE INDICAR QUE PARTE DEL BARCO ESTOY HUNDIENDO
            barco.getParteBarco(fila,columna).hundirParteBarco();


            tablero.obtenerCasilla(fila,columna).setTapada();
            if (barco.getLongitud() == 1){

                barco.hundirBarco();
                // tenemos que revelar las casilla de las esquinas
                revelaCasillasVecinas(fila,columna, barco);
                // TODO: LUEGO TENGO QUE CAMBIAR ESTE continue por RETURN
                continue;
            }

            // ME HE QUEDADO AQUI!!!!!!!!
            // que hayamos tocado una parte del barco y NO hundamos el barco

            // TODO: ME FALTA INDICAR QUE CUANDO HEMOS TOCADO TODAS LAS PARTES DEL BARCO, ESPECIFICAR QUE ESE BARCO ESTA HUNDIDO

            if (!barco.todasPartesBarcoTocadas()){
                revelaCasillasVecinas(fila,columna, barco);
                // TODO: LUEGO TENGO QUE CAMBIAR ESTE continue por RETURN
                continue;
            }

            // que hayamos tocado todas las partes del barco y hundamos el barco
            if (jugador.stillAlive()){
                barco.hundirBarco();
                revelaCasillasVecinas(fila,columna, barco);
                if (jugador.stillAlive()){
                    presentacion.mensajeGameOver();
                }
                // TODO: LUEGO TENGO QUE CAMBIAR ESTE continue por RETURN
                continue;
            }


            // que hayamos hundido todos los barcos
            barco.hundirBarco();
            presentacion.mensajeGameOver();
        }



    }

    private void imprimirTablero() {
        presentacion.mensajeEsTuTurno();
        presentacion.printTablero(tablero);
        presentacion.printTableroConBarcos(tablero);
    }

    public void revelaCasillasVecinas(int fila, int columna, Barco barco) {
        // revelar si el barco es de una sola longitud
        if (barco.getLongitud() == 1) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if ((i == 0) && (j == 0)) {
                        continue;
                    }

                    if (tablero.insideTable(fila + i, columna + j)) {
                        tablero.obtenerCasilla(fila + i, columna + j).setTapada();
                    }

                }

            }
            return;
        }
    //  solo puede abrir las casillas en forma de CURZ "X"
        if (barco.isHundido() == false){
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (posicionNoPermitida(i, j)){
                        continue;
                    }
                    if (tablero.insideTable(fila + i, columna + j)) {
                        tablero.obtenerCasilla(fila + i, columna + j).setTapada();


                    }
                }
            }
            // TODO: COMPROBAR EL ESTADO DEL BARCO (ESTA HUNDIDO?)
            if (barco.todasPartesBarcoTocadas() == false){
                return;
            }
        }

        if (barco.isHundido()){
            int longitudBarco = barco.getLongitud();
            int filaInicial = barco.getParteBarco(fila,columna).getPosFila();
            int columnaInicial = barco.getParteBarco(fila,columna).getPosColumna();
            int modFila;
            int modColumna;
            if (barco.isPosHorizontal()){

                for (int parteMovil = filaInicial; parteMovil <= (filaInicial +longitudBarco); parteMovil++) {
                    for (int j = -1; parteMovil <= 1; parteMovil++) {
                        for (int k = -1; j <= 1; j++) {
                            if ((j == 0) && (k == 0)) {
                                continue;
                            }
                            modFila = parteMovil + j;
                            modColumna = columnaInicial + k;
                            if (tablero.insideTable(modFila, modColumna)) {
                                tablero.obtenerCasilla(modFila, modColumna).setTapada();
                            }

                        }
                    }
                }
                return;
            }

            for (int parteMovil = columnaInicial; parteMovil <= (columnaInicial +longitudBarco); parteMovil++) {
                for (int j = -1; parteMovil <= 1; parteMovil++) {
                    for (int k = -1; j <= 1; j++) {
                        if ((j == 0) && (k == 0)) {
                            continue;
                        }
                        modFila = filaInicial + j;
                        modColumna = parteMovil + k;
                        if (tablero.insideTable(modFila, modColumna)) {
                            tablero.obtenerCasilla(modFila, modColumna).setTapada();
                        }

                    }
                }
            }

        }



    }

    private static boolean posicionNoPermitida(int i, int j) {
        if ((i == 0) && (j == 0)) {
            return true;
        }
        if ((i == -1) && (j == 0)) {
            return true;
        }
        if ((i == 1) && (j == 0)) {
            return true;
        }
        if ((i == 0) && (j == -1)) {
            return true;
        }
        if ((i == 0) && (j == 1)) {
            return true;
        }
        return false;
    }


    private boolean squareIsOpen(int fila, int columna){
        if (!tablero.obtenerCasilla(fila,columna).isTapada()){
            return true;
        }
        return false;
    }

}





