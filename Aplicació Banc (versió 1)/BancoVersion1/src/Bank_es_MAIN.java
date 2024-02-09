
import java.time.LocalDate;


import java.util.*;
public class Bank_es_MAIN {

    private static Account activeAccount;
    private static int accountConter;


    // Solo poner en mayuscula la clase Client, su variable va en minuscula.
    private static Client client;

    private static ArrayList<Client> listaClientes = new ArrayList<>();

    private static Account account;

    private static ArrayList<Account> listaCuentas = new ArrayList<>();
    private static ArrayList<Transaction> listaTransacciones = new ArrayList<>();



    public static void createClient(){

        // para hacerlo de este modo, tenemos que crear un constructor vacio.
        Client crearNuevoCliente = new Client();

        // solo hace falta crear una clase de Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("Client name:");
        crearNuevoCliente.setName(sc.nextLine());


        System.out.println("Client lastnames:");
        crearNuevoCliente.setLastName(sc.nextLine());


        System.out.println("Client address:");
        crearNuevoCliente.setAddress(sc.nextLine());

        System.out.println("Client city:");
        crearNuevoCliente.setCity(sc.nextLine());

        do {
            System.out.println("Client birthday YYYY-MM-DD:");
            try {
                crearNuevoCliente.setBirthdate(LocalDate.parse(sc.next()));
            }catch (Exception DateTimeParseException){
                System.out.println("Fecha mal introducida");
                continue;
            }


            System.out.println("El cliente: " + crearNuevoCliente.fullAddress() + "se ha creado correctamente");
            listaClientes.add(crearNuevoCliente);
            break;

        }while (true);

    }

    public static void createAccound(){
        System.out.println("Client name to create an account for: ");

        // 2 formas de Listar el Array List de Cliente
        // para poder imprimir el Objeto que esta dentro de un ARRAY LIST
        // tenemos que crear el método de toString() en la clase Cliente
        // 1r forma
        for(int i = 0; i < listaClientes.size(); i++) {
            System.out.println(listaClientes.get(i));
        }

        /*
        // 2n forma Listar el Array List de Cliente
        System.out.println(listaClientes.toString());
         */

        for (Client cliente : listaClientes) {
            System.out.println("Escriba el name de un cliente");
            Scanner sc = new Scanner(System.in);
            String nombreClienteIntroducido = sc.nextLine();

            if (cliente.getName().equals(nombreClienteIntroducido)) {
                System.out.println("Hemos encontrado al cliente");

                // Aquí puedes realizar las operaciones que necesites con el cliente encontrado
                // luego crear un método para poner todo este conetido dentro del método
                    // Sup IMP:
                    // de esta forma estamos asociando la cuenta con el cliente new Account(cliente) [lo hemos asociado con el atributo que aparece en la clase Account #777)
                Account crearNuevaCuenta = new Account(cliente);

                do {
                    System.out.println("Numero de cuenta: ");
                    try {
                        crearNuevaCuenta.setAccountNumber(sc.nextInt());
                    }catch (Exception InputMismatchException){
                        System.out.println("ha introducido un valor no númerico");
                        // para borrar el buffer:
                        sc.nextLine();
                        continue;
                    }
                    System.out.println("Cuenta creada con éxito");
                    break;

                }while (true);


                do {
                    System.out.println("Ingreso inicial que tendra la cuenta: ");
                    try {
                        crearNuevaCuenta.setBalance(sc.nextDouble());
                    }catch (Exception InputMismatchException) {
                        System.out.println("ha introducido un valor no númerico");
                        // para borrar el buffer:
                        sc.nextLine();
                        continue;
                    }

                    System.out.println("La cuenta: " + crearNuevaCuenta.fullAccount() + "se ha creado correctamente");
                    break;

                }while (true);





                listaCuentas.add(crearNuevaCuenta);

                break; // Termina el bucle una vez encontrado el cliente y creado una cuenta

            }else{
                System.out.println("No se ha encontrado al cliente");
            }
        }


    }

    public static void mostrarCuentas(){
        System.out.println();
        System.out.println("Las cuentas son las siguientes: ");

        for(int i = 0; i < listaCuentas.size(); i++) {
            // ojo muestra lo que he puesto en la CLASE Account en el apartado del método toString()
            System.out.println(listaCuentas.get(i));
        }

        System.out.println("Seleccione un accountNumber");
        int eleccionAccountNumber;
        Scanner sc = new Scanner(System.in);
        eleccionAccountNumber =  sc.nextInt();

        System.out.println("La cuenta seleccionada es: ");
        // he puesto un -1 pq recuerda que una
        System.out.println(listaCuentas.get(eleccionAccountNumber -1));
        mostrarAccountMenu(eleccionAccountNumber -1);
    }

