package segundoIntento.Vista;

import java.util.Scanner;

public class ImprimirTablero  {

    static Scanner sc = new Scanner(System.in);

    // no se como conectar la parte de la Vista con la Logica
        // tengo que crear un objeto de la clase ImprimirTablero
        // en la clase Juego que esta en la carpeta de Lógica

    public void menu(){
        String mensaje =
                """
                2 opciones:
                    1. Poner Bandera
                    2. Destapar Casilla
                """;
        System.out.println(mensaje);
    }


    public static void putFlag(){
        // reutilizar método de introducirFila y introducirColumna
        System.out.println("Elija una fila");
        int fila = sc.nextInt() -1;
        System.out.println("Elija una columna");
        int columna = sc.nextInt() -1;

        tableroDef.getFichaTablero(fila,columna).switchFlag();
    }

    public void printTablero() {
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
                    System.out.print(printMatrizCasilla(i,j) + "\t");
                    if (j == tableroDef1.getColumnaTabla() - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }


    public static String printMatrizCasilla(int fila, int columna){
        if (tableroDef1.getFichaTablero(fila,columna).esBandera()){
            return  "!";
        }
        if (tableroDef1.getFichaTablero(fila,columna).esTapada()){
            return  "-";
        }else {
            int numeroBombas = tableroDef1.getFichaTablero(fila,columna).getNumBombasVecinas();

            return  Integer.toString(numeroBombas);
        }


    }
    // este método lo puedo borrar luego, sirve para mirar donde estan las bombas y ver si
    // el código funciona
    public  void printTableroConBombas() {
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
                    if (tableroDef1.getFichaTablero(i,j).esMina()){
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
    public  void printTableroSolucion() {
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
                    System.out.print(tableroDef1.getFichaTablero(i,j).getNumBombasVecinas() + "\t");
                    if (j == tableroDef1.getColumnaTabla() - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }

    public  boolean chooseRowColumn(int rowMAx, int columnMAx ) throws Exception {
        boolean elJuegoContinua = true;

        int fila = introducirFila(rowMAx);
        int column = introducirColumna(columnMAx);

        return elJuegoContinua = tableroDef1.jugar(fila, columna);

    }


    public  int introducirFila(int rowMax){
        // comprobamos que se ha introducido correctamente la fila
        int fila;
        do{
            System.out.println("Elija una fila entre 0 y " + rowMax);
            System.out.println("Elija una fila");
            fila = sc.nextInt() - 1;
        }while (   (fila < 0) || (fila > rowMax)   );
        return fila;
    }

    public  int introducirColumna(int columnMax ){
        // comprobamos que se ha introducido correctamente columna
        int columna;
        do{
            System.out.println("Elija una columna entre 0 y " + columnMax);
            System.out.println("Elija una columna");
            columna = sc.nextInt() - 1;
        }while (  (columna < 0) || (columna > columnMax)  );

        return columna;
    }
}
