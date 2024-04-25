

import Logica.Juego;
import Modelo.Tablero;

import java.util.Scanner;

public class MainBuscaMinas {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // Creamos una instacia de tablero
        Tablero tablero = new Tablero(10,10,10 );
        // creamos una instancia de Juego, y le pasamos el tablero que
        // hemos creado
        Juego buscaMinas = new Juego(tablero);
        buscaMinas.jugar();
    }

}







