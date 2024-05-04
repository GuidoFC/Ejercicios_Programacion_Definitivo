import Logica.Juego;
import Model.Jugador;
import Model.Tablero;

public class Main {
    public static void main(String[] args) {
        // creamos el jugador
        Jugador jugador1 = new Jugador("Guido", "Figueroa", 10, 10);

        //y pasamos este jugador a la parte logica
        Juego juego = new Juego(jugador1);
        juego.starGame();
    }


}
