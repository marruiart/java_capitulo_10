import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Escribe un programa que ordene 10 números enteros introducidos por teclado
 * y almacenados en un objeto de la clase ArrayList.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce un número: ");
            try {
                nums.add(s.nextInt());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nArrayList desordenado: ");
        for (int n : nums)
            System.out.print(n + " ");

        Collections.sort(nums);

        System.out.println("\nArrayList ordenado: ");
        for (int n : nums)
            System.out.print(n + " ");
        s.close();

    }
}
