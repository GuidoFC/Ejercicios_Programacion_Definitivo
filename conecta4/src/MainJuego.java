import java.util.Scanner;

public class MainJuego {
    public static int turno = 0;

    public Scanner sc = new Scanner(System.in);
    static int columnaElegidaPorElJugador;


    public static void main(String[] args) {

        Tablero.inicializarJuego();

        boolean ganador = false;

        do {
            Tablero.dibujarTablero();
            boolean columnaLibreDisponible = false;

            columnaElegidaPorElJugador = Ficha.elegirColumna();
            columnaLibreDisponible = Tablero.comprobarSiColumnaLibre(columnaElegidaPorElJugador);
            if (columnaLibreDisponible == false){
                continue;
            }


            if (columnaLibreDisponible && turno % 2 == 0 ){
                Tablero.guardarFicha[Tablero.getPosFila()][Tablero.getPosColumna()] = new Ficha('X');

                Tablero.dibujarTablero();

                ganador = Tablero.ganadorHorizontal('X');
                ganador = Tablero.ganadorVertical('X');
                ganador = Tablero.ganadorDiagAscIzq('X');
                ganador = Tablero.ganadorDiagAscDerech('X');
                ganador = Tablero.ganadorDiagDescIzq('X');
                ganador = Tablero.ganadorDiagDescDerecho('X');
                turno ++;
            }else {
                Tablero.guardarFicha[Tablero.getPosFila()][Tablero.getPosColumna()] = new Ficha('0');

                Tablero.dibujarTablero();

                ganador = Tablero.ganadorHorizontal('0');
                ganador = Tablero.ganadorVertical('0');
                ganador = Tablero.ganadorDiagAscIzq('0');
                ganador = Tablero.ganadorDiagAscDerech('0');
                ganador = Tablero.ganadorDiagDescIzq('0');
                ganador = Tablero.ganadorDiagDescDerecho('0');



                turno ++;
            }


        }while (ganador == false);

    }
}
