package tema2;

import java.io.*;

public class PrintReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/tema2/Ejemplo"));
        PrintWriter pw = new PrintWriter(new FileWriter("src/tema2/PrintReader.txt"));

        String cad = br.readLine();
        while (cad != null) {
            pw.println(cad);
            cad = br.readLine();
        }
        //Es muy importante cerrar los archivos, si no se acumulan en el sistema operativo y da error.
        pw.close();
        br.close();
    }
}
