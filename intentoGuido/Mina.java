package intentoGuido;

public class Mina extends Ficha {
    private char [][] minaCasilla;
    private int numBombas;

    public Mina(int fila, int columna, int bombas){
        minaCasilla = new char[fila][columna];
        this.numBombas = bombas;
    }

    public char getMinaFichaConcreta(int fila, int columna) {
        return minaCasilla[fila][columna];
    }

    public void setMinaCasilla(char[][] minaCasilla) {
        this.minaCasilla = minaCasilla;
    }

    public int getNumBombas() {
        return numBombas;
    }

    public void setNumBombas(int numBombas) {
        this.numBombas = numBombas;
    }

    public  void RellenarFicha (){
        for (int i = 0; i < minaCasilla.length; i++) {
            for (int j = 0; j < minaCasilla[0].length; j++) {
                minaCasilla[i][j] = ' ';
            }
        }
    }
    public void insertarBombas() {
        int totalBombas = this.numBombas;
        int fila = this.minaCasilla.length;
        int columna = this.minaCasilla[0].length;
        int bombasIntroducidas = 0;


        while (bombasIntroducidas < totalBombas) {
            int i = (int) (Math.random() * fila);
            int j = (int) (Math.random() * columna);

            if (minaCasilla[i][j] == ' ') {
                minaCasilla[i][j] = 'x';
                bombasIntroducidas++;
            }
        }
    }



        public void imprimirTableroMina() {
            for (int i = -1; i < minaCasilla.length; i++) {
                for (int j = 0; j < minaCasilla[0].length; j++) {
                    if ((i == -1)) {
                        System.out.print("\t" + (j + 1) + " ");
                        if (j == minaCasilla[0].length - 1) {
                            System.out.println();
                        }
                    }
                    if (i >= 0) {
                        if (j == 0) {
                            System.out.print(i + 1 + "\t");
                        }
                        System.out.print(minaCasilla[i][j] + "\t");
                        if (j == minaCasilla[0].length - 1) {
                            System.out.println();
                        }
                    }
                }
            }
        }

        public void motrarTodaslasBombas(Tablero tablero1){
            for (int i = 0; i < minaCasilla.length; i++) {
                for (int j = 0; j < minaCasilla[0].length; j++) {
                    if (minaCasilla[i][j] == 'x'){
                        tablero1.setTableroFicha(i,j,'x');
                    }
                }

            }
        }



    }





