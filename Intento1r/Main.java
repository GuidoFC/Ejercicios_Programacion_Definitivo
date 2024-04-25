import Logica.Juego;
import Model.Jugador;
import Model.Tablero;

public class Main {
    public static void main(String[] args) {



        // Si juegas con alguien
        Jugador jugador1 = new Jugador("Guido", "Figueroa", 10, 10);
        Jugador jugador2 = new Jugador("Marta", "HP", 10, 10);
        Juego hundirBarco = new Juego(jugador1,jugador2);

        //si juegas contra la maquina
        Juego juego = new Juego(jugador1);
    }


}
