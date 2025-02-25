import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner moneda = new Scanner(System.in);
        int opcion, numerodemonedas;


        do {
            System.out.println("Menú:");
            System.out.println("1) Moneda de 20");
            System.out.println("2) Moneda de 50");
            System.out.println("3) Moneda de 100");
            System.out.println("4) Moneda de 200");
            System.out.println("5) Finalizar programa");
            System.out.print("Seleccione una opción: ");
            opcion = moneda.nextInt();

            if (opcion == 5) {
                System.out.println("Finalizando el programa...");
                break;
            }

            System.out.print("Ingrese el número de monedas: ");
            numerodemonedas = moneda.nextInt();

            // método calcularTotal()
            int total = calcularTotal(opcion, numerodemonedas);
            if (total != -1) { // Si el total es válido
                System.out.println("El número de monedas es: " + numerodemonedas +
                        " con denominación de " + obtenerValorMoneda(opcion) +
                        ". Total: " + total);
            }

        } while (opcion != 5); // Repite hasta que el usuario elija 5

        moneda.close();
    }

    // Método para calcular el total
    public static int calcularTotal(int opcion, int cantidad) {
        int valor = obtenerValorMoneda(opcion);
        if (valor == -1) {
            System.out.println("Opción no válida. Intente de nuevo.");
            return -1;
        }
        return valor * cantidad;
    }

    // Método para obtener el valor de la moneda
    public static int obtenerValorMoneda(int opcion) {
        switch (opcion) {
            case 1: return 20;
            case 2: return 50;
            case 3: return 100;
            case 4: return 200;
            default: return -1;
        }
    }
}

