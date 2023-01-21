import java.util.HashMap;
import java.util.Scanner;

/**
 * Realiza un programa que sepa decir la capital de un país (en caso de conocer
 * la respuesta) y que, además, sea capaz de aprender nuevas capitales. En
 * principio, el programa solo conoce las capitales de España, Portugal y
 * Francia. Estos datos deberán estar almacenados en un diccionario. Los datos
 * sobre capitales que vaya aprendiendo el programa se deben almacenar en el
 * mismo diccionario. El usuario sale del programa escribiendo la palabra
 * “salir”.
 * 
 * @author: Marina Ruiz Artacho
 */

public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, String> capitales = new HashMap<String, String>();
        String r;
        capitales.put("Espana", "Madrid");
        capitales.put("Portugal", "Lisboa");
        capitales.put("Francia", "París");

        do {
            System.out.print("Escribe el nombre de un país y te diré su capital: ");
            r = s.next();
            if (!r.equals("salir")) {
                if (capitales.containsKey(r))
                    System.out.printf("La capital de %s es %s\n", r, capitales.get(r));
                else {
                    System.out.print("No conozco la respuesta ¿cuál es la capital de Alemania? ");
                    capitales.put(r, s.next());
                    System.out.println("Gracias por enseñarme nuevas capitales");
                }
            }
        } while (!r.equals("salir"));
        s.close();
    }
}
