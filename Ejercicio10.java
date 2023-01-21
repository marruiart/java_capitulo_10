import java.util.HashMap;
import java.util.Scanner;

/**
 * Crea un mini-diccionario español-inglés que contenga, al menos, 20 palabras
 * (con su correspondiente traducción). Utiliza un objeto de la clase HashMap
 * para almacenar las parejas de palabras. El programa pedirá una palabra en
 * español y dará la correspondiente traducción en inglés.
 * 
 * @author: Marina Ruiz Artacho
 */

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, String> diccionario = new HashMap<String, String>();
        String p;
        diccionario.put("hola", "hello");
        diccionario.put("adiós", "goodbye");
        diccionario.put("por favor", "please");
        diccionario.put("gracias", "thank you");
        diccionario.put("nombre", "name");
        diccionario.put("edad", "age");
        diccionario.put("bien", "good");
        diccionario.put("mal", "bad");
        diccionario.put("agua", "water");
        diccionario.put("comida", "food");
        diccionario.put("tienda", "store");
        diccionario.put("dinero", "money");
        diccionario.put("autobús", "bus");
        diccionario.put("coche", "car");
        diccionario.put("bicicleta", "bicycle");
        diccionario.put("teléfono", "telephone");
        diccionario.put("hospital", "hospital");
        diccionario.put("policía", "police");
        diccionario.put("pasaporte", "passport");
        diccionario.put("ordenador", "computer");

        do {
            System.out.print("Introduzca una palabra en español ('aaa' para salir): ");
            p = s.next();
            if (diccionario.containsKey(p))
                System.out.printf("'%s' en inglés se dice '%s'\n", p, diccionario.get(p));
            else
                System.out.println("La palabra no está en el diccionario");
        } while (!p.equals("aaa"));
    }
}
