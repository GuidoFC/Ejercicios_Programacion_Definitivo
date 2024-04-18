package segundoIntento.Logica;

import segundoIntento.Modelo.BuscaMinas.TableroDef;
import segundoIntento.Vista.ImprimirTablero;

public class Juego {
    // para conectar la parte logica con la vista:
    private ImprimirTablero interaccion = new ImprimirTablero();
    private TableroDef tableroDef;

    public Juego(int fila, int columna, int bomba){
        TableroDef tableroDef = new TableroDef(fila, columna, bomba);
    }




    public boolean jugar(int fila, int columna) throws Exception {
        if(this.tableroDef.getFichaTablero(fila,columna).esMina()){
            gameOverImprimirTodasLasMinas();
            return false;
        }
        // TableroDef tableroDef = this;
        // Como hacer que este método funcione?
        this.revelarCasillasVaciasRecursivamente(fila,columna);
        return true;

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
