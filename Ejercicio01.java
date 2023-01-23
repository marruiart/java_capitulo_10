import java.util.ArrayList;

/**
 * Crea un ArrayList con los nombres de 6 compañeros de clase. A continuación,
 * muestra esos nombres por pantalla. Utiliza para ello un bucle for que recorra
 * todo el ArrayList sin usar ningún índice.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio01 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<String>();
        nombres.add("Juanma");
        nombres.add("Marina");
        nombres.add("Diego");
        nombres.add("Marco");
        nombres.add("Pablo");
        nombres.add("Jesús");

        for(String n : nombres)
            System.out.println(n);
    }
}
