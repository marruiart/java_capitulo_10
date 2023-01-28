
/**
 * Amplía el programa anterior de tal forma que sea capaz de aprender palabras y
 * sinónimos. Cuando una palabra no tiene sinónimos, es decir, cuando aparece la
 * palabra en español con su traducción y esa traducción no la tiene ninguna
 * otra palabra española, se le preguntará al usuario si quiere añadir uno (un
 * sinónimo) y, en caso afirmativo, se pedirá la palabra y se añadirá al
 * diccionario. Se puede dar la circunstancia de que el usuario introduzca una
 * palabra en español que no está en el diccionario; en tal caso, se mostrará el
 * consiguiente mensaje y se dará la posibilidad al usuario de añadir la entrada
 * correspondiente en el diccionario pidiendo, claro está, la palabra en inglés.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.*;

public class Ejercicio20 {
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
            p = s.nextLine();
            if (diccionario.containsKey(p)) {
                String valor = diccionario.get(p);
                for (Map.Entry<String, String> pareja : diccionario.entrySet()) {
                    if (pareja.getValue().equals(valor) && !pareja.getKey().equals(p))
                        sinonimos += pareja.getKey() + ", ";
                }
                if (sinonimos.equals("")) {
                    System.out.print("No conozco sinónimos de esa palabra ¿quiere añadir alguno? (s/n): ");
                    String respuesta = s.nextLine();
                    if (respuesta.equals("s")) {
                        System.out.print(String.format("Introduzca un sinónimo de '%s': ", p));
                        String sinonimo = s.nextLine();
                        diccionario.put(sinonimo, valor);
                        System.out.println("Gracias por enseñarme nuevos sinónimos.");
                    } else {
                        continue;
                    }
                } else {
                    sinonimos = sinonimos.substring(0, (sinonimos.length() - 2));
                    System.out.print(String.format("Sinónimos de %s: %s\n", p, sinonimos));
                }
            } else if (!p.equals("salir")) {
                System.out.print("No conozco esa palabra ¿quiere añadirla al diccionario? (s/n): ");
                String respuesta = s.nextLine();
                if (respuesta.equals("s")) {
                    System.out.print(String.format("Introduzca la traducción de %s en inglés: ", p));
                    String ingles = s.nextLine();
                    diccionario.put(p, ingles);
                    System.out.println("Gracias por enseñarme nuevas palabras.");
                } else {
                    continue;
                }
            }

        } while (!p.equals("salir"));
        s.close();
    }
}
