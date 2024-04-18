package segundoIntento.Vista;

public class ImprimirTablero   {


    public static void menu(){
        String mensaje =
                """
                2 opciones:
                    1. Poner Bandera
                    2. Destapar Casilla
                """;
        System.out.println(mensaje);
    }


    public static void putFlag(){
        System.out.println("Elija una fila");
        int fila = sc.nextInt() -1;
        System.out.println("Elija una columna");
        int columna = sc.nextInt() -1;
        tableroDef1.getFichaTablero(fila,columna).switchFlag();
    }

    public static void printTablero() {
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
    public static void printTableroConBombas() {
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
    public static void printTableroSolucion() {
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

    public static boolean chooseRowColumn() throws Exception {
        boolean elJuegoContinua = true;
        System.out.println("Elija una fila");
        int fila = sc.nextInt() -1;
        System.out.println("Elija una columna");
        int columna = sc.nextInt() -1;



        return elJuegoContinua = tableroDef1.jugar(fila, columna);

    }
}
