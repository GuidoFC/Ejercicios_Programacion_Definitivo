package intentoGuido;

import java.util.Scanner;


public class JuegoMain {

    static Scanner sc = new Scanner(System.in);
    public static Tablero tablero1;
    public static Solucion solucion1;
    public static Mina mina1;


    public static void main(String[] args) {

        introduccionAlJuego();


        int opcion = sc.nextInt();
        elegirOpcion(opcion);

        // borrar
        tablero1.imprimirTablero();
        System.out.println();
        solucion1.imprimirTableroSolucion();
        System.out.println();
        mina1.imprimirTableroMina();
        // borrar

        juegar();

//fin del main
    }

    public static void introduccionAlJuego(){
        System.out.println("""
                            
                            1. Nivel fácil: 
                                4 Filas 4 Columnas 1 Bomba 
                            2. Nivel intermedio:
                                10 Filas 10 Columnas 30 Bombas 
                            3. Nivel Dios
                                20 Filas 20 Columnas 10 Bombas
                            Eliga la dificultad del juego:
                            """);
        System.out.println();
    }

    public static void elegirOpcion(int opcion){
        switch (opcion){
            case 1:
                System.out.println("Ha seleccionado el nivel fácil");
                Tablero tablero2= new Tablero(4,4);
                tablero1 = tablero2;
                Mina mina2 = new Mina(4,4, 1);
                mina1 = mina2;
                Solucion solucion2 = new Solucion(4,4);
                solucion1 = solucion2;
                break;
            case 2:
                System.out.println("Ha seleccionado el nivel intermidio");
                Tablero tablero3= new Tablero(10,10);
                tablero1 = tablero3;
                Mina mina3 = new Mina(10,10, 30);
                mina1 = mina3;
                Solucion solucion3 = new Solucion(10,10);
                solucion1 = solucion3;
                break;
            default:
                System.out.println("Estamos en proceso de crear el modo Dios," +
                        "\n perdone las molestias");
                break;
        }
        rellenarTodasFichas();
    }

    public static void rellenarTodasFichas(){
        tablero1.RellenarFicha();

        mina1.RellenarFicha();
        mina1.insertarBombas();

        solucion1.RellenarFicha();
        solucion1.crearPlantillaSolucion(mina1);
    }

    public static void juegar(){
        int numBombas = mina1.getNumBombas();
        int bombasEcontradas = 0;
        while (bombasEcontradas <= numBombas){
            tablero1.imprimirTablero();
            System.out.println();

            System.out.println("Fila: ");
            int fila = sc.nextInt() -1;

            System.out.println("Columna: ");
            int columna = sc.nextInt() -1;

            boolean gameOver = comprobar (fila, columna);
            if (gameOver){
                tablero1.imprimirTablero();
                System.out.println("GAME OVER");
                break;
            }
            bombasEcontradas ++;

        }

    }

    public static boolean comprobar(int fila, int columna){
        if (mina1.getMinaFichaConcreta(fila,columna) == 'x'){
            System.out.println("Has perdido, has detonado una bomba");
            mina1.motrarTodaslasBombas(tablero1);

            return true;
        }else {
            // quiero pasar de un valor numerico a un char
            // pasar el valor de solución a Tablero
            tablero1.setTableroFicha(fila,columna,solucion1.transformarUnIntaChar(fila,columna));
            return false;
        }

    }

}
