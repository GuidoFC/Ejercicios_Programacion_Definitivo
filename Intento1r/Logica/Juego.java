package Logica;

import Model.Barco;
import Model.Jugador;

import Model.ParteBarco;
import Model.Tablero;
import Vista.Print;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> listaJugadores;
    private ArrayList<Tablero> listaTablero;
    // todo: Creo que sobra el Arraylist <Print>
    private ArrayList<Print> listaPresentacion;
    private int turno;
    private int turnoMax;


    // como aplicar este concepto:
    // Program to an interface, not an implemetation

    // Jugador1 Vs Maquina

    public Juego(Jugador jugador1, Jugador jugador2) {
        arrayListAddJugadores(jugador1, jugador2);
        definirTurnoMax();
        addTableroForEachPlayer();
    }

    private void arrayListAddJugadores(Jugador jugador1, Jugador jugador2) {
        listaJugadores = new ArrayList<>();
        this.listaJugadores.add(jugador1);
        this.listaJugadores.add(jugador2);
    }


    public void starGame(){
        for (int i = 0; i < turnoMax; i++) {
            turno = i;
            createShipForEachPlayer(turno);
        }

        turno = 0;

        while (jugar(turno)){
            turno++;
            if (turno == turnoMax){
                turno = 0;
            }
        }

    }
    // crear barcos con un ARRAY { {1,1,1,1}, {2,2,2}, {4,4} }
    // implica crear 4 barcos que tienen tamaño 1
    // crear 3 barcos de tamaño 2
    // crear 2 barcos de tamaño 2
    public void createShipForEachPlayer(int turno) {
        // Definimos cuantos barcos queremos y su longitud
        int[] arrayBarcos = {1, 2, 2, 2, 3, 3, 4};

        for (int i = 0; i < arrayBarcos.length; i++) {
            int longitudBarco = arrayBarcos[i];
            // primero comprobamos que entre el barco 
            // y luego creamos el barco
            createShipIfEnter(longitudBarco, turno);
        }
    }

    // colocar los barcos
    private void createShipIfEnter(int longitudBarco, int turno){

        while (true) {

                // Para refactorizaer esto debería crear una clase de GeneradorCoordenadas y ponerle atributos?
                // hay alguna otra manera de refactorizar?
                Tablero tableroRef = this.listaTablero.get(turno);
                int fila = generateRandomNumber(tableroRef);
                int columna = generateRandomNumber(tableroRef);
                int numeroAleatorio = generateRandomNumber(tableroRef);
                boolean ramdomHorizontal =  randomPosition(numeroAleatorio);



            // 1r las casillas tiene que estar vacias
            if (squareIsEmpty(fila, columna, tableroRef)) {
                // 2n ese barco entra en el tablero
                if(shipNotFitTable(fila, columna, longitudBarco, ramdomHorizontal, tableroRef)){
                    continue;
                }
                // 3r  a 1 casilla de distancia hay barco?
                if (isShipsAround(fila, columna, longitudBarco, ramdomHorizontal, tableroRef)){
                    continue;
                }
                // Si cumplimos con los 3 requisitos, creamos el barco
                Barco barco = new Barco(longitudBarco, fila, columna, ramdomHorizontal);
                // decimos que ese barco pertenece al jugador

                // TODO: tengo que hacer un arrary list de Jugadores
                Jugador jugadorRef = listaJugadores.get(turno);
                jugadorRef.addBarco(barco);

                // ponemos el barco en el tablero
                putShipTable(fila, columna, barco, turno);
                return;


            }
        }

    }

    private void putShipTable(int fila, int columna, Barco barco, int turno){
        // si el barco solo tiene una parte

        Tablero tableroRef =  listaTablero.get(turno);
        ParteBarco parteBarco;
        if (shipHasOnly1Part(barco)){

            parteBarco = barco.getParteBarco(fila,columna);
            tableroRef.obtenerCasilla(fila,columna).colocarParteBarco(parteBarco);
            // decir en que parte esta esa parte del barco
            tableroRef.obtenerCasilla(fila,columna).setVacio();
            return;
        }
        // si el barco esta compuesto con más de una parte

        // posicion horizontal
        if (barco.isPosHorizontal()){
            for (int i = 0; i < barco.getLongitud(); i++) {
            parteBarco = barco.getParteBarco(fila,columna+i);
            tableroRef.obtenerCasilla(fila,columna +i).colocarParteBarco(parteBarco);
            tableroRef.obtenerCasilla(fila,columna+i).setVacio();
            }
            return;
        }

        // posicion vertical
        for (int i = 0; i < barco.getLongitud(); i++) {
            parteBarco = barco.getParteBarco(fila+i,columna);
            tableroRef.obtenerCasilla(fila+i,columna ).colocarParteBarco(parteBarco);
            tableroRef.obtenerCasilla(fila+i,columna).setVacio();
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
    private boolean shipNotFitTable(int fila, int columna, int longitudBarco, boolean ramdomHorizontal, Tablero tableroRef){

        if (shipIsHorizontal(ramdomHorizontal)){
            return (tableroRef.getMaxColumna() >= columna + longitudBarco) ? false : true;
        }
        return (tableroRef.getMaxFila() >= fila + longitudBarco) ? false : true;

    }

    private boolean shipIsHorizontal(boolean ramdomHorizontal) {
        return (ramdomHorizontal == true) ? true : false;
    }

private boolean isShipsAround(int fila, int columna, int longitudBarco, boolean ramdomHorizontal, Tablero tableroRef){

        // en que casilla me encuetro (lo recibo por parametro)
        // TENGO QUE MIRAR SI EL BARCO ES HORIZONTAL O VERTICAL
        // comprobar si hay barcos alrededor (is vacio False)
            // todo: aplicar esta logica por cada parte del barco --> Lo miro con la int longitudBarco
        // todo: cuando creo el barco pongo que esa casilla ya no este vacia


        if (shipIsHorizontal(ramdomHorizontal)){
            // comprobarBarcosEnCasillasVecinas(), el parametro que se introduce primero es la parte Fija
            // y el segundo paramentro que se introduce es la parte que se tiene que recorrer
                // El barco es Horizontal, tenemos que recorrer la columna
            if (comprobarBarcosEnCasillasVecinas(fila, columna, longitudBarco, tableroRef, ramdomHorizontal)){
                return true;
            }

        }
            // El barco es Vertical, tenemos que recorrer la fila
        if (comprobarBarcosEnCasillasVecinas(columna, fila, longitudBarco, tableroRef, ramdomHorizontal)){
            return true;
        }
        // isShipsAround() devuelve false, indicando que no hay barcos alrededor
        return false;
    }

    private boolean comprobarBarcosEnCasillasVecinas(int posFija, int posRecorrer, int longitudBarco, Tablero tableroRef, boolean ramdomHorizontal) {
        int filaModificada;
        int columnaModificada;
        
        for (int recorrerPosicion = posRecorrer; recorrerPosicion <= posRecorrer + longitudBarco; recorrerPosicion++) {
            for (int modFila = -1; modFila <= 1 ; modFila++) {
                for (int modColumn = -1; modColumn <=  1; modColumn++) {
                    if (NoVerificarCasillasVecinas(modFila, modColumn)){
                        continue;
                    }
                    if (shipIsHorizontal(ramdomHorizontal)){
                        // En este caso la fila es FIJA
                        filaModificada = posFija + modFila;
                        columnaModificada = recorrerPosicion + modColumn;
                        
                    }else {
                        // En este caso la Columna es FIJA
                        filaModificada = recorrerPosicion + modFila;
                        columnaModificada = posFija + modColumn;
                    }
                    if (!tableroRef.insideTable(filaModificada, columnaModificada)){
                        // no me interesa comprobar casillas fuera del tablero
                        continue;
                    }
                    if (!squareIsEmpty(filaModificada ,columnaModificada, tableroRef)){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private static boolean NoVerificarCasillasVecinas(int modFila, int modColumn) {
        return (modFila == 0) && (modColumn == 0);
    }


    private boolean squareIsEmpty(int fila, int columna, Tablero tableroRef){
        return tableroRef.obtenerCasilla(fila,columna).isVacio();
    }

    private int generateRandomNumber(Tablero tableroRef){
        int numeroFilasColumnas = tableroRef.getMaxColumna();

        return (int) (Math.random() * numeroFilasColumnas);
    }



    public boolean jugar(int turno){

        // atacar mientras el jugador tenga Barcos
        Jugador jugadorRef = listaJugadores.get(turno);
        Tablero tableroRef = listaTablero.get(turno);
        Print presentacionRef = listaPresentacion.get(turno);


        int indiceEnemigo = obtenerIndiceJugadorEnemigo(turno);

        Tablero tableroEnemigo = listaTablero.get(indiceEnemigo);

        if (jugadorRef.stillAlive() == false){
            presentacionRef.mensajeGameOver(jugadorRef);
            return false;
        }

        while (true){

            imprimirTablero(jugadorRef, tableroRef, presentacionRef, tableroEnemigo);

            int fila = presentacionRef.elegir("Fila") -1;
            int columna = presentacionRef.elegir("Columna") -1;
            // atacar una casilla que ya esta abierta

            if(squareIsOpen(fila,columna, tableroEnemigo)){
                // casilla abierta previamente, volver a elegir row and column
                presentacionRef.mensajeCasillaAbierta();
                continue;
            }
            // que este vacio la casilla, y no haya barco
                // tenemos que destapar casilla
            if(casillaSinBarco(fila,columna, tableroEnemigo)){
                tableroEnemigo.obtenerCasilla(fila,columna).setTapada();
                imprimirTablero(jugadorRef, tableroRef, presentacionRef, tableroEnemigo);
                return true;
            }

            // el barco este compuesto de solo una parte y la toquemos. Tocado y hundido
            // ponerlo en un método

            Barco barco = tableroEnemigo.obtenerCasilla(fila,columna).getParteBarco().getBarco();
            // todo: TENGO QUE INDICAR QUE PARTE DEL BARCO ESTOY HUNDIENDO
            barco.getParteBarco(fila,columna).hundirParteBarco();
            tableroEnemigo.obtenerCasilla(fila,columna).setTapada();

            if (barco.getLongitud() == 1){

                barco.hundirBarco();
                // tenemos que revelar las casilla de las esquinas
                revelaCasillasVecinas(fila,columna, barco, tableroEnemigo, presentacionRef);
                imprimirTablero(jugadorRef, tableroRef, presentacionRef, tableroEnemigo);
                presentacionRef.MensajeHasHundidoBarco();
                continue;
            }

            // que hayamos tocado una parte del barco y NO hundamos el barco

            if (barco.todasPartesBarcoTocadas() == false){
                revelaCasillasVecinas(fila,columna, barco, tableroEnemigo, presentacionRef);
                imprimirTablero(jugadorRef, tableroRef, presentacionRef, tableroEnemigo);
                presentacionRef.MensajeHasTocadoParteBarco();
                continue;
            }

            // que hayamos tocado todas las partes del barco y hundamos el barco
            if (jugadorRef.stillAlive()){
                revelaCasillasVecinas(fila,columna, barco, tableroEnemigo, presentacionRef);
                if (jugadorRef.stillAlive() == false){
                    imprimirTablero(jugadorRef, tableroRef, presentacionRef, tableroEnemigo);
                    presentacionRef.mensajeGameOver(jugadorRef);
                    return false;
                }

                imprimirTablero(jugadorRef, tableroRef, presentacionRef, tableroEnemigo);
                return true;
            }

            // que hayamos hundido todos los barcos
            barco.hundirBarco();


        }

    }

    private boolean casillaSinBarco(int fila, int columna, Tablero tableroRef){
        if (squareIsEmpty(fila,columna, tableroRef) && !(tableroRef.obtenerCasilla(fila,columna).tieneBarco())){
            return true;
        }
        return false;
    }

    private void imprimirTablero(Jugador jugadorRef, Tablero tableroRef, Print presentacionRef, Tablero tableroEnemigo) {

        // todo: hace falta tener un Print presentacionRef?

        presentacionRef.mensajeEsTuTurno(jugadorRef);

        System.out.println("Tablero Enemigo");
        presentacionRef.printTableroEnemigo(tableroEnemigo);

        System.out.println("Tu tablero");
        // todo: borrar uno
        presentacionRef.printTableroConBarcos(tableroRef);


    }

    private int obtenerIndiceJugadorEnemigo(int turnoRef){
        if (turnoRef == this.turnoMax-1){
            return 0;
        }
        return turnoRef+1;



    }

    public void revelaCasillasVecinas(int fila, int columna, Barco barco, Tablero tableroRef, Print presentacionRef) {
        // revelar si el barco es de una sola longitud
        if (barco.getLongitud() == 1) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if ((i == 0) && (j == 0)) {
                        continue;
                    }

                    if (tableroRef.insideTable(fila + i, columna + j)) {
                        tableroRef.obtenerCasilla(fila + i, columna + j).setTapada();
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
                    if (tableroRef.insideTable(fila + i, columna + j)) {
                        tableroRef.obtenerCasilla(fila + i, columna + j).setTapada();


                    }
                }
            }
            // TODO: COMPROBAR EL ESTADO DEL BARCO (ESTA HUNDIDO?)
            if (barco.todasPartesBarcoTocadas() == true){
                barco.hundirBarco();
            }else {
                return;
            }

        }

        if (barco.isHundido()){
            tableroRef.obtenerCasilla(fila, columna).setTapada();

            // TODO: no estoy seguro si el codigo de abajo deberia pasar: tableroRef o tableroEnemigo
            presentacionRef.printTableroEnemigo(tableroRef);
            int longitudBarco = barco.getLongitud();
            // TODO: tengo que buscar el barco de la posicion 0 y recorrer todo el barco

            int filaInicial = barco.filaPrimeraParteBarco();
            int columnaInicial = barco.columnaPrimeraParteBarco();
            int modFila;
            int modColumna;
            if (barco.isPosHorizontal()){

                for (int recorrerColumnas = columnaInicial; recorrerColumnas < (columnaInicial + longitudBarco); recorrerColumnas++) {
                    for (int j = -1; j <= 1; j++) {
                        for (int k = -1; k <= 1; k++) {
                            if (NoVerificarCasillasVecinas(j, k)) {
                                continue;
                            }
                            modFila = filaInicial + k;
                            modColumna = recorrerColumnas + j;

                            if (tableroRef.insideTable(modFila, modColumna)) {
                                tableroRef.obtenerCasilla(modFila, modColumna).setTapada();

                            }

                        }
                    }
                }
                return;
            }

            for (int recorrerFilas = filaInicial; recorrerFilas < (filaInicial + longitudBarco); recorrerFilas++) {
                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {
                        if (NoVerificarCasillasVecinas(j, k)) {
                            continue;
                        }
                        modFila = recorrerFilas + k;
                        modColumna = columnaInicial + j;
                        if (tableroRef.insideTable(modFila, modColumna)) {
                            tableroRef.obtenerCasilla(modFila, modColumna).setTapada();

                        }

                    }
                }
            }

        }



    }

    private static boolean posicionNoPermitida(int i, int j) {
        if (NoVerificarCasillasVecinas(i, j)) {
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


    private boolean squareIsOpen(int fila, int columna, Tablero tableroRef){
        if (tableroRef.obtenerCasilla(fila,columna).isTapada() == false){
            return true;
        }
        return false;
    }

    private void definirTurnoMax(){
        this.turnoMax = listaJugadores.size();

    }



    private void addTableroForEachPlayer(){
        listaTablero = new ArrayList<>();
        listaPresentacion = new ArrayList<>();
        for (int i = 0; i < this.listaJugadores.size(); i++) {
            Jugador jugador = listaJugadores.get(i);
            Tablero tablero= jugador.getTableroJugador();
            listaTablero.add(tablero);
            listaPresentacion.add(new Print(tablero));
        }
    }


}





