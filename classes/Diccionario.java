package classes;

import java.util.*;

public class Diccionario {
    public static HashMap<String, String> entradas = new HashMap<String, String>();
    static {
        entradas.put("hola", "hello");
        entradas.put("adiós", "goodbye");
        entradas.put("por favor", "please");
        entradas.put("gracias", "thank you");
        entradas.put("nombre", "name");
        entradas.put("edad", "age");
        entradas.put("bien", "good");
        entradas.put("mal", "bad");
        entradas.put("agua", "water");
        entradas.put("comida", "food");
        entradas.put("tienda", "store");
        entradas.put("dinero", "money");
        entradas.put("autobús", "bus");
        entradas.put("coche", "car");
        entradas.put("bicicleta", "bicycle");
        entradas.put("teléfono", "telephone");
        entradas.put("hospital", "hospital");
        entradas.put("policía", "police");
        entradas.put("pasaporte", "passport");
        entradas.put("ordenador", "computer");
    }

    public static Map.Entry<String, String> entradaAleatoria() {
        List<Map.Entry<String, String>> entrada = new ArrayList<Map.Entry<String, String>>(
                Diccionario.entradas.entrySet());
        return entrada.get((int) (Math.random() * entrada.size()));
    }
}
