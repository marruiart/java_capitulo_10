
/**
 * Modifica el programa anterior de tal forma que las cartas se muestren
 * ordenadas. Primero se ordenarán por palo: bastos, copas, espadas, oros.
 * Cuando coincida el palo, se ordenará por número: as, 2, 3, 4, 5, 6, 7, sota,
 * caballo, rey.
 * 
 * @author: Marina Ruiz Artacho
 */

import classes.baraja.*;

public class Ejercicio09 {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        Mano mano = new Mano(baraja, 10);

        mano.ordenarMano();
        for (Carta c : mano.cartas) {
            System.out.println(c);
        }
    }
}