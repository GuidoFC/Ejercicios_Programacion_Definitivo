import java.util.Scanner;

public class Ficha {
    public static Scanner sc = new Scanner(System.in);

    private char ficha;



    public Ficha(char ficha){
        this.ficha = ficha; // una variable char lleva comilla simple
 // es un cero
    }

    public char getFicha() {
        return ficha;
    }

    public static int introducirFichaColumna(){
        int columna;
        System.out.println("En que columna quieres introducir la ficha");
        return columna = sc.nextInt();
    }


}
