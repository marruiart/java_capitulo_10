package classes.ajedrez;

import java.util.HashMap;
import enums.Enums.Piezas;

public class Pieza {
    private Piezas nombre;
    private Integer peones;

    public Pieza(Piezas nombre) {
        this.nombre = nombre;
        this.peones = switch (nombre) {
            case REY -> null;
            case REINA -> 9;
            case TORRE -> 5;
            case ALFIL -> 3;
            case CABALLO -> 3;
            case PEON -> 1;
        };
    }

    public Piezas getNombre() {
        return nombre;
    }

    public Integer getPeones() {
        return peones;
    }

    @Override
    public String toString() {
        return this.nombre.toString().toLowerCase()
                + (this.getNombre().equals(Piezas.REY) ? "" : " (" + peones + " peones)");
    }
}
