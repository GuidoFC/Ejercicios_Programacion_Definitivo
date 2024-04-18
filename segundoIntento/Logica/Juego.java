package segundoIntento.Logica;

import segundoIntento.Modelo.BuscaMinas.TableroDef;

public class Juego {

    private TableroDef tableroDef;

    public Juego(int fila, int columna, int bomba){
        TableroDef tableroDef = new TableroDef(fila, columna, bomba);
    }



    public boolean jugar(int fila, int columna) throws Exception {
        if(this.getFichaTablero(fila,columna).esMina()){
            gameOverImprimirTodasLasMinas();
            return false;
        }
        // TableroDef tableroDef = this;
        // Como hacer que este método funcione?
        this.revelarCasillasVaciasRecursivamente(fila,columna);
        return true;

    }

    public void gameOverImprimirTodasLasMinas(){
        for (int i = 0; i < getFilaTabla(); i++) {
            for (int j = 0; j < getColumnaTabla(); j++) {
                if (this.getFichaTablero(i,j).esMina()){
                    this.getFichaTablero(i,j).abrirCasilla();
                }
            }
        }
    }
    public boolean insideTable(int fila, int columna){
        if ((fila >= 0) && (fila < this.getFilaTabla())
                && (columna >= 0) && (columna < this.getColumnaTabla()) ){
            return true;
        }
        return false;
    }

    public  void revelarCasillasVaciasRecursivamente(int fila, int columna) throws Exception{

        if (!this.insideTable(fila,columna)){
            return;
        }

        if (!this.getFichaTablero(fila,columna).esTapada()){
            return;
        }

        if (this.getFichaTablero(fila,columna).getNumBombasVecinas() != 0){
            this.getFichaTablero(fila,columna).abrirCasilla();
            return;
        }

        this.getFichaTablero(fila,columna).abrirCasilla();
        for (int i = fila -1; i <= fila + 1; i++) {
            for (int j = columna -1 ; j <= columna +1; j++) {
                if (this.insideTable(i,j)){
                    revelarCasillasVaciasRecursivamente(i,j);
                }


            }
        }

    }
}
