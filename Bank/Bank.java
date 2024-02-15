import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class Bank {

    // Una vez que lo declaras fuera del Main no necesitas volver
    // a declararlo dentro de los métodos o dentro del main
    private static Scanner sc = new Scanner(System.in);


    // Como determina que tiene que crear dentro de banco un ArrayList de Cliente y Cuentas?
    private static ArrayList<Client> listaClients = new ArrayList<Client>();
    // creamos una lista con la clase padre, y ella sabra de que TIPO guardamos en la lista
    private static ArrayList<AccountAbstract> listaDeTodasLasCuentas = new ArrayList<AccountAbstract>();



    // Este AccountAbstract sirve para hacer una copia de un objeto y a traves de esta copia
    // podemos hacer los cambios que veamos oportunos y eso hara que el objeto original tmb se modifique
    private static AccountAbstract activeAccount;


    // para que usa esta variable de accountCounter?
        // para tener un control de todas las cuentas que se han creado de forma cronologica
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
            // como funciona el accountNumber? cada una tendria que tener un numero diferente? En este csao las 3 tiene un 1
        CurrentAccount currentAccount1 = new CurrentAccount(contadorDeLas3Cuentas++, 0, cliente1 );
        MortgageAccount mortgageAccount1 = new MortgageAccount(contadorDeLas3Cuentas++, 1_00,cliente2);
        InvestmentFund investmentFund1 = new InvestmentFund(contadorDeLas3Cuentas++, 5_000,cliente3);

        listaDeTodasLasCuentas.add(currentAccount1);
        listaDeTodasLasCuentas.add(mortgageAccount1);
        listaDeTodasLasCuentas.add(investmentFund1);



        int option = 0;
        while (option != 4) {
            mainMenu();

            // De esta forma transformamos un String en un INTEGER --> Parse
            option = Integer.parseInt(sc.nextLine());
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





    } // Fin del Main


    // Por que este médodo para crear un cliente, no esta dentro de la Clase Cliente?
    private static void createClient() {
        String name;
        do {

            System.out.println("Client name:");
            name = sc.nextLine();

            boolean existe = comprobarSiElClienteExiste(name);
            if (existe){
                System.out.println("El cliente no se puede crear pq ya exite");
                System.out.println("Vuelvalo a intentar con otro nombre de cliente");
                continue;
            }
            break;

        }while (true);

        System.out.println("Client lastnames:");
        String lastNames = sc.nextLine();
        System.out.println("Client address:");
        String address = sc.nextLine();
        System.out.println("Client city:");
        String city = sc.nextLine();
        do {
            System.out.println("Client birthday YYYY-MM-DD:");
            try {
                LocalDate birthday = LocalDate.parse(sc.nextLine());
                listaClients.add(new Client(name, lastNames, address, city, birthday));

            }catch (DateTimeParseException e){
                System.out.println("La fecha introducida no es correcta");
                System.out.println(e);
                continue;
            }
            break;
        }while (true);


        // Primero hace unas variables donde guarda los datos y luego pasa
        // esas variables al constructor del objeto.
        // Nota: fijate como hace para pasar la FECHA con parse
        // aprender a usar correctamente "parse"



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
        Client clientCopia = null;
        do {
            // imprime todos los clientes que tenemos creados para decidir con que cliente crearemos la cuenta
            System.out.println("Client name to create an account for:");
            for (Client c : listaClients) {
                System.out.println(c.getName());
            }
            // guardar el nombre del cliente en la variable name
            name = sc.nextLine();
            //
            clientCopia = validateClient(name);
        } while (clientCopia == null); // Si cliente es null volvera a pedir que escribas el nombre

        // para elegir la cuenta tengo que saber que cliente lo va a hacer
        chooseAccount(clientCopia);
        System.out.println("Volviendo al menú principal");

    }


    // Nota: fijate que lo que devuelve este método es un objeto de Cliente
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
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("Creant Compte Corrent");

                    listaDeTodasLasCuentas.add(new CurrentAccount(contadorDeLas3Cuentas++, 0, client));
                    System.out.println("New Current Account for " + client.fullName() + " created succesfully.");

                    // con el return salgo del método
                    // y con el break salgo de esta opcion del switch?
                    return;
                case 2:
                    System.out.println("Creant Compte Vivenda");
                    listaDeTodasLasCuentas.add(new MortgageAccount(contadorDeLas3Cuentas++, 1_000, client));
                    System.out.println("New Mortgage Account for " + client.fullName() + " created succesfully.");
                    return;
                case 3:
                    System.out.println("Creant Fons d’inversió");
                    listaDeTodasLasCuentas.add(new InvestmentFund(contadorDeLas3Cuentas++, 5_000, client));
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


    }

    private static void accountMaintenance() {
        // primero hay que seleccionar el tipo de cuenta
        int eligaCuenta;
        do {
            for (AccountAbstract cuenta :listaDeTodasLasCuentas) {
                /*
                para cada cuenta [hay 3 cuentas diferentes] usara el .toString de cada clase
                 */
                System.out.println(cuenta.toString());
            }
            System.out.println("Elige una de las cuentas por 'accountNumber':");
            eligaCuenta = Integer.parseInt(sc.nextLine());

            for (AccountAbstract a: listaDeTodasLasCuentas) {
                if(eligaCuenta == a.getAccountNumber()){
                    activeAccount = a;
                    // cuando lo encuentres rompe el bucle del for each
                    break;
                }

            }
        }while (activeAccount == null);


        selectAccountOption();

    }

    // Con esta modificación, el método comprobacionCuentaVacia ahora puede aceptar cualquier ArrayList,
    // independientemente del tipo de elementos que contenga.
    /*
    ArrayList<?> sustituir eso con un if ([] intaceof.[])
     */







    // Duda: Tengo que triplicar este metodo para cada cuenta?
    private static boolean validateCurrentAccount(int accountNumber) {
        for (AccountAbstract a : listaDeTodasLasCuentas) {
            if (a.getAccountNumber() == accountNumber) {
                activeAccount = a;
                return true;
            }
        }
        return false;
    }



    private static void selectAccountOption() {
        int option = 0;
        while (option != 5) {
            accountMenu();
            option = Integer.parseInt(sc.nextLine());
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

                    /*
                    duda: como puedo añadir el método para que solo se me active si es en la cuenta
                    es de Investment


                     Para ello como usamos un objeto activeAccount de la clase AccountAbstract
                     tenemos que crear el método dentro de esa clase y luego en la clase
                     InvestFund hacer un Override de ese método
                     */
                        activeAccount.interesesAnual();


                    break;
                case 5:
                    System.out.println("Back to Main Menu.");
                    activeAccount = null;

                default:
                    System.out.println("Option not valid, select an option between 1 and 4");
                    break;
            }
        }
    }


    private static void deposit() {
        System.out.println("Amount to deposit:");
        int amount = Integer.parseInt(sc.nextLine());
            activeAccount.deposit(amount);

    }

    private static void withdraw() {
        System.out.println("Amount to withdraw:");
        int amount = Integer.parseInt(sc.nextLine());

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
                    4 - Intereses de InvestmentFound
                    5 - Back to Main Menu
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




        // No tiene que devolver nada, solo tiene que imprimir dentro del método el menu

        private static boolean comprobarSiElClienteExiste(String name) {
            for (Client indiceDelArray : listaClients) {
                if (indiceDelArray.getName().equals(name)) {
                    System.out.println("Este cliente ya existe");
                    return true;
                }
            }
            return false;
        }






    }

