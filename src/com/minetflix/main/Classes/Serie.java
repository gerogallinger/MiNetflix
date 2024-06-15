package com.minetflix.main.Classes;

public class Serie extends Video {
    private int temporadas;
    // cada serie tiene que tener un array de caputulos

    private Capitulo[] capitulos;

    public Serie(String titulo, int anio, String genero, int duracion) {
        super(titulo, anio, genero, duracion);

    }

    // agregar temporadas
    // clase temporada que tenga titulo y cantidad de episodios

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    // metodo getCapituloByNumero
    public Capitulo getCapituloByNumero(int numero) {
        return capitulos[numero];
    }

    // agregar capitulo
    public void agregarCapitulo(Capitulo capitulo) {
        // agregar capitulo al array de capitulos
        var cap = new Capitulo[capitulos.length + 1];
        for (int i = 0; i < capitulos.length; i++) {
            cap[i] = capitulos[i];
        }

    }
}
