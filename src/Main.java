import java.util.Scanner; // Falta importar Scanner

public class Main {
    public static void main(String[] args) {
        Scanner moneda = new Scanner(System.in);

        int a, valorswitch1 = 0, numerodemonedas, multiplicacion;

        System.out.print("Ingrese denominación de la moneda (1)20, (2)50, (3)100, (4)200, (5)500): ");
        a = moneda.nextInt();

        switch (a) {
            case 1:
                valorswitch1 = 20;
                break;
            case 2:
                valorswitch1 = 50;
                break;
            case 3:
                valorswitch1 = 100;
                break;
            case 4:
                valorswitch1 = 200;
                break;
            case 5:
                valorswitch1 = 500;
                break;
            default:
                System.out.println("Opción no válida.");
                moneda.close();
                return;
        }

        System.out.print("Ingrese el número de monedas: ");
        numerodemonedas = moneda.nextInt();

        multiplicacion = valorswitch1 * numerodemonedas;

        System.out.println("El número de monedas es: " + numerodemonedas +
                " con denominación de " + valorswitch1 +
                ". Total: " + multiplicacion);

        moneda.close();
    }
}
