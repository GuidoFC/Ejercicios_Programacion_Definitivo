import java.util.ArrayList;

public abstract class  AccountAbstract {

    // Nota: en la clase abstracta hay que poner que los atributos
    // sean protected
    protected int accountNumber;
    protected double balance;
    // Crea una clase cliente para de esta forma asociar la cuenta a un cliente
    protected Client owner;

    // Duda: como sabe que tiene que crear un ArrayList de transaciones en cuenta?
    protected ArrayList<Transaction> transactions;

    public AccountAbstract(int accountNumber, double balance, Client owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;

        this.transactions = new ArrayList<Transaction>();
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void viewAccount();

    // public abstract void interesesAnual();


    public void interesesAnual() {
        System.out.println("Esta cuenta no genera intereses");
        System.out.println("Solo genera intereses la cuenta Investment Fund");
    }




    public abstract String toString();

    public abstract int getAccountNumber();

    public abstract void setAccountNumber(int accountNumber);

    public abstract double getBalance();

    public abstract void setBalance(double balance);

    public abstract Client getOwner();

    public abstract void setOwner(Client owner);

    protected abstract String viewTransactions();
}

