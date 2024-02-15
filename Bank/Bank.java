import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    // no acabo de entender este Scanner como utilizarlo correctamente
    private static Scanner in = new Scanner(System.in);
    // Como determina que tiene que crear dentro de banco un ArrayList de Cliente y Cuentas?
    private static ArrayList<Client> listaClients = new ArrayList<Client>();
    private static ArrayList<CurrentAccount> listCurrentAccounts = new ArrayList<CurrentAccount>();
    private static ArrayList<MortgageAccount> listMortgageAccount = new ArrayList<MortgageAccount>();
    private static ArrayList<InvestmentFund> listInvestmentFund = new ArrayList<InvestmentFund>();

    // Este activeAccount sirve para hacer una copia de un objeto y a traves de esta copia
    // podemos hacer los cambios que veamos oportunos y eso hara que el objeto original tmb se modifique

    // una pregunta esto sería la clase Account y esto seria el nombre del objeto activeAccount y estoy diciendo
    // a traves del constructor vacio que no me guarde nada?
    private static CurrentAccount activeCurrentAccount = null;
    private static MortgageAccount activeMortgageAccount = null;
    private static InvestmentFund activeInvestmentFund = null;


    // para que usa esta variable de accountCounter?
    private static int contadorDeLas3Cuentas = 1;




    public static void main(String[] args) {

        // Vamos a crear 3 objetos de cliente

        Client cliente1 = new Client("Guido", "Figueroa", "C/ Manacor", "Mallorca",LocalDate.parse("1996-06-12"));
        Client cliente2 = new Client("Miquel", "Rosello", "C/ Manacor", "Mallorca",LocalDate.parse("1996-06-12"));
        Client cliente3 = new Client("Rafa", "Matallana", "C/ Manacor", "Mallorca",LocalDate.parse("1996-06-12"));

        listaClients.add(cliente1);
        listaClients.add(cliente2);
        listaClients.add(cliente3);
        // creamos 3 objetos de cuentas
        // Duda: que diferencia hay entre crear un objeto de este modo:
        //AccountAbstract currentAccount1 = new CurrentAccount(1, 10, cliente1 );
        //MortgageAccount mortgageAccount1 = new MortgageAccount(1, 500,cliente2);
        // una de ellas esta creada con una clase abstracta y la otra el tipo de la misma clase
        CurrentAccount currentAccount1 = new CurrentAccount(1, 0, cliente1 );
        MortgageAccount mortgageAccount1 = new MortgageAccount(1, 1_00,cliente2);
        InvestmentFund investmentFund1 = new InvestmentFund(1, 5_000,cliente3);

        listCurrentAccounts.add(currentAccount1);
        listMortgageAccount.add(mortgageAccount1);
        listInvestmentFund.add(investmentFund1);



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




    } // Fin del Main


    // Por que este médodo para crear un cliente, no esta dentro de la Clase Cliente?
    private static void createClient() {
        System.out.println("Client name:");

        String name = in.nextLine();
        for (Client a: listaClients) {
            if (a.getName().equals(name)){
                System.out.println("Este cliente ya existe");
                return;
            }
        }
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

        // crear un método
        // No s’ha de poder inserir un Client que ja existeixi a l’entitat bancària

        listaClients.add(new Client(name, lastNames, address, city, LocalDate.parse(birthday)));

        System.out.println("Client " + name + " " + lastNames + " created succesfully.");

    }




    // tmp entiendo pq no se ha creado este método dentro de Cuenta
    private static void createAccount() {
        // Comprobar si un array esta vacio
        if (listaClients.isEmpty()) {
            System.out.println("There are no clients in the bank, you must create one first");
            // si no lo encontramos sal del método
            return;
        }

        // primero en el método se pone todo lo que va mal, y luego empieza el método.
        // creamos un String de name y una variable de tipo cliente
            // Duda: para que creamos una variable de tipo cliente?
        String name;
        Client client = null;
        do {
            // imprime todos los clientes que tenemos creados para decidir con que cliente crearemos la cuenta
            System.out.println("Client name to create an account for:");
            for (Client c : listaClients) {
                System.out.println(c.getName());
            }
            // guardar el nombre del cliente en la variable name
            name = in.nextLine();
            //
            client = validateClient(name);
        } while (client == null); // Si cliente es null volvera a pedir que escribas el nombre

        // para elegir la cuenta tengo que saber que cliente lo va a hacer
        chooseAccount(client);
    }


    private static Client validateClient(String name) {
        // clients es la lista de clientes que hemos creado con ArrayList
        // Client es el tipo de variable que se ha guardado dentro de la lista
        // c es como la numeracion de por donde va la lista.
        for (Client c : listaClients) {
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

    public static void chooseAccount(Client client){

        int opcion;

        do{
            chooseAccountMenu();
            opcion = Integer.parseInt(in.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("Creant Compte Corrent");

                    listCurrentAccounts.add(new CurrentAccount(contadorDeLas3Cuentas++, 0, client));
                    System.out.println("New Current Account for " + client.fullName() + " created succesfully.");

                    // con el return salgo del método
                    // y con el break salgo de esta opcion del switch?
                    return;
                case 2:
                    System.out.println("Creant Compte Vivenda");
                    listMortgageAccount.add(new MortgageAccount(contadorDeLas3Cuentas++, 1_000, client));
                    System.out.println("New Mortgage Account for " + client.fullName() + " created succesfully.");
                    return;
                case 3:
                    System.out.println("Creant Fons d’inversió");
                    listInvestmentFund.add(new InvestmentFund(contadorDeLas3Cuentas++, 5_000, client));
                    System.out.println("New Investment Fund for " + client.fullName() + " created succesfully.");
                    return;
                case 4:
                    System.out.println("Back to Main Menu");
                    break;
                default:
                    System.out.println("Opción incorrecta, vuelta a intentarlo");
                    break;
            }

        }while (opcion != 4);
        in.close();

    }

    private static void accountMaintenance() {
        // primero hay que seleccionar el tipo de cuenta
        int eligaCuenta;
        do {

            menuEleccionCuenta();
            eligaCuenta = Integer.parseInt(in.nextLine());
            switch (eligaCuenta){

                case 1:
                    System.out.println("Ha elegido: Current Account");

                    comprobacionCuentaVaciaYSeleccionarCuenta(listCurrentAccounts, eligaCuenta);
                    return;
                case 2:
                    System.out.println("Ha elegido: Mortgage Account");
                    comprobacionCuentaVaciaYSeleccionarCuenta(listInvestmentFund, eligaCuenta);
                    return;
                case 3:
                    System.out.println("Ha elegido: Investment Fund");
                    comprobacionCuentaVaciaYSeleccionarCuenta(listInvestmentFund, eligaCuenta);
                    return;
                case 4:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Numero introducido no valido");
                    break;
            }
        }while (eligaCuenta != 4);
        in.close();

    }

    // Con esta modificación, el método comprobacionCuentaVacia ahora puede aceptar cualquier ArrayList,
    // independientemente del tipo de elementos que contenga.
    private static void comprobacionCuentaVaciaYSeleccionarCuenta(ArrayList<?> lista3Cuentas, int eligaCuenta) {
        if (lista3Cuentas.isEmpty()) {
            System.out.println("There are no accounts in the bank, you must create one first");
            return;

        }
        if (eligaCuenta == 1){
            seleccionarCuentaCurrentAccount(listCurrentAccounts);

        }else if (eligaCuenta == 2){
            seleccionarCuentaMortgageAccount(listMortgageAccount);

        }else if (eligaCuenta == 3) {
            seleccionarCuentaInvestmentFund(listInvestmentFund);

        }


    }
    private static void seleccionarCuentaCurrentAccount(ArrayList<CurrentAccount> listCurrentAccounts){
        int accountNumber = 0;
        do {
            System.out.println("Select an account by account number:");
            // Duda: por que Java me ha sugerdo que ponga Object?
            // mi idea era poner la clase de CurrentAccount
            for (CurrentAccount a : listCurrentAccounts) {
                //De la lista ArrayList de accounts
                // imprimeme toda la informacon que tenga de la clase Account para cada objeto que he creado
                System.out.println(a.toString());
            }
            // coge el numero que te pasa el usuario y lo transformas en un INTEGER
            accountNumber = Integer.parseInt(in.nextLine());

            // esto quiere decir --> ??? !validateAccount(accountNumber)
        } while (!validateCurrentAccount(accountNumber)); //

        selectAccountOption();

    }

    private static void seleccionarCuentaMortgageAccount(ArrayList<MortgageAccount> listMortgageAccount){
        int accountNumber = 0;
        do {
            System.out.println("Select an account by account number:");
            // Duda: por que Java me ha sugerdo que ponga Object?
            // mi idea era poner la clase de CurrentAccount

            for (MortgageAccount a : listMortgageAccount) {
                //De la lista ArrayList de accounts
                // imprimeme toda la informacon que tenga de la clase Account para cada objeto que he creado
                System.out.println(a.toString());
            }
            // coge el numero que te pasa el usuario y lo transformas en un INTEGER
            accountNumber = Integer.parseInt(in.nextLine());

            // esto quiere decir --> ??? !validateAccount(accountNumber)
        } while (!validateMortgageAccount(accountNumber)); //

        selectAccountOption();

    }

    private static void seleccionarCuentaInvestmentFund(ArrayList<InvestmentFund> listInvestmentFund){
        int accountNumber = 0;
        do {

            System.out.println("Select an account by account number:");
            // Duda: por que Java me ha sugerdo que ponga Object?
            // mi idea era poner la clase de CurrentAccount

            for (InvestmentFund a : listInvestmentFund) {
                //De la lista ArrayList de accounts
                // imprimeme toda la informacon que tenga de la clase Account para cada objeto que he creado
                System.out.println(a.toString());
            }
            // coge el numero que te pasa el usuario y lo transformas en un INTEGER
            accountNumber = Integer.parseInt(in.nextLine());

            // esto quiere decir --> ??? !validateAccount(accountNumber)
        } while (!validateInvestmentFund(accountNumber)); //

        selectAccountOption();

    }



    // Duda: Tengo que triplicar este metodo para cada cuenta?
    private static boolean validateCurrentAccount(int accountNumber) {
        for (CurrentAccount a : listCurrentAccounts) {
            if (a.getAccountNumber() == accountNumber) {
                activeCurrentAccount = a;
                return true;
            }
        }
        return false;
    }

    private static boolean validateMortgageAccount(int accountNumber) {
        for (MortgageAccount a : listMortgageAccount) {
            if (a.getAccountNumber() == accountNumber) {
                activeMortgageAccount = a;
                return true;
            }
        }
        return false;
    }

    private static boolean validateInvestmentFund(int accountNumber) {
        for (InvestmentFund a : listInvestmentFund) {
            if (a.getAccountNumber() == accountNumber) {
                activeInvestmentFund = a;
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
                    // Duda: Tengo que hacer activeCurrentAccount = null cuando se termine
                    if (activeCurrentAccount != null){

                        activeCurrentAccount.viewAccount();

                    }else if (activeMortgageAccount != null){

                        activeMortgageAccount.viewAccount();

                    }else if (activeInvestmentFund != null) {

                        activeInvestmentFund.viewAccount();
                    }
                    break;
                case 4:
                    System.out.println("Back to Main Menu.");
                    activeCurrentAccount = null;
                    activeMortgageAccount = null;
                    activeInvestmentFund = null;
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

        if (activeCurrentAccount != null){

            activeCurrentAccount.deposit(amount);

        }else if (activeMortgageAccount != null){

            activeMortgageAccount.deposit(amount);

        }else if (activeInvestmentFund != null) {

            activeInvestmentFund.deposit(amount);
        }


    }

    private static void withdraw() {
        System.out.println("Amount to withdraw:");
        int amount = Integer.parseInt(in.nextLine());

        if (activeCurrentAccount != null){

            activeCurrentAccount.withdraw(amount);

        }else if (activeMortgageAccount != null){

            activeMortgageAccount.withdraw(amount);

        }else if (activeInvestmentFund != null) {

            activeInvestmentFund.withdraw(amount);
        }

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

    private static void chooseAccountMenu(){
        String s = """
                
                Choose your Account
                    1 - Current Account (Compte Corrent): es crea amb 0€
                    2 - MortgageAccount (Compte Vivenda): es crea amb 1,000€
                    3 - Investment Fund (Fons d’inversió): es crea amb 5,000€.
                    4 - Back to Main Menu
                """;
        System.out.println(s);
    }

    private static void menuEleccionCuenta() {
        String s = """
                Elija una cuenta:
                    1 - Current Account
                    2 - Mortgage Account
                    3 - Investment Fund
                    4 - Exit
                """;
        // No tiene que devolver nada, solo tiene que imprimir dentro del método el menu
        System.out.println(s);
    }



        // aplicar intereses cada año
        // Duda: no se muy bien como quieres que lo implemente
        // es decir, creo un if y que solo se pueda aplicar este método a final de año?
   /*
    public static void interesesAnual(){
        for (InvestmentFund a :listInvestmentFund) {


            if (a.balance >= 100_000){
                a.balance = a.balance * (1 + 0.05);

            } else if ((a.balance >= 50_000)) {
                a.balance = a.balance * (1 + 0.02);

            } else {
                a.balance = a.balance * (1 + 0.04);
            }

        }

    */

}
