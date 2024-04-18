package segundoIntento;

import segundoIntento.Logica.Juego;
import segundoIntento.Vista.ImprimirTablero;

import java.util.Scanner;

public class BuscaMinaMain {
    // no podemos usar static en una variable
    // static TableroDefEj tableroDef1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Juego viewTablero = new Juego(10,10,3);
        viewTablero.jugar();
    }
}






        // luego hacer un Swithc para elegir la dificultad
//        tableroDef1 = new TableroDefEj(10,10,10);
//        printTablero();
//
//        printTableroConBombas();
//
//        printTableroSolucion();
//
//        boolean continua = true;
//
//        while (continua){
//
//
//            menu();
//            int option = sc.nextInt();
//         switch (option){
//             case 1: putFlag();
//                     printTablero();
//                     break;
//
//             case 2: continua = chooseRowColumn();
//                 if (!continua){
//                     printTablero();
//                     System.out.println("Has perdido");
//                     break;
//                 }
//                 printTablero();
//                 break;
//             default:
//                 System.out.println("Opción No Valida. Vuelva a intentarlo");
//                 break;
//         }
//
//
//        }
//
//    }