    public static void mostrarAccountMenu(int eleccionAccountNumber){

        // nota: para poder usar el do-while con switch
        // tenemos que crear la siguiente variable
        int opcion2;
        do {
            System.out.println("ACCOUNT MENU:");
            System.out.println("1 - Deposit");
            System.out.println("2 - Withdrawal");
            System.out.println("3 - View Account Data");
            System.out.println("4 - Back to Main Menu");


            Scanner sc = new Scanner(System.in);
            opcion2 = sc.nextInt();

            switch (opcion2){
                case 1:
                    System.out.println("Ha elegido la opción: Deposit ");
                    // introducir el método de depósito
                    System.out.println("Cual es la cantidad de dinero que quiere ingresar? ");
                    Scanner sca = new Scanner(System.in);
                    double ingreso = sca.nextDouble();

                    listaCuentas.get(eleccionAccountNumber).Deposito(ingreso);
                    // me he quedado aqui pq no se como ingresar el dinero
                    /* double ingreso;
                    ingreso = sc.nextDouble();
                    Deposito(ingreso);

                     */
                    break;
                case 2:
                    System.out.println("Ha elegido la opción: Withdrawal");
                    System.out.println("Cual es la cantidad de dinero que quiere retirar? ");
                    double retirarDinero = sc.nextDouble();

                    listaCuentas.get(eleccionAccountNumber).retirarDineroAccount(retirarDinero);
                    break;
                case 3:
                    System.out.println("Ha elegido la opción: View Account Data");
                    System.out.println(listaCuentas.get(eleccionAccountNumber));
                    break;
                case 4:
                    System.out.println("Saliendo del programa ACCOUNT MENU... Back to Main Menu");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }

        }while (opcion2 != 4);
    }
// saber usar el control + click para ver el origen
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        // creamos 2 clientes fijos y los añadimos a la lista de Array Cliente

            Client ClienteFijo = new Client("Guido", "Figueroa", "C/ Via Mallorca", "Cala Ratjada", LocalDate.parse("1996-12-12"));
            Client ClienteFijo2 = new Client("Miquel", "Rossello", "C/ Via Felanitx", "Porto Colom", LocalDate.parse("1996-12-12"));

            // añadimos estos clientes en el ARRAY de clientes
            listaClientes.add(ClienteFijo);
            listaClientes.add(ClienteFijo2);


        // creamos 2 cuentas fijas y los añadimos a la lista de Array Cliente


            Account CuentaFija1 = new Account(2_500.25, ClienteFijo);
            Account CuentaFija2 = new Account(500.05, ClienteFijo2);
            Account CuentaFija3 = new Account(ClienteFijo);

            // añadimos estos cuentas en el ARRAY de cuentas
            listaCuentas.add(CuentaFija1);
            listaCuentas.add(CuentaFija2);
            listaCuentas.add(CuentaFija3);

        // creamos 3 cuentas de trasacciones
            Transaction transaccionCuenta1 = new Transaction(CuentaFija1);
            Transaction transaccionCuenta2 = new Transaction(CuentaFija2);
            Transaction transaccionCuenta3 = new Transaction(CuentaFija3);

        // añadimos estos transacciones de cada cuenta en el ARRAY de transacciones
            listaTransacciones.add(transaccionCuenta1);
            listaTransacciones.add(transaccionCuenta2);
            listaTransacciones.add(transaccionCuenta3);



        do {
            // Mostrar el menú
            {
                System.out.println("Menú:");
                System.out.println("1 - Create Client");
                System.out.println("2 - Create Account");
                System.out.println("3 - Account Maintenance");
                System.out.println("4 - Exit");
                System.out.print("Elige una opción: ");

                // Leer la opción del usuario
                opcion = sc.nextInt();
            }

            // Procesar la opción seleccionada

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opción 1 - Create Client");
                        // Ponemos el método de crear un cliente
                        // Este método solo se puede hacer si tienes un Array Creado
                        createClient();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opción 2 - Create Account");
                        createAccound();
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opción 3.");
                        if (listaCuentas.isEmpty()) {
                            System.out.println("There are no accounts in the bank, you must create one first.");
                        } else {
                            System.out.println("Select an account by account number:");
                            mostrarCuentas();
                        }
                        // Aquí puedes poner el código que corresponde a la opción 3
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elige una opción válida.");
                }
                // este do-while se activara todo el rato hasta que opcion = 4. Ahi es cuando
                //  el bucle se rompera

        } while (opcion != 4);

    }

    }


