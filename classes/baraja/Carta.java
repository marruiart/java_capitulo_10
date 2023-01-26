package classes.baraja;

import java.util.Comparator;
import enums.Enums.*;

public class Carta {
    private Numeros numero;
    private Palos palo;
    private Integer puntos;

    public Carta(Numeros numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public String getNumero() {
        return numero.toString().toLowerCase();
    }

    public String getPalo() {
        return palo.toString().toLowerCase();
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(int p) {
        this.puntos = p;
    }

    public static Comparator<Carta> comparar() {
        return Comparator.comparing(Carta::getPalo).thenComparing(Carta::getNumero);
    }

    public boolean equals(Carta c) {
        return (this.getPalo()).equals(c.getPalo());
    }

    @Override
    public String toString() {
        return this.getNumero() + " de " + this.getPalo();
    }

}
