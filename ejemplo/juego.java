package ejemplo;

import java.util.Scanner;

public class juego {
    // La palabra clave static significa que esta variable es compartida por todas las instancias
    // de la clase en la que está declarada.
    static char[][] tablero;
    // representar un tablero de un juego utilizando una variable char[][] en Java
    // Es un ARRAY DE char
    // Por ejemplo, usaremos 'T' para torres, 'C' para caballos, etc.
    // tablero[0] = new char[] {'T', 'C', 'A', 'D', 'R', 'A', 'C', 'T'}; T-> Torre C-> Caballo
    // tablero[1] = new char[] {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'};
    static char[][] minas;
    // fijate que la solución en un ARRAY de numeros. Cuando esta vacio
    static int[][] solucion;
    static Scanner sc;
    public static void main(String[] args) {

        // Mirar como usar el Scanner de forma general creandolo una variable
        // stati fuera del main ?
        sc = new Scanner(System.in);

        System.out.println("Seleccione el nivel:\n1. Principiante\n2. Intermedio\n3. Experto");
        int nivel = sc.nextInt();

        switch (nivel){
            case 1:
                // esto es un objeto que crea de la Clase Tablero
                iniciarTablero(3, 3, 1);
                break;
            case 2:
                iniciarTablero(6, 6, 10);
                break;
            case 3:
                iniciarTablero(10, 10, 30);
                break;
        }

        // primero se elige el nivel y hay se crean las bombas. luego creamos el juego con generarSolucion
        generarSolucion();
        jugar(1);
        // fin del main
    }

    public static void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                // esa "t sirve para tabular"
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void iniciarTablero(int filas, int columnas, int totalMinas) {
        // le digo cuantas filas y columnas pueden tener como maximo
        // mi tables, minas y solución.
        // ejemplo
        // tablero[0] = new char[] {'T', 'C', 'A', 'D', 'R', 'A', 'C', 'T'}; T-> Torre C-> Caballo
        tablero = new char[filas][columnas];
        minas = new char[filas][columnas];
        solucion = new int[filas][columnas];

//        relleno el tablero de -
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = '-';
            }
        }

        int contadorMinas = 0;

        while (contadorMinas < totalMinas) {
            //  si filas es 10, como en tu caso, la expresión int x = (int) (Math.random() * filas);
            //  generará un número aleatorio entero entre 0 y 9, que será almacenado en la variable x.
            int x = (int) (Math.random() * filas);
            int y = (int) (Math.random() * columnas);
            if (minas[x][y] == '\u0000') {
                // en un principio la celda de mina esta vacia, si es asi se sustituira por una X
                // las minas tendran valor "X"
                // el tablero sera con "-"3
                minas[x][y] = 'X';
                // ojo fijate que el contador lo ha puesto dentro porque si no cumple la condición lo tiene
                // que volver a hacer
                contadorMinas++;
            }
        }
    }

    public static void generarSolucion() {
        // filas, recuerda que estamos en un ARRAY DE CHAR
        // tablero[1] = new char[] {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'};
        for (int i = 0; i < minas.length; i++) {
            // columnas
            for (int j = 0; j < minas[0].length; j++) {
                // para mirar los vecinos de filas
                for (int k = -1; k <= 1; k++) {
                    // para mirar los vecinos de columnas
                    for (int l = -1; l <= 1; l++) {
                        if ((i + k >= 0) && (j + l >= 0) && (i + k < minas.length) && (j + l < minas[0].length)) {
                            // tengo que entender porque hay un -1

                            // en esta posición no hay mina
                            if (minas[i][j] != 'X') {
                                if (minas[i + k][j + l] == 'X') {
                                    // voy sumando cuantas minas hay alrededor
                                    solucion[i][j]++;
                                }
                            } else {
                                // si hay una mina, en la solución poner -1, por que? sera para que
                                // más adelante esto no se muestre ??
                                solucion[i][j] = -1;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void jugar(int cantidadMinas) {
        boolean completado = false;
        do {
            System.out.print("Ingrese fila: ");
            // de esta forma controla que si ingreso la fila 1 visualmente sea el 1
            // ya que nosotros empezamos a contar en 1 y no en cero.
            int x = sc.nextInt() - 1;
            System.out.print("Ingrese columna: ");
            int y = sc.nextInt() - 1;

            if (minas[x][y] == 'X') {
                System.out.println("Perdiste pendejo!");
                for (int i = 0; i < minas.length; i++) {
                    for (int j = 0; j < minas[0].length; j++) {
                        if (minas[i][j] == 'X') {
                            // tranforma los guiones en bomba
                            tablero[i][j] = 'X';
                        }
                    }
                }
                mostrarTablero();
                break;
            } else {
                // lo que tengo que hacer es transformar ese número en un caracter char para poderlo
                // copiar en mi ARRAY TABLERO
                tablero[x][y] = (solucion[x][y] + "").charAt(0);
                mostrarTablero();
            }

            boolean victoria = verficarVictoria(cantidadMinas);

            if (victoria) {
                System.out.println("Ganaste!");
                for (int i = 0; i < minas.length; i++) {
                    for (int j = 0; j < minas[0].length; j++) {
                        if (minas[i][j] == 'X') {
                            tablero[i][j] = '*';
                        }
                    }
                }
                mostrarTablero();
                // para salir del bucle porque el juego ha terminado
                break;
            }
        } while (!completado);
    }

    public static boolean verficarVictoria(int cantidadMinas) {
        int posiblesMinas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == '-') {
                    posiblesMinas++;
                }
            }
        }
        // lo que hace es que en un principio las posibles Minas seran 100
        // y minas hay 30. Cuando ese valor coincida esto me devolvera TRUE
        if (posiblesMinas == cantidadMinas) {
            return true;
        }
        return false;
            }
}

