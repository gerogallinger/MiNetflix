package com.minetflix.main;

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
            opcion = lector.nextInt();

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
                // mostrarVideosVistos();
            } else if (opcion == 8) {
                System.out.println("Saliendo");
            } else {
                System.out.println("Error.");
            }
        }

    }

    public static void registrarPelicula(Scanner lector, MinetflixService minetflixService) {

        System.out.print("Título: ");
        String titulo = lector.nextLine();
        System.out.print("Año: ");
        int anio = lector.nextInt();
        lector.nextLine();
        System.out.print("Género: ");
        String genero = lector.nextLine();
        System.out.print("Duración (minutos): ");
        int duracion = lector.nextInt();
        lector.nextLine();
        Pelicula peliToAdd = new Pelicula(titulo, anio, genero, duracion);

        minetflixService.agregarVideo(peliToAdd);

        System.out.println("Pelicula registrada");
    }

}
