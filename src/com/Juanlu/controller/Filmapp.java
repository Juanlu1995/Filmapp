package com.Juanlu.controller;

import com.Juanlu.model.Actor;
import com.Juanlu.model.Multimedia;
import com.Juanlu.model.multimedia.Movie;
import com.Juanlu.model.multimedia.Serie;

import java.util.*;

/**
 * Created by juanl on 20/05/2017.
 */
public class Filmapp {
    /**
     * Iniciamos la aplicacion
     *
     * Creamos un ArrayList con la lista de actores, peliculas, series y documentales que van a estar disponibles de
     * modificacion a gusto del cliente, ya sea eliminar o añadir un elemento a la lista.
     * Así mismo mostramos un menú que nos mostrará para elegir qué queremos hacer y los numeros validos
     * para cada opcion.
     * Podemos movernos al menu de las peliculas(*1), el de las series(*2), imprimir una lista general
     * de nuestros elementos multimedia (*3) o salir
     *
     *
     * @see #printListToDo()
     * @see #movieMenu(ArrayList, ArrayList)
     * @see #seriesMenu(ArrayList, ArrayList)
     * @see #printGenaralList(ArrayList, ArrayList)
     */
    public static void run(){
        Scanner input = new Scanner(System.in);

        ArrayList<Actor> actors = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Serie> series = new ArrayList<>();

        int index;

        do {
            printListToDo();
            index = selector();
            switch (index){
                case 1:
                    movieMenu(movies,actors);
                    break;
                case 2:
                    seriesMenu(series,actors);
                    break;
                case 3:
                    printGenaralList(movies,series);
                    break;
                case 0:
                    System.out.println("Bye!");
                       break;

                    default:
                        System.out.println("Numero no valido. Introduce por favor un numero válido");
                        break;
            }
        }while (index != 0);
    }

    private static void printGenaralList(ArrayList<Movie> movies, ArrayList<Serie> series) {
        System.out.println("*********************   PELICULAS   *********************");
        printMovies(movies);
        System.out.println("\n***********************   SERIES   ***********************");
        printSeries(series);

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
        System.out.println("* 3 - Lista general (por puntuacion)                    *");
        System.out.println("* 0 - Salir                                             *");
        System.out.println("*                                                       *");
        System.out.println("*********************************************************");
    }




    /**
     * Muestra el menú de qué se puede hacer con las películas y el número correspondiente para interactuar con ellas.
     * @param movies ArrayList de películas
     * @param actors ArrayList de actores
     */
    private static void movieMenu(ArrayList<Movie> movies, ArrayList<Actor> actors) {
        Scanner input = new Scanner(System.in);
        int index = 0;

        do {
            System.out.println("****************   ¿QUÉ QUIERES HACER?   ****************");
            System.out.println("*                       Peliculas                       *");
            System.out.println("* 1 - Ver lista de peliculas ordenadas por...           *");
            System.out.println("* 2 - Añadir pelicula                                   *");
            System.out.println("* 3 - Eliminar pelicula                                 *");
            System.out.println("* 0 - Atrás                                             *");
            System.out.println("*                                                       *");
            System.out.println("*********************************************************");

            index = selector();

            switch (index){
                case 1:
                    printMovieOptions(movies);
                    break;
                case 2:
                    addMovie(movies,actors);
                    break;
                case 3:
                    delMovie(movies);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;

                default:
                    System.out.println("Numero no válido. Por favor, introduce otro");
            }
        }while (index != 0);
    }
    /**
     * Muestra el menú de qué se puede hacer con las series y el número correspondiente para interactuar con ellas.
     * @param series ArrayList de series
     * @param actors ArrayList de actores
     */
    private static void seriesMenu(ArrayList<Serie> series, ArrayList<Actor> actors) {
        int index = 0;

        do {
            System.out.println("****************   ¿QUÉ QUIERES HACER?   ****************");
            System.out.println("*                        Series                         *");
            System.out.println("* 1 - Ver lista de series ordenadas por...              *");
            System.out.println("* 2 - Añadir series                                     *");
            System.out.println("* 3 - Eliminar serie                                    *");
            System.out.println("* 4 - Editar una serie                                  *");
            System.out.println("* 0 - Atrás                                             *");
            System.out.println("*                                                       *");
            System.out.println("*********************************************************");

            index = selector();
            switch (index) {
                case 1:
                    printSerieOptions(series);
                    break;
                case 2:
                    addSerie(series, actors);
                    break;
                case 3:
                    delSerie(series);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;

                default:
                    System.out.println("Numero no válido. Por favor, introduce otro");
            }
        }while (index != 0);
    }



