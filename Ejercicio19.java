
/**
 * Realiza un buscador de sinónimos. Utiliza el diccionario español-inglés que
 * se proporciona a continuación. El programa preguntará una palabra y dará una
 * lista de sinónimos (palabras que tienen el mismo significado). Por ejemplo,
 * si se introduce la palabra “caliente”, el programa dará como resultado:
 * ardiente, candente, abrasador. ¿Cómo sabe el programa cuáles son los
 * sinónimos de “caliente”? Muy fácil, en el diccionario debe existir la entrada
 * (“caliente”, “hot”), por tanto solo tendrá que buscar las palabras en español
 * que también signifiquen “hot”; esta información estará en las entradas
 * (“ardiente”, “hot”) y (“abrasador”, “hot”). Cuando una palabra existe en el
 * diccionario pero no tiene sinónimos, debe mostrar el mensaje “No conozco
 * sinónimos de esa palabra”. Si una palabra no está en el diccionario se
 * mostrará el mensaje “No conozco esa palabra”. El usuario sale del programa
 * escribiendo la palabra “salir”.
 * 
 * @author: Marina Ruiz Artacho
 */

import java.util.*;

public class Ejercicio19 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, String> diccionario = new HashMap<String, String>();
        String p;
        diccionario.put("caliente", "hot");
        diccionario.put("rojo", "red");
        diccionario.put("ardiente", "hot");
        diccionario.put("verde", "green");
        diccionario.put("agujetas", "stiff");
        diccionario.put("abrasador", "hot");
        diccionario.put("hierro", "iron");
        diccionario.put("grande", "big");

        do {
            String sinonimos = "";
            System.out.print("Introduzca una palabra y le daré los sinónimos ('salir' para salir): ");
            p = s.next();
            if (diccionario.containsKey(p)) {
                String valor = diccionario.get(p);
                for (Map.Entry<String, String> pareja : diccionario.entrySet()) {
                    if (pareja.getValue().equals(valor) && !pareja.getKey().equals(p))
                        sinonimos += pareja.getKey() + ", ";
                }
                if (sinonimos.equals(""))
                    System.out.println("No conozco sinónimos de esa palabra");
                else {
                    sinonimos = sinonimos.substring(0, (sinonimos.length() - 2));
                    System.out.print(String.format("Sinónimos de %s: %s\n", p, sinonimos));
                }
            } else if (!p.equals("salir"))
                System.out.println("No conozco esa palabra");

        } while (!p.equals("salir"));
        s.close();
    }
}