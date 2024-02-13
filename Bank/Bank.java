import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    // no acabo de entender este Scanner como utilizarlo correctamente
    private static Scanner in = new Scanner(System.in);
    // Como determina que tiene que crear dentro de banco un ArrayList de Cliente y Cuentas?
    private static ArrayList<Client> clients = new ArrayList<Client>();
    private static ArrayList<Account> accounts = new ArrayList<Account>();

    // Este activeAccount sirve para hacer una copia de un objeto y a traves de esta copia
    // podemos hacer los cambios que veamos oportunos y eso hara que el objeto original tmb se modifique

    // una pregunta esto sería la clase Account y esto seria el nombre del objeto activeAccount y estoy diciendo
    // a traves del constructor vacio que no me guarde nada?
    private static Account activeAccount = null;
    // para que usa esta variable de accountCounter?
    private static int accountCounter = 1;

    public static void main(String[] args) {
        int option = 0;
        while (option != 4) {
            mainMenu();

            // De esta forma transformamos un String en un INTEGER --> Parse
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
        // una vez que se termina de usar el Scanner hay que cerrarlo
        in.close();
    }

    // Por que este médodo para crear un cliente, no esta dentro de la Clase Cliente?
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

        // Primero hace unas variables donde guarda los datos y luego pasa
        // esas variables al constructor del objeto.
        // Nota: fijate como hace para pasar la FECHA con parse
        // aprender a usar correctamente "parse"
        clients.add(new Client(name, lastNames, address, city, LocalDate.parse(birthday)));
        System.out.println("Client " + name + " " + lastNames + " created succesfully.");

    }

    // tmp entiendo pq no se ha creado este método dentro de Cuenta
    private static void createAccount() {
        // Comprobar si un array esta vacio
        if (clients.isEmpty()) {
            System.out.println("There are no clients in the bank, you must create one first");
            // si no lo encontramos sal del método
            return;
        }
        // primero en el método se pone todo lo que va mal, y luego empieza el método.
        // creamos un String de name y una variable de tipo cliente
            // para que creamos una variable de tipo cliente?
        String name;
        Client client = null;
        do {
            // imprime todos lo clientes que tenemos creados para decidir con que cliente crearemos la cuenta
            System.out.println("Client name to create an account for:");
            for (Client c : clients) {
                System.out.println(c.getName());
            }
            // guardar el nombre del cliente en la variable name
            name = in.nextLine();
            //
            client = validateClient(name);
        } while (client == null); // Si cliente es null volvera a pedir que escribas el nombre

        // si encontramos al cliente
        // accountCounter es una variable STATIC que actua como contador, pero no acabo de entder como funciona
        // pq en el constructor aparece --> this.accountNumber = accountNumber;
        accounts.add(new Account(accountCounter++, 0, client));
        System.out.println("Account for " + client.fullName() + " created succesfully.");
    }

    private static Client validateClient(String name) {
        // clients es la lista de clientes que hemos creado con ArrayList
        // Client es el tipo de variable que se ha guardado dentro de la lista
        // c es como la numeracion de por donde va la lista.
        for (Client c : clients) {
            // mira si en la lista de clientes coincide con el nomnbre introducido
            if (c.getName().equals(name)) {
                // devuelveme el Cliente que esta en la posicion "c"
                return c;
            }
        }
        // si no encuentra nada, sal del método y devuelveme Client = null
        // que significa que un objeto sea NULL?
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
                //De la lista ArrayList de accounts
                // imprimeme toda la informacon que tenga de la clase Account para cada objeto que he creado
                System.out.println(a.toString());
            }
            // coge el numero que te pasa el usuario y lo transformas en un INTEGER
            accountNumber = Integer.parseInt(in.nextLine());

            // esto quiere decir --> ??? !validateAccount(accountNumber)
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

        // Duda: para que sirve el activeAccount ?
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
        // No tiene que devolver nada, solo tiene que imprimir dentro del método el menu
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
