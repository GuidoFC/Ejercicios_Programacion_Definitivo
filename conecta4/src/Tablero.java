public class Tablero {

    public static Ficha [][] guardarFicha = new Ficha[6][7];
    private static int posColumna;
    private static int posFila;

    public Tablero (Ficha [][] guardarFicha){
        this.guardarFicha = guardarFicha ;
    }

    public static int getPosColumna() {
        return posColumna;
    }

    public static int getPosFila() {
        return posFila;
    }

    public static void setGuardarFicha(Ficha[][] guardarFicha) {
        Tablero.guardarFicha = guardarFicha;
    }

    // mirar si lo puedo mejorar este método
    public static void inicializarJuego() {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                guardarFicha[i][j] = new Ficha(' ');

            }
        }
    }

    public static void dibujarTablero(){
        System.out.println(" ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 0){
                    System.out.print(i + "| " + guardarFicha[i][j].getFicha() + " |");
                }else {
                    System.out.print("| " + guardarFicha[i][j].getFicha() + " |");
                }

            }
            System.out.println();
        }
        for (int i = 0; i < 7; i++) {
            if (i == 0){
                char a = ' ';

                System.out.print(a + "| " +i+ " |");
            }else {
                System.out.print("| " +i+ " |");
            }

        }
        System.out.println(" ");
        System.out.println(" ");

    }

    public static boolean comprobarSiColumnaLibre(int columnaElegida){
        char vacio = ' ';

        for (int fila = 5; fila >= 0; fila--) {
            char fichaIntroducida =  guardarFicha[fila][columnaElegida].getFicha();
            if(fichaIntroducida == vacio) {
                posColumna = columnaElegida;
                posFila = fila;
                return true;
            }
        }
        System.out.println("No se puede introducir ninguna ficha en esa columna");
        return false;
    }

    public static boolean ganadorHorizontalDerecha(char ficha){
        int contador = 0;
        char comprobacion;
        char comprobacion2;

        comprobacion = guardarFicha[posFila][posColumna].getFicha();

        for (int columna = 1; columna <= 6; columna++) {
                if (columna + posColumna <= 6){
                    comprobacion2 = guardarFicha[posFila][columna + posColumna].getFicha();
                    if (comprobacion  == comprobacion2) {
                        contador++;
                        if (contador == 3){
                            return true;
                        }
                    }else {
                        contador = 0;

                    }
                }else {
                    return false;
                }
        }return false;

    }

    // este método ganadorHorizontalIzquierda funciona
    public static boolean ganadorHorizontalIzquierda(char ficha){
        int contador = 0;
        char comprobacion;
        char comprobacion2;

        comprobacion = guardarFicha[posFila][posColumna].getFicha();

        for (int columna = posColumna; columna >= 0; columna--) {
            if (posColumna - columna   >= 0){
                comprobacion2 = guardarFicha[posFila][posColumna - columna].getFicha();
                if (comprobacion  == comprobacion2) {
                    contador++;
                    if (contador == 4){
                        return true;
                    }
                }else {
                    contador = 0;

                }
            }
        }return false;

    }

    public static boolean ganadorVertical(char ficha){
        // mirar siempre hacia abajo para ver si se ha ganado
        int contador = 0;
        char comprobacion;
        char comprobacion2;

        comprobacion = guardarFicha[posFila][posColumna].getFicha();

        for (int fila = 1 ; fila <= 5; fila++) {
            if (fila + posFila <= 5) {
                comprobacion2 = guardarFicha[fila + posFila][posColumna].getFicha();
                if (comprobacion == comprobacion2) {
                    contador++;
                    if (contador == 3) {
                        return true;
                    }
                }
            }
        }return false;
    }




    public static boolean ganadorDiagDescendienteIzquierdo(char ficha){
        // a las filas sumo
        // a las columnas resto
        int contador = 0;
        char comprobacion;
        char comprobacion2;

        comprobacion = guardarFicha[posFila][posColumna].getFicha();

        if (posFila + 1 > 5 || posColumna - 1 < 0){
            return false;
        }
        // tengo que hacer que los 2 for sean simultaneos
        for (int i = 1; i <= 5; i++) {
            comprobacion2 = guardarFicha[posFila + i][posColumna - i].getFicha();
            if (comprobacion == comprobacion2 ) {
                contador ++;
                if (contador == 3){
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }


    public static boolean ganadorDiagAscendienteDerecho(char ficha){
        // a las filas resto
        // a las columnas sumo
        int contador = 0;
        char comprobacion;
        char comprobacion2;

        comprobacion = guardarFicha[posFila][posColumna].getFicha();

        if (posFila - 1 < 0 || posColumna + 1 > 6){
            return false;
        }
        for (int i = 1; i <= 5; i++) {
            comprobacion2 = guardarFicha[posFila - i][posColumna + i].getFicha();
            if (comprobacion == comprobacion2 ) {
                contador ++;
                if (contador == 3){
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }




    public static boolean ganadorDiagAscendienteIzquierdo(char ficha){
        // a las filas resto
        // a las columnas resto
        int contador = 0;
        char comprobacion;
        char comprobacion2;

        comprobacion = guardarFicha[posFila][posColumna].getFicha();

        for (int i = 1; i <= 5; i++) {
            if (posFila - i < 0 || posColumna - i < 0){
                return false;
            }else {
                comprobacion2 = guardarFicha[posFila - i][posColumna - i].getFicha();
                if (comprobacion == comprobacion2) {
                    contador++;
                    if (contador == 3) {
                        return true;
                    }
                }
            }


        }
        return false;
    }

    public static boolean ganadorDiagDescendienteDerecho(char ficha){
        // a las filas suma
        // a las columnas suma
        int contador = 0;
        char comprobacion;
        char comprobacion2;

        comprobacion = guardarFicha[posFila][posColumna].getFicha();

        if (posFila + 1 >= 5 || posColumna + 1 >= 6){
            return false;
        }
        for (int i = 1; i <= 5; i++) {
            comprobacion2 = guardarFicha[posFila + i][posColumna + i].getFicha();
            if (comprobacion == comprobacion2 ) {
                contador ++;
                if (contador == 3){
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }






}
