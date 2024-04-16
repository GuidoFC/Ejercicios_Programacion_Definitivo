package segundoIntento;

public class TableroDef {
    private Casilla [][] matrizDeCasilla;
    private int numBombas;
    private int numBanderas;



    public TableroDef(int fila, int columna, int numBombas){
        matrizDeCasilla = new Casilla[fila][columna];
        this.numBombas = numBombas;
        numBanderas = 0;

        RellenarTodasLasFichasDelTableroAlInicio();
        insertarBombas();
        contadorDeLasBombasVecinas();
    }

    // que hace el get tablero??
    // del tablero busca la casilla porque es un Array de Casilla
    public Casilla getLaFichaDelTablero(int fila, int columna){
        return this.matrizDeCasilla[fila][columna];
    }

    public int getFilaTabla(){
        int filas = this.matrizDeCasilla.length;
        return filas;
    }

    public int getColumnaTabla(){
        int columnas = this.matrizDeCasilla[0].length;
        return columnas;
    }


    private void RellenarTodasLasFichasDelTableroAlInicio() {
        for (int i = 0; i < matrizDeCasilla.length; i++) {
            for (int j = 0; j < matrizDeCasilla[0].length; j++) {
                matrizDeCasilla[i][j] = new Casilla();
            }
        }
    }

    private void insertarBombas() {
        int totalBombas = this.numBombas;
        int fila = this.getFilaTabla();
        int columna = this.getColumnaTabla();
        int bombasIntroducidas = 0;


        while (bombasIntroducidas < totalBombas) {
            int i = (int) (Math.random() * fila);
            int j = (int) (Math.random() * columna);

            if (!this.matrizDeCasilla[i][j].esMina()) {
                this.matrizDeCasilla[i][j].ponerMina();
                bombasIntroducidas++;
            }
        }
    }

    private void contadorDeLasBombasVecinas(){
        for (int fila = 0; fila < this.getFilaTabla() ; fila++) {
            for (int columna = 0; columna < this.getColumnaTabla(); columna++) {
                for (int modificaFila = -1; modificaFila <= 1; modificaFila++) {
                    for (int modificaColumna = -1; modificaColumna <=1 ; modificaColumna++) {
                        if (estamosDentodeLaTabla(fila,modificaFila,columna,modificaColumna) ){
                            if (!hayMinaEnEstaCasilla(fila, columna)){
                                int vecinosFila = fila + modificaFila; // vecinoFila = -1 ?
                                int vecinosColumnas = columna + modificaColumna;
                                if (hayMinaEnEstaCasilla(vecinosFila,vecinosColumnas)){
                                    incrementarNumeroSegunBombasVecinas(fila,columna);
                                }
                            }else {
                                this.getLaFichaDelTablero(fila,columna).setNumBombasVecinas(-1);
                            }
                        }
                    }
                }
            }
        }
    }


    private boolean estamosDentodeLaTabla(int fila, int modFilia, int columna, int modColumna){
        final int INDICE_CERO = 0;
        if ((fila + modFilia >= INDICE_CERO) && (columna + modColumna >= INDICE_CERO) &&
                (fila + modFilia < this.getFilaTabla() ) &&
                (columna + modColumna < this.getColumnaTabla()) ){
            return true;
        }
        return false;
    }


    private boolean hayMinaEnEstaCasilla(int fila, int columna){
        if (this.getLaFichaDelTablero(fila, columna).esMina()){
            return true;
        }
        return false;
    }

    private void incrementarNumeroSegunBombasVecinas(int fila, int columna){
        this.getLaFichaDelTablero(fila,columna).incrementoNumeroBomas();
    }

    public boolean jugar(int fila, int columna) throws Exception {
        if(this.getLaFichaDelTablero(fila,columna).esMina()){
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
                if (this.getLaFichaDelTablero(i,j).esMina()){
                    this.getLaFichaDelTablero(i,j).abrirCasilla();
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

        if (!this.getLaFichaDelTablero(fila,columna).esTapada()){
            return;
        }

        if (this.getLaFichaDelTablero(fila,columna).getNumBombasVecinas() != 0){
            this.getLaFichaDelTablero(fila,columna).abrirCasilla();
            return;
        }

        this.getLaFichaDelTablero(fila,columna).abrirCasilla();
            for (int i = fila -1; i <= fila + 1; i++) {
                for (int j = columna -1 ; j <= columna +1; j++) {
                    if (this.insideTable(i,j)){
                        revelarCasillasVaciasRecursivamente(i,j);
                    }


                }
            }

    }


}
