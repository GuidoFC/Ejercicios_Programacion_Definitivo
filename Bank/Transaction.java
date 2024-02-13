import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Transaction {

    private LocalDateTime dateTime;
    private double amount;
    private double finalBalance;
    // Curioso:
    // Cuando hacemos un ENUM

    // Duda: TransactionType = clase y
    // type = que sería?
    private TransactionType type;

    public Transaction(LocalDateTime dateTime, double amount, double finalBalance, TransactionType type) {
        this.dateTime = dateTime;
        this.amount = amount;
        this.finalBalance = finalBalance;
        this.type = type;
    }

    @Override
    public String toString() {
        // Ternaria
        // TransactionType.DEPOSIT = condicion --- ? "   TRUE = DEPOSIT" : " FALSE =WITHDRAWAL"
        return (this.type == TransactionType.DEPOSIT ? "   DEPOSIT" : "WITHDRAWAL")

                // Buscar info de como funciona este formato de fecha
                + " [Date = " + this.dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
                + ", time = " + this.dateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))
                + ", amount = " + this.amount
                + ", balance = " + this.finalBalance + "$"
                + "]";
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    // Curios el getter y setter también se aplican en ENUM

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
