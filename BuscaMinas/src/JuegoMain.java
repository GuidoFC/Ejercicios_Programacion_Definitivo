import java.util.Arrays;
import java.util.Scanner;
public class JuegoMain {
    public static Scanner sc = new Scanner(System.in);
    // public static int filasDefinitiva;
    // public static int columnasDefinitiva;

    public static Ficha[][] fichas = new Ficha[3][2];



    public static void main(String[] args) {

        Ficha casillaVacia = new Ficha('X');

        int fila = elijaNumeroFilas();
        int columna = elijaNumeroColumnas();
        inicializarJuegoCasillasVacias(casillaVacia, fila, columna);
        Tablero.dibujarTablero(fila, columna);







        /*Esto son los objetos que tengo que crear de la clase ficha:
        private char mina = 'M';
        private char bandera = 'B';
        private char solo1Bomba = '1';
        private char solo2Bomba = '2';
        private char solo3Bomba = '3';
        private char solo4Bomba = '4';
        private char solo5Bomba = '5';
        private char solo6Bomba = '1';
        private char solo7Bomba = '8';
        private char solo8Bomba = '1';
        */



    }
    private static int elijaNumeroFilas(){
        System.out.println("Cuantas filas quiere que tenga el tablero?");
        int filas = sc.nextInt();
        return filas;
    }

    private static int elijaNumeroColumnas(){
        System.out.println("Cuantas Columnas quiere que tenga el tablero?");
        int columnas = sc.nextInt();
        return columnas;
    }

    public static void inicializarJuegoCasillasVacias(Ficha casillaVacia, int fila, int columna){
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++)
                fichas[i][j].setCasilla(casillaVacia);
            }

        }

    }
