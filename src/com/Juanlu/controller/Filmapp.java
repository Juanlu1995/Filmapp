package com.Juanlu.controller;

import com.Juanlu.model.Actor;
import com.Juanlu.model.Multimedia;
import com.Juanlu.model.NegativeNumberException;
import com.Juanlu.model.multimedia.Documentary;
import com.Juanlu.model.multimedia.Film;
import com.Juanlu.model.multimedia.Serie;
import org.omg.CORBA.INITIALIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by juanl on 20/05/2017.
 */
public class Filmapp {
//TODO etiquetas see
    /**
     * Iniciamos la aplicacion
     *
     * Creamos un ArrayList con la lista de actores, peliculas, series y documentales que van a estar disponibles de 
     * modificacion a gusto del cliente, ya sea eliminar o añadir un elemento a la lista.
     * Así mismo mostramos un menú que nos mostrará para elegir qué queremos hacer(*1) y los numeros validos 
     * para cada opcion.
     * Podemos movernos al menu de las peliculas(*2), el de las series(*3), documetales(*4), imprimir una lista general
     * de nuestros elementos multimedia(*5) o ir a un menu para ver otro tipo de ordenes de impresion en nuestros
     * elementos multimedia.
     *
     * 
     * @see #printListToDo()
     * 
     */
    public static void run(){
        Scanner input = new Scanner(System.in);

        ArrayList<Actor> actors = new ArrayList<>();
        ArrayList<Film> films = new ArrayList<>();
        ArrayList<Serie> series = new ArrayList<>();
        ArrayList<Documentary> documentarys = new ArrayList<>();

//        films.add(new Film());
//        films.add(new Film(30.0));
//        films.add(new Film(5.5));

        actors.add(new Actor(1));
        actors.add(new Actor(2));
        int index;

        do {
            printListToDo();
            index = selector();
            switch (index){
                case 1:
                    filmMenu(films,actors);
                    break;
                case 2:
                    seriesMenu(series,actors);
                    break;
//                case 3:
//                    documentarysMenu(documentarys,actors);
//                    break;
//                case 4:
//                    printGenaralList(films,series,documentarys);
//                    break;
//                case 5:
//                    printListAllMultimediaOptions(films,series,documentarys);
                   case 0:
                    System.out.println("Bye!");
                       break;

                    default:
                        System.out.println("Numero no valido. Introduce por favor un numero válido");
                        break;
            }
        }while (index != 0);


    }



    //TODO queda por hacer el switch y las opciones de cada uno (Series), así como comentarios
    private static void seriesMenu(ArrayList<Serie> series, ArrayList<Actor> actors) {
        System.out.println("****************   ¿QUÉ QUIERES HACER?   ****************");
        System.out.println("*                        Series                         *");
        System.out.println("* 1 - Ver lista de series ordenadas por...              *");
        System.out.println("* 2 - Añadir series                                     *");
        System.out.println("* 3 - Eliminar serie                                    *");
        System.out.println("* 4 - Editar una serie                                  *");
        System.out.println("* 0 - Atrás                                             *");
        System.out.println("*                                                       *");
        System.out.println("*********************************************************");

        selector();
    }


    //TODO queda por hacer el switch y las opciones de cada uno (Peliculas), así como comentarios. Arreglado el bucle de las excepciones.
    private static void filmMenu(ArrayList<Film> films, ArrayList<Actor> actors) {
        Scanner input = new Scanner(System.in);
        int index = 0;

        do {
            System.out.println("****************   ¿QUÉ QUIERES HACER?   ****************");
            System.out.println("*                       Peliculas                       *");
            System.out.println("* 1 - Ver lista de peliculas ordenadas por...           *");
            System.out.println("* 2 - Añadir pelicula                                   *");
            System.out.println("* 3 - Eliminar pelicula                                 *");
            System.out.println("* 4 - Editar una pelicula                               *");
            System.out.println("* 0 - Atrás                                             *");
            System.out.println("*                                                       *");
            System.out.println("*********************************************************");

            index = selector();

            switch (index){
                case 1:
                    printFilmOptions(films);
                    break;
                case 2:
                    addMultimedia(films,actors);
                    break;
//                case 3:
//                    delMultimedia(films,actors);
//                    break;
//                case 4:
//                    editMultimedia(films,actors);
//                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;

                    default:
                        System.out.println("Numero no válido. Por favor, introduce otro");
            }
        }while (index != 0);
    }

