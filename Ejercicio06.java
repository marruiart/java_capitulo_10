
/**
 * Implementa el control de acceso al área restringida de un programa. Se debe
 * pedir un nombre de usuario y una contraseña. Si el usuario introduce los
 * datos correctamente, el programa dirá “Ha accedido al área restringida”. El
 * usuario tendrá un máximo de 3 oportunidades. Si se agotan las oportunidades
 * el programa dirá “Lo siento, no tiene acceso al área restringida”. Los
 * nombres de usuario con sus correspondientes contraseñas deben estar
 * almacenados en una estructura de la clase HashMap.
 * 
 * @author: Marina Ruiz Artacho
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int intentos = 1;
        boolean acceso = false;
        HashMap<String, String> usuarios = new HashMap<String, String>();
        for (int i = 0; i < 20; i++) {
            String u = "user" + i;
            String p = "pass" + i;
            usuarios.put(u, p);
        }

        do {
            System.out.print("Introduzca usuario: ");
            String u = s.next();
            if (!usuarios.containsKey(u)) {
                System.out.println("El usuario introducido no existe.");
                continue;
            }
            System.out.print("Introduzca contraseña: ");
            String p = s.next();
            if (usuarios.get(u).equals(p)) {
                System.out.println("Ha accedido al área restringida.");
                acceso = true;
            } else {
                System.out.printf("Los datos introducidos son incorrectos. Intento %d/3\n", intentos);
                intentos++;
            }
        } while (intentos <= 3 && !acceso);
        if (!acceso)
            System.out.println("Lo siento, no tiene acceso al área restringida");
    }
}
