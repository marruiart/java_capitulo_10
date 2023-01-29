package classes;

import java.util.*;
import exceptions.*;

public class Devoluciones extends Almacen {
    protected static HashMap<String, Devolucion> devoluciones = new HashMap<>();

    private Devoluciones(Devolucion articulos)
            throws stockNotFoundException, notEnoughArticlesException, articleIsNullException {
        devoluciones.put(generarCodigo(((Integer) devoluciones.size()).toString()), articulos);
        for (Articulo a : articulos.getArticulos()) {
            (articulos.getTienda()).devolverStock(a.getCodigo(), a.getUnidades());
        }
    }

    public static String imprimirTicket(Carrito c) {
        String ticket = c.toString();
        System.out.println(ticket);
        return ticket;
    }

    public static void hacerDevolucion(Devolucion articulos)
            throws stockNotFoundException, notEnoughArticlesException, articleIsNullException {
        new Devoluciones(articulos);
    }

    public static void imprimirDevoluciones() {
        String listaDevoluciones = "DEVOLUCIONES REALIZADAS\n";
        listaDevoluciones += "==============================================================================================================================\n";
        for (Map.Entry<String, Devolucion> d : devoluciones.entrySet()) {
            listaDevoluciones += d.getValue() + "\n";
        }
        System.out.println(listaDevoluciones);
    }
}
