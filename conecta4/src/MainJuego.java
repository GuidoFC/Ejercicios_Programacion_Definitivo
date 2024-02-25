import java.util.Scanner;

public class MainJuego {
    public static int turno = 0;

    public Scanner sc = new Scanner(System.in);
    static int columnaElegidaPorElJugador;


    public static void main(String[] args) {

        Tablero.inicializarJuego();
        // haciendo trampas para iterar menos
        // Tengo un problema, si la ficha cae en medio del 3 enraya no detecta un ganador
        // este problema afecta con todos los métodos
        /*
        Tablero.guardarFicha[5][0].setFicha('X');
        Tablero.guardarFicha[3][2].setFicha('X');
        Tablero.guardarFicha[2][3].setFicha('X');

         */
        // ganadorDiagAscendiente funciona

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


                ganador = Tablero.ganadorHorizontalIzquierdaADerecha('X'); // FUNCIONA
                if (ganador){
                    System.out.println("El jugador 'X' ha ganado");
                    System.out.println("ganadorHorizontalIzquierdaADerecha");
                    break;
                }

                ganador = Tablero.ganadorVertical('X'); // pte
                if (ganador){
                    System.out.println("El jugador 'X' ha ganado");
                    System.out.println("ganadorVertical");
                    break;
                }
                ganador = Tablero.ganadorDiagDescendiente('X'); // pte
                if (ganador){
                    System.out.println("ganadorDiagDescendiente");
                    System.out.println("El jugador 'X' ha ganado");
                    break;
                }
                ganador = Tablero.ganadorDiagAscendiente('X'); // pte
                if (ganador){
                    System.out.println("ganadorDiagAscendiente");
                    System.out.println("El jugador 'X' ha ganado");
                    break;
                }
                turno ++;

            }else {
                Tablero.guardarFicha[Tablero.getPosFila()][Tablero.getPosColumna()] = new Ficha('0');

                Tablero.dibujarTablero();


                ganador = Tablero.ganadorHorizontalIzquierdaADerecha('0');
                if (ganador){
                    System.out.println("El jugador '0' ha ganado");
                    System.out.println("ganadorHorizontalIzquierdaADerecha");
                    break;
                }
                ganador = Tablero.ganadorVertical('0');
                if (ganador){
                    System.out.println("El jugador '0' ha ganado");
                    System.out.println("ganadorVertical");
                    break;
                }
                ganador = Tablero.ganadorDiagDescendiente('0');
                if (ganador){
                    System.out.println("El jugador '0' ha ganado");
                    System.out.println("ganadorDiagDescendiente");
                    break;
                }
                ganador = Tablero.ganadorDiagAscendiente('0');
                if (ganador){
                    System.out.println("El jugador '0' ha ganado");
                    System.out.println("ganadorDiagAscendiente");
                    break;
                }
                turno ++;
            }


        }while (ganador == false);

    }
}
