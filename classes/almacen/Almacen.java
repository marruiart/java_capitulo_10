package classes.almacen;

import java.util.ArrayList;

public class Almacen {
    private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    private static int espacio;
    private static int espacioMax = 1000;

    public Almacen() {
        this(espacioMax);
    }

    public Almacen(int espacio) {
        Almacen.espacio = espacio;
    }

    public static int getEspacio() {
        return Almacen.espacio;
    }

    public Articulo buscarArticulo(String codigo) {
        for (Articulo a : articulos)
            if (a.getCodigo().equals(codigo))
                return a;
        return null;
    }

    public void hacerListado() {
        if (articulos.size() == 0)
            System.out.println("\nNo se ha encontrado ningún artículo.");
        else {
            for (Articulo a : articulos)
                System.out.print(a);
        }
    }

    public void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    public boolean borrarArticulo(String codigo) {
        for (Articulo a : articulos)
            if (a.getCodigo().equals(codigo)) {
                if (a.getStock() > 0) {
                    System.out.println("\nError al borrar. Quedan artículos en stock.");
                    return false;
                }
                articulos.remove(a);
                System.out.println("\nArtículo borrado.");
                return true;
            }
        System.out.println("\nNo se ha encontrado ese artículo");
        return false;
    }
}