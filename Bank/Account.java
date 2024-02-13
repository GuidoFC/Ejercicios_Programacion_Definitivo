import java.time.LocalDateTime;
import java.util.ArrayList;

public class Account {

    private int accountNumber;
    private double balance;
    // Crea una clase cliente para de esta forma asociar la cuenta a un cliente
    private Client owner;

    // Duda: como sabe que tiene que crear un ArrayList de transaciones en cuenta?
    private ArrayList<Transaction> transactions;

    public Account(int accountNumber, double balance, Client owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;

        // Duda: Por que esto lo haces asi?
            // Puede ser pq dentro de una cuenta tiene muchas transacciones y
            // nos interesa guardar el registro
        this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("ERROR: Can't deposit a negative or 0 amount");
            return;
        }
        this.balance += amount;
        // añade este desposito en la lista de transacciones
        // Duda: dentro de esta lista, de la clase Transaction has añadido un atributo de la clase Account --> this.balance
        // pq no has añadido finalBalance que es un atributo del Transaction?
        this.transactions.add(new Transaction(LocalDateTime.now(), amount, this.balance, TransactionType.DEPOSIT));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("ERROR: Can't deposit a negative or 0 amount");
            return;
        }
        if (amount > this.balance) {
            System.out.println("ERROR: There's not enough balance");
            return;
        }
        this.balance -= amount;
        // fijate como funciona el ENUM
        this.transactions.add(new Transaction(LocalDateTime.now(), amount, this.balance, TransactionType.WITHDRAWAL));
    }

    public void viewAccount() {
        String s = "";
        // curioso como guarda estos datos con el \n
        s += "Account Number: " + this.accountNumber + "\n";
        s += "Owner: " + this.owner.fullName() + ", address at " + this.owner.fullAddress() + "\n";
        s += "Current balance: " + this.balance + "$\n";
        s += "------------------------ TRANSACTIONS ------------------------\n";

        // lo que hace aqui es agregar todos los depositos y retida de dinero
        s += this.viewTransactions();

        // dice que imprima toddo dentro de un borde
        Borders.printTextWithBorders(s);
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + this.accountNumber + ", owner=" + this.owner.fullName() + "]";
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    private String viewTransactions() {
        String s = "";

        // vaya crack para imprimir cada transaccion
        for (Transaction transaction : transactions) {
            s += transaction.toString() + "\n";
        }
        return s;
    }

}