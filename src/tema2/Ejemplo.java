package tema2;

import java.io.FileReader;
import java.io.IOException;

public class Ejemplo {
    public static void main(String[] args) throws IOException {
        FileReader f_in = new FileReader("src/tema2/Ejemplo");
        int c = f_in.read();
        while (c != -1) {
            System.out.print((char) c);
            c = f_in.read();
        }
    }
}
