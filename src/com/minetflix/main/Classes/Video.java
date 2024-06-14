package com.minetflix.main.Classes;

import com.minetflix.main.Interfaces.Visualizable;

public abstract class Video implements Visualizable {
    private String titulo;
    private int anio;
    private String genero;
    private int duracion;
    private boolean visto;
    private int tiempoVisto;
    private int calificacion;

    public Video(String titulo, int anio, String genero, int duracion) {
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
        this.duracion = duracion;
        this.visto = false;
        this.tiempoVisto = 0;
        this.calificacion = 0;
    }

    // #region Getters and Setters
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public int getTiempoVisto() {
        return tiempoVisto;
    }

    public void setTiempoVisto(int tiempoVisto) {
        this.tiempoVisto = tiempoVisto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    // #endregion

    // Implementación de métodos de la interfaz Visualizable
    @Override
    public void tiempoVisto(int tiempo) {
        this.tiempoVisto = tiempo;
    }

    @Override
    public void ponerCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

}
