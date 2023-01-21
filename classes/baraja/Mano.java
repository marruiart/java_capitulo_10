package classes.baraja;

import java.util.ArrayList;
import java.util.Collections;

public class Mano {
    public ArrayList<Carta> cartas = new ArrayList<Carta>();

    public void ordenarMano() {
        Collections.sort(cartas);
    }
}
