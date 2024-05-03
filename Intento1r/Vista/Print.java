package Vista;

import Model.Tablero;
import java.util.Scanner;

public class Print {
    static Scanner sc = new Scanner(System.in);
    private Tablero tableroJugadorA;


    public Print (Tablero tableroRefernciaA){
        this.tableroJugadorA = tableroRefernciaA;
    }

    public  void mensajeEsTuTurno(){
        String mensaje =
                """
                Es su turno, le toca atacar!
                A continuación vera su tablero
                y seguidamente vera el tablero
                de su enemigo.
                """;
        System.out.println(mensaje);
    }

    public  String printMatrizCasilla(int fila, int columna, Tablero tableroJugadorA) {
        if (tableroJugadorA.obtenerCasilla(fila, columna).isTapada()) {
            return "-";
        }
        if (tableroJugadorA.obtenerCasilla(fila, columna).isAtacado()){
            if (tableroJugadorA.obtenerCasilla(fila,columna).isParteBarco()){
                return "B";
            }

        }
        return "x";
    }



        public void printTablero(Tablero tableroJugadorA) {
        System.out.println();
        for (int i = -1; i < tableroJugadorA.getMaxFila(); i++) {
            for (int j = 0; j < tableroJugadorA.getMaxColumna(); j++) {
                if ((i == -1)) {
                    System.out.print("\t" + (j + 1) + " ");
                    if (j == tableroJugadorA.getMaxColumna() - 1) {
                        System.out.println();
                    }
                }
                if (i >= 0) {
                    if (j == 0) {
                        System.out.print(i + 1 + "\t");
                    }
                    System.out.print(printMatrizCasilla(i,j,tableroJugadorA) + "\t");
                    if (j == tableroJugadorA.getMaxColumna() - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }

    public  void printTableroConBarcos(Tablero tableroJugadorA) {
        System.out.println();
        for (int i = -1; i < tableroJugadorA.getMaxFila(); i++) {
            for (int j = 0; j < tableroJugadorA.getMaxColumna(); j++) {
                if ((i == -1)) {
                    System.out.print("\t" + (j + 1) + " ");
                    if (j == tableroJugadorA.getMaxColumna() - 1) {
                        System.out.println();
                    }
                }
                if (i >= 0) {
                    if (j == 0) {
                        System.out.print(i + 1 + "\t");
                    }
                    if (tableroJugadorA.obtenerCasilla(i,j).isParteBarco()){
                        System.out.print( "x" + "\t");
                    }else {
                        System.out.print("0" + "\t");
                    }

                    if (j == tableroJugadorA.getMaxColumna() - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }

    public int elegir(String filaColumna){
        System.out.println("Elija una " + filaColumna);
        return sc.nextInt();
    }

    public void mensajeCasillaAbierta(){
        System.out.println("Esta casilla ya esta abierta");
    }

    public void mensajeGameOver(){
        System.out.println("Has perdido");
    }
}
