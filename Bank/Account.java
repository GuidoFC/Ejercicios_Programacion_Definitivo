import java.time.LocalDateTime;
import java.util.ArrayList;

public class Account {

    private int accountNumber;
    private double balance;
    private Client owner;

    private ArrayList<Transaction> transactions;

    public Account(int accountNumber, double balance, Client owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;

        this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("ERROR: Can't deposit a negative or 0 amount");
            return;
        }
        this.balance += amount;
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
        this.transactions.add(new Transaction(LocalDateTime.now(), amount, this.balance, TransactionType.WITHDRAWAL));
    }

    public void viewAccount() {
        String s = "";
        s += "Account Number: " + this.accountNumber + "\n";
        s += "Owner: " + this.owner.fullName() + ", address at " + this.owner.fullAddress() + "\n";
        s += "Current balance: " + this.balance + "$\n";
        s += "------------------------ TRANSACTIONS ------------------------\n";
        s += this.viewTransactions();
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
        for (Transaction transaction : transactions) {
            s += transaction.toString() + "\n";
        }
        return s;
    }

}