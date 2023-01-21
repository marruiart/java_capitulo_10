
/**
 * Realiza de nuevo el ejercicio de la colección de discos pero utilizando esta
 * vez una lista para almacenar la información sobre los discos en lugar de un
 * array convencional.
 * 
 * @author: Marina Ruiz Artacho
 */

import java.util.Scanner;
import classes.coleccion_discos.*;

public class Ejercicio05 {
    static Scanner s = new Scanner(System.in);

    public static void printMenu() {
        System.out.print("\nCOLECCIÓN DE DISCOS\n" +
                "===================\n" +
                "1. Listado\n" +
                "2. Nuevo disco\n" +
                "3. Modificar\n" +
                "4. Borrar\n" +
                "5. Salir\n" +
                "Introduzca una opción: ");
    }

    public static void listarDiscos(ColeccionDiscos coleccion) {
        int opcion;
        System.out.print("\nLISTADO\n" +
                "=======\n" +
                "1. Mostrar todos los discos\n" +
                "2. Listar por autor\n" +
                "3. Listar por género\n" +
                "4. Listar por duración\n" +
                "Introduzca una opción: ");
        opcion = s.nextInt();
        switch (opcion) {
            case 1:
                coleccion.hacerListado();
                break;
            case 2:
                System.out.print("Introduzca el nombre del autor: ");
                String autor = s.next();
                coleccion.hacerListado(autor, opcion);
                break;
            case 3:
                System.out.print("Introduzca el género del álbum: ");
                String genero = s.next();
                coleccion.hacerListado(genero, opcion);
                break;
            case 4:
                System.out.print("Introduzca la duración mínima: ");
                int min = s.nextInt();
                System.out.print("Introduzca la duración máxima: ");
                int max = s.nextInt();
                coleccion.hacerListado(min, max);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public static boolean comprobarCodigo(ColeccionDiscos coleccion, String codigo) {
        if (coleccion.buscarDisco(codigo) != null) {
            System.out.println("\nEl código introducido ya existe");
            return false;
        }
        return true;
    }

    public static void nuevoDisco(ColeccionDiscos coleccion) {
        String codigo, autor, titulo, genero;
        int duracion;
        System.out.print("\nNUEVO DISCO\n" +
                "===========\n" +
                "Por favor, introduzca los datos del disco.\n");
        System.out.print("Código: ");
        codigo = s.next();
        if (!comprobarCodigo(coleccion, codigo))
            return;
        System.out.print("Autor: ");
        autor = s.next();
        System.out.print("Título: ");
        titulo = s.next();
        System.out.print("Género: ");
        genero = s.next();
        System.out.print("Duración: ");
        duracion = s.nextInt();
        coleccion.agregarDisco(new Disco(codigo, autor, titulo, genero, duracion));
    }

    public static void modificarDisco(ColeccionDiscos coleccion) {
        String codigo, autor, titulo, genero;
        int duracion;
        System.out.print("\nMODIFICAR\n" +
                "=========\n" +
                "Por favor, introduzca el código del disco cuyos datos desea cambiar: ");
        codigo = s.next();
        Disco disco = coleccion.buscarDisco(codigo);
        if (disco == null) {
            System.out.println("\nÁlbum no encontrado.");
            return;
        }
        System.out.print("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");
        System.out.print("\nCódigo: " + disco.getCodigo());
        System.out.print("\nNuevo código: ");
        codigo = s.next();
        if (!disco.getCodigo().equals(codigo) && !comprobarCodigo(coleccion, codigo))
            return;
        System.out.print("\nAutor: " + disco.getAutor());
        System.out.print("\nNuevo autor: ");
        autor = s.next();
        System.out.print("\nTítulo: " + disco.getTitulo());
        System.out.print("\nNuevo título: ");
        titulo = s.next();
        System.out.print("\nGénero: " + disco.getGenero());
        System.out.print("\nNuevo género: ");
        genero = s.next();
        System.out.print("\nDuración: " + disco.getDuracion());
        System.out.print("\nNueva duración: ");
        duracion = s.nextInt();
        disco.modificar(codigo, autor, titulo, genero, duracion);
    }

    public static void borrarDisco(ColeccionDiscos coleccion) {
        String codigo;
        System.out.print("\nBORRAR\n" +
                "======\n" +
                "Por favor, introduzca el código del disco que desea borrar: ");
        codigo = s.next();
        coleccion.borrarDisco(coleccion.buscarDisco(codigo));
    }

    public static void main(String[] args) {
        ColeccionDiscos coleccion = new ColeccionDiscos();
        int opcion;
        do {
            printMenu();
            opcion = s.nextInt();
            switch (opcion) {
                case 1 -> listarDiscos(coleccion);
                case 2 -> nuevoDisco(coleccion);
                case 3 -> modificarDisco(coleccion);
                case 4 -> borrarDisco(coleccion);
                case 5 -> System.out.println("¡Adiós!");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 5);
        s.close();
    }
}
