package classes.ajedrez;

import java.util.ArrayList;
import java.util.HashMap;
import enums.Enums.Piezas;

public class Ajedrez {
    public ArrayList<Pieza> ajedrez = new ArrayList<Pieza>();
    public HashMap<Piezas, Integer> disponibles = new HashMap<Piezas, Integer>();
    {
        disponibles.put(Piezas.REY, 1);
        disponibles.put(Piezas.REINA, 1);
        disponibles.put(Piezas.TORRE, 2);
        disponibles.put(Piezas.ALFIL, 3);
        disponibles.put(Piezas.CABALLO, 2);
        disponibles.put(Piezas.PEON, 8);
    }

    public Ajedrez() {
        Piezas[] nombres = Piezas.values();
        for (int i = 0; i < nombres.length; i++) {
            Pieza p = new Pieza(nombres[i]);
            while (disponibles.get(nombres[i]) > 0) {
                ajedrez.add(p);
                disponibles.put(nombres[i], disponibles.get(nombres[i]) - 1);
            }
        }
    }

    public Pieza capturarPieza(Pieza p) {
        if (ajedrez.contains(p)) {
            ajedrez.remove(p);
        } else
            System.out.println("Esa pieza no está en el tablero");
        return p;
    }


    @Override
    public String toString() {
        String s = "";
        for (Pieza p : ajedrez)
            s += p + "\n";
        return s;
    }
}
