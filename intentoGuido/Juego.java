package intentoGuido;

import java.util.Scanner;


public class Juego {

    static Scanner sc;
    public static Tablero tablero1;
    public static Solucion solucion1;
    public static Mina mina1;


    public static void main(String[] args) {

        introduccionAlJuego();

        sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        elegirOpcion(opcion);

        tablero1.imprimirTablero();

    }

    public static void introduccionAlJuego(){
        System.out.println("""
                            
                            1. Nivel fácil: 
                                4 Filas 4 Columnas 1 Bomba 
                            2. Nivel intermedio:
                                10 Filas 10 Columnas 5 Bombas 
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
                Mina mina3 = new Mina(10,10, 5);
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
}
