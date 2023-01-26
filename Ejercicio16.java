import java.util.Scanner;

import classes.Paises;

/**
 * Realiza un programa que sepa decir la capital de un país (en caso de conocer
 * la respuesta) y que, además, sea capaz de aprender nuevas capitales. En
 * principio, el programa solo conoce las capitales de España, Portugal y
 * Francia. Estos datos deberán estar almacenados en un diccionario. Los datos
 * sobre capitales que vaya aprendiendo el programa se deben almacenar en el
 * mismo diccionario. El usuario sale del programa escribiendo la palabra
 * “salir”.
 * 
 * @author: Marina Ruiz Artacho
 */

public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Paises paises = new Paises();
        String pais;

        do {
            System.out.print("Escribe el nombre de un país y te diré su capital: ");
            pais = s.nextLine();
            if (!pais.equals("salir")) {
                String capital = paises.getCapital(pais);
                if (capital != null)
                    System.out.printf("La capital de %s es %s\n", pais, paises.capitales.get(pais));
                else {
                    System.out.print("No conozco la respuesta ¿cuál es la capital de Alemania? ");
                    capital = s.nextLine();
                    paises.agregar(pais, capital);
                    System.out.println("Gracias por enseñarme nuevas capitales");
                }
            }
        } while (!pais.equals("salir"));
        s.close();
    }
}
