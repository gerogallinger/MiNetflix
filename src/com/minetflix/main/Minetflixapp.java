package com.minetflix.main;

import java.util.ArrayList;
import java.util.List;

import com.minetflix.main.Classes.Pelicula;
import com.minetflix.main.Classes.Serie;
import com.minetflix.main.Classes.Video;

public class Minetflixapp {

    private List<Video> videos;

    // Constructor
    public Minetflixapp() {
        this.videos = new ArrayList<>();
    }

    public void agregarVideo(Video video) {
        this.videos.add(video);
    }

    public List<Video> getVideos() {
        return videos;
    }

    public Video getVideoById(int id) {
        return videos.get(id);
    }

    public List<Video> vistos() {
        List<Video> vistos = new ArrayList<>();
        for (Video video : videos) {
            if (video.isVisto()) {
                vistos.add(video);
            }
        }
        return vistos;
    }

    public List<Video> pendientes() {
        // logica inversa a vistos
        List<Video> pendientes = new ArrayList<>();
        for (Video video : videos) {
            if (!video.isVisto()) {
                pendientes.add(video);
            }
        }
        return pendientes;
    }

    public List<Video> favoritas() {
        List<Video> favoritas = new ArrayList<>();
        for (Video video : videos) {
            if (video.getCalificacion() >= 4) { // Por ejemplo, calificación de 4 o más
                favoritas.add(video);
            }
        }
        return favoritas;
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
