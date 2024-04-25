package Vista;

import Model.Tablero;
import java.util.Scanner;

public class Print {
    static Scanner sc = new Scanner(System.in);
    private Tablero tableroJugadorA;
    private Tablero tableroJugadorB;

    public Print (Tablero tableroRefernciaA, Tablero tableroRefernciaB){
        this.tableroJugadorA = tableroRefernciaA;
        this.tableroJugadorB = tableroRefernciaB;
    }
}
