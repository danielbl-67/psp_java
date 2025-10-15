import java.io.IOException;
import java.util.Scanner;

public class Ej_Menu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Listar ficheros");
            System.out.println("2. Ver fecha y hora");
            System.out.println("3. Ver usuario actual");
            System.out.println("4. Ver historial de comandos");
            System.out.println("5. Ver espacio libre en disco");
            System.out.println("6. Ver procesos en ejecución");
            System.out.println("7. Mostrar red actual");
            System.out.println("8. Mostrar IP local");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpia salto de línea

            String[] command = null;

            switch (opcion) {
                case 1 -> command = new String[]{"ls", "-l"};
                case 2 -> command = new String[]{"date"};
                case 3 -> command = new String[]{"whoami"};
                case 4 -> command = new String[]{"history"};
                case 5 -> command = new String[]{"df", "-h"};
                case 6 -> command = new String[]{"ps", "aux"};
                case 7 -> command = new String[]{"ip", "a"};
                case 8 -> command = new String[]{"hostname", "-I"};
                case 9 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }

            if (command != null) {
                try {
                    int return_code = new ProcessBuilder(command)
                            .inheritIO()
                            .start()
                            .waitFor();
                    if (return_code != 0)
                        System.out.println("Error: " + return_code);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } while (opcion != 9);

        sc.close();
    }
}
