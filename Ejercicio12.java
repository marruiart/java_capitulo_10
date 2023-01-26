import java.util.HashMap;
import classes.baraja.*;

/**
 * Escribe un programa que genere una secuencia de 5 cartas de la baraja
 * española y que sume los puntos según el juego de la brisca. El valor de las
 * cartas se debe guardar en una estructura HashMap que debe contener parejas
 * (figura, valor), por ejemplo (“caballo”, 3). La secuencia de cartas debe ser
 * una estructura de la clase ArrayList que contiene objetos de la clase Carta.
 * El valor de las cartas es el siguiente:
 * as → 11,
 * tres → 10,
 * sota → 2,
 * caballo → 3,
 * rey → 4;
 * el resto de cartas no vale nada.
 * 
 * @author: Marina Ruiz Artacho
 */

public class Ejercicio12 {
    public static void main(String[] args) {
        HashMap<String, Integer> cartas = new HashMap<String, Integer>();
        Baraja baraja = new Baraja();
        Brisca brisca = new Brisca(baraja);
        Mano mano = brisca.obtenerMano();
        int puntos = 0;
        for (Carta c : mano.cartas) {
            int p = c.getPuntos();
            puntos += p;
            cartas.put(c.getNumero(), p);
            System.out.printf("%-18s -> %d ptos.\n", c, p);
        }
        System.out.println("=============================");
        System.out.printf("Tienes %d puntos", puntos);
    }
}
