package classes;

public class Moneda {
    public static String[] valores = { "1 céntimo", "2 céntimos", "5 céntimos", "10 céntimos", "25 céntimos",
            "50 céntimos", "1 euro", "2 euros" };
    public static String[] caras = { "cara", "cruz" };
    public String valor;
    public String cara;

    public Moneda() {
        this(valores[(int) (Math.random() * 8)], caras[(int) (Math.random() * 2)]);
    }

    public Moneda(String valor, String cara) {
        this.valor = valor;
        this.cara = cara;
    }

    @Override
    public String toString() {
        return this.valor + " - " + this.cara;
    }
}
