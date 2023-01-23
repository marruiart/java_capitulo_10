import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Realiza un programa equivalente al anterior pero en esta ocasión, el programa
 * debe ordenar palabras en lugar de números.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> palabras = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce una palabra: ");
            try {
                palabras.add(s.next());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nArrayList desordenado: ");
        for (String p : palabras)
            System.out.print(p + " ");

        Collections.sort(palabras);

        System.out.println("\nArrayList ordenado: ");
        for (String p : palabras)
            System.out.print(p + " ");
        s.close();

    }
}