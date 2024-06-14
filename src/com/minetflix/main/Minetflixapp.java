package com.minetflix.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.minetflix.main.Classes.Capitulo;
import com.minetflix.main.Classes.Pelicula;
import com.minetflix.main.Classes.Serie;
import com.minetflix.main.Services.MinetflixService;

public class Minetflixapp {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        Minetflixapp miNetflix = new Minetflixapp();

        // creo el servicio para despues llamar a los metodos segun corresponda la
        // opcion
        MinetflixService minetflixService = new MinetflixService();

        int opcion = 0;
        while (opcion != 8) {
            System.out.println("Mi Netflix");
            System.out.println("1.- Registrar Pelicula");
            System.out.println("2.- Registrar Serie");
            System.out.println("3.- Registrar Capitulo");
            System.out.println("4.- Actualizar Pelicula");
            System.out.println("5.- Actualizar Serie");
            System.out.println("6.- Actualizar Captiulo");
            System.out.println("7.- Lista");
            System.out.println("8.- Salir");
            System.out.print("Seleccione una opcion: ");
            // leer la opcion ingresada
            if (lector.hasNextInt()) {
                opcion = lector.nextInt();
                lector.nextLine(); // Consumir la nueva línea residual
            } else {
                System.out.println("Por favor, ingresa un número válido.");
                lector.next(); // Descartar la entrada no válida
                continue;
            }
            if (opcion == 1) {
                registrarPelicula(lector, minetflixService);
            } else if (opcion == 2) {
                // TODO: hacer lo mismo para el reso de los casos

                // registrarSerie();
            } else if (opcion == 4) {
                // TODO: hacer lo mismo para el reso de los casos

                // actualizarPelicula();
            } else if (opcion == 5) {
                // TODO: hacer lo mismo para el reso de los casos
                // actualizarSerie();
            } else if (opcion == 7) {
                // TODO: hacer lo mismo para el reso de los casos
                listarSeriesAndPeliculas(lector, minetflixService);
            } else if (opcion == 8) {
                System.out.println("Saliendo");
            } else {
                System.out.println("Error.");
            }
        }

    }

    public static void registrarPelicula(Scanner lector, MinetflixService minetflixService) {

        System.out.print("Título: ");
        String titulo = lector.nextLine().trim(); // .trim() elimina espacios en blanco al inicio y al final
        System.out.println("Título: " + titulo); // Usa println para asegurar la nueva línea

        System.out.print("Año: ");
        while (!lector.hasNextInt()) {
            System.out.println("Por favor, ingresa un año válido.");
            lector.next(); // Descartar la entrada no válida
        }
        int anio = lector.nextInt();
        lector.nextLine(); // Consume la línea restante

        System.out.print("Género: ");
        String genero = lector.nextLine().trim(); // .trim() elimina espacios en blanco al inicio y al final

        System.out.print("Duración (minutos): ");
        while (!lector.hasNextInt()) {
            System.out.println("Por favor, ingresa una duración válida.");
            lector.next(); // Descartar la entrada no válida
        }
        int duracion = lector.nextInt();
        lector.nextLine(); // Consume la línea restante

        Pelicula peliToAdd = new Pelicula(titulo, anio, genero, duracion);

        minetflixService.agregarVideo(peliToAdd);

        System.out.println("Pelicula registrada");
    }

    public static void registrarSerie(Scanner lector, MinetflixService minetflixService) {

        System.out.print("Título: ");
        String titulo = lector.nextLine();
        System.out.print("Año: ");
        int anio = lector.nextInt();
        lector.nextLine();
        System.out.print("Género: ");
        String genero = lector.nextLine();
        System.out.print("Temporadas: ");
        int temporadas = lector.nextInt();
        lector.nextLine();
        Serie serieToAdd = new Serie(titulo, anio, genero, temporadas);

        minetflixService.agregarVideo(serieToAdd);

        System.out.println("Serie registrada");
    }

    public static void listarSeriesAndPeliculas(Scanner lector, MinetflixService minetflixService) {
        var videos = minetflixService.getVideos();
        System.out.println("Videos: " + videos.size());
        // desglozar de los videos cuales son series y cuales peliculas
        var series = new ArrayList<Serie>();
        var peliculas = new ArrayList<Pelicula>();

        videos.forEach(video -> {
            if (video instanceof Serie) {
                series.add(0, (Serie) video);
            } else if (video instanceof Pelicula) {
                peliculas.add(0, (Pelicula) video);
                System.out.println("Pelicula: " + video.getTitulo());
                System.out.println("Pelicula: " + video.getGenero());
                System.out.println("Pelicula: " + video.getDuracion());
            }
        });

        System.out.println("Series: ");
        series.forEach(serie -> {
            System.out.println(" -- " + serie.getTitulo());
        });

        System.out.println("Peliculas: ");
        peliculas.forEach(peli -> {
            System.out.println(" -- " + peli.getTitulo());
        });

    }
}