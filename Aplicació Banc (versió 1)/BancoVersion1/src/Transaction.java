// para poder utilizar LocalDateTime tenemos que imprtar la clase

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    // primero he hecho un commit en la rama Piedra, luego he hecho
    // el push i finalmente he cambiado de rama. Ahora hare un commit
    // esta rama y mirare como se ha quedado en el git hub
    public static int accountTransaction = 1;
    private int numeroTransaccion;
    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL
    }

    private TransactionType type;

    // es como una FK (de Base de datos pq en el diagrama aparece como *)
    private Account account;

    public Transaction(Account account) {
        this.numeroTransaccion = accountTransaction++;
        this.account = account;

    }

    public void Deposito(double ingreso){

    }

    public Transaction(TransactionType type) {
        this.type = type;
    }

    public TransactionType getType() {
        return type;
    }
    private double amount;
    private double finalBalance;


    public static void main(String[] args) {
        // Dentro del método main
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Fecha y hora actual: " + now);
    }
}
