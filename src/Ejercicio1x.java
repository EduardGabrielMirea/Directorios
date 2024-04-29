import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1x {
    public static void main(String[] args){
        //En sistemas Linux devolverá un único elemento, pero en sistemas Windows devolverá la raíz de cada unidad del sistema, por eso es un array. Esta es una manera de obtener un File que apunta a la raíz (y en el caso de Windows a la raíz de C :)
        File f = File.listRoots()[0];
        System.out.println("Lista de ficheros y directorios del directorio actual");
        System.out.println("---------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        int contador;
        int opcion;
        do {
            contador = 0;
            opcion = 0;
            for (File e : f.listFiles()) {
                contador++;
                if ( e.isFile()) {
                    System.out.println(contador+". -"+e.getName() + " " + e.length());
                }
                if (e.isDirectory()){
                    System.out.println(contador+". -"+e.getName()  + " <Directorio>");
                }
            }
            try {
                opcion = sc.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("Introduzca sólo números");
            }
            sc.nextLine();
            if (opcion == 0) {
               if (f.getParentFile() != null) {
                   f = f.getParentFile();
               }
            }else if (opcion !=  -1) {
                if(opcion >= 0 && opcion <= f.listFiles().length){
                    if (f.listFiles()[opcion - 1].isDirectory() && f.listFiles()[opcion - 1].canRead()){
                        f = f.listFiles()[opcion - 1];
                    }
                }
            }
        }while (opcion != -1);
    }

}
