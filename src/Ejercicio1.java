import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        //Con File.listRoots()[0] nos devolvera la raiz porque la opcion 0 es el directorio padre.
        File currentDirectory = File.listRoots()[0];
        navigateDirectory(currentDirectory);
    }

    public static void navigateDirectory(File directory) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDirectorio actual: " + directory.getAbsolutePath());
            File[] files = directory.listFiles();
            int count = 1;

            System.out.println("0. Ir al directorio padre");

            for (File file : files) {
                System.out.print(count + ". ");
                if (file.isDirectory()) {
                    System.out.println("<" + file.getName() + ">");
                } else {
                    System.out.println(file.getName() + " (" + file.length() + " bytes)");
                }
                count++;
            }

            System.out.print("\nIngrese el número correspondiente: ");
            int choice = scanner.nextInt();

            if (choice == -1) {
                System.out.println("¡Adiós!");
                break;
            } else if (choice == 0) {
                //Con directory.getParentFile() conseguimos volver al directorio padre del que estamos. Es decir, volver al anterior.
                File parentDirectory = directory.getParentFile();
                if (parentDirectory != null) {
                    directory = parentDirectory;
                } else {
                    System.out.println("Este directorio no tiene directorio padre.");
                }
            } else if (choice > 0 && choice <= files.length) {
                File chosenFile = files[choice - 1];
                if (chosenFile.isDirectory()) {
                    if (chosenFile.canRead()) {
                        directory = chosenFile;
                    } else {
                        System.out.println("No tienes permisos para acceder a este directorio.");
                    }
                } else {
                    System.out.println("Esta opción no es un directorio válido.");
                }
            } else {
                System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }
}