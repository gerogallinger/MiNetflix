package com.minetflix.main.Classes;

public class Serie extends Video {
    private int temporadas;
    // cada serie tiene que tener un array de caputulos

    public Capitulo[] capitulos;

    public Serie(String titulo, int anio, String genero, int duracion) {
        super(titulo, anio, genero, duracion);
        this.capitulos = new Capitulo[0];
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
        var cap = new Capitulo[this.capitulos.length + 1];
        for (int i = 0; i < this.capitulos.length; i++) {
            cap[i] = this.capitulos[i];
        }

    }
}
