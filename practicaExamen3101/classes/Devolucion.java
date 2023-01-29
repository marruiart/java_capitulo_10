package classes;

import java.util.*;
import java.text.*;
import exceptions.*;

public class Devolucion {
    private ArrayList<Articulo> articulos = new ArrayList<>();
    private Carrito articulosComprados;
    private DateFormat horaDevolucion;
    private double total;

    public Devolucion(String codigoCompra) throws articleNotSoldException {
        articulosComprados = Compras.getCompra(codigoCompra);
    }

    public Almacen getTienda() {
        return this.articulosComprados.getTienda();
    }

    public DateFormat getHoraDevolucion() {
        return this.horaDevolucion;
    }

    public Carrito consultarTicket() {
        return articulosComprados;
    }

    public ArrayList<Articulo> getArticulos() {
        return this.articulos;
    }

    public Articulo devolverArticulo(String codigo)
            throws notEnoughArticlesException, stockNotFoundException, articleIsNullException,
            CloneNotSupportedException {
        return devolverArticulos(codigo, 1);
    }

    public Articulo devolverArticulos(String codigo, int cantidad)
            throws notEnoughArticlesException, stockNotFoundException, articleIsNullException,
            CloneNotSupportedException {
        Articulo a = articulosComprados.filtraArticulo(codigo);
        if (a == null || a.getUnidades() < cantidad)
            throw new notEnoughArticlesException("Esos artículos no están en este ticket de compra.");
        Articulo clon = (Articulo) a.clone();
        clon.setUnidades(cantidad);
        articulos.add(clon);
        return clon;
    }

    public String finalizarDevolucion()
            throws stockNotFoundException, notEnoughArticlesException, articleIsNullException {
        this.horaDevolucion = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Devoluciones.hacerDevolucion(this);
        return this.toString();
    }

    @Override
    public String toString() {
        this.total = 0;
        String devolucion = String.format("  DEVOLUCIÓN       %70s\n", this.horaDevolucion.format(new Date()));
        devolucion += "--------------------------------------------------------------------------------------------\n";
        for (Articulo a : articulos) {
            this.total += (a.getPrecio() * a.getUnidades());
            devolucion += a + "\n";
        }
        devolucion += "--------------------------------------------------------------------------------------------\n";
        devolucion += String.format("%70s  TOTAL: -%.2f euros ", "", this.total);
        return devolucion;
    }
}
