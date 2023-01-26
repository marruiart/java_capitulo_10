package classes.baraja;

public class Brisca {
    private Baraja mazo;

    public Brisca(Baraja mazo) {
        this.mazo = mazo;
        for (Carta c : mazo.mazo) {
            int p = switch (c.getNumero()) {
                case "as" -> 11;
                case "tres" -> 10;
                case "sota" -> 2;
                case "caballo" -> 3;
                case "rey" -> 4;
                default -> 0;
            };
            c.setPuntos(p);
        }
    }

    public Mano obtenerMano() {
        return new Mano(mazo, 5);
    }
}
