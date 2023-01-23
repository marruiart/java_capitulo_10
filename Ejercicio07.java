import java.util.ArrayList;
import classes.Moneda;

/**
 * La máquina Eurocoin genera una moneda de curso legal cada vez que se pulsa un
 * botón siguiendo la siguiente pauta: o bien coincide el valor con la moneda
 * anteriormente generada - 1 céntimo, 2 céntimos, 5 céntimos, 10 céntimos, 25
 * céntimos, 50 céntimos, 1 euro o 2 euros - o bien coincide la posición – cara
 * o cruz. Simula, mediante un programa, la generación de 6 monedas aleatorias
 * siguiendo la pauta correcta. Cada moneda generada debe ser una instancia de
 * la clase Moneda y la secuencia se debe ir almacenando en una lista.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio07 {
    public static void main(String[] args) {
        ArrayList<Moneda> monedas = new ArrayList<Moneda>();
        Moneda m = new Moneda();
        monedas.add(m);
        for (int i = 0; i < 5; i++) {
            Moneda tmp;
            String valor;
            String cara;
            if (Math.random() < 0.5) {
                valor = m.valor;
                do {
                    cara = Moneda.caras[(int) (Math.random() * 2)];
                } while (m.cara.equals(cara));
                tmp = new Moneda(valor, cara);
            } else {
                cara = m.cara;
                do {
                    valor = Moneda.valores[(int) (Math.random() * 8)];
                } while (m.valor.equals(valor));
                tmp = new Moneda(valor, cara);
            }
            monedas.add(tmp);
            m = tmp;
        }

        for (Moneda moneda : monedas)
            System.out.println(moneda);
    }
}
