import java.io.File;
import java.util.Arrays;

public class Ejercicio1xx {

    public static void main(String[] args) {
        //Introducimos el vector de la raiz en f
        File f = File.listRoots()[0];
        //navegarDirectorios(directorio);
        do {

            File[] lista = f.listFiles();
            Arrays.stream(lista).sorted().forEach(System.out::println);

        }while (true);
    }

    public static void navegarDirectorios(File directorio) {
    }

}
