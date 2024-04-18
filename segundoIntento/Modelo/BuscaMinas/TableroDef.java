package segundoIntento.Modelo.BuscaMinas;



public class TableroDef  {
    private Casilla[][] matrizDeCasilla;

    private final int numBombas;
    private int numBanderas;


    // constructor
    public TableroDef(int fila, int columna, int numBombas){
        matrizDeCasilla = new Casilla[fila][columna];
        this.numBombas = numBombas;
        numBanderas = 0;

        crearTableroConCasillas();
        insertarBombas();
        contadorDeLasBombasVecinas();
    }

    public Casilla getFichaTablero(int fila, int columna){
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

    private void crearTableroConCasillas() {
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
                        if (  ( modificaColumna == 0) && ( modificaFila == 0 ) )
                            continue;
                        if (!estamosDentodeLaTabla(fila,modificaFila,columna,modificaColumna)) {
                            continue;
                        }
                        int vecinosFila = fila + modificaFila;
                        int vecinosColumnas = columna + modificaColumna;
                        if (matrizDeCasilla[vecinosFila][vecinosColumnas].esMina()) {
                            matrizDeCasilla[fila][columna].incrementoNumeroBomas();

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



}
