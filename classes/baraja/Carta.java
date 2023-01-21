package classes.baraja;

import enums.Enums.*;

public class Carta {
    private Numeros numero;
    private Palos palo;

    public Carta(Numeros numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
    }

    @Override
    public String toString() {
        return this.numero.toString().toLowerCase() + " de " + this.palo.toString().toLowerCase();
    }
}
