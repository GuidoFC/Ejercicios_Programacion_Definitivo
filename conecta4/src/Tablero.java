import java.util.Arrays;
public class Tablero {

    public static Ficha [][] guardarFicha = new Ficha[6][7];

    public Tablero (int [][] tableroFichas){
        tableroFichas = this.tableroFichas;
    }

// mirar si lo puedo mejorar este método
    public static void dibujarTablero() {
        // Dibujar la primera fila
        for (int j = 0; j < 7; j++) {
            System.out.print("|   ");
        }
        System.out.println("|");

        // Dibujar las filas
        for (int i = 0; i < 6; i++) {
            // Dibujar las columnas
            for (int j = 0; j < 7; j++) {
                System.out.print("|___");
            }
            System.out.println("|");

            // Dibujar los separadores de fila
            for (int j = 0; j < 7; j++) {
                System.out.print("|   ");
            }
            System.out.println("|");
        }

        // Dibujar la última fila

    }

    public static boolean columnaLibre(int columnaElegida){
        if(guardarFicha[contadorGuardarFichaFila][columnaElegida] == null) {
            return true;
        }
        System.out.println("No se puede introducir ninguna ficha en ese tablero");
        return false;
    }

    public static boolean ganadorHorizontal(Ficha ficha){
        int sumaColumna = 1;
        char comprobacion;
        char comprobacion2;

        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                    comprobacion = guardarFicha[fila][columna].getFicha();
                    comprobacion2 = guardarFicha[fila][columna + sumaColumna].getFicha();
                    if (ficha.getFicha() == comprobacion && ficha.getFicha() == comprobacion2 ) {
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

    public static boolean ganadorVertical(Ficha ficha){
        int sumaFila = 1;
        char comprobacion;
        char comprobacion2;

        // i = columna
        for (int i = 0; i < 7; i++)  {
            // j = fila
            for (int j = 0; j < 5; j++)  {
                comprobacion = guardarFicha[j][i].getFicha();
                comprobacion2 = guardarFicha[j+ sumaFila][i].getFicha();
                if (ficha.getFicha() == comprobacion && ficha.getFicha() == comprobacion2 ) {
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

    public static boolean ganadorDiagonal(Ficha ficha){
        int sumaColumna = 1;
        char comprobacion;
        char comprobacion2;


        return false;
    }




}
