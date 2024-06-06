package main.java.com.minetflix;

public abstract class Video {
    protected String titulo;
    protected int anio;
    protected boolean visto;
    protected int tiempoVisto;
    protected int calificacion;

    public Video(String titulo, int anio) {
        this.titulo = titulo;
        this.anio = anio;
        this.visto = false;
        this.tiempoVisto = 0;
        this.calificacion = 0;
    }

    // Getters y setters
}
