import java.util.ArrayList;
import classes.baraja.*;

/**
 * Realiza un programa que escoja al azar 10 cartas de la baraja española
 * (10 objetos de la clase Carta). Emplea un objeto de la clase ArrayList para
 * almacenarlas y asegúrate de que no se repite ninguna.
 * 
 * @author: Marina Ruiz Artacho
 */

public class Ejercicio08 {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        ArrayList<Carta> cartasEnMano = new ArrayList<Carta>();

        for (int i = 0; i < 10; i++) {
            cartasEnMano.add(baraja.sacarCarta());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(cartasEnMano.get(i));
        }
    }
}
