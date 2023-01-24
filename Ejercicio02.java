import java.util.ArrayList;
import java.util.Collections;

/**
 * Realiza un programa que introduzca valores aleatorios (entre 0 y 100) en un
 * ArrayList y que luego calcule la suma, la media, el máximo y el mínimo de
 * esos números. El tamaño de la lista también será aleatorio y podrá oscilar
 * entre 10 y 20 elementos ambos inclusive.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio02 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        int size = (int) (Math.random() * ((20 - 10) + 1)) + 10;
        long suma = 0;
        double media;
        for (int i = 0; i < size; i++) {
            int n = (int) (Math.random() * 101);
            nums.add(n);
            suma += n;
        }
        media = suma / size;
        System.out.println(nums);
        Collections.sort(nums);
        System.out.printf("Suma: %d \nMedia: %.2f \nMáximo: %d \nMínimo: %d\n",
                suma, media, nums.get(0), nums.get(nums.size() - 1));
    }
}