    private static void addMultimedia(ArrayList<Film> films, ArrayList<Actor> actorsAvailable) {
        Scanner input = new Scanner(System.in);
        /*
            protected Calendar releaseDate;
            protected Actor director;
         */
        int num = 0;

        boolean valid = false;
        String name;
        double score, bugdet;
        int code;
        ArrayList<Actor> actors = new ArrayList<Actor>();

        do {
            try {
                System.out.println("Nombre de la pelicula: ");
                name = input.nextLine();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido, intentalo otra vez");
                input.nextLine();
            }
        }while (valid == false);
        valid = false;
        do {
            try {
                System.out.println("\nPuntuacion de la pelicula (0-100): ");
                score = input.nextDouble();
                if (score <= 100 && score >= 0) {
                    valid = true;
                }else {
                    System.out.println("Numero no valido, tiene que ser entre 0 y 100");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido, intentalo otra vez.");
                input.nextLine();
            }
        }while (valid == false);
        valid = false;
        do {
            try {
                System.out.print("\nPresupuesto de la pelicula (En millones): ");
                bugdet = input.nextDouble();
                if (bugdet >= 0){
                    valid = true;
                }else {
                    System.out.println("Numero no válido, tiene que ser mayor o igual a 0");
                }
            }catch (InputMismatchException e){
                System.out.println("Valor no válido, intentalo otra vez");
                input.nextLine();
            }

        }while (valid == false);
        //TODO Falla al introducir el actor.
        //En la seleccion de actores, para que no cambiar la condicion de salida que tenemos en el programa
        // hacemos la impresion desde el uno, y cuando se introduce el valor del actor se le resta 1 para compensarlo
        // de la impresion.

        do {
            System.out.println("\n¿Alguno de estos actores está en la pelicula?");
            printActor(actorsAvailable);
            System.out.print("\nSelecciona el numero o pulse 0 para no añadir: ");
            num = input.nextInt() -1;
            if (actorsAvailable.contains(new Actor(num))){
                if (!actors.contains(new Actor(num))){
                    actors.add(actorsAvailable.get(num));
                }else {
                    System.out.println("\nEl actor ya está añadido");
                }
            }else {
                System.out.println("\nNumero no válido, intente otro. Por favor.");
            }
        }while (num != -1);
    }

    /**
     * Nos imprime las posibilidades de ordenamiento de las las peliculas, así como el numero correspondiente para
     * acceder a dicha opcion.
     *
     * @param films ArrayList de peliculas
     * @see #printFilm(ArrayList)
     */
    private static void printFilmOptions(ArrayList<Film> films) {
        int num;
        do {
            System.out.println("**************** ¿Comó quieres Imprimir? ****************");
            System.out.println("*                  Impresion peliculas                  *");
            System.out.println("* 1 - Por puntuacion                                    *");
            System.out.println("* 2 - Por orden alfabético                              *");
            System.out.println("* 3 - Por fecha de salida                               *");
            System.out.println("* 4 - Por presupuesto                                   *");
            System.out.println("* 0 - Salir                                             *");
            System.out.println("*                                                       *");
            System.out.println("*********************************************************");

            num = selector();

            switch (num){
                case 1:
                    Collections.sort(films,Multimedia.ComparatorByScore);
                    printFilm(films);
                    break;
                case 2:
                    Collections.sort(films,Multimedia.ComparatorByName);
                    printFilm(films);
                    break;
                case 3:
                    Collections.sort(films,Multimedia.ComparatorByDate);
                    printFilm(films);
                    break;
                case 4:
                    Collections.sort(films,Film.ComparatorByBudget);
                    printFilm(films);
                    break;
                case 0:
                    System.out.println("Volviendo al menú Peliculas");
                    break;

                default:
                    System.out.println("Numero no válido. Por favor, introduce otro.");
            }
        }while (num != 0);
    }


    /**
     * Nos imprime una lista de las opcines validas que hacer en el programa, así como el número correspondiente
     * de ejecucion de la opcion.
     */
    private static void printListToDo() {
        System.out.println("****************   ¿QUÉ QUIERES HACER?   ****************");
        System.out.println("*                    Menu Principal                     *");
        System.out.println("* 1 - Menu Peliculas                                    *");
        System.out.println("* 2 - Menu Series                                       *");
        System.out.println("* 3 - Menu Documentales                                 *");
        System.out.println("* 4 - Lista general (por score)                         *");
        System.out.println("* 5 - Lista general (otro orden)                        *");
        System.out.println("* 0 - Salir                                             *");
        System.out.println("*                                                       *");
        System.out.println("*********************************************************");
    }
    
    //Helppers


    private static int selector() {
        Scanner input = new Scanner(System.in);
        int num = 0;
        do {
            try {
                num = input.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Introduce un número válido");
                num = -1;
                input.nextLine();
            }
        }while (num == -1);
        return num;
    }


    /**
     * Hellpper para la impresion de peliculas.
     * @param films ArrayList de peliculas.
     */
    private static void printFilm(ArrayList<Film> films){
        for (Film film : films) {
            System.out.println(film);
        }
    }

    /**
     * Lee la lista de actores
     * @param actors ArrayList de actores
     */
    private static void printActor(ArrayList<Actor> actors){
        for (int i = 0 ; i < actors.size() ; i++) {
            System.out.println("* " + (i+1) + " - " + actors.get(i));
        }
    }
}
