package classes.baraja;

import java.util.Comparator;
import enums.Enums.*;

public class Carta {
    private Numeros numero;
    private Palos palo;

    public Carta(Numeros numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public Numeros getNumero() {
        return numero;
    }

    public Palos getPalo() {
        return palo;
    }

    public static Comparator<Carta> comparar() {
        return Comparator.comparing(Carta::getPalo).thenComparing(Carta::getNumero);
    }

    public boolean equals(Carta c) {
        return (this.palo).equals(c.getPalo());
    }

    @Override
    public String toString() {
        return this.numero.toString().toLowerCase() + " de " + this.palo.toString().toLowerCase();
    }

}
