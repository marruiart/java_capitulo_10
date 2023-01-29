package classes;

import java.util.Comparator;

public class Articulo implements Cloneable, Comparable<Articulo> {
    private String codigo;
    private String nombre;
    private Double precio;
    private int unidades;

    public Articulo(String codigo) {
        this(codigo, null, null, 0);
    }

    public Articulo(String codigo, String nombre, Double precio, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public int getUnidades() {
        return this.unidades;
    }

    public void setUnidades(int cantidad) {
        this.unidades = cantidad;
    }

    public void addUnidades(int cantidad) {
        this.unidades += cantidad;
    }

    public void removeUnidades(int cantidad) {
        this.unidades -= cantidad;
    }

    public static Comparator<Articulo> precioArticuloComparator = new Comparator<Articulo>() {
        public int compare(Articulo a1, Articulo a2) {
            Double precioA1 = a1.getPrecio();
            Double precioA2 = a2.getPrecio();
            return precioA1.compareTo(precioA2);
        }
    };

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Articulo(this.codigo, this.nombre, this.precio, this.unidades);
    }

    @Override
    public int compareTo(Articulo a) {
        return (this.getNombre()).compareTo(a.getNombre());
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass()) && (this.codigo).equals(((Articulo) obj).getCodigo());
    }

    @Override
    public String toString() {
        return String.format("   { %s - %-32s   %-5.2f x %4d ud   Subtotal: %-8.2f }",
                codigo, nombre, precio, unidades, precio * unidades);
    }

}