import java.time.LocalDate;

public class Client {
    private String name;
    private String lastNames;
    private String address;
    private String city;
    private LocalDate birthDate;

    public Client(String name, String lastNames, String address, String city, LocalDate birthDate) {
        this.name = name;
        this.lastNames = lastNames;
        this.address = address;
        this.city = city;
        this.birthDate = birthDate;
    }

    public String fullName() {
        return this.name + " " + this.lastNames;
    }

    public String fullAddress() {
        return this.address + ", " + this.city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
