package classes;

import java.util.*;
import exceptions.*;

public class Compras extends Almacen {
    protected static HashMap<String, Carrito> compras = new HashMap<>();

    private Compras(Carrito carrito) throws stockNotFoundException, notEnoughArticlesException {
        Almacen almacen = carrito.getTienda();
        for (Articulo a : carrito.getCompra()) {
            almacen.sacarStock(a.getCodigo(), a.getUnidades());
        }
        compras.put(carrito.getCodigo(), carrito);
    }

    public static Integer numeroCompras() {
        return compras.size();
    }

    public static String imprimirTicket(Carrito c) {
        String ticket = c.toString();
        System.out.println(ticket);
        return ticket;
    }

    public static void hacerCompra(Carrito carrito)
            throws stockNotFoundException, notEnoughArticlesException, articleNotSoldException {
        if (!carrito.getCompra().isEmpty())
            new Compras(carrito);
        else
            throw new articleNotSoldException("El carrito está vacío.");
    }

    public static String getCodigoCompra(Carrito c) throws articleNotSoldException {
        for (Map.Entry<String, Carrito> m : compras.entrySet()) {
            if (c.equals(m.getValue()))
                return m.getKey();
        }
        throw new articleNotSoldException("\nEl artículo no está en esta compra.");
    }

    public static Carrito getCompra(String codigo) throws articleNotSoldException {
        for (Map.Entry<String, Carrito> m : compras.entrySet()) {
            if (codigo.equals(m.getKey()))
                return m.getValue();
        }
        throw new articleNotSoldException("\nEl código de compra no existe.");
    }

    public static void imprimirCompras() {
        String listaCompras = "COMPRAS REALIZADAS\n";
        listaCompras += "==============================================================================================================================\n";
        for (Map.Entry<String, Carrito> c : compras.entrySet()) {
            listaCompras += c.getValue() + "\n";
        }
        System.out.println(listaCompras);
    }
}
