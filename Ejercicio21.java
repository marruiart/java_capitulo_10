
/**
 * La asociación “Amigos de los anfibios” nos ha encargado una aplicación
 * educativa sobre estos animalitos. Crea un programa que pida al usuario el
 * tipo de anfibio y que, a continuación, nos muestre su hábitat y su
 * alimentación. Si el tipo de anfibio introducido no existe, se debe mostrar el
 * mensaje “Ese tipo de anfibio no existe”.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.*;
import classes.anfibios.*;

public class Ejercicio21 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Enciclopedia anfibios = new Enciclopedia();
        anfibios.agregarEntrada(
                new Anfibio("rana", "En los trópicos y cerca de las zonas húmedas y acuáticas.", "Larvas e insectos."));
        anfibios.agregarEntrada(
                new Anfibio("salamandra", "Ecosistemas húmedos.", "Pequeños crustáceos e insectos."));
        anfibios.agregarEntrada(
                new Anfibio("sapo", "En cualquier sitio salvo el desierto y la Antártida.",
                        "Insectos, lombrices y pequeños roedores."));
        anfibios.agregarEntrada(
                new Anfibio("tritón", "América y África.", "Insectos."));
        System.out.print("Introduzca el tipo de anfibio: ");
        String tipo = s.nextLine();
        Anfibio a = anfibios.buscarAnfibio(tipo);
        if (a != null)
            System.out.println(a);
        else
            System.out.println("Ese tipo de anfibio no existe.");
        s.close();
    }
}