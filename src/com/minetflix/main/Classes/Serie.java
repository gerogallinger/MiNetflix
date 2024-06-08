package com.minetflix.main.Classes;

public class Serie extends Video {
    private int temporadas;

    public Serie(String titulo, int anio, String genero, int duracion) {
        super(titulo, anio, genero, duracion);

    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

}
