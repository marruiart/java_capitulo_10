package classes.baraja;

import java.util.ArrayList;
import java.util.Comparator;

public class Mano {
    public ArrayList<Carta> cartas = new ArrayList<Carta>();

    public Mano(Baraja baraja, int n) {
        for (int i = 0; i < n; i++) {
            cartas.add(baraja.sacarCarta());
        }
    }

    public void ordenarMano() {
        Comparator<Carta> comparador = Carta.comparar();
        cartas.sort(comparador);
    }
}
