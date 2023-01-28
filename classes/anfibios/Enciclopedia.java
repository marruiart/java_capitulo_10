package classes.anfibios;

import java.util.HashMap;

public class Enciclopedia {
    private HashMap<String, Anfibio> enciclopedia = new HashMap<>();

    public void agregarEntrada(Anfibio a) {
        enciclopedia.put(a.getTipo(), a);
    }

    public Anfibio buscarAnfibio(String a) {
        return enciclopedia.get(a);
    }
}
