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


    // este método solo hare una que mirara de izq a derecha
    public static boolean ganadorHorizontalIzquierdaADerecha(char ficha){
        int contador = 0;
        char comprobacion;
        char comprobacion2;

        comprobacion = guardarFicha[posFila][posColumna].getFicha();
        for (int columna = 0; columna <= 6; columna++) {
                comprobacion2 = guardarFicha[posFila][columna].getFicha();
                if (comprobacion  == comprobacion2) {
                    contador++;
                    if (contador == 4){
                        return true;
                    }
                }else {
                    contador = 0;

                }
        }
        return false;

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




    public static boolean ganadorDiagDescendiente(char ficha){
        // primero hago que la ficha se me vaya hacia la izquierda y hacia arriba
            // crear método

        int arribaFila = posFila;
        int izquierdaColumna = posColumna;
        do {
            if (arribaFila -1 >= 0 && izquierdaColumna - 1 >= 0){
                arribaFila --;
                izquierdaColumna --;
            }else {
                break;
            }
        }while (arribaFila > -1);


        // y luego empiezo a mirar si hay ganador de forma descendiente de izquierda a Derecha
        int contador = 0;
        char comprobacion;
        char comprobacion2;

        comprobacion = guardarFicha[posFila][posColumna].getFicha();
        // mirar la lógica que los 2 for no van al mismo compaso

        do {
            comprobacion2 = guardarFicha[arribaFila][izquierdaColumna].getFicha();
                if (comprobacion == comprobacion2){
                    contador ++;
                    if (contador == 4){
                        return true;
                    }
                }else {
                    contador =0;
                }
            if (arribaFila + 1 <= 5 && izquierdaColumna + 1 <= 6) {
                arribaFila++;
                izquierdaColumna++;
            }else{
                return false;
            }

        }while (arribaFila > -1);

        return false;

    }


    public static boolean ganadorDiagAscendiente(char ficha){
        // primero hago que la ficha se me vaya hacia la izquierda(columna) y hacia abajo (fila 5)
        // crear método

        int arribaFila = posFila;
        int izquierdaColumna = posColumna;
        do {
            if (arribaFila +1 <= 5 && izquierdaColumna - 1 >= 0){
                arribaFila ++;
                izquierdaColumna --;
            }else {
                break;
            }
        }while (arribaFila > -1);


        // y luego empiezo a mirar si hay ganador de forma descendiente de izquierda a Derecha
        int contador = 0;
        char comprobacion;
        char comprobacion2;

        comprobacion = guardarFicha[posFila][posColumna].getFicha();
        // mirar la lógica que los 2 for no van al mismo compaso

        do {
            comprobacion2 = guardarFicha[arribaFila][izquierdaColumna].getFicha();
            if (comprobacion == comprobacion2){
                contador ++;
                if (contador == 4){
                    return true;
                }
            }else {
                contador =0;
            }
            if (arribaFila - 1 >= 0 && izquierdaColumna + 1 <= 6) {
                arribaFila--;
                izquierdaColumna++;
            }else{
                return false;
            }

        }while (arribaFila > -1);

        return false;

    }
}
