package main.java.com.minetflix;

public class Pelicula extends Video {
    private int duracion; // Duración en minutos

    public Pelicula(String titulo, int anio, int duracion) {
        super(titulo, anio);
        this.duracion = duracion;
    }

    // Getters y setters
}
