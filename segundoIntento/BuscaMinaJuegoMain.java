package segundoIntento;

import java.util.Scanner;

public class BuscaMinaJuegoMain {
    static TableroDef tableroDef1;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        // luego hacer un Swithc para elegir la dificultad
        tableroDef1 = new TableroDef(5,5,3);
        imprimirTablero();

        imrimirTableroConBombas();

        imprimirLaSolucion();

        boolean continua = true;

        while (continua){

         continua = elegirFilaColumnaParaJugar();
         if (!continua){
             System.out.println("Has perdido");
         }
         imprimirTablero();
        }

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

    // aqui hay el fallo porque no se imprime
    public static String imprimirMatrizCasilla(int fila, int columna){
        if (tableroDef1.getLaFichaDelTablero(fila,columna).esBandera()){
            return  "!";
        }
        if (tableroDef1.getLaFichaDelTablero(fila,columna).estaTapada()){
            return  "-";
        }else {
            int numeroBombas = tableroDef1.getLaFichaDelTablero(fila,columna).getNumBombasVecinas();

            return  Integer.toString(numeroBombas);
        }


    }
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

    public static boolean elegirFilaColumnaParaJugar(){
        boolean elJuegoContinua = true;
        System.out.println("Elija una fila");
        int fila = sc.nextInt() -1;
        System.out.println("Elija una columna");
        int columna = sc.nextInt() -1;



        return elJuegoContinua = tableroDef1.jugar(fila, columna);

    }
}
