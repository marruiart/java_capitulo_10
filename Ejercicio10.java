import java.util.Scanner;
import classes.Diccionario;

/**
 * Crea un mini-diccionario.entradas español-inglés que contenga, al menos, 20
 * palabras
 * (con su correspondiente traducción). Utiliza un objeto de la clase HashMap
 * para almacenar las parejas de palabras. El programa pedirá una palabra en
 * español y dará la correspondiente traducción en inglés.
 * 
 * @author: Marina Ruiz Artacho
 */

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Diccionario diccionario = new Diccionario();
        String p;

        do {
            System.out.print("Introduzca una palabra en español ('salir' para salir): ");
            p = s.next();
            if (diccionario.entradas.containsKey(p))
                System.out.printf("'%s' en inglés se dice '%s'\n", p, diccionario.entradas.get(p));
            else
                System.out.println("La palabra no está en el diccionario.entradas");
        } while (!p.equals("salir"));
        s.close();
    }
}
