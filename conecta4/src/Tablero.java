public class Tablero {

    private int [][] tableroFichas = new int[6][7];

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
}
