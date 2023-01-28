package classes.anfibios;

public class Anfibio {
    private String tipo;
    private String habitat;
    private String alimentacion;

    public Anfibio(String tipo, String habitat, String alimentacion) {
        this.tipo = tipo;
        this.habitat = habitat;
        this.alimentacion = alimentacion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    @Override
    public String toString() {
        return String.format("Hábitat: %s\nAlimentación: %s", habitat, alimentacion);
    }

}
