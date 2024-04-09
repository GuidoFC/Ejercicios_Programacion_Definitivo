package intentoGuido;

public class Solucion extends Ficha {
    private int [][] solucionFicha;

    public Solucion(int fila, int columna){
        solucionFicha = new int[fila][columna];
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
                            (i-k < this.solucionFicha.length ) &&
                            (j-l < this.solucionFicha[0].length) ){
                            if (mina1.getMinaFichaConcreta(i,j) != 'x'){
                                if (mina1.getMinaFichaConcreta(i+k,j+l) == 'x'){
                                    this.solucionFicha[i][j] ++;
                                }
                            }
                        }

                    }

                }

            }

        }
    }
}
