package classes.supermercado;

import java.util.HashMap;

public class Supermercado {
    protected HashMap<String, Producto> productos = new HashMap<>();

    public void agregaProducto(Producto p) {
        this.productos.put(p.getNombre(), p);
    }

    public void eliminaProducto(Producto p) {
        this.productos.put(p.getNombre(), p);
    }
}
