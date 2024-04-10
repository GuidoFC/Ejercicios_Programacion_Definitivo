package segundoIntento;

public class BuscaMinaJuegoMain {
    static TableroDef tableroDef1;
    public static void main(String[] args) {

        tableroDef1 = new TableroDef(10,10,30);

        tableroDef1.RellenarTableroAlInicio();
        imprimirTablero();
    }
    public static void imprimirTablero() {
        System.out.println();
        for (int i = -1; i < tableroDef1.numFilas(); i++) {
            for (int j = 0; j < tableroDef1.numColumnas(); j++) {
                if ((i == -1)) {
                    System.out.print("\t" + (j + 1) + " ");
                    if (j == tableroDef1.numColumnas() - 1) {
                        System.out.println();
                    }
                }
                if (i >= 0) {
                    if (j == 0) {
                        System.out.print(i + 1 + "\t");
                    }
                    System.out.print(tableroDef1.getTablero(i,j).getCasillaVisible() + "\t");
                    if (j == tableroDef1.numColumnas() - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }
}
