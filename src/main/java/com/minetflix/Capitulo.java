package main.java.com.minetflix;

public class Capitulo extends Video {
    private int numeroCapitulo;

    public Capitulo(String titulo, int anio, int numeroCapitulo) {
        super(titulo, anio);
        this.numeroCapitulo = numeroCapitulo;
    }

    // Getters y setters
}
