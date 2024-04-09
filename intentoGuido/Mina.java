package intentoGuido;

public class Mina extends Ficha {
    private char [][] minaFicha;
    private int numBombas;

    public Mina(int fila, int columna, int bombas){
        minaFicha = new char[fila][columna];
        this.numBombas = bombas;
    }

    public char getMinaFichaConcreta(int fila, int columna) {
        return minaFicha[fila][columna];
    }

    public void setMinaFicha(char[][] minaFicha) {
        this.minaFicha = minaFicha;
    }

    public int getNumBombas() {
        return numBombas;
    }

    public void setNumBombas(int numBombas) {
        this.numBombas = numBombas;
    }

    public  void RellenarFicha (){
        for (int i = 0; i < minaFicha.length; i++) {
            for (int j = 0; j < minaFicha[0].length; j++) {
                minaFicha[i][j] = ' ';
            }
        }
    }
    public void insertarBombas(){
        int totalBombas = this.numBombas;
        int fila = this.minaFicha.length;
        int columna = this.minaFicha[0].length;
        int bombasIntroducidas = 0;


        while (bombasIntroducidas < totalBombas){
            int i = (int) (Math.random() * fila);
            int j = (int) (Math.random() * columna);

                    if (minaFicha[i][j] == ' '){
                        minaFicha[i][j] = 'x';
                        bombasIntroducidas ++;
                    }
        }

    }
}




