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

    public void setUnidades(int cantidad) {
        this.unidades += cantidad;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj.getClass() == this.getClass() && this.nombre.equals(((Elemento) obj).getNombre()));
    }

    @Override
    public String toString() {
        return String.format("%s PVP: %.2f Unidades: %d Subtotal: %.2f\n",
                this.nombre, this.precio, this.unidades, this.precio * this.unidades);
    }
}
