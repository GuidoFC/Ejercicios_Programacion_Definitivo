import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Client {
    private String name;
    private String lastName;
    private String address;
    private String city;
    private LocalDate birthdate;



    // constructor


    public Client() {
    }

    public Client(String name, String lastName, String address, String city, LocalDate birthdate) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        // preguntar para que sirve poner esto
        this.birthdate = birthdate;
    }

    // los setters se colocan por si quieres modificar la info
    // que previamente has introducido en el constructor.
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String fullName(){
        return this.name + " " + this.lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String fullAddress(){
        return this.address + " " + this.city;
    }



    // para poder imprimir el Objeto que esta dentro de un ARRAY LIST
    // tenemos que crear el método de toString() en la clase Cliente
    @Override
    public String toString() {
        return "Client{ " +
                "name= '" + name + '\'' +
                ", lastName= '" + lastName + '\''
                +
                '}';
    }
}
