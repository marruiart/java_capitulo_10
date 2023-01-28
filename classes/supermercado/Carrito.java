package classes.supermercado;

import java.util.ArrayList;
import exceptions.*;

public class Carrito {
    private Supermercado supermercado;
    private ArrayList<Producto> lista = new ArrayList<>();
    private boolean descuento = false;

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

    public void setDescuento(String dto) {
        if (dto.equals("ECODTO"))
            this.descuento = true;
    }

    @Override
    public String toString() {
        double dto = 0;
        String ticket = ("Producto Precio Cantidad Subtotal\n" +
                "--------------------------------\n");
        for (Producto p : lista)
            ticket += p + "\n";
        if (this.descuento) {
            dto = this.precioTotal() * 0.10;
            ticket += String.format("--------------------------------\n" +
                    "Descuento: %.2f euros\n", dto);
        }
        ticket += String.format("--------------------------------\n" +
                "TOTAL: %.2f euros", this.precioTotal() - dto);
        return ticket;
    }

}
