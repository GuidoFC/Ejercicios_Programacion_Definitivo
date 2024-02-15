import java.time.LocalDateTime;
import java.util.ArrayList;

public class InvestmentFund extends AccountAbstract {


    public InvestmentFund(int accountNumber, double balance, Client owner) {
        super(accountNumber, balance, owner);
    }

    @Override
    public void deposit(double amount) {
        if (amount < 500) {
            System.out.println("El ingreso tiene que ser superior a 500€");
            return;
        }
        this.balance += amount;
        // añade este desposito en la lista de transacciones
        // Duda: dentro de esta lista, de la clase Transaction has añadido un atributo de la clase Account --> this.balance
        // pq no has añadido finalBalance que es un atributo del Transaction?
        this.transactions.add(new Transaction(LocalDateTime.now(), amount, this.balance, TransactionType.DEPOSIT));
    }
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("ERROR: Can't deposit a negative or 0 amount");
            return;
        }
        if (amount > this.balance) {
            System.out.println("ERROR: There's not enough balance");
            return;
        }
        if (amount >= 500) {
            System.out.println("ERROR: Supera los 500€ que es la retirada màxima.");
            return;
        }
        this.balance -= amount;
        // fijate como funciona el ENUM
        this.transactions.add(new Transaction(LocalDateTime.now(), amount, this.balance, TransactionType.WITHDRAWAL));
    }
    @Override
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
        return "Investment Fund [accountNumber=" + this.accountNumber + ", owner=" + this.owner.fullName() + "]";
    }
    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
    @Override
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    @Override
    public double getBalance() {
        return balance;
    }
    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public Client getOwner() {
        return owner;
    }
    @Override
    public void setOwner(Client owner) {
        this.owner = owner;
    }
    @Override
    public String viewTransactions() {
        String s = "";

        // vaya crack para imprimir cada transaccion
        for (Transaction transaction : transactions) {
            s += transaction.toString() + "\n";
        }
        return s;
    }


    public void interesesAnual() {
        double balanceAntiguo;
        double intereses;
            if (this.balance >= 100_000) {
                balanceAntiguo = this.balance;
                intereses = this.balance * 0.05;
                this.balance = balanceAntiguo + intereses;

                System.out.println("Su saldo era de: " + balanceAntiguo);
                System.out.println("Los intereses generados son: "+ intereses);
                System.out.println("Ahora en su cuenta tiene: " + this.balance);


            } else if ((this.balance >= 50_000)) {
                balanceAntiguo = this.balance;
                intereses = this.balance * 0.04;
                this.balance = balanceAntiguo + intereses;

                System.out.println("Su saldo era de: " + balanceAntiguo);
                System.out.println("Los intereses generados son: "+ intereses);
                System.out.println("Ahora en su cuenta tiene: " + this.balance);
                return;

            } else {

                balanceAntiguo = this.balance;
                intereses = this.balance * 0.02;
                this.balance = balanceAntiguo + intereses;

                System.out.println("Su saldo era de: " + balanceAntiguo);
                System.out.println("Los intereses generados son: "+ intereses);
                System.out.println("Ahora en su cuenta tiene: " + this.balance);
            }

    }




    }