package classes.tienda;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Elemento> lista = new ArrayList<Elemento>();

    public Elemento agrega(Elemento e) {
        lista.add(e);
        return e;
    }

    public int numeroDeElementos() {
        return lista.size();
    }

    public double importeTotal() {
        double importeTotal = 0;
        for (int i = 0; i < this.numeroDeElementos(); i++) {
            importeTotal += (lista.get(i).getPrecio() * lista.get(i).getUnidades());
        }
        return importeTotal;
    }

    @Override
    public String toString() {
        String carrito = "Contenido del carrito\n" +
                "=====================\n";
        // concatenar cada e del carrito
        for (int i = 0; i < this.numeroDeElementos(); i++) {
            carrito += String.format("%s PVP: %.2f Unidades: %d Subtotal: %.2f\n", lista.get(i).getNombre(),
                    lista.get(i).getPrecio(), lista.get(i).getUnidades(),
                    lista.get(i).getPrecio() * lista.get(i).getUnidades());
        }
        return carrito;
    }
}
