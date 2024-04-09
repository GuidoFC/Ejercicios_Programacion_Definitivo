package intentoGuido;

public class Tablero extends Ficha{
    private char [][] tableroFicha;

    public Tablero(int fila, int columna){
        tableroFicha = new char[fila][columna];
    }

    public  void RellenarFicha (){
        for (int i = 0; i < tableroFicha.length; i++) {
            for (int j = 0; j < tableroFicha[0].length; j++) {
                tableroFicha[i][j] = ' ';
            }
        }
    }

    public void imprimirTablero(){
        for (int i = 0; i < tableroFicha.length; i++) {
            for (int j = 0; j < tableroFicha[0].length; j++) {
                System.out.print(tableroFicha[i][j] + "\t");
            }
        }
    }
}
