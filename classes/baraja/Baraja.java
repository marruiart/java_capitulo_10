package classes.baraja;

import java.util.ArrayList;
import enums.Enums.*;

public class Baraja {
    private ArrayList<Carta> baraja = new ArrayList<Carta>();

    public Baraja() {
        Palos[] palos = Palos.values();
        Numeros[] numeros = Numeros.values();
        for (Palos p : palos) {
            for (Numeros n : numeros) {
                baraja.add(new Carta(n, p));
            }
        }
    }

    public Carta sacarCarta() {
        int n = (int) (Math.random() * baraja.size());
        Carta carta = baraja.get(n);
        baraja.remove(n);
        return carta;
    }

    public void devolverCarta(Carta carta) {
        devolverCarta(baraja.size(), carta);
    }

    public void devolverCarta(int posicion, Carta carta) {
        baraja.add(posicion, carta);
    }
}
