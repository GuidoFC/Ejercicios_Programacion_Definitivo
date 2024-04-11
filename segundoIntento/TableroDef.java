package segundoIntento;

public class TableroDef {
    private Casilla [][] casilla;
    private int numBombas;
    private int numBanderas;



    public TableroDef(int fila, int columna, int numBombas){
        casilla = new Casilla[fila][columna];
        this.numBombas = numBombas;
        numBanderas = 0;

        //

    }

    // que hace el get tablero??
    // del tablero busca la casilla porque es un Array de Casilla
    public Casilla getLaFichaDelTablero(int fila, int columna){
        return this.casilla[fila][columna];
    }


    public int getFilaTabla(){
        int filas = this.casilla.length;
        return filas;
    }

    public int getColumnaTabla(){
        int columnas = this.casilla[0].length;
        return columnas;
    }


    public void RellenarTodasLasFichasDelTableroAlInicio() {
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[0].length; j++) {
                casilla[i][j] = new Casilla('-');
            }
        }
    }

    public void insertarBombas() {
        int totalBombas = this.numBombas;
        int fila = this.getFilaTabla();
        int columna = this.getColumnaTabla();
        int bombasIntroducidas = 0;


        while (bombasIntroducidas < totalBombas) {
            int i = (int) (Math.random() * fila);
            int j = (int) (Math.random() * columna);

            if (!this.casilla[i][j].esMina()) {
                this.casilla[i][j].ponerMina(true);
                bombasIntroducidas++;
            }
        }
    }

    public void contadorBombasVecinas(){
        for (int fila = 0; fila < this.getFilaTabla() ; fila++) {
            for (int columna = 0; columna < this.getColumnaTabla(); columna++) {
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <=1 ; l++) {

                        if (estamosDentodeLaTabla(fila,columna,k,l) ){  // and not ( ( k == 0 ) and ( l == 0 ) )

                            // si es mina i+k,j+l   ===> i,j incrementar numMinasVecinas
                            if (!this.getLaFichaDelTablero(fila, columna).esMina()){
                                int vecinosFila = fila+k;
                                int vecinosColumnas = columna+l;
                                if (this.getLaFichaDelTablero(vecinosFila,vecinosColumnas).esMina()){
                                    // tengo que hacer un increment
                                    this.getLaFichaDelTablero(fila,columna).incrementoNumeroBomas();
                                }
                            }if (this.getLaFichaDelTablero(fila,columna).esMina()){
                                // en este caso indico que no hay bomba
                                // cambiar el estado de la casilla.

                                // este codigo no lo borro por si luego necesito adaptarlo
                                // this.getTablero(i,j).setEstado('x');
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

        if ((fila + modFilia >= INDICE_CERO) && (columna+modColumna >= INDICE_CERO) &&
                (fila + modFilia < this.getFilaTabla() ) &&
                (columna + modColumna < this.getColumnaTabla()) ){
            return true;
        }
        return false;
    }


    public boolean jugar(int fila, int columna){
        if(this.getLaFichaDelTablero(fila,columna).getNumBombasVecinas() == -1){
            gameOverImprimirTodasLasMinas();
            return false;
        }
        this.getLaFichaDelTablero(fila,columna).setTapada(false);
        // importante como pasar de un int a un char
        char numero = (char) ('0' + this.getLaFichaDelTablero(fila,columna).getNumBombasVecinas());
        this.getLaFichaDelTablero(fila,columna).setCasillaVisible(numero);
        return true;

    }

    public void gameOverImprimirTodasLasMinas(){
        for (int i = 0; i < getFilaTabla(); i++) {
            for (int j = 0; j < getColumnaTabla(); j++) {
                if (this.getLaFichaDelTablero(i,j).getNumBombasVecinas() == -1){
                    this.getLaFichaDelTablero(i,j).setCasillaVisible('x');
                }

            }

        }

    }

}
