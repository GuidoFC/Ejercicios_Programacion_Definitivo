package Vista;

import Model.Jugador;
import Model.ParteBarco;
import Model.Tablero;
import java.util.Scanner;

public class Print {
    static Scanner sc = new Scanner(System.in);
    private Tablero tableroJugadorA;


    public Print (Tablero tableroRefernciaA){
        this.tableroJugadorA = tableroRefernciaA;
    }

    public  void mensajeEsTuTurno(Jugador jugadorRef){
        String mensaje =
                """
                
                Es el turno de:
                """ + " " + jugadorRef.getNombre() + " "+
                """
                le toca atacar!
                A continuación vera el tablero
                de su enemigo
                y seguidamente vera su tablero.
                """;
        System.out.println(mensaje);
    }

    public  String imprimirEstadoCasilla(int fila, int columna, Tablero tableroJugadorA) {
        if (tableroJugadorA.obtenerCasilla(fila, columna).isTapada()) {
            return "-";
        }
        if (!tableroJugadorA.obtenerCasilla(fila, columna).isTapada()){
            if (tableroJugadorA.obtenerCasilla(fila,columna).isParteBarco()){
                return ConsoleColors.RED + "T" + ConsoleColors.RESET;
            }

        }
        return ConsoleColors.GREEN + "!" + ConsoleColors.RESET;
    }



        public void printTableroEnemigo(Tablero tableroEnemigo) {
        System.out.println();
        for (int i = -1; i < tableroEnemigo.getMaxFila(); i++) {
            for (int j = 0; j < tableroEnemigo.getMaxColumna(); j++) {
                if ((i == -1)) {
                    System.out.print("\t" + (j + 1) + " ");
                    if (j == tableroEnemigo.getMaxColumna() - 1) {
                        System.out.println();
                    }
                }
                if (i >= 0) {
                    if (j == 0) {
                        System.out.print(i + 1 + "\t");
                    }
                    System.out.print(imprimirEstadoCasilla(i,j,tableroEnemigo) + "\t");
                    if (j == tableroEnemigo.getMaxColumna() - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }


    public  void printTableroConBarcos(Tablero tableroJugador) {
        System.out.println();
        for (int i = -1; i < tableroJugador.getMaxFila(); i++) {
            for (int j = 0; j < tableroJugador.getMaxColumna(); j++) {
                if ((i == -1)) {
                    System.out.print("\t" + (j + 1) + " ");
                    if (j == tableroJugador.getMaxColumna() - 1) {
                        System.out.println();
                    }
                }
                // Todo: logica para visualizar los ataques
                if (i >= 0) {
                    if (j == 0) {
                        System.out.print(i + 1 + "\t");
                    }
                    ParteBarco parteBarco = tableroJugador.obtenerCasilla(i, j).getParteBarco();
                    if (parteBarco != null){
                        if (ataqueAcertado(tableroJugador, i, j)){
                            System.out.print( ConsoleColors.RED + "T" + "\t" + ConsoleColors.RESET);
                            if (j == tableroJugador.getMaxColumna() - 1) {
                                System.out.println();
                            }
                        }else{
                            System.out.print( ConsoleColors.BLUE + "x" + "\t" + ConsoleColors.RESET);
                            if (j == tableroJugador.getMaxColumna() - 1) {
                                System.out.println();
                            }
                        }

                    }else {
                        if(AtaqueFallido(tableroJugador, i, j)){
                            System.out.print( ConsoleColors.GREEN + "!" + "\t" + ConsoleColors.RESET);
                            if (j == tableroJugador.getMaxColumna() - 1) {
                                System.out.println();
                            }

                        }
                        else {
                            System.out.print("0" + "\t");
                        }

                        if (j == tableroJugador.getMaxColumna() - 1) {
                            System.out.println();
                        }
                    }


                }
            }
        }
    }

    private static boolean AtaqueFallido(Tablero tableroJugador, int i, int j){
        if(tableroJugador.obtenerCasilla(i, j).isVacio() && tableroJugador.obtenerCasilla(i, j).isTapada() == false ){
            return true;
        }
        return false;
    }
    private static boolean Casilla_No_Atacada_Y_HayBarco(Tablero tableroJugador, int i, int j) {
        return tableroJugador.obtenerCasilla(i, j).isParteBarco();
    }

    private static boolean ataqueAcertado(Tablero tableroJugador, int i, int j) {
        if (tableroJugador.obtenerCasilla(i, j).getParteBarco().isTocado() == true){
            return true;
        }
        return false;
    }

    public int elegir(String filaColumna){
        System.out.println("Elija una " + filaColumna);
        return sc.nextInt();
    }

    public void mensajeCasillaAbierta(){
        System.out.println("Esta casilla ya esta abierta");
    }

    public void mensajeGameOver(Jugador jugadorRef){
        System.out.println("El Jugador: " + jugadorRef.getNombre() + "ha perdido");
    }
}
