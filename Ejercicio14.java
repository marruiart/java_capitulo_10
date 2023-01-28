import java.util.Scanner;

import classes.supermercado.*;
import exceptions.productNotAvailable;

/**
 * Un supermercado de productos ecológicos nos ha pedido hacer un programa para
 * vender su mercancía. En esta primera versión del programa se tendrán en
 * cuenta los productos que se indican en la tabla junto con su precio. Los
 * productos se venden en bote, brick, etc. Cuando se realiza la compra, hay que
 * indicar el producto y el número de unidades que se compran, por ejemplo
 * “guisantes” si se quiere comprar un bote de guisantes y la cantidad, por
 * ejemplo “3” si se quieren comprar 3 botes. La compra se termina con la
 * palabra “fin. Suponemos que el usuario no va a intentar comprar un producto
 * que no existe. Utiliza un diccionario para almacenar los nombres y precios de
 * los productos y una o varias listas para almacenar la compra que realiza el
 * usuario.
 * 
 * avena 2,21
 * garbanzos 2,39
 * tomate 1,59
 * jengibre 3,13
 * quinoa 4,50
 * guisantes 1,60
 * 
 * @author: Marina Ruiz Artacho
 */

public class Ejercicio14 {
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

        System.out.println(compra);
        s.close();
    }
}
