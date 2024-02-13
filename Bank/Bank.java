import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private static Scanner in = new Scanner(System.in);
    private static ArrayList<Client> clients = new ArrayList<Client>();
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private static Account activeAccount = null;
    private static int accountCounter = 1;

    public static void main(String[] args) {
        int option = 0;
        while (option != 4) {
            mainMenu();
            option = Integer.parseInt(in.nextLine());
            switch (option) {
                case 1:
                    createClient();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    accountMaintenance();
                    break;
                case 4:
                    System.out.println("Exit.");
                    break;

                default:
                    System.out.println("Option not valid, select an option between 1 and 4");
                    break;
            }
        }
        in.close();
    }

    private static void createClient() {
        System.out.println("Client name:");
        String name = in.nextLine();
        System.out.println("Client lastnames:");
        String lastNames = in.nextLine();
        System.out.println("Client address:");
        String address = in.nextLine();
        System.out.println("Client city:");
        String city = in.nextLine();
        System.out.println("Client birthday YYYY-MM-DD:");
        String birthday = in.nextLine();

        clients.add(new Client(name, lastNames, address, city, LocalDate.parse(birthday)));
        System.out.println("Client " + name + " " + lastNames + " created succesfully.");

    }

    private static void createAccount() {
        if (clients.isEmpty()) {
            System.out.println("There are no clients in the bank, you must create one first");
            return;
        }

        String name;
        Client client = null;
        do {
            System.out.println("Client name to create an account for:");
            for (Client c : clients) {
                System.out.println(c.getName());
            }
            name = in.nextLine();
            client = validateClient(name);
        } while (client == null);

        accounts.add(new Account(accountCounter++, 0, client));
        System.out.println("Account for " + client.fullName() + " created succesfully.");
    }

    private static Client validateClient(String name) {
        for (Client c : clients) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    private static void accountMaintenance() {
        if (accounts.isEmpty()) {
            System.out.println("There are no accounts in the bank, you must create one first");
            return;
        }

        int accountNumber = 0;
        do {
            System.out.println("Select an account by account number:");
            for (Account a : accounts) {
                System.out.println(a.toString());
            }
            accountNumber = Integer.parseInt(in.nextLine());
        } while (!validateAccount(accountNumber));

        selectAccountOption();
    }

    private static boolean validateAccount(int accountNumber) {
        for (Account a : accounts) {
            if (a.getAccountNumber() == accountNumber) {
                activeAccount = a;
                return true;
            }
        }
        return false;
    }

    private static void selectAccountOption() {
        int option = 0;
        while (option != 4) {
            accountMenu();
            option = Integer.parseInt(in.nextLine());
            switch (option) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    activeAccount.viewAccount();
                    break;
                case 4:
                    System.out.println("Back to Main Menu.");
                    break;

                default:
                    System.out.println("Option not valid, select an option between 1 and 4");
                    break;
            }
        }
    }

    private static void deposit() {
        System.out.println("Amount to deposit:");
        int amount = Integer.parseInt(in.nextLine());
        activeAccount.deposit(amount);
    }

    private static void withdraw() {
        System.out.println("Amount to withdraw:");
        int amount = Integer.parseInt(in.nextLine());
        activeAccount.withdraw(amount);
    }

    private static void mainMenu() {
        String s = """

                MAIN MENU
                1 - Create Client
                2 - Create Account
                3 - Account Maintenance
                4 - Exit
                """;
        System.out.println(s);
    }

    private static void accountMenu() {
        String s = """

                ACCOUNT MENU
                1 - Deposit
                2 - Withdrawal
                3 - View Account Data
                4 - Back to Main Menu
                """;
        System.out.println(s);
    }

}
