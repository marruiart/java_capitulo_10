package classes.supermercado;

import java.util.ArrayList;
import exceptions.*;

public class Carrito {
    private Supermercado supermercado;
    private ArrayList<Producto> lista = new ArrayList<>();

    public Carrito(Supermercado supermercado) {
        this.supermercado = supermercado;
    }

    public void agregaProducto(String nombre, int cantidad) throws productNotAvailable {
        Producto p = supermercado.productos.get(nombre);
        if (p == null) {
            throw new productNotAvailable("Lo sentimos, no disponemos de ese producto");
        } else if (lista.contains(p)) {
            Producto l = lista.get(lista.indexOf(p));
            l.setCantidad(l.getCantidad() + cantidad);
        } else {
            lista.add(p);
            agregaProducto(p.getNombre(), cantidad);
        }
    }

    public double precioTotal() {
        double total = 0;
        for (Producto p : lista)
            total += (p.getPrecio() * p.getCantidad());
        return total;
    }

    @Override
    public String toString() {
        String ticket = ("Producto Precio Cantidad Subtotal\n" +
                "--------------------------------\n");
        for (Producto p : lista)
            ticket += p + "\n";
        ticket += String.format("--------------------------------\n" +
                "TOTAL: %.2f euros", this.precioTotal());
        return ticket;
    }

}
