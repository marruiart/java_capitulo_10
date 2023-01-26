package classes.tienda;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Elemento> lista = new ArrayList<Elemento>();

    public Carrito() {

    }

    public Elemento agrega(Elemento e) {
        lista.add(e);
        return e;
    }

    public int numeroDeElementos() {
        return lista.size();
    }

    public int numeroDeUnidades() {
        int cantidad = 0;
        for (Elemento e : lista)
            cantidad += e.getUnidades();
        return cantidad;
    }

    public double importeTotal() {
        double importeTotal = 0;
        for (Elemento e : lista) {
            importeTotal += (e.getPrecio() * e.getUnidades());
        }
        return importeTotal;
    }

    @Override
    public String toString() {
        String carrito = "Contenido del carrito\n" +
                "=====================\n";
        for (Elemento e : lista) {
            carrito += e;
        }
        return carrito;
    }
}
