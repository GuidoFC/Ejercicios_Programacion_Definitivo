import java.util.*;
import java.util.Random;
public class PiedraPapelTijera {

    static String eleccionDefinitiva;
    static String humanoEleccion [] = {"Piedra", "Papel", "Tijeras"};
    static int numHumano;
    static String ordenadorEleccion [] = {"Piedra", "Papel", "Tijeras"};
    static int numOrdenador;
    static int contador = 0;
    static int ganaOrdenador = 0;
    static int ganaHumano =  0;

    // hacemos un comentario, y luego me movere de rama. para hacer otro comentario en la rama Banco

    public static void main(String[] args) {


        while (contador <=2){

            eleccioJugador();
            eleccioComputadora();
            determinarGuanyador();
            if (contador == 3){
                System.out.println("Game Over");
            }
        }



    }

    public static void eleccioJugador(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba una de las siguientes opciones:\n" +
                "1. Piedra\n" + "2. Papel\n" + "3. Tijeras\n"  );
        String previaEleccion = sc.nextLine();



        // Si s’introdueix algun altra text,
        // es mostra un missatge d’error i es segueix demanant
        // que s’indiqui la opció elegida fins que la paraula sigui
        // “pedra”, “paper”, o “tisores”

        if ((previaEleccion.equals("Piedra")) || (previaEleccion.equals("Papel")) || (previaEleccion.equals("Tijeras"))){
            System.out.println("Usted ha elegido: " + previaEleccion);
            eleccionDefinitiva = previaEleccion;
        } else {
            System.out.println("Error en la palabara introducida. Tiene que escribir:");
            System.out.println("Piedra, Papel o Tijeras, con la primera letra en Mayuscula");
            System.out.println();
            eleccioJugador();
        }
        for (int i = 0; i < ordenadorEleccion.length; i++) { // Se puede poner dentro del If un for?
            if (eleccionDefinitiva.equals(ordenadorEleccion[i])){
                numHumano = i;
                System.out.println("Imprime el codigo?" + "El numero de la Array es: " + numHumano);
                System.out.println();
            }
        }

    }
    public static void eleccioComputadora(){
        int numero = (int)(Math.random()*3); // OJO: Con la multiplicación del (INT) hacemos
        // que el numero que nos da que esta en float, es decir, nos da
        // Estos valores de 0.0 a 2.0 --> Ahora nos da 0, 1 y 2

        numOrdenador = numero;
        System.out.println("El ordenador ha elegido: " + ordenadorEleccion[numOrdenador]);
        System.out.println("Imprime el codigo?" + "El numero de la Array es: " + numOrdenador);
        System.out.println();

    }

    public static void determinarGuanyador(){
//Les eleccions del jugador i la computadora es passen com a paràmetres
//Determina si el jugador guanya, perd o empata, seguint les normes del joc
//Mostra el resultat per pantalla

        // {"Piedra", "Papel", "Tijera"} Ordenador
        // {"Piedra", "Papel", "Tijera"} Humano

        if (contador < 3) {
            if ((numOrdenador == numHumano)) {
                System.out.println("Habeis empatado, 1 punto a cada uno");
                System.out.println();
                contador++;
                ganaOrdenador++;
                ganaHumano++;
                System.out.println("El marcador es:");
                System.out.println("El ordenador tiene: " + ganaOrdenador + " puntos");
                System.out.println("Usted tiene: " + ganaHumano + " puntos");
                System.out.println();
            }
            if (numOrdenador == 0  && numHumano == 1) { // Piedra - Papel
                System.out.println("Enhorabuena, has ganado un punto");
                System.out.println();
                ganaHumano++;
                contador++;
                System.out.println("El marcador es:");
                System.out.println("El ordenador tiene: " + ganaOrdenador + " puntos");
                System.out.println("Usted tiene: " + ganaHumano + " puntos");
                System.out.println();
            }
            // {"Piedra", "Papel", "Tijera"} Ordenador
            // {"Piedra", "Papel", "Tijera"} Humano
            if (numOrdenador == 0 && numHumano == 2) { // Piedra - Tijera
                System.out.println("Has perdido, un punto para el ordenador");
                System.out.println();
                ganaOrdenador++;
                contador++;
                System.out.println("El marcador es:");
                System.out.println("El ordenador tiene: " + ganaOrdenador + " puntos");
                System.out.println("Usted tiene: " + ganaHumano + " puntos");
                System.out.println();
            }
            if (numOrdenador == 1 && numHumano == 0) { // Papel - Piedra
                System.out.println("Has perdido, un punto para el ordenador");
                System.out.println();
                ganaOrdenador++;
                contador++;
                System.out.println("El marcador es:");
                System.out.println("El ordenador tiene: " + ganaOrdenador + " puntos");
                System.out.println("Usted tiene: " + ganaHumano + " puntos");
                System.out.println();
            }
            if (numOrdenador == 1 && numHumano == 2) { // Papel - Tijera
                System.out.println("Enhorabuena, has ganado un punto");
                System.out.println();
                ganaHumano++;
                contador++;
                System.out.println("El marcador es:");
                System.out.println("El ordenador tiene: " + ganaOrdenador + " puntos");
                System.out.println("Usted tiene: " + ganaHumano + " puntos");
                System.out.println();
            }
            // {"Piedra", "Papel", "Tijera"} Ordenador
            // {"Piedra", "Papel", "Tijera"} Humano
            if (numOrdenador == 2 && numHumano == 0) { // Tijera - Piedra
                System.out.println("Enhorabuena, has ganado un punto");
                System.out.println();
                ganaHumano++;
                contador++;
                System.out.println("El marcador es:");
                System.out.println("El ordenador tiene: " + ganaOrdenador + " puntos");
                System.out.println("Usted tiene: " + ganaHumano + " puntos");
                System.out.println();
            }
            if (numOrdenador == 2 && numHumano == 1) { // Tijera - Papel
                System.out.println("Has perdido, un punto para el ordenador");
                System.out.println();
                ganaOrdenador++;
                contador++;
                System.out.println("El marcador es:");
                System.out.println("El ordenador tiene: " + ganaOrdenador + " puntos");
                System.out.println("Usted tiene: " + ganaHumano + " puntos");
                System.out.println();
            }

        }

        if (contador ==3){
            System.out.println("Se ha terminado el juego");
            System.out.println("El ganador es:");
                if (ganaOrdenador > ganaHumano){
                    System.out.println("El ordenador");
                    contador++;

                }if (ganaOrdenador < ganaHumano){
                    System.out.println("Usted");
                    contador++;
                }
                if (ganaHumano == ganaOrdenador){
                    System.out.println("Ha habido un empate");
                    contador++;
                }
            System.out.println();

            System.out.println("El marcador ha quedado de la siguiente manera:");
            System.out.println();
            System.out.println("El ordenador tiene: " + ganaOrdenador + " puntos");
            System.out.println();
            System.out.println("Usted tiene: " + ganaHumano + " puntos");
        }


}
}
