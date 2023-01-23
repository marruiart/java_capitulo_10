import java.util.Scanner;
import classes.almacen.*;

/**
 * Modifica el programa Gestisimal realizado anteriormente añadiendo las
 * siguientes mejoras:
 * • Utiliza una lista en lugar de un array para el almacenamiento de los datos.
 * • Comprueba la existencia del código en el alta, la baja y la modificación de
 * artículos para evitar errores.
 * • Cambia la opción “Salida de stock” por “Venta”. Esta nueva opción permitirá
 * hacer una venta de varios artículos y emitir la factura correspondiente. Se
 * debe preguntar por los códigos y las cantidades de cada artículo que se
 * quiere comprar. Aplica un 21% de IVA.
 * 
 * @author: Marina Ruiz Artacho
 */

public class Ejercicio13 {
    static Scanner s = new Scanner(System.in);

    public static void printMenu() {
        System.out.print("\nGESTISIMAL\n" +
                "===================\n" +
                "1. Listado\n" +
                "2. Alta\n" +
                "3. Baja\n" +
                "4. Modificación\n" +
                "5. Entrada de mercancía\n" +
                "6. Salida de mercancía\n" +
                "7. Salir\n" +
                "Introduzca una opción: ");
    }

    public static void listarArticulos(Almacen almacen) {
        System.out.print("\nLISTADO\n" +
                "=======\n");
        almacen.hacerListado();
    }

    public static boolean comprobarCodigo(Almacen almacen, String codigo) {
        if (almacen.buscarArticulo(codigo) != null) {
            System.out.println("\nEl código introducido ya existe");
            return false;
        }
        return true;
    }

    public static void altaArticulo(Almacen almacen) {
        String codigo, descripcion;
        double precioCompra, precioVenta;
        System.out.print("\nALTA ARTÍCULO\n" +
                "===========\n" +
                "Por favor, introduzca los datos del articulo.\n");
        System.out.print("Código: ");
        codigo = s.next();
        if (!comprobarCodigo(almacen, codigo))
            return;
        System.out.print("Descripción: ");
        descripcion = s.next();
        System.out.print("Precio de compra: ");
        precioCompra = s.nextDouble();
        System.out.print("Precio de Venta: ");
        precioVenta = s.nextDouble();
        almacen.agregarArticulo(new Articulo(codigo, descripcion, precioCompra, precioVenta));
    }

    public static boolean bajaArticulo(Almacen almacen) {
        String codigo;
        System.out.print("\nBAJA ARTÍCULO\n" +
                "======\n" +
                "Por favor, introduzca el código del articulo que desea borrar: ");
        codigo = s.next();
        if (!almacen.borrarArticulo(codigo))
            return false;
        return true;
    }

    public static void modificarArticulo(Almacen almacen) {
        String codigo, descripcion;
        double precioCompra, precioVenta;
        System.out.print("\nMODIFICAR ARTÍCULO\n" +
                "=========\n" +
                "Por favor, introduzca el código del articulo cuyos datos desea cambiar: ");
        codigo = s.next();
        Articulo articulo = almacen.buscarArticulo(codigo);
        if (articulo == null) {
            System.out.println("\nArtículo no encontrado.");
            return;
        }
        System.out.print("Introduzca los nuevos datos del articulo.");
        System.out.print("\nCódigo: " + articulo.getCodigo());
        System.out.print("\nNuevo código: ");
        codigo = s.next();
        if (!articulo.getCodigo().equals(codigo) && !comprobarCodigo(almacen, codigo))
            return;
        System.out.print("\nDescripción: " + articulo.getDescripcion());
        System.out.print("\nNueva descripcion: ");
        descripcion = s.next();
        System.out.print("\nPrecio de compra: " + articulo.getPrecioCompra());
        System.out.print("\nNuevo precio de compra: ");
        precioCompra = s.nextDouble();
        System.out.print("\nPrecio de venta: " + articulo.getPrecioVenta());
        System.out.print("\nNuevo precio de venta: ");
        precioVenta = s.nextDouble();
        articulo.modificar(codigo, descripcion, precioCompra, precioVenta);
    }

    public static void entradaMercancia(Almacen almacen) {
        String codigo;
        int cantidad;
        System.out.print("\nENTRADA MERCANCÍA\n" +
                "=========\n" +
                "Por favor, introduzca el código del articulo que entra al almacén: ");
        codigo = s.next();
        Articulo articulo = almacen.buscarArticulo(codigo);
        if (articulo == null) {
            System.out.println("\nArtículo no encontrado.");
            return;
        }
        System.out.print("¿Cuántos artículos entran? ");
        cantidad = s.nextInt();
        articulo.agregarStock(cantidad);
    }

    public static void salidaMercancia(Almacen almacen) {
        String codigo;
        int cantidad;
        System.out.print("\nSALIDA MERCANCÍA\n" +
                "=========\n" +
                "Por favor, introduzca el código del articulo que sale del almacén: ");
        codigo = s.next();
        Articulo articulo = almacen.buscarArticulo(codigo);
        if (articulo == null) {
            System.out.println("\nArtículo no encontrado.");
            return;
        }
        System.out.print("¿Cuántos artículos salen? ");
        cantidad = s.nextInt();
        articulo.reducirStock(cantidad);
    }

    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        int opcion;
        do {
            printMenu();
            opcion = s.nextInt();
            switch (opcion) {
                case 1 -> listarArticulos(almacen);
                case 2 -> altaArticulo(almacen);
                case 3 -> bajaArticulo(almacen);
                case 4 -> modificarArticulo(almacen);
                case 5 -> entradaMercancia(almacen);
                case 6 -> salidaMercancia(almacen);
                case 7 -> System.out.println("¡Adiós!");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 7);
        s.close();
    }
}