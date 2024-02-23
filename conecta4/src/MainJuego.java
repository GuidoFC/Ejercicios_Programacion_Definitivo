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
        Tablero.guardarFicha[5][0].setFicha('X');
        Tablero.guardarFicha[5][2].setFicha('X');
        Tablero.guardarFicha[5][3].setFicha('X');



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


                ganador = Tablero.ganadorHorizontalIzquierda('X'); // funciona
                if (ganador){
                    System.out.println("El jugador 'X' ha ganado");
                    System.out.println("ganadorHorizontalIzquierda");
                    break;
                }
                ganador = Tablero.ganadorHorizontalDerecha('X'); // funciona
                if (ganador){
                    System.out.println("El jugador 'X' ha ganado");
                    System.out.println("ganadorHorizontalDerecha");
                    break;
                }
                ganador = Tablero.ganadorVertical('X'); // funciona
                if (ganador){
                    System.out.println("El jugador 'X' ha ganado");
                    System.out.println("ganadorVertical");
                    break;
                }
                ganador = Tablero.ganadorDiagDescendienteIzquierdo('X'); // funciona
                if (ganador){
                    System.out.println("ganadorDiagDescendienteIzquierdo");
                    System.out.println("El jugador 'X' ha ganado");
                    break;
                }
                ganador = Tablero.ganadorDiagAscendienteDerecho('X'); // funciona
                if (ganador){
                    System.out.println("ganadorDiagAscDerech");
                    System.out.println("El jugador 'X' ha ganado");
                    break;
                }
                ganador = Tablero.ganadorDiagAscendienteIzquierdo('X'); // funciona
                if (ganador){
                    System.out.println("ganadorDiagDescIzq");
                    System.out.println("El jugador 'X' ha ganado");
                    break;
                }
                ganador = Tablero.ganadorDiagDescendienteDerecho('X'); //funciona
                if (ganador){
                    System.out.println("ganadorDiagDescDerecho");
                    System.out.println("El jugador 'X' ha ganado");
                    break;
                }
                turno ++;
            }else {
                Tablero.guardarFicha[Tablero.getPosFila()][Tablero.getPosColumna()] = new Ficha('0');

                Tablero.dibujarTablero();


                ganador = Tablero.ganadorHorizontalIzquierda('0');
                if (ganador){
                    System.out.println("El jugador '0' ha ganado");
                    break;
                }
                ganador = Tablero.ganadorHorizontalDerecha('0');
                if (ganador){
                    System.out.println("El jugador '0' ha ganado");
                    break;
                }
                ganador = Tablero.ganadorVertical('0');
                if (ganador){
                    System.out.println("El jugador '0' ha ganado");
                    break;
                }
                ganador = Tablero.ganadorDiagDescendienteIzquierdo('0');
                if (ganador){
                    System.out.println("El jugador '0' ha ganado");
                    break;
                }
                ganador = Tablero.ganadorDiagAscendienteDerecho('0');
                if (ganador){
                    System.out.println("El jugador '0' ha ganado");
                    break;
                }
                ganador = Tablero.ganadorDiagAscendienteIzquierdo('0');
                if (ganador){
                    System.out.println("El jugador '0' ha ganado");
                    break;
                }
                ganador = Tablero.ganadorDiagDescendienteDerecho('0');
                if (ganador){
                    System.out.println("El jugador '0' ha ganado");
                    break;
                }



                turno ++;
            }


        }while (ganador == false);

    }
}
