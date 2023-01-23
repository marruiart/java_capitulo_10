package classes.almacen;

public class Articulo {
    private String codigo;
    public String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int stock;

    public Articulo(String codigo, String descripcion, double precioCompra, double precioVenta) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = 0;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return this.precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return this.precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return this.stock;
    }

    public void agregarStock(int cantidad) {
        this.stock += cantidad;
    }

    public boolean reducirStock(int cantidad) {
        if (this.stock - cantidad < 0) {
            System.out.println("No quedan tantos artículos en stock.");
            return false;
        }
        this.stock -= cantidad;
        return true;
    }

    public void modificar(String codigo, String descripcion, double precioCompra, double precioVenta) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "{" +
                " codigo: " + getCodigo() +
                ", descripcion: " + getDescripcion() +
                ", precioCompra: " + getPrecioCompra() +
                ", precioVenta: " + getPrecioVenta() +
                ", stock disponible: " + getStock() +
                "}\n";
    }

}
