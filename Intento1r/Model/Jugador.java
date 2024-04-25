package Model;

public class Jugador {
    private String nombre;
    private String apellido;

    private Tablero tablero;

    // matriz de barcos

    public Jugador(String nombre, String apellido, Tablero tablero){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre(){
        return this.nombre;
    }
    public  String getApellido(){
        return this.apellido;
    }
}
