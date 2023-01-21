package classes.baraja;

import enums.Enums.*;

public class Carta implements Comparable<Carta> {
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

    @Override
    public int compareTo(Carta c) {
        return (this.palo).compareTo(c.getPalo());
    }

    public boolean equals(Carta c) {
        return (this.palo).equals(c.getPalo());
    }

    @Override
    public String toString() {
        return this.numero.toString().toLowerCase() + " de " + this.palo.toString().toLowerCase();
    }

}
