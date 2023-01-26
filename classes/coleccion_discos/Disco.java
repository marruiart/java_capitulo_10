package classes.coleccion_discos;

public class Disco {
    protected String codigo, autor, titulo, genero;
    protected int duracion;

    protected Disco() {
        this(null, null, null, null, 0);
    }

    public Disco(String codigo, String autor, String titulo, String genero, int duracion) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getGenero() {
        return this.genero;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void modificar(String codigo, String autor, String titulo, String genero, int duracion) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return String.format("------------------------------------------\n" +
                "Código: %s\n" +
                "Autor: %s\n" +
                "Título: %s\n" +
                "Género: %s\n" +
                "Duración: %d\n" +
                "------------------------------------------\n",
                this.codigo, this.autor, this.titulo, this.genero, this.duracion);
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass()) && (this.codigo).equals(((Disco) obj).getCodigo());
    }
}