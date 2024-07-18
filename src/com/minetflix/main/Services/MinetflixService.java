package com.minetflix.main.Services;

import java.util.Arrays;

import com.minetflix.main.Classes.Pelicula;
import com.minetflix.main.Classes.Serie;
import com.minetflix.main.Classes.Video;

public class MinetflixService {

    private Video[] videos;
    private int videoCount; // Necesario para llevar la cuenta de cuántos vídeos hemos agregado, ya que no
                            // hay métodos de tamaño en los arrays.

    // Constructor
    public MinetflixService() {
        this.videos = new Video[100]; // suponiendo un tamaño máximo de 100
        this.videoCount = 0;
    }

    public int agregarVideo(Video video) {
        if (videoCount < videos.length) {
            this.videos[videoCount++] = video;
            return videoCount - 1; // Devolver el índice del video agregado
        } else {
            System.out.println("Array completo, no se pueden agregar más videos.");
            return -1;
        }
    }

    public Video[] getVideos() {
        return videos;
    }

    public Video getVideoById(int id) {
        return id >= 0 && id < videoCount ? videos[id] : null;
    }

    public Video[] vistos() {
        Video[] vistos = new Video[videoCount];
        int count = 0;
        for (int i = 0; i < videoCount; i++) {
            if (videos[i].isVisto()) {
                vistos[count++] = videos[i];
            }
        }
        return Arrays.copyOf(vistos, count); // Reduce the array to the actual number of elements
    }

    public Video[] pendientes() {
        Video[] pendientes = new Video[videoCount];
        int count = 0;
        for (int i = 0; i < videoCount; i++) {
            if (videos[i] != null && !videos[i].isVisto()) {
                pendientes[count++] = videos[i];
            }
        }
        return Arrays.copyOf(pendientes, count); // Ajustar el tamaño del array al número real de elementos
    }

    public Video[] favoritas() {
        Video[] favoritas = new Video[videoCount];
        int count = 0;
        for (int i = 0; i < videoCount; i++) {
            if (videos[i] != null && videos[i].getCalificacion() >= 8) {
                favoritas[count++] = videos[i];
            }
        }
        return Arrays.copyOf(favoritas, count); // Ajustar el tamaño del array al número real de elementos
    }

    public Serie serieMasCapitulos() {
        Serie serieMasCapitulos = null;
        for (Video video : videos) {
            if (video instanceof Serie) {
                Serie serie = (Serie) video;
                if (serieMasCapitulos == null || serie.getTemporadas() > serieMasCapitulos.getTemporadas()) {
                    serieMasCapitulos = serie;
                }
            }
        }
        return serieMasCapitulos;
    }

    public Pelicula peliculaMasCorta() {
        Pelicula peliculaMasCorta = null;
        for (Video video : videos) {
            if (video instanceof Pelicula) {
                Pelicula pelicula = (Pelicula) video;
                if (peliculaMasCorta == null || pelicula.getDuracion() < peliculaMasCorta.getDuracion()) {
                    peliculaMasCorta = pelicula;
                }
            }
        }
        return peliculaMasCorta;
    }

}
