import java.util.Scanner;

public class MainJuego {


    public final static int MAXIMO_FILAS = 6;
    public final static int MAXIMO_COLUMNAS = 7;
    public static int turno = 0;




    public Scanner sc = new Scanner(System.in);
    static int columnaElegida;


    public static void main(String[] args) {

        Tablero.dibujarTablero();

        boolean columnaLibreDisponible = false;

        do {
            columnaElegida = Ficha.introducirFichaColumna();
            columnaLibreDisponible = Tablero.columnaLibre(columnaElegida);

            if (columnaLibreDisponible && turno % 2 == 0 ){
                guardarFicha[MAXIMO_FILAS][MAXIMO_COLUMNAS] = new Ficha('X');
                // Esto esta mal pq mi tablero es bidimensional
                MAXIMO_COLUMNAS ++;
                MAXIMO_FILAS++;
                // añadir Tablero.ganadorHorizontal();

                turno ++;
            }else {
                guardarFicha[MAXIMO_FILAS][MAXIMO_COLUMNAS] = new Ficha('0');
                // Esto esta mal pq mi tablero es bidimensional
                MAXIMO_COLUMNAS  ++;
                MAXIMO_FILAS++;
                // añadir Tablero.ganadorHorizontal();

                turno ++;
            }


        }while (columnaLibreDisponible == false);

    }
}
