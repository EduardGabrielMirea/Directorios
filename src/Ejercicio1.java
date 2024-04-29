import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        //Con File.listRoots()[0] nos devolvera la raiz porque la opcion 0 es el directorio padre.
        File Directory = File.listRoots()[0];
        navigateDirectory(Directory);
    }

    public static void navigateDirectory(File directory) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //Muestra con la ruta absouta es decir desde la raiz, e inserta los archivos en un array list.
            System.out.println("\nDirectorio actual: " + directory.getAbsolutePath());
            File[] files = directory.listFiles();
            int count = 1;

            System.out.println("0. Ir al directorio padre");
            //Recorre el array list y lo imprime empezando desde "1 .".
            for (File file : files) {
                //1 + .
                System.out.print(count + ". ");
                if (file.isDirectory()) {
                    System.out.println("<" + file.getName() + ">");
                } else {
                    //En caso de que sea un archivo, con file.length() podremos ver el tamaño del mismo.
                    System.out.println(file.getName() + " (" + file.length() + " bytes)");
                }
                count++;
            }

            System.out.print("\nIngrese el número correspondiente (-1 para salir): ");
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
                //Choice - 1 ya que empezamos en 0 pero nuesto menu empieza en 1, entonces hay que quitarle siempre 1 para que conicida con el menu.
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