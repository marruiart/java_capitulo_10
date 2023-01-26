package classes;

import java.util.*;

public class Diccionario {
    public HashMap<String, String> entradas = new HashMap<String, String>();

    public Diccionario() {
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

    public Map.Entry<String, String> entradaAleatoria() {
        ArrayList<Map.Entry<String, String>> entrada = new ArrayList<>(this.entradas.entrySet());
        int i = (int) (Math.random() * entrada.size());
        return entrada.get(i);
    }
}
