package segundoIntento.Logica;

import segundoIntento.Modelo.BuscaMinas.TableroDef;
import segundoIntento.Vista.ImprimirTablero;

public class Juego {
    // para conectar la parte logica con la vista creamos un
    // objeto de la clase ImprimirTablero que pertenece al
    // package de Vista:
    private ImprimirTablero presentacion = new ImprimirTablero();
    private TableroDef tableroDef;

    public Juego(int fila, int columna, int bomba){
        TableroDef tableroDef = new TableroDef(fila, columna, bomba);
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

            // me falta hacer la opcion de la bandera


            // insertar fila
             fila = presentacion.introducirFila(this.tableroDef.getFilaTabla());
            // insertar columna
             columna = presentacion.introducirColumna(this.tableroDef.getColumnaTabla());

            // logica del juego

            if(this.tableroDef.getFichaTablero(fila,columna).esMina()){
                gameOverImprimirTodasLasMinas();
                continuarJugar = false;
            }
            this.revelarCasillasVaciasRecursivamente(fila,columna);

        }
    }

    public void gameOverImprimirTodasLasMinas(){
        for (int i = 0; i < this.tableroDef.getFilaTabla(); i++) {
            for (int j = 0; j < this.tableroDef.getColumnaTabla(); j++) {
                if (this.tableroDef.getFichaTablero(i,j).esMina()){
                    this.tableroDef.getFichaTablero(i,j).abrirCasilla();
                }
            }
        }
    }
    public boolean insideTable(int fila, int columna){
        if ((fila >= 0) && (fila < this.tableroDef.getFilaTabla())
                && (columna >= 0) && (columna < this.tableroDef.getColumnaTabla()) ){
            return true;
        }
        return false;
    }

    public  void revelarCasillasVaciasRecursivamente(int fila, int columna) throws Exception{

        if (!this.insideTable(fila,columna)){
            return;
        }

        if (!this.tableroDef.getFichaTablero(fila,columna).esTapada()){
            return;
        }

        if (this.tableroDef.getFichaTablero(fila,columna).getNumBombasVecinas() != 0){
            this.tableroDef.getFichaTablero(fila,columna).abrirCasilla();
            return;
        }

        this.tableroDef.getFichaTablero(fila,columna).abrirCasilla();
        for (int i = fila -1; i <= fila + 1; i++) {
            for (int j = columna -1 ; j <= columna +1; j++) {
                if (this.insideTable(i,j)){
                    revelarCasillasVaciasRecursivamente(i,j);
                }


            }
        }

    }
}
