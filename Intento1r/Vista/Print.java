package Vista;

import Model.Tablero;
import java.util.Scanner;

public class Print {
    static Scanner sc = new Scanner(System.in);
    private Tablero tableroJugadorA;


    public Print (Tablero tableroRefernciaA){
        this.tableroJugadorA = tableroRefernciaA;
    }

    public int elegir(String filaColumna){
        System.out.println("Elija una " + filaColumna);
        return sc.nextInt();
    }

    public void mensajeCasillaAbierta(){
        System.out.println("Esta casilla ya esta abierta");
    }
}
