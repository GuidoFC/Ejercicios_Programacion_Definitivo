import java.util.ArrayList;

public class Account{

    // tengo que seguir lo pasos que ha hecho miquel vera y hacer otra carpet donde me ponga la info del banco version 2
    // creamos accountCounter para hacer un Auto Increment de accountNumber
    public static int accountCounter = 1;
    private int accountNumber;
    private double balance;

    // es como una FK (de Base de datos pq en el diagrama aparece como *) #777
    private Client client;

    public Account(){
    }

    public Account(Client client){
        this.accountNumber = accountCounter++;
        this.balance = 0;
        this.client = client;
    }

    public Account(double balance, Client client) {
        this.accountNumber = accountCounter++;
        this.balance = balance;
        this.client = client;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void Deposito(double ingreso) {
        System.out.println("Amount to deposit: \n" + ingreso);
        balance += ingreso;
        System.out.println("Saldo: " + balance);
        System.out.println("--------");
        System.out.println();

    }
    public void retirarDineroAccount(double retirarDinero) {
        balance -= retirarDinero;
        if (balance < 0) {
            System.out.println("ERROR: There's not enough balance");
            balance += retirarDinero;
            System.out.println("Saldo: " + balance);
            System.out.println("--------");
            System.out.println();
        } else {
            System.out.println("Con la retirada de dinero: \n"
                   + retirarDinero  +"Su saldo es: "+ balance);
            System.out.println("--------");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Account{ " +
                "accountNumber= " + accountNumber +
                ", balance = " + balance +
                ", client = " + client +
                '}';
    }

    public String fullAccount(){
        return "Su número de cuenta es: \n " + this.accountNumber + " y su saldo inicial es: \n " + this.balance;
    }


}
