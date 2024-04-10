package intentoGuido;

public class Solucion extends Ficha {
    private int [][] solucionFicha;

    public Solucion(int fila, int columna){
        solucionFicha = new int[fila][columna];
    }

    public int getSolucionFicha(int fila, int columna) {
        return solucionFicha[fila][columna];
    }

    public char transformarUnIntaChar(int fila, int columna){
        // sup importante como
        char transformacion = (char) ('0' + getSolucionFicha(fila,columna));
        return transformacion;
    }

    public  void RellenarFicha (){
        for (int i = 0; i < solucionFicha.length; i++) {
            for (int j = 0; j < solucionFicha[0].length; j++) {
                solucionFicha[i][j] = 0;
            }
        }
    }

    public void crearPlantillaSolucion(Mina mina1){
        for (int i = 0; i < this.solucionFicha.length; i++) {
            for (int j = 0; j < this.solucionFicha[0].length; j++) {
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <=1 ; l++) {

                        if ((i+k >= 0) && (j+l >= 0) &&
                            (i+k < this.solucionFicha.length ) &&
                            (j+l < this.solucionFicha[0].length) ){
                            if (mina1.getMinaFichaConcreta(i,j) != 'x'){
                                int a = i+k;
                                int b = j+l;
                                if (mina1.getMinaFichaConcreta(a,b) == 'x'){
                                    this.solucionFicha[i][j] ++;
                                }
                            }if (mina1.getMinaFichaConcreta(i,j) == 'x'){
                                this.solucionFicha[i][j] =-1;
                            }
                        }

                    }

                }

            }

        }
    }

    public void imprimirTableroSolucion() {
        for (int i = -1; i < solucionFicha.length; i++) {
            for (int j = 0; j < solucionFicha[0].length; j++) {
                if ((i == -1)) {
                    System.out.print("\t" + (j + 1) + " ");
                    if (j == solucionFicha[0].length - 1) {
                        System.out.println();
                    }
                }
                if (i >= 0) {
                    if (j == 0) {
                        System.out.print(i + 1 + "\t");
                    }
                    System.out.print(solucionFicha[i][j] + "\t");
                    if (j == solucionFicha[0].length - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }





}
