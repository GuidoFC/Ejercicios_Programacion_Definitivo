package segundoIntento;

import segundoIntento.Modelo.TableroDef;

import java.util.Scanner;

public class BuscaMinaJuegoMain {
    // hacer un push y comprobar que hay que mejorar mañana en clase
    static TableroDef tableroDef1;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        // luego hacer un Swithc para elegir la dificultad
        tableroDef1 = new TableroDef(10,10,10);
        imprimirTablero();

        imrimirTableroConBombas();

        imprimirLaSolucion();

        boolean continua = true;

        while (continua){


            menu();
            int option = sc.nextInt();
         switch (option){
             case 1: ponerBandera();
                     imprimirTablero();
                     break;

             case 2: continua = elegirFilaColumnaParaJugar();
                 if (!continua){
                     imprimirTablero();
                     System.out.println("Has perdido");
                     break;
                 }
                 imprimirTablero();
                 break;
             default:
                 System.out.println("Opción No Valida. Vuelva a intentarlo");
                 break;
         }



        }

    }

    public static void menu(){
        String mensaje =
                """
                2 opciones:
                    1. Poner Bandera
                    2. Destapar Casilla
                """;
        System.out.println(mensaje);
    }

    public static void ponerBandera(){
        System.out.println("Elija una fila");
        int fila = sc.nextInt() -1;
        System.out.println("Elija una columna");
        int columna = sc.nextInt() -1;
        tableroDef1.getLaFichaDelTablero(fila,columna).switchFlag();
    }


    public static void imprimirTablero() {
        System.out.println();
        for (int i = -1; i < tableroDef1.getFilaTabla(); i++) {
            for (int j = 0; j < tableroDef1.getColumnaTabla(); j++) {
                if ((i == -1)) {
                    System.out.print("\t" + (j + 1) + " ");
                    if (j == tableroDef1.getColumnaTabla() - 1) {
                        System.out.println();
                    }
                }
                if (i >= 0) {
                    if (j == 0) {
                        System.out.print(i + 1 + "\t");
                    }
                    System.out.print(imprimirMatrizCasilla(i,j) + "\t");
                    if (j == tableroDef1.getColumnaTabla() - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }


    public static String imprimirMatrizCasilla(int fila, int columna){
        if (tableroDef1.getLaFichaDelTablero(fila,columna).esBandera()){
            return  "!";
        }
        if (tableroDef1.getLaFichaDelTablero(fila,columna).esTapada()){
            return  "-";
        }else {
            int numeroBombas = tableroDef1.getLaFichaDelTablero(fila,columna).getNumBombasVecinas();

            return  Integer.toString(numeroBombas);
        }


    }
    // este método lo puedo borrar luego, sirve para mirar donde estan las bombas y ver si
    // el código funciona
    public static void imrimirTableroConBombas() {
        System.out.println();
        for (int i = -1; i < tableroDef1.getFilaTabla(); i++) {
            for (int j = 0; j < tableroDef1.getColumnaTabla(); j++) {
                if ((i == -1)) {
                    System.out.print("\t" + (j + 1) + " ");
                    if (j == tableroDef1.getColumnaTabla() - 1) {
                        System.out.println();
                    }
                }
                if (i >= 0) {
                    if (j == 0) {
                        System.out.print(i + 1 + "\t");
                    }
                    if (tableroDef1.getLaFichaDelTablero(i,j).esMina()){
                        System.out.print( "x" + "\t");
                    }else {
                        System.out.print("0" + "\t");
                    }

                    if (j == tableroDef1.getColumnaTabla() - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }

    // este método lo puedo borrar luego, sirve para mirar donde estan las bombas y ver si
    // el código funciona
    public static void imprimirLaSolucion() {
        System.out.println();
        for (int i = -1; i < tableroDef1.getFilaTabla(); i++) {
            for (int j = 0; j < tableroDef1.getColumnaTabla(); j++) {
                if ((i == -1)) {
                    System.out.print("\t" + (j + 1) + " ");
                    if (j == tableroDef1.getColumnaTabla() - 1) {
                        System.out.println();
                    }
                }
                if (i >= 0) {
                    if (j == 0) {
                        System.out.print(i + 1 + "\t");
                    }
                    System.out.print(tableroDef1.getLaFichaDelTablero(i,j).getNumBombasVecinas() + "\t");
                    if (j == tableroDef1.getColumnaTabla() - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }

    public static boolean elegirFilaColumnaParaJugar() throws Exception {
        boolean elJuegoContinua = true;
        System.out.println("Elija una fila");
        int fila = sc.nextInt() -1;
        System.out.println("Elija una columna");
        int columna = sc.nextInt() -1;



        return elJuegoContinua = tableroDef1.jugar(fila, columna);

    }
}
