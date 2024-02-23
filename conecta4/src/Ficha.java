import java.util.Objects;
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

    public void setFicha(char ficha) {
        this.ficha = ficha;
    }

    public static int elegirColumna(){
        int columna;
        System.out.println("En que columna quieres introducir la ficha? ");
        return columna = sc.nextInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ficha ficha1 = (Ficha) o;
        return ficha == ficha1.ficha;
    }

}
