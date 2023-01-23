import java.util.*;
import classes.Diccionario;

/**
 * Realiza un programa que escoja al azar 5 palabras en español del
 * minidiccionario del ejercicio anterior. El programa irá pidiendo que el
 * usuario teclee la traducción al inglés de cada una de las palabras y
 * comprobará si son correctas. Al final, el programa deberá mostrar cuántas
 * respuestas son válidas y cuántas erróneas.
 * 
 * @author: Marina Ruiz Artacho
 */

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String r;
        int aciertos = 0;
        HashMap<String, String> entradas = new HashMap<String, String>();

        while (entradas.size() < 5) {
            Map.Entry<String, String> e = Diccionario.entradaAleatoria();
            entradas.put(e.getKey(), e.getValue());
        }

        for (Map.Entry<String, String> e : entradas.entrySet()) {
            System.out.printf("Introduzca la traducción de '%s': ", e.getKey());
            r = s.nextLine();
            if (r.equals(e.getValue())) {
                System.out.println("¡BIEN!");
                aciertos++;
            } else {
                System.out.printf("Lo siento, la respuesta correcta era '%s'\n", e.getValue());
            }
        }
        System.out.printf("Se han acertado %d/5\n", aciertos);
        s.close();
    }
}