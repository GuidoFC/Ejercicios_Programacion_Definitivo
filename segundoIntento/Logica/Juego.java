package Logica;


import Vista.ImprimirTablero;
import Modelo.Tablero;

public class Juego {
    // para conectar la parte Logica con la Vista creamos un
    // objeto de la clase ImprimirTablero que pertenece al
    // package de Vista:
    private ImprimirTablero presentacion;

    // para conectar la parte Logica con el Modelo creamos un
    // objeto de la clase TableroDef que pertenece al
    // package de Modelo:
    private Tablero tablero;

    // constructor
        // Primero va la creacion del Modelo
        // Luego la lógica
        // finalmenente la Vista
    public Juego(Tablero tableroRefInput){
        tablero = tableroRefInput;
        presentacion = new ImprimirTablero(tablero);
    }


    public void jugar() throws Exception {

        // bucle que fins que no hi hagi end vagi iterant
        boolean continuarJugar = true;
        int fila;
        int columna;
        while (continuarJugar){

            // imprimir Tabla
            presentacion.printTablero();

            // imprimir tablero con minas
            presentacion.printTableroConBombas();

            // imprimir tablero con solucion
            presentacion.printTableroSolucion();

            // menu
            presentacion.menu();

            // me falta hacer que eliga entre la opcion
            // de poner bandera o destapar casilla
            // por ahora dejo comentado la opcion de BANDERA

            // presentacion.set_or_Remove_Flag(this.tableroDef.getFilaTabla(),this.tableroDef.getColumnaTabla());


            // insertar fila
            fila = presentacion.introducirFila(this.tablero.getFilaTabla());
            // insertar columna
            columna = presentacion.introducirColumna(this.tablero.getColumnaTabla());

            // logica del juego
            if(this.tablero.getFichaTablero(fila,columna).esMina()){
                gameOver();
                continuarJugar = false;
            }else {
                this.revelarCasillasVacias(fila,columna);
            }


        }
        presentacion.endGame();

    }

    public void gameOver(){
        for (int i = 0; i < this.tablero.getFilaTabla(); i++) {
            for (int j = 0; j < this.tablero.getColumnaTabla(); j++) {
                if (this.tablero.getFichaTablero(i,j).esMina()){
                    this.tablero.getFichaTablero(i,j).abrirCasilla();
                }
            }
        }
    }


    public  void revelarCasillasVacias(int fila, int columna) throws Exception{

        if (!this.insideTable(fila,columna)){
            return;
        }

        if (!this.tablero.getFichaTablero(fila,columna).esTapada()){
            return;
        }

        if (this.tablero.getFichaTablero(fila,columna).getNumBombasVecinas() != 0){
            this.tablero.getFichaTablero(fila,columna).abrirCasilla();
            return;
        }

        this.tablero.getFichaTablero(fila,columna).abrirCasilla();
        for (int i = fila -1; i <= fila + 1; i++) {
            for (int j = columna -1 ; j <= columna +1; j++) {
                if (this.insideTable(i,j)){
                    revelarCasillasVacias(i,j);
                }
            }
        }
    }

    public boolean insideTable(int fila, int columna){
        if ((fila >= 0) && (fila < this.tablero.getFilaTabla())
                && (columna >= 0) && (columna < this.tablero.getColumnaTabla()) ){
            return true;
        }
        return false;
    }
}
