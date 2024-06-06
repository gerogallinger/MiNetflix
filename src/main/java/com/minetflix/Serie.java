package main.java.com.minetflix;

import java.util.ArrayList;

public class Serie extends Video {
    private int temporadas;
    private ArrayList<Capitulo> capitulos;

    public Serie(String titulo, int anio, int temporadas) {
        super(titulo, anio);
        this.temporadas = temporadas;
        this.capitulos = new ArrayList<>();
    }

    // Métodos para gestionar capítulos
}
