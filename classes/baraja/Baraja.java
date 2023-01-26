package classes.baraja;

import java.util.*;
import enums.Enums.*;

public class Baraja {
    public ArrayList<Carta> mazo = new ArrayList<Carta>();

    public Baraja() {
        Palos[] palos = Palos.values();
        Numeros[] numeros = Numeros.values();
        for (Palos p : palos) {
            for (Numeros n : numeros) {
                mazo.add(new Carta(n, p));
            }
        }
        barajar();
    }

    public Carta sacarCarta() {
        int n = (int) (Math.random() * mazo.size());
        Carta carta = mazo.remove(n);
        return carta;
    }

    public Carta sacarPrimeraCarta() {
        Carta carta = mazo.remove(0);
        return carta;
    }

    public void devolverCarta(Carta carta) {
        devolverCarta(mazo.size(), carta);
    }

    public void barajar() {
        Collections.shuffle(mazo);
    }

    public void devolverCarta(int posicion, Carta carta) {
        mazo.add(posicion, carta);
    }
}
