import java.util.HashMap;
import java.util.Map;

import classes.ajedrez.Ajedrez;
import classes.ajedrez.Pieza;
import enums.Enums.Piezas;

/**
 * En ajedrez, el valor de las piezas se mide en peones. Una dama vale 9 peones,
 * una torre 5 peones, un alfil 3, un caballo 2 y un péon vale, lógicamente, 1
 * peón. Realiza un programa que genere al azar las n que ha hecho un
 * jugador durante una partida. El número de n será un valor aleatorio
 * entre 0 y 15. Hay que tener en cuenta que cada jugador tiene la posibilidad
 * de capturar algunas de las siguientes piezas (no más): 1 dama, 2 torres, 2
 * alfiles, 2 caballos y 8 peones. Al final debe aparecer la puntuación total.
 * 
 * @author: Marina Ruiz Artacho
 */

public class Ejercicio23 {
    public static void main(String[] args) {
        Ajedrez tablero = new Ajedrez();
        int n = (int) (Math.random() * 16);
        int puntos = 0;
        System.out.println("Fichas capturadas por el jugador: ");
        for (int i = 0; i < n; i++) {
            Pieza p;
            do {
                p = tablero.capturarPieza(tablero.ajedrez.get((int) (Math.random() * tablero.ajedrez.size())));
            } while (p.getNombre().equals(Piezas.REY));
            System.out.println(p);
            puntos += p.getPeones();
        }

        System.out.println("Puntos totales: " + puntos + " peones.");
    }
}
