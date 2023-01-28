
/**
 * Realiza una nueva versión del ejercicio anterior con las siguientes mejoras:
 * Si algún producto se repite en diferentes líneas, se deben agrupar en una
 * sola. Por ejemplo, si se pide primero 1 bote de tomate y luego 3 botes de
 * tomate, en el extracto se debe mostrar que se han pedido 4 botes de tomate.
 * Después de teclear “fin”, el programa pide un código de descuento. Si el
 * usuario introduce el código “ECODTO”, se aplica un 10% de descuento en la
 * compra.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;
import classes.supermercado.*;
import exceptions.productNotAvailable;

public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Supermercado mercadona = new Supermercado();
        Carrito compra = new Carrito(mercadona);
        String producto;
        int cantidad;
        mercadona.agregaProducto(new Producto("avena", 2.21));
        mercadona.agregaProducto(new Producto("garbanzos", 2.39));
        mercadona.agregaProducto(new Producto("tomate", 1.59));
        mercadona.agregaProducto(new Producto("jengibre", 3.13));
        mercadona.agregaProducto(new Producto("quinoa", 4.50));
        mercadona.agregaProducto(new Producto("guisantes", 1.60));

        do {
            System.out.print("Producto: ");
            producto = s.nextLine();
            if (producto.equals("fin"))
                break;
            System.out.print("Cantidad: ");
            cantidad = Integer.parseInt(s.nextLine());
            try {
                compra.agregaProducto(producto, cantidad);
            } catch (productNotAvailable pna) {
                System.out.println(pna.getMessage());
            }
        } while (true);
        System.out.print("Introduzca código de descuento (INTRO si no tiene ninguno): ");
        String dto = s.nextLine();
        compra.setDescuento(dto);
        System.out.println(compra);
        s.close();
    }
}