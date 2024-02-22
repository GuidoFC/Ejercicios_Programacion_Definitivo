import java.util.Arrays;

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
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("| " + guardarFicha[i][j].getFicha() + " |");
            }
            System.out.println();
        }


    }

    public static boolean comprobarSiColumnaLibre(int columnaElegida){
        for (int i = 5; i >= 0; i--) {
            if(guardarFicha[i][columnaElegida] == null) {
                posColumna = i;
                posFila = columnaElegida;
                return true;
            }
        }
        System.out.println("No se puede introducir ninguna ficha en esa columna");
        return false;
    }

    public static boolean ganadorHorizontal(char ficha){
        int sumaColumna = 1;
        char comprobacion;
        char comprobacion2;

        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                    comprobacion = guardarFicha[fila][columna].getFicha();
                    comprobacion2 = guardarFicha[fila][columna + sumaColumna].getFicha();
                    if (ficha == comprobacion && ficha == comprobacion2 ) {
                        sumaColumna++;
                        if (sumaColumna == 4){
                            return true;
                        }
                    }else {
                        sumaColumna = 1;
                    }
            }
        }
        return false;
    }

    public static boolean ganadorVertical(char ficha){
        // si introduzco una ficha y obtengo su posicion es más facil hacer comprobacion de arriba a abajo
        // por solo una columna
        int sumaFila = 1;
        char comprobacion;
        char comprobacion2;

        // i = columna
        for (int i = 0; i < 7; i++)  {
            // j = fila
            for (int j = 0; j < 5; j++)  {
                comprobacion = guardarFicha[j][i].getFicha();
                comprobacion2 = guardarFicha[j+ sumaFila][i].getFicha();
                if (ficha == comprobacion && ficha == comprobacion2 ) {
                    sumaFila++;
                    if (sumaFila == 4){
                        return true;
                    }
                }else {
                    sumaFila = 1;
                }
            }
        }
        return false;
    }


    public static boolean ganadorDiagAscIzq(char ficha){
        int variableTemporalFila = posFila;
        int variableTemporalColumna = posColumna;

        int modColumna = -1;
        int modFila = -1;
        char comprobacion;
        char comprobacion2;

        // seguramente tengo que hacer un Try and Catch por si no se puede ejecutar el código
        // ponga que no dse ha ganado y el programa tire.
        if (variableTemporalFila - 3 <= 0 || variableTemporalColumna - 3 <= 0){
            return false;
        }
        for (int i = variableTemporalFila; i < 0; i--) {
            for (int j = variableTemporalColumna; j < 0; j--) {
                comprobacion = guardarFicha[i][j].getFicha();
                comprobacion2 = guardarFicha[i + modFila][j + modColumna].getFicha();
                if (ficha == comprobacion && ficha == comprobacion2 ) {
                    modColumna --;
                    modFila --;
                    if (modColumna == -4){
                        return true;
                    }
                }else {
                    modColumna = -1;
                    modFila = -1;
                }
            }
        }
        return false;
    }


    public static boolean ganadorDiagAscDerech(char ficha){
        int variableTemporalFila = posFila;
        int variableTemporalColumna = posColumna;

        int modColumna = 1;
        int modFila = -1;
        char comprobacion;
        char comprobacion2;

        // seguramente tengo que hacer un Try and Catch por si no se puede ejecutar el código
        // ponga que no dse ha ganado y el programa tire.
        if (variableTemporalFila - 3 < 0 || variableTemporalColumna +3 > 7){
            return false;
        }
        for (int i = variableTemporalFila; i < 0; i--) {
            for (int j = variableTemporalColumna; j < 6; j++) {
                comprobacion = guardarFicha[i][j].getFicha();
                comprobacion2 = guardarFicha[i + modFila][j + modColumna].getFicha();
                if (ficha == comprobacion && ficha == comprobacion2 ) {
                    modColumna ++;
                    modFila --;
                    if (modColumna == -4){
                        return true;
                    }
                }else {
                    modColumna = 1;
                    modFila = -1;
                }
            }
        }
        return false;
    }


    public static boolean ganadorDiagDescIzq(char ficha){
        int variableTemporalFila = posFila;
        int variableTemporalColumna = posColumna;

        int modColumna = -1;
        int modFila = 1;
        char comprobacion;
        char comprobacion2;

        // seguramente tengo que hacer un Try and Catch por si no se puede ejecutar el código
        // ponga que no dse ha ganado y el programa tire.
        if (variableTemporalFila + 3 > 6 || variableTemporalColumna -4 < 0){
            return false;
        }
        for (int i = variableTemporalFila; i < 6; i++) {
            for (int j = variableTemporalColumna; j > 0; j--) {
                comprobacion = guardarFicha[i][j].getFicha();
                comprobacion2 = guardarFicha[i + modFila][j + modColumna].getFicha();
                if (ficha == comprobacion && ficha == comprobacion2 ) {
                    modColumna ++;
                    modFila --;
                    if (modColumna == -4){
                        return true;
                    }
                }else {
                    modColumna = -1;
                    modFila = -1;
                }
            }
        }
        return false;
    }

    public static boolean ganadorDiagDescDerecho(char ficha){
        int variableTemporalFila = posFila;
        int variableTemporalColumna = posColumna;

        int modColumna = 1;
        int modFila = 1;
        char comprobacion;
        char comprobacion2;

        // seguramente tengo que hacer un Try and Catch por si no se puede ejecutar el código
        // ponga que no dse ha ganado y el programa tire.
        if (variableTemporalFila + 3 > 6 || variableTemporalColumna +3 > 7){
            return false;
        }
        for (int i = variableTemporalFila; i > 6; i++) {
            for (int j = variableTemporalColumna; j > 0; j++) {
                comprobacion = guardarFicha[i][j].getFicha();
                comprobacion2 = guardarFicha[i + modFila][j + modColumna].getFicha();
                if (ficha == comprobacion && ficha == comprobacion2 ) {
                    modColumna ++;
                    modFila ++;
                    if (modColumna == 4){
                        return true;
                    }
                }else {
                    modColumna = 1;
                    modFila = 1;
                }
            }
        }
        return false;
    }






}
