import Model.Jugador;
import Model.Tablero;

public class Main {
    public static void main(String[] args) {

        Tablero tableroA = new Tablero(10,10);
        Jugador jugador = new Jugador("Guido","Figueroa", tableroA);
    }

}
