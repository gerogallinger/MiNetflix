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
        // Minetflixapp miNetflix = new Minetflixapp();

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
            // agregar antes de cada llamada al metodo limpiar la pantalla

            if (opcion == 1) {
                // limpiamos la consola
                clearScreen();
                registrarPelicula(lector, minetflixService);
            } else if (opcion == 2) {
                clearScreen();
                registrarSerie(lector, minetflixService);
            } else if (opcion == 3) {
                clearScreen();
                registrarCapitulo(lector, minetflixService);
            } else if (opcion == 4) {
                clearScreen();
                actualizarPelicula(lector, minetflixService);
            } else if (opcion == 5) {
                clearScreen();
                actualizarSerie(lector, minetflixService);
            } else if (opcion == 6) {
                clearScreen();
                actualizarCapitulo(lector, minetflixService);
            } else if (opcion == 7) {
                clearScreen();
                listarSeriesAndPeliculas(lector, minetflixService);
            } else if (opcion == 8) {
                System.out.println("Saliendo");
            } else {
                System.out.println("Error.");
            }
        }

    }

    private static void actualizarCapitulo(Scanner lector, MinetflixService minetflixService) {

        // obtenemos la serie para actualizar el capitulo
        System.out.print("Ingrese el id de la serie a la que se le agregara el capitulo: ");
        int id = lector.nextInt();
        lector.nextLine();
        Serie serie = (Serie) minetflixService.getVideoById(id);
        // pedir el numero de capitulo a actualizar
        System.out.print("Ingrese el numero de capitulo a actualizar: ");
        int numero = lector.nextInt();
        lector.nextLine();
        // obtener el capitulo a actualizar
        Capitulo capitulo = serie.getCapituloByNumero(numero);
        // pedir los datos del capitulo
        System.out.print("Titulo del capitulo: ");
        String titulo = lector.nextLine();
        System.out.print("Duracion del capitulo: ");
        int duracion = lector.nextInt();
        lector.nextLine();
        System.out.print("Numero de capitulo: ");
        int numeroCapitulo = lector.nextInt();
        lector.nextLine();
        // actualizar los datos del capitulo
        capitulo.setTitulo(titulo);
        capitulo.setDuracion(duracion);

        // mostrar que se actualizo el capitulo
        System.out.println("Capitulo actualizado de la serie: " + serie.getTitulo() + " con el numero: " + numero);

    }

    private static void registrarCapitulo(Scanner lector, MinetflixService minetflixService) {
        // TODO Auto-generated method stub
        // pedir la serie a la que se le agregara el capitulo
        System.out.print("Ingrese el id de la serie a la que se le agregara el capitulo: ");
        int id = lector.nextInt();
        lector.nextLine();
        // obtener la serie a la que se le agregara el capitulo
        Serie serie = (Serie) minetflixService.getVideoById(id);
        // pedir los datos del capitulo
        System.out.print("Titulo del capitulo: ");
        String titulo = lector.nextLine();
        System.out.print("Duracion del capitulo: ");
        int duracion = lector.nextInt();
        lector.nextLine();
        System.out.print("Numero de capitulo: ");
        int numero = lector.nextInt();
        lector.nextLine();
        // crear el capitulo
        Capitulo capitulo = new Capitulo(titulo, duracion, titulo, numero);
        // agregar el capitulo a la serie
        serie.agregarCapitulo(capitulo);
        // mostrar que se agrego el capitulo
        System.out.println("Capitulo agregado a la serie: " + serie.getTitulo());
    }

    private static void actualizarSerie(Scanner lector, MinetflixService minetflixService) {
        // deberiamos pedir el id de la serie, para actualizar en el caso de que exista
        // a partir del id obtenemos la serie y solo damos la opcion de actualizar el
        // titulo y el año
        System.out.print("Ingrese el id de la serie a actualizar: ");
        int id = lector.nextInt();
        lector.nextLine();

        Serie serieToUpdate = (Serie) minetflixService.getVideoById(id);
        System.out.println("Datos actuales de la serie: ");
        System.out.println("Titulo: " + serieToUpdate.getTitulo());
        System.out.println("Año: " + serieToUpdate.getAnio());
        System.out.println("Genero: " + serieToUpdate.getGenero());
        System.out.println("Temporadas: " + serieToUpdate.getTemporadas());

        System.out.print("Ingresa el Nuevo titulo: ");
        String titulo = lector.nextLine();
        System.out.print("Ingresa el Nuevo año: ");
        int anio = lector.nextInt();
        lector.nextLine();

        serieToUpdate.setTitulo(titulo);
        serieToUpdate.setAnio(anio);
        // avisamos que esta hecho el cambio
        System.out.println("Datos actualizados de la serie: " + serieToUpdate.getTitulo());

    }

    private static void actualizarPelicula(Scanner lector, MinetflixService minetflixService) {
        // TODO Auto-generated method stub
        // deberiamos pedir el id de la pelicula a actualizar
        System.out.print("Ingrese el id de la pelicula a actualizar: ");
        int id = lector.nextInt();
        lector.nextLine();
        // obtenemos la pelicula a actualizar
        Pelicula peliToUpdate = (Pelicula) minetflixService.getVideoById(id);
        // mostramos los datos actuales de la pelicula
        System.out.println("Datos actuales de la pelicula: ");
        System.out.println("Titulo: " + peliToUpdate.getTitulo());
        System.out.println("Año: " + peliToUpdate.getAnio());
        System.out.println("Genero: " + peliToUpdate.getGenero());
        System.out.println("Duracion: " + peliToUpdate.getDuracion());
        // pedimos los nuevos datos
        System.out.print("Nuevo titulo: ");
        String titulo = lector.nextLine();
        System.out.print("Nuevo año: ");
        int anio = lector.nextInt();
        lector.nextLine();
        System.out.print("Nuevo genero: ");
        String genero = lector.nextLine();
        System.out.print("Nueva duracion: ");
        int duracion = lector.nextInt();
        lector.nextLine();
        // actualizamos los datos de la pelicula
        peliToUpdate.setTitulo(titulo);
        peliToUpdate.setAnio(anio);
        peliToUpdate.setGenero(genero);
        peliToUpdate.setDuracion(duracion);
        // mostramos los datos actualizados
        System.out.println("Datos actualizados de la pelicula: ");
        System.out.println("Titulo: " + peliToUpdate.getTitulo());
        System.out.println("Año: " + peliToUpdate.getAnio());
        System.out.println("Genero: " + peliToUpdate.getGenero());
        System.out.println("Duracion: " + peliToUpdate.getDuracion());
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

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}