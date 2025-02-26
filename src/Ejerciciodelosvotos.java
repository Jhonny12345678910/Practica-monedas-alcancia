import java.util.Scanner;

public class Ejerciciodelosvotos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int contadorRespuestas = 0;
        int[] votosCandidatos = new int[3];
        int[] votosMedios = new int[3];
        int[] costoTotalCandidatos = new int[3]; // Para calcular el costo de campaña

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Votar por un candidato");
            System.out.println("2. Vaciar urnas");
            System.out.println("3. Ver resultados");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 4) {
                break;
            } else if (opcion == 2) {
                // Vaciar datos
                votosCandidatos = new int[3];
                votosMedios = new int[3];
                costoTotalCandidatos = new int[3];
                contadorRespuestas = 0;
                System.out.println("¡Urnas vaciadas con éxito!");
                continue;
            } else if (opcion == 3) {
                // Mostrar resultados
                if (contadorRespuestas == 0) {
                    System.out.println("No hay votos registrados.");
                    continue;
                }

                System.out.println("\nResultados finales:");
                System.out.println("Votos por candidato:");
                int totalVotos = 0;
                for (int votos : votosCandidatos) {
                    totalVotos += votos;
                }

                for (int i = 0; i < votosCandidatos.length; i++) {
                    double porcentaje = (totalVotos == 0) ? 0 : ((double) votosCandidatos[i] / totalVotos) * 100;
                    System.out.printf("Candidato %d: %d votos (%.2f%%)\n", i + 1, votosCandidatos[i], porcentaje);
                }

                System.out.println("\nCosto promedio de campaña por candidato:");
                for (int i = 0; i < votosCandidatos.length; i++) {
                    if (votosCandidatos[i] > 0) {
                        double costoPromedio = (double) costoTotalCandidatos[i] / votosCandidatos[i];
                        System.out.printf("Candidato %d: %.2f unidades monetarias\n", i + 1, costoPromedio);
                    } else {
                        System.out.printf("Candidato %d: No recibió votos.\n", i + 1);
                    }
                }
                continue;
            }

            // Proceso de votación
            System.out.println("Qué candidato:");
            System.out.println("1. Candidato A");
            System.out.println("2. Candidato B");
            System.out.println("3. Candidato C");
            System.out.print("Ingrese el número del candidato: ");
            int candidato = scanner.nextInt();

            System.out.println("Por qué medio conoció al candidato:");
            System.out.println("1. Internet");
            System.out.println("2. Radio");
            System.out.println("3. Televisión");
            System.out.print("Ingrese el número del medio: ");
            int medio = scanner.nextInt();

            votosCandidatos[candidato - 1]++;
            votosMedios[medio - 1]++;

            int costo = 0;
            switch (medio) {
                case 1:
                    costo = 700000;
                    break;
                case 2:
                    costo = 200000;
                    break;
                case 3:
                    costo = 600000;
                    break;
            }

            costoTotalCandidatos[candidato - 1] += costo;

            System.out.println("Costo de la campaña: " + costo);
            contadorRespuestas++;

            System.out.print("¿Desea continuar votando? (s/n): ");
            scanner.nextLine(); // Consumir el salto de línea
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }
}

