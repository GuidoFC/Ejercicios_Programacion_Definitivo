package Model;

public class Tablero  {
    Casilla [][] matrizCasilla;


    public Tablero (int fila, int columna, Jugador jugador1, Jugador jugador2){
        this.matrizCasilla = new Casilla [fila][columna];


    }


}
