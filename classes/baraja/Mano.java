package classes.baraja;

import java.util.ArrayList;
import java.util.Comparator;

public class Mano {
    public ArrayList<Carta> cartas = new ArrayList<Carta>();

    public void ordenarMano() {
        Comparator<Carta> comparador = Carta.comparar();
        cartas.sort(comparador);
    }
}
