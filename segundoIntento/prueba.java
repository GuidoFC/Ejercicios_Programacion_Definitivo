package segundoIntento;

public class prueba {
    // Método para revelar las casillas vacías de forma recursiva
    public static int calcularFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
    }

    public static void main(String[] args) {
        int numero = 3;
        int resultado = calcularFibonacci(numero);
        System.out.println("El número de Fibonacci para " + numero + " es: " + resultado);
    }
}



