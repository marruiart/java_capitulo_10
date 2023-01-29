package classes;

import java.util.*;
import java.text.*;
import exceptions.*;

public class Carrito extends Almacen {
    private final Almacen TIENDA;
    private ArrayList<Articulo> compra = new ArrayList<>();
    private String numeroTicket;
    private DateFormat horaCompra;
    private double total;

    public Carrito() {
        this(new Almacen());
    }

    public Carrito(Almacen almacen) {
        this.TIENDA = almacen;
    }

    public Articulo filtraArticulo(String codigo) throws articleIsNullException {
        ArrayList<Articulo> aux = (ArrayList<Articulo>) compra.clone();
        Articulo art = null;
        aux.removeIf(a -> !a.equals(new Articulo(codigo)));
        if (aux.size() > 0)
            art = aux.get(0);
        return art;
    }

    public String getCodigo() {
        return this.numeroTicket;
    }

    public Almacen getTienda() {
        return this.TIENDA;
    }

    public ArrayList<Articulo> getCompra() {
        return this.compra;
    }

    public DateFormat getHoraCompra() {
        return this.horaCompra;
    }

    public void verCarrito() {
        for (Articulo a : compra) {
            System.out.println(a);
        }
    }

    public Articulo agregarArticulo(String codigo) throws stockNotFoundException, articleIsNullException {
        return agregarArticulos(codigo, 1);
    }

    public Articulo agregarArticulos(String codigo, int cantidad)
            throws stockNotFoundException, articleIsNullException {
        Articulo a = filtraArticulo(codigo);
        if (compra.contains(a)) {
            a.addUnidades(cantidad);
        } else {
            a = new Articulo(codigo, TIENDA.buscarArticulo(codigo).getNombre(),
                    TIENDA.buscarArticulo(codigo).getPrecio(), cantidad);
            compra.add(a);
        }
        return a;
    }

    public Articulo eliminarDelCarrito(String codigo)
            throws notEnoughArticlesException, stockNotFoundException, articleIsNullException {
        return eliminarDelCarrito(codigo, 1);
    }

    public Articulo eliminarDelCarrito(String codigo, int cantidad)
            throws notEnoughArticlesException, stockNotFoundException, articleIsNullException {
        Articulo a = filtraArticulo(codigo);
        Articulo aux = a;
        if (compra.contains(a)) {
            if (cantidad < 0 || (a.getUnidades() - cantidad) < 0)
                throw new notEnoughArticlesException("\nNo se puede eliminar esa cantidad de artículos.");
            else if (a.getUnidades() - cantidad == 0) {
                compra.remove(a);
            } else {
                a.removeUnidades(cantidad);
            }
        } else
            throw new notEnoughArticlesException("\nEl artículo no se encuentra en el carrito.");
        return aux;
    }

    public void finalizarCompra() throws stockNotFoundException, notEnoughArticlesException {
        this.horaCompra = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Integer n = Compras.numeroCompras() == null ? 1 : Compras.numeroCompras() + 1;
        numeroTicket = TIENDA.generarCodigo(n.toString());
        Compras.hacerCompra(this);
        Compras.imprimirTicket(this);
    }

    @Override
    public String toString() {
        this.total = 0;
        String carrito = String.format("  TICKET DE COMPRA nº %s      %55s\n", this.numeroTicket,
                this.horaCompra.format(new Date()));
        carrito += "--------------------------------------------------------------------------------------------\n";
        for (Articulo a : compra) {
            this.total += (a.getPrecio() * a.getUnidades());
            carrito += a + "\n";
        }
        carrito += "--------------------------------------------------------------------------------------------\n";
        carrito += String.format("%70s  TOTAL: %.2f euros ", "", this.total);
        return carrito;
    }
}