    /**
     * Nos imprime las posibilidades de ordenamiento de las las peliculas, así como el numero correspondiente para
     * acceder a dicha opcion.
     *
     * @param movies ArrayList de peliculas
     * @see #printMovies(ArrayList)
     */
    private static void printMovieOptions(ArrayList<Movie> movies) {
        int num;

        if (movies.size() > 1) {
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

                switch (num) {
                    case 1:
                        Collections.sort(movies, Multimedia.ComparatorByScore);
                        printMovies(movies);
                        break;
                    case 2:
                        Collections.sort(movies, Multimedia.ComparatorByName);
                        printMovies(movies);
                        break;
                    case 3:
                        Collections.sort(movies, Multimedia.ComparatorByDate);
                        printMovies(movies);
                        break;
                    case 4:
                        Collections.sort(movies, Movie.ComparatorByBudget);
                        printMovies(movies);
                        break;
                    case 0:
                        System.out.println("Volviendo al menú Peliculas");
                        break;

                    default:
                        System.out.println("Numero no válido. Por favor, introduce otro.");
                }
            } while (num != 0);
        }else if (movies.size() == 1) {
            System.out.print("No hay peliculas suficiente par un orden. La unica pelicula de la que tenemos constancia es: ");
            printMovies(movies);
        }else {
            System.out.println("No hay peliculas.");
        }
    }
    /**
     * Nos imprime las posibilidades de ordenamiento de las las series, así como el numero correspondiente para
     * acceder a dicha opcion.
     *
     * @param series ArrayList de series
     * @see #printSeries(ArrayList)
     */
    private static void printSerieOptions(ArrayList<Serie> series) {
        int num;
        if (series.size() > 1) {
            do {
                System.out.println("**************** ¿Comó quieres Imprimir? ****************");
                System.out.println("*                  Impresion Series                     *");
                System.out.println("* 1 - Por puntuacion                                    *");
                System.out.println("* 2 - Por orden alfabético                              *");
                System.out.println("* 3 - Por fecha de salida                               *");
                System.out.println("* 4 - Por capítulos                                     *");
                System.out.println("* 0 - Salir                                             *");
                System.out.println("*                                                       *");
                System.out.println("*********************************************************");

                num = selector();

                switch (num) {
                    case 1:
                        Collections.sort(series, Multimedia.ComparatorByScore);
                        printSeries(series);
                        break;
                    case 2:
                        Collections.sort(series, Multimedia.ComparatorByName);
                        printSeries(series);
                        break;
                    case 3:
                        Collections.sort(series, Multimedia.ComparatorByDate);
                        printSeries(series);
                        break;
                    case 4:
                        Collections.sort(series, Serie.ComparatosByChaptes);
                        printSeries(series);
                        break;
                    case 0:
                        System.out.println("Volviendo al menú Series");
                        break;

                    default:
                        System.out.println("Numero no válido. Por favor, introduce otro.");
                }
            } while (num != 0);
        }else if (series.size() == 1){
            System.out.print("No hay series suficiente par un orden. La unica serie de la que tenemos constancia es: ");
            printSeries(series);
        }else {
            System.out.println("No hay series.");
        }
    }



    /**
     * En este menú creamos las peliculas.
     * Tenemos que darle valores a cada uno de los atributos de la pelicula controlando que no den errores.
     *
     * @param movies ArrayList de peliculas
     * @param actorsAvailable ArrayList de actores que hay hasta el momoneto creados y, por lo tanto,
     *                        leibles por nuestro programa
     */
    private static void addMovie(ArrayList<Movie> movies, ArrayList<Actor> actorsAvailable) {
        Scanner input = new Scanner(System.in);

        int num = 0;

        boolean valid = false;
        String nameFilm = "";
        double score = 0, bugdet = 0;
        ArrayList<Actor> actorsInMovie = new ArrayList<Actor>();

        Calendar releaseDate = new GregorianCalendar();
        int releaseYear = 0;
        int releaseMonth = 0;
        int releaseDay = 0;
        //Damos el nombre de la pelicula
        do {
            try {
                System.out.print("Nombre de la pelicula: ");
                nameFilm = input.nextLine();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido, intentalo otra vez");
                input.nextLine();
            }
        } while (valid == false);

        valid = false;
        //Damos una puntuacion a la pelicula entre 0 y 100.
        do {
            try {
                System.out.print("\nPuntuacion de la pelicula (0-100): ");
                score = input.nextDouble();
                if (score <= 100 && score >= 0) {
                    valid = true;
                } else {
                    System.out.println("Numero no valido, tiene que ser entre 0 y 100");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido, intentalo otra vez.");
                input.nextLine();
            }
        } while (valid == false);

        valid = false;

        //Damos el presupuesto de la pelcula.
        //Impedimos que el presupuesto sea menor de 0
        do {
            try {
                System.out.print("\nPresupuesto de la pelicula (En millones): ");
                bugdet = input.nextDouble();
                if (bugdet >= 0) {
                    valid = true;
                } else {
                    System.out.println("Numero no válido, tiene que ser mayor o igual a 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido, intentalo otra vez");
                input.nextLine();
            }

        } while (valid == false);

        //Damos a la pelicula los actores.
        //No permitimos que hayan actores repetidos en la pelicula.
        //Si el actor que queremos no existe en nuestra lista de actores, lo podemos crear.

        do {
            try {
                System.out.println("\n¿Quieres añadir un actor a la película?");
                System.out.println("* 1 - Sí");
                System.out.println("* 0 - No");
                num = input.nextInt();
                if (num == 0 && actorsInMovie.size() == 0) {
                    System.out.println("Tienes que añadir al menos un actor a la película");
                    num = -1;
                } else if (num == 1) {
                    System.out.println();
                    System.out.println();
                    System.out.println("* 1 - Añadir actor de la lista de actores");
                    System.out.println("* 2 - Añadir nuevo actor");
                    num = input.nextInt();
                    if (num == 1){
                        num = addActorToMultimediaOnList(actorsAvailable,actorsInMovie);
                        if (num != -1){
                            actorsInMovie.add(actorsAvailable.get(num));
                        }
                    }else if (num == 2){
                        addActor(actorsAvailable);
                        actorsInMovie.add((actorsAvailable.get(actorsAvailable.size()-1)));
                    }
                    num = -1;
                }
            }catch (InputMismatchException e){
                System.out.println("Valor no válido. Introduce un numero válido");
                input.nextLine();
            }
        }while (num != 0);

        valid = false;

        //Creamos la fecha
        do {
            try {
                do {
                    System.out.print("Año de estreno (YYYY): ");
                    releaseYear = input.nextInt();
                    if (releaseYear < 1887){
                        System.out.println("Numero no válido. El cine, se invento en 1887. El año tiene que ser porsterior al mismo");
                    }
                }while (releaseYear < 1887);
                do {
                    System.out.print("Mes de estreno(MM): ");
                    releaseMonth = input.nextInt();
                    if (releaseMonth <= 0 || releaseMonth > 12){
                        System.out.println("El mes no puede ser mayor que 12 ni menor que 1.");
                    }
                }while (releaseMonth <= 0 || releaseMonth > 12);
                do {
                    System.out.print("Dia de estreno(DD): ");
                    releaseMonth = input.nextInt();
                    if (releaseMonth <= 0 || releaseMonth > 31){
                        System.out.println("El dia no puede ser mayor que 31 ni menor que 1.");
                    }
                }while (releaseMonth <= 0 || releaseMonth > 31);
                valid = true;
            }catch (InputMismatchException e){
                System.out.println("Valor no válido. Por favor, introduce un valor válido");
            }
        }while (valid == false);

        //Añadimos la pelicula
        movies.add(new Movie(
                new GregorianCalendar(releaseYear,releaseMonth-1,releaseDay),
                actorsInMovie,
                score,
                nameFilm,
                movies.size(),
                bugdet));
    }
    /**
     * En este menú creamos las series.
     * Tenemos que darle valores a cada uno de los atributos de la serie controlando que no den errores.
     *
     * @param series ArrayList de series
     * @param actorsAvailable ArrayList de actores que hay hasta el momoneto creados y, por lo tanto,
     *                        leibles por nuestro programa.
     */
    private static void addSerie(ArrayList<Serie> series, ArrayList<Actor> actorsAvailable) {
        Scanner input = new Scanner(System.in);

        int num = 0;

        boolean valid = false;
        String nameSerie = "";
        double score = 0;
        int seasons = 0, chapters = 0;
        ArrayList<Actor> actorsInSerie = new ArrayList<Actor>();

        Calendar releaseDate = new GregorianCalendar();
        int releaseYear = 0;
        int releaseMonth = 0;
        int releaseDay = 0;
        //Damos el nombre de la serie
        do {
            try {
                System.out.print("Nombre de la serie: ");
                nameSerie = input.nextLine();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido, intentalo otra vez");
                input.nextLine();
            }
        } while (valid == false);

        valid = false;
        //Damos una puntuacion a la serie entre 0 y 100.
        do {
            try {
                System.out.print("\nPuntuacion de la serie (0-100): ");
                score = input.nextDouble();
                if (score <= 100 && score >= 0) {
                    valid = true;
                } else {
                    System.out.println("Numero no valido, tiene que ser entre 0 y 100");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido, intentalo otra vez.");
                input.nextLine();
            }
        } while (valid == false);

        valid = false;

        //Damos las temporadas de la serie.
        //Impedimos que las temporadas sean menor de 0
        do {
            try {
                System.out.print("\nTemporasdas de la serie: ");
                seasons = input.nextInt();
                if (seasons >= 0) {
                    valid = true;
                } else {
                    System.out.println("Numero no válido, tiene que ser mayor o igual a 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido, intentalo otra vez");
                input.nextLine();
            }

        } while (valid == false);

        valid = false;

        // Damos los capitulos de la serie.
        // El numero de capitulos no puede ser menor que 0, y si hay al menos una temporada,
        // tiene que tener al menos más de un capitulo
        do {
            try {
                System.out.print("\nCapitulos de la serie: ");
                chapters = input.nextInt();
                if (seasons > 0) {
                    if (chapters > 1) {
                        valid = true;
                    } else {
                        System.out.println("Numero no válido, tiene que ser mayor a 1");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido, intentalo otra vez");
                input.nextLine();
            }

        } while (valid == false);



        //Damos a la pelicula los actores.
        //No permitimos que hayan actores repetidos en la pelicula.
        //Si el actor que queremos no existe en nuestra lista de actores, lo podemos crear.
//TODO evitar la repeticion del código
        do {
            try {
                System.out.println("\n¿Quieres añadir un actor a la serie?");
                System.out.println("* 1 - Sí");
                System.out.println("* 0 - No");
                num = input.nextInt();
                if (num == 0 && actorsInSerie.size() == 0) {
                    System.out.println("Tienes que añadir al menos un actor a la serie");
                    num = -1;
                } else if (num == 1) {
                    System.out.println();
                    System.out.println();
                    System.out.println("* 1 - Añadir actor de la lista de actores");
                    System.out.println("* 2 - Añadir nuevo actor");
                    num = input.nextInt();
                    if (num == 1){
                        num = addActorToMultimediaOnList(actorsAvailable,actorsInSerie);
                        if (num != -1){
                            actorsInSerie.add(actorsAvailable.get(num));
                        }
                    }else if (num == 2){
                        addActor(actorsAvailable);
                        actorsInSerie.add((actorsAvailable.get(actorsAvailable.size()-1)));
                    }
                    num = -1;
                }
            }catch (InputMismatchException e){
                System.out.println("Valor no válido. Introduce un numero válido");
                input.nextLine();
            }
        }while (num != 0);

        valid = false;

        //Creamos la fecha
        do {
            try {
                do {
                    System.out.print("Año de estreno (YYYY): ");
                    releaseYear = input.nextInt();
                    if (releaseYear < 1887){
                        System.out.println("Numero no válido. El cine, se invento en 1887. El año tiene que ser porsterior al mismo");
                    }
                }while (releaseYear < 1887);
                do {
                    System.out.print("Mes de estreno(MM): ");
                    releaseMonth = input.nextInt();
                    if (releaseMonth <= 0 || releaseMonth > 12){
                        System.out.println("El mes no puede ser mayor que 12 ni menor que 1.");
                    }
                }while (releaseMonth <= 0 || releaseMonth > 12);
                do {
                    System.out.print("Dia de estreno(DD): ");
                    releaseMonth = input.nextInt();
                    if (releaseMonth <= 0 || releaseMonth > 31){
                        System.out.println("El dia no puede ser mayor que 31 ni menor que 1.");
                    }
                }while (releaseMonth <= 0 || releaseMonth > 31);
                valid = true;
            }catch (InputMismatchException e){
                System.out.println("Valor no válido. Por favor, introduce un valor válido");
            }
        }while (valid == false);

        //Añadimos la serie
        series.add(new Serie(
                new GregorianCalendar(releaseYear,releaseMonth-1,releaseDay),
                actorsInSerie,
                score,
                nameSerie,
                series.size(),
                seasons,
                chapters));

    }




    /**
     * Método para añadir un actor de la lista de actores ya creados a la pelicula.
     * @param actorsAvailable ArrayList de actores disponibles
     * @param actorsInMovie ArrayList de actores en la pelicula
     * @return int del actor para añadir a la pelicula
     */
    private static int addActorToMultimediaOnList(ArrayList<Actor> actorsAvailable, ArrayList<Actor> actorsInMovie) {
        Scanner input = new Scanner(System.in);
        int num;

        try {
            printActor(actorsAvailable);
            System.out.print("Selecciona un actor para la pelicula: ");
            num = input.nextInt();
            if (actorsAvailable.contains(new Actor(num))) {
                if (actorsInMovie.contains(new Actor(num))) {
                    System.out.println("El actor ya está en la película");
                } else {
                    return num;
                }
            } else {
                System.out.println("Introduce un número válido");
            }
        }catch (InputMismatchException e) {
            System.out.println("Valor no válido");
            input.nextLine();
        }
        return -1;
    }


    /**
     * Añadimos un actor nuevo a la lista de actores disponibles
     * @param actors ArrayList de actores
     */


    /**
     * Elimina una película de la lista de películas
     * @param movies ArrayList de películas
     */
    private static void delMovie(ArrayList<Movie> movies) {
        Scanner input = new Scanner(System.in);
        int num;
        if (movies.size() > 0) {
            try {
                System.out.println("Lista de películas: ");

                printMovies(movies);
                System.out.print("Pelicula para borrar: ");
                num = input.nextInt();
                if (num <= 0 || num >= movies.size()) {
                    System.out.println("Número válido. Por favor, introduce un número válido.");
                } else {
                    movies.remove(num);
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido. Por favor, introduce un valor válido.");
            }
        } else {
            System.out.println("No hay peliculas disponibles que puedas borrar.");
        }
    }
    /**
     * Elimina una serie de la lista de series.
     * @param series ArrayList de series
     */
    private static void delSerie(ArrayList<Serie> series) {
        Scanner input = new Scanner(System.in);
        int num;
        if (series.size() > 0) {
            try {
                System.out.println("Lista de Series: ");

                printSeries(series);
                System.out.print("Pelicula para borrar: ");
                num = input.nextInt();
                if (num <= 0 || num >= series.size()) {
                    System.out.println("Número válido. Por favor, introduce un número válido.");
                } else {
                    series.remove(num);
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido. Por favor, introduce un valor válido.");
            }
        }else {
            System.out.println("No hay peliculas en la lsta que puedas borrar");
        }
    }


    private static void addActor(ArrayList<Actor> actors) {
        Scanner input = new Scanner(System.in);

        int ageActor = 0;
        String nameActor, lastNameActor;
        Boolean valid = true;


        System.out.print("Nombre del actor: ");
        nameActor = input.nextLine();
        System.out.print("\nApellido del actor: ");
        lastNameActor = input.nextLine();
        do {
            try{
                System.out.print("\nEdad del actor: ");
                ageActor = input.nextInt();
                if (ageActor < 0){
                    System.out.println("La edad no puede ser negativa. Introduce un número válido.");
                    valid = false;
                }
            }catch (InputMismatchException e){
                System.out.println("Valor introducido no válido. Introduce uno válido.");
            }
        }while (valid == false);

        actors.add(new Actor(actors.size(),nameActor,lastNameActor,ageActor));
    }

    //Helppers

    /**
     * Prueba que el numero insertado
     * @return
     */
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
     * @param movies ArrayList de peliculas.
     */
    private static void printMovies(ArrayList<Movie> movies){
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    /**
     * Hellpper para la impresion de series.
     * @param series ArrayList de series.
     */
    private static void printSeries(ArrayList<Serie> series) {
        for(Serie serie : series){
            System.out.println(serie);
        }
    }

    /**
     * Lee la lista de actores
     * @param actors ArrayList de actores
     */
    private static void printActor(ArrayList<Actor> actors){
        for (int i = 0 ; i < actors.size() ; i++) {
            System.out.println("* " + i + " - " + actors.get(i));
        }
    }
}
