import java.time.LocalDateTime;

public class InvestmentFund extends AccountAbstract {


    public InvestmentFund(int accountNumber, double balance, Client owner) {
        super(accountNumber, balance, owner);
    }

    @Override
    public void deposit(double amount) {
        if (amount < 10) {
            System.out.println("El ingreso tiene que ser superior a 10€");
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
        return "Account [accountNumber=" + this.accountNumber + ", owner=" + this.owner.fullName() + "]";
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



}