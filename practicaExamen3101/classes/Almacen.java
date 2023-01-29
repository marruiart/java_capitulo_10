package classes;

import java.util.*;
import exceptions.*;

public class Almacen {
    private final String NOMBRE;
    private static int n = 0;
    protected HashMap<String, Articulo> stock = new HashMap<>();

    public Almacen() {
        this.NOMBRE = "Almacen " + (++n);
    }

    public String generarCodigo(String numero) {
        String codigo = "";
        for (int i = 0; i < 10 - numero.length(); i++) {
            codigo += "0";
        }
        return codigo + numero;
    }

    public Articulo buscarArticulo(String codigo) throws stockNotFoundException {
        Articulo art = stock.get(codigo);
        if (art == null || art.getUnidades() == 0)
            throw new stockNotFoundException("\nEl artículo no se encuentra en el almacén.");
        return art;
    }

    private ArrayList<Articulo> listadoArticulos() {
        ArrayList<Articulo> articulos = new ArrayList<>();
        for (Map.Entry<String, Articulo> a : stock.entrySet()) {
            articulos.add(a.getValue());
        }
        return articulos;
    }

    protected Articulo sacarStock(String codigo, int cantidad)
            throws stockNotFoundException, notEnoughArticlesException {
        try {
            Articulo art = buscarArticulo(codigo);
            if (art.getUnidades() - cantidad < 0)
                throw new notEnoughArticlesException("\nNo hay suficiente stock en el almacén.");
            art.removeUnidades(cantidad);
            return art;
        } catch (stockNotFoundException snf) {
            throw snf;
        }
    }

    protected Articulo devolverStock(String codigo, int cantidad)
            throws articleIsNullException, stockNotFoundException {
        Articulo a = buscarArticulo(codigo);
        return agregarStock(new Articulo(codigo, a.getNombre(), a.getPrecio(), cantidad));
    }

    public Articulo agregarStock(Articulo art) throws articleIsNullException {
        if (art == null)
            throw new articleIsNullException("\nNo se puede agregar un artículo nulo.");
        if (stock.containsKey(art.getCodigo())) {
            art.addUnidades(stock.get(art.getCodigo()).getUnidades());
            stock.put(art.getCodigo(), art);
        } else
            stock.put(art.getCodigo(), art);
        return art;
    }

    public Articulo agregarStock(String codigo, String nombre, double precio, int unidades) {
        return new Articulo(codigo, nombre, precio, unidades);
    }

    public ArrayList<Articulo> filtrarPorNombre(String nombre) throws stockNotFoundException {
        ArrayList<Articulo> articulos = listadoArticulos();
        if (articulos.isEmpty())
            throw new stockNotFoundException("\nNo se han encontrado artículos en el almacén.");
        articulos.removeIf(a -> !a.getNombre().startsWith(nombre));
        return articulos;
    }

    public ArrayList<Articulo> ordenarAZ() throws stockNotFoundException {
        ArrayList<Articulo> articulos = listadoArticulos();
        if (articulos.isEmpty())
            throw new stockNotFoundException("\nNo se han encontrado artículos en el almacén.");
        Collections.sort(articulos);
        return articulos;
    }

    public ArrayList<Articulo> ordenarZA() throws stockNotFoundException {
        ArrayList<Articulo> articulos = listadoArticulos();
        if (articulos.isEmpty())
            throw new stockNotFoundException("\nNo se han encontrado artículos en el almacén.");
        Collections.sort(articulos, Collections.reverseOrder());
        return articulos;
    }

    public ArrayList<Articulo> ordenarPrecioAscendente() throws stockNotFoundException {
        ArrayList<Articulo> articulos = listadoArticulos();
        if (articulos.isEmpty())
            throw new stockNotFoundException("\nNo se han encontrado artículos en el almacén.");
        Collections.sort(articulos, Articulo.precioArticuloComparator);
        return articulos;
    }

    public Articulo consultarStockArticulo(String codigo) throws stockNotFoundException {
        Articulo art = this.buscarArticulo(codigo);
        if (art == null || art.getUnidades() == 0)
            throw new stockNotFoundException("\nEl artículo no se encuentra en el almacén.");
        return art;
    }

    public String consultarStock(ArrayList<Articulo> articulos) throws stockNotFoundException {
        String stockAlmacen = "\nSTOCK EN ALMACÉN\n==============================================================================================================================\n";
        for (Articulo a : articulos) {
            stockAlmacen += a + "\n";
        }
        return stockAlmacen;
    }

    public String consultarStock() throws stockNotFoundException {
        return consultarStock(listadoArticulos());
    }

    @Override
    public String toString() {
        return this.NOMBRE;
    }
}
