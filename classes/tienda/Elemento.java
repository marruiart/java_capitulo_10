package classes.tienda;

public class Elemento {
    private String nombre;
    private double precio;
    private int unidades;

    public Elemento(String nombre, double precio) {
        this(nombre, precio, 0);
    }

    public Elemento(String nombre, double precio, int unidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getUnidades() {
        return this.unidades;
    }
}
