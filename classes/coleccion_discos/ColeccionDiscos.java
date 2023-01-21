package classes.coleccion_discos;

import java.util.ArrayList;

public class ColeccionDiscos {
    protected ArrayList<Disco> discos;

    public ColeccionDiscos() {
        this.discos = new ArrayList<Disco>();
    }

    public Disco buscarDisco(String codigo) {
        for (Disco d : discos)
            if (d.getCodigo().equals(codigo))
                return d;
        return null;
    }

    private int buscarPosicionDisco(String codigo) {
        for (int i = 0; i < discos.size(); i++)
            if (discos.get(i).getCodigo().equals(codigo))
                return i;
        return -1;
    }

    public void hacerListado(int min, int max) {
        int count = 0;
        for (Disco d : discos) {
            if (d.duracion >= min && d.duracion <= max) {
                System.out.print(d);
                count++;
            }
        }
        if (count == 0)
            System.out.println("\nNo se ha encontrado ningún álbum.");

    }

    public void hacerListado(String nombre, int filtro) {
        int count = 0;
        for (Disco d : discos) {
            if (filtro == 2 && d.autor.equals(nombre)) {
                System.out.print(d);
                count++;
            } else if (filtro == 3 && d.genero.equals(nombre)) {
                System.out.print(d);
                count++;
            }
        }
        if (count == 0)
            System.out.println("\nNo se ha encontrado ningún álbum.");

    }

    public void hacerListado() {
        int count = 0;
        for (int i = 0; i < discos.size(); i++)
            if (discos.get(i) != null) {
                System.out.print(discos.get(i));
                count++;
            }
        if (count == 0)
            System.out.println("\nNo se ha encontrado ningún álbum.");
    }

    public Disco agregarDisco(Disco disco) {
        discos.add(disco);
        return disco;
    }

    public Disco agregarDisco(Disco disco, int posicion) {
        discos.add(posicion, disco);
        return disco;
    }

    public Disco modificarDisco(String codigo, String autor, String titulo, String genero, int duracion) {
        int i = buscarPosicionDisco(codigo);
        Disco disco = new Disco(codigo, autor, titulo, genero, duracion);
        discos.set(i, disco);
        System.out.println("\nDisco modificado con éxito");
        return disco;
    }

    public Disco borrarDisco(Disco disco) {
        Disco d = disco;
        discos.remove(disco);
        return d;
    }
}