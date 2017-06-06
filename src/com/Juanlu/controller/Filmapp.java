package com.Juanlu.controller;

import com.Juanlu.model.Actor;
import com.Juanlu.model.Multimedia;
import com.Juanlu.model.NegativeNumberException;
import com.Juanlu.model.multimedia.Movie;
import com.Juanlu.model.multimedia.Serie;

import java.io.*;
import java.util.*;

/**
 * Created by juanl on 20/05/2017.
 */
public class Filmapp {

    private ArrayList<Actor> actors = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Serie> series = new ArrayList<>();

    public Filmapp() {
        loadActors();
        loadMovies();
        loadSeries();
    }

    /**
     * Iniciamos la aplicacion
     *
     * Creamos un ArrayList con la lista de actores, peliculas, series y documentales que van a estar disponibles de
     * modificacion a gusto del cliente, ya sea eliminar o añadir un elemento a la lista.
     * Así mismo mostramos un menú que nos mostrará para elegir qué queremos hacer y los numeros validos
     * para cada opcion.
     * Podemos movernos al menú de las peliculas(*1), el de las series(*2), imprimir una lista general
     * de nuestros elementos multimedia (*3), ir al menú de actores, guardar los cambios o salir (guardando los cambios)
     *
     *
     * @see #movieMenu()
     * @see #seriesMenu()
     * @see #printGenaralList()
     */

    public void run(){

        int index;

        do {
            System.out.println("\n****************   ¿QUÉ QUIERES HACER?   ****************");
            System.out.println("*                    Menu Principal                     *");
            System.out.println("* 1 - Menu Peliculas                                    *");
            System.out.println("* 2 - Menu Series                                       *");
            System.out.println("* 3 - Lista general (por puntuacion)                    *");
            System.out.println("* 4 - Menu Actores                                      *");
            System.out.println("* 5 - Guardar los cambios                               *");
            System.out.println("* 0 - Salir                                             *");
            System.out.println("*                                                       *");
            System.out.println("*********************************************************");
            System.out.print("Opcion: ");
            index = selector();
            switch (index){
                case 1:
                    movieMenu();
                    break;
                case 2:
                    seriesMenu();
                    break;
                case 3:
                    printGenaralList();
                    break;
                case 4:
                    actorMenu();
                    break;
                case 5:
                    saveMultimedia();
                    break;
                case 0:
                    System.out.println("Bye!");
                    saveMultimedia();
                       break;

                    default:
                        System.out.println("Numero no valido. Introduce por favor un numero válido");
                        break;
            }
        }while (index != 0);
    }




    /**
     * Muestra el menú de qué se puede hacer con las películas y el número correspondiente para interactuar con ellas.
     */
    private void movieMenu() {
        Scanner input = new Scanner(System.in);
        int index = 0;

        do {
            System.out.println("****************   ¿QUÉ QUIERES HACER?   ****************");
            System.out.println("*                       Peliculas                       *");
            System.out.println("* 1 - Ver lista de peliculas ordenadas por...           *");
            System.out.println("* 2 - Añadir pelicula                                   *");
            System.out.println("* 3 - Modificar pelicula                                *");
            System.out.println("* 4 - Eliminar pelicula                                 *");
            System.out.println("* 0 - Atrás                                             *");
            System.out.println("*                                                       *");
            System.out.println("*********************************************************");

            index = selector();

            switch (index){
                case 1:
                    printMovieOptions();
                    break;
                case 2:
                    addMovie();
                    break;
                case 3:
                    editMovie();
                    break;
                case 4:
                    delMovie();
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
     */
    private void seriesMenu() {
        int index;

        do {
            System.out.println("****************   ¿QUÉ QUIERES HACER?   ****************");
            System.out.println("*                        Series                         *");
            System.out.println("* 1 - Ver lista de series ordenadas por...              *");
            System.out.println("* 2 - Añadir series                                     *");
            System.out.println("* 3 - Modificar serie                                   *");
            System.out.println("* 3 - Eliminar serie                                    *");
            System.out.println("* 0 - Atrás                                             *");
            System.out.println("*                                                       *");
            System.out.println("*********************************************************");
            System.out.print("Opcion: ");
            index = selector();
            switch (index) {
                case 1:
                    printSerieOptions();
                    break;
                case 2:
                    addSerie();
                    break;
                case 3:
                    editSerie();
                    break;
                case 4:
                    delSerie();
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
     * Muestra el menú de qué se puede hacer con los actores y el número correspondiente para interactuar con ellos.
     */
    private void actorMenu() {
        Scanner input = new Scanner(System.in);

        int num = 0;

        do {
            try {
                System.out.println("****************   ¿QUÉ QUIERES HACER?   ****************");
                System.out.println("*                        Actores                        *");
                System.out.println("* 1 - Ver lista de actores ordenados por...             *");
                System.out.println("* 2 - Añadir actor                        c             *");
                System.out.println("* 3 - Modificar actor                                   *");
                System.out.println("* 0 - Atrás                                             *");
                System.out.println("*                                                       *");
                System.out.println("*********************************************************");
                System.out.print("Opcion: ");
                num = input.nextInt();

                switch (num) {
                    case 1:
                        printActorOptions();
                        break;
                    case 2:
                        addActorSelector(this.actors);
                        break;
                    case 3:
                        editActor(this.actors);
                    case 0:
                        System.out.println("Volviendo al menú principal.");
                        break;

                    default:
                        System.out.println("Número no válido");
                }
            }catch (InputMismatchException e){
                System.out.println("Valor no válido, intentalo otra vez");
            }
        }while (num != 0);
    }


    /**
     * Nos imprime las posibilidades de ordenamiento de las las peliculas, así como el numero correspondiente para
     * acceder a dicha opcion.
     *
     * @see #printMovies()
     */
    private void printMovieOptions() {
        int num;

        if (movies.size() > 1) {
            do {
                System.out.println("\n**************** ¿Comó quieres Imprimir? ****************");
                System.out.println("*                  Impresion peliculas                  *");
                System.out.println("* 1 - Por puntuacion                                    *");
                System.out.println("* 2 - Por orden alfabético                              *");
                System.out.println("* 3 - Por fecha de salida                               *");
                System.out.println("* 4 - Por presupuesto                                   *");
                System.out.println("* 0 - Salir                                             *");
                System.out.println("*                                                       *");
                System.out.println("*********************************************************");
                System.out.println("Opcion: ");
                num = selector();

                switch (num) {
                    case 1:
                        Collections.sort(this.movies, Multimedia.ComparatorByScore);
                        printMovies();
                        break;
                    case 2:
                        Collections.sort(this.movies, Multimedia.ComparatorByName);
                        printMovies();
                        break;
                    case 3:
                        Collections.sort(this.movies, Multimedia.ComparatorByDate);
                        printMovies();
                        break;
                    case 4:
                        Collections.sort(this.movies, Movie.ComparatorByBudget);
                        printMovies();
                        break;
                    case 0:
                        System.out.println("Volviendo al menú Peliculas");
                        break;

                    default:
                        System.out.println("Numero no válido. Por favor, introduce otro.");
                }
            } while (num != 0);
        }else if (this.movies.size() == 1) {
            System.out.print("No hay peliculas suficiente par un orden. La unica pelicula de la que tenemos constancia es: ");
            System.out.println(this.movies.get(0));;
        }else {
            System.out.println("No hay peliculas.");
        }
        Collections.sort(this.movies,Multimedia.ComparatorByName);
    }
    /**
     * Nos imprime las posibilidades de ordenamiento de las las series, así como el numero correspondiente para
     * acceder a dicha opcion.
     *
     * @see #printSeries()
     */
    private void printSerieOptions() {
        int num;
        if (series.size() > 1) {
            do {
                System.out.println("\n**************** ¿Comó quieres Imprimir? ****************");
                System.out.println("*                    Impresion Series                   *");
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
                        Collections.sort(this.series, Multimedia.ComparatorByScore);
                        printSeries();
                        break;
                    case 2:
                        Collections.sort(this.series, Multimedia.ComparatorByName);
                        printSeries();
                        break;
                    case 3:
                        Collections.sort(this.series, Multimedia.ComparatorByDate);
                        printSeries();
                        break;
                    case 4:
                        Collections.sort(this.series, Serie.ComparatosByChaptes);
                        printSeries();
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
            System.out.println(series.get(0));
        }else {
            System.out.println("No hay series.");
        }
        Collections.sort(this.series,Multimedia.ComparatorByName);
    }
    /**
     * Nos imprime las posibilidades de ordenamiento de las los actores, así como el numero correspondiente para
     * acceder a dicha opcion.
     *
     * @see #printActorOptions()
     */
    private void printActorOptions() {
        int num = 0;
        if (this.actors.size() > 0) {
            do {
                try {
                    System.out.println("\n**************** ¿Comó quieres Imprimir? ****************");
                    System.out.println("*                   Impresion Actores                   *");
                    System.out.println("* 1 - Por nombre                                        *");
                    System.out.println("* 2 - Por apellido                                      *");
                    System.out.println("* 3 - Por edad                                          *");
                    System.out.println("* 0 - Salir                                             *");
                    System.out.println("*                                                       *");
                    System.out.println("*********************************************************");
                    System.out.print("Opcion: ");
                    num = selector();

                    switch (num) {
                        case 1:
                            Collections.sort(this.actors, Actor.ComparatorByName);
                            printActor(this.actors);
                            break;
                        case 2:
                            Collections.sort(this.actors, Actor.ComparatorByLastName);
                            printActor(this.actors);
                            break;
                        case 3:
                            Collections.sort(this.actors, Actor.ComparatorByAge);
                            printActor(this.actors);
                            break;
                        case 0:
                            System.out.println("Volviendo al menú actores");
                            break;

                        default:
                            System.out.println("Numero no válido. Por favor, introduce otro.");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Valor no válido, intentalo otra vez.");
                }
            } while (num != 0);
        } else if (this.actors.size() == 1) {
            System.out.print("No hay actores suficiente par un orden. El único actor del que tenemos constancia es: ");
            System.out.println(this.actors.get(0));
            ;
        } else {
            System.out.println("No hay actores.");
        }
        Collections.sort(this.actors,Actor.ComparatorByName);
    }



    /**
     * En este menú creamos las peliculas.
     * Tenemos que darle valores a cada uno de los atributos de la pelicula controlando que no den errores.
     */
    private void addMovie() {
        Scanner input = new Scanner(System.in);

        int num = 0;

        boolean valid = false;
        String nameFilm = "";
        double score = 0, bugdet = 0;
        ArrayList<Actor> actorsInMovie = new ArrayList<Actor>();

        Calendar releaseDate;

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
        //Damos una puntuacion a la pelicula entre 0 y 10.
        do {
            try {
                System.out.print("\nPuntuacion de la pelicula (0-10): ");
                score = input.nextDouble();
                if (score <= 10 && score >= 0) {
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
                    addActorSelector(actorsInMovie);
                    }
            }catch (InputMismatchException e){
                System.out.println("Valor no válido. Introduce un numero válido");
                input.nextLine();
            }
        }while (num != 0);

        valid = false;

        //Creamos la fecha
        releaseDate = createDate();


        //Añadimos la pelicula
        this.movies.add(new Movie(
                releaseDate,
                actorsInMovie,
                score,
                nameFilm,
                movies.size(),
                bugdet));
    }
    /**
     * En este menú creamos las series.
     * Tenemos que darle valores a cada uno de los atributos de la serie controlando que no den errores.
     */
    private void addSerie() {
        Scanner input = new Scanner(System.in);

        int num = 0;

        boolean valid = false;
        String nameSerie = "";
        double score = 0;
        int seasons = 0, chapters = 0;
        ArrayList<Actor> actorsInSerie = new ArrayList<Actor>();
        Calendar releaseDate;

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
        //Damos una puntuacion a la serie entre 0 y 10.
        do {
            try {
                System.out.print("\nPuntuacion de la serie (0-10): ");
                score = input.nextDouble();
                if (score <= 10 && score >= 0) {
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
                System.out.print("\nTemporadas de la serie: ");
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
                    addActorSelector(actorsInSerie);
                }
            }catch (InputMismatchException e){
                System.out.println("Valor no válido. Introduce un numero válido");
                input.nextLine();
            }
        }while (num != 0);


        //Creamos la fecha
        releaseDate = createDate();

        //Añadimos la serie
        this.series.add(new Serie(
                releaseDate,
                actorsInSerie,
                score,
                nameSerie,
                series.size(),
                seasons,
                chapters));

    }


    /**
     * Modifíca los valores de la pelicula.
     * Nos muestra un menú por el cual pordemos interactuar,
     * permitiéndonos modificar cada uno de los atributos de la película
     */
    private void editMovie() {
        Scanner input = new Scanner(System.in);

        int movie = 0, num = 0;
        double budget = 0,score;
        boolean valid = false;
        String name;
        ArrayList<Actor> newActors;

        valid = false;
        do {
            try {
                System.out.println("\n\n¿Qué película quieres editar?\n");
                printMovies();
                movie = input.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Valor no válido. Por favor, introduce un valor válido");
            }
        } while (valid == false);
        valid = false;
        do {
            try {
                System.out.println("\n" + movies.get(movie));
                System.out.println("\n¿Qué quieres modificar?");
                System.out.println("* 1 - Nombre");
                System.out.println("* 2 - Puntuacion");
                System.out.println("* 3 - Fecha de estreno");
                System.out.println("* 4 - Actores");
                System.out.println("* 5 - Presupuesto");
                System.out.println("* 0 - Volver.");
                num = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido. Por favor, introduce un valor válido");
                input.nextLine();
            }

            switch (num) {
                case 1:
                    System.out.print("Introduce el nuevo nombre: ");
                    name = input.nextLine();
                    input.nextLine();
                    movies.get(movie).setName(name);
                    break;
                case 2:
                    do {
                        try {
                            System.out.print("Introduce la nueva puntuacion: ");
                            score = input.nextDouble();
                            movies.get(movie).setScore(score);
                            valid = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Valor no válido. Por favor, introduce un valor válido.");
                            input.nextLine();
                        }
                    } while (valid == false);
                    break;
                case 3:
                    System.out.println("Introduce la nueva fecha de estreno: ");
                    movies.get(movie).setReleaseDate(createDate());
                    break;
                case 4:
                    newActors = movies.get(movie).getActors();
                    editActorSelector(newActors);
                    movies.get(movie).setActors(newActors);
                    break;
                case 5:
                    do {
                        try {
                            System.out.print("Introduce el nuevo presupuesto: ");
                            budget = input.nextDouble();
                            input.nextLine();
                            movies.get(movie).setBudget(budget);
                            valid = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Valor no válido. Por favor, introduce un valor válido.");
                        } catch (NegativeNumberException e) {
                            System.out.println("No se pueden establecer un presupuesto negativo.");
                        }
                    } while (valid == false);
                    break;
                case 0:
                    System.out.println("Volviendo al menú películas.");
                    break;

                default:
                    System.out.println("Número no válido. Por favor, introduce un número válido.");

            }
        }while (num != 0);
    }
    /**
     * Modifíca los valores de la serie.
     * Nos muestra un menú por el cual pordemos interactuar,
     * permitiéndonos modificar todos y cada uno de los atributos de la serie
     */
    private void editSerie() {
        Scanner input = new Scanner(System.in);

        int serie = 0, num = 0, seasons = 0, chapters = 0;
        boolean valid = false;
        String name;

        ArrayList<Actor> newActors;

        valid = false;
        do {
            try {
                System.out.println("\n\n¿Qué serie quieres editar?");
                printSeries();
                serie = input.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Valor no válido. Por favor, introduce un valor válido");
            }
        } while (valid == false);
        valid = false;
        do {
            try {
                System.out.println("¿Qué quieres modificar?");
                System.out.println("* 1 - Nombre");
                System.out.println("* 2 - Puntuacion");
                System.out.println("* 3 - Fecha de estreno");
                System.out.println("* 4 - Actores");
                System.out.println("* 5 - Temporadas");
                System.out.println("* 6 - Capítulos");
                System.out.println("* 0 - Cancelar.");
                System.out.println(series.get(serie));
                num = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido. Por favor, introduce un valor válido");
                input.nextLine();
            }

            switch (num) {
                case 1:
                    System.out.print("Introduce el nuevo nombre: ");
                    name = input.nextLine();
                    input.nextLine();
                    series.get(serie).setName(name);
                    break;
                case 2:
                    do {
                        try {
                            System.out.print("Introduce la nueva puntuacion: ");
                            num = input.nextInt();
                            input.nextLine();
                            series.get(serie).setScore(num);
                            valid = true;
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Valor no válido. Por favor, introduce un valor válido.");
                        }
                    } while (valid == false);
                case 3:
                    System.out.println("Introduce la nueva fecha de estreno: ");
                    series.get(serie).setReleaseDate(createDate());
                    break;
                case 4:
                    newActors = series.get(serie).getActors();
                    editActorSelector(newActors);
                    series.get(serie).setActors(newActors);
                    break;
                case 5:
                    do {
                        try {
                            System.out.print("Introduce el numero de temporadas: ");
                            seasons = input.nextInt();
                            input.nextLine();
                            series.get(serie).setSeasons(seasons);
                            valid = true;

                        } catch (InputMismatchException e) {
                            System.out.println("Valor no válido. Por favor, introduce un valor válido.");
                        } catch (NegativeNumberException e) {
                            System.out.println("No se pueden establecer un numero de temporadas en negativo.");
                        }
                    } while (valid == false);
                    break;
                case 6:
                    do {
                        try {
                            System.out.print("Introduce el numero de capítulos: ");
                            chapters = input.nextInt();
                            input.nextLine();
                            series.get(serie).setChapters(chapters);
                            valid = true;
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Valor no válido. Por favor, introduce un valor válido.");
                        } catch (NegativeNumberException e) {
                            System.out.println("No se pueden establecer un numero de capítulos en negativo.");
                        }
                    } while (valid == false);
                    break;
                case 0:
                    System.out.println("Volviendo al menú series.");
                    break;

                default:
                    System.out.println("Número no válido. Por favor, introduce un número válido.");

            }
        }while (num != 0);
    }



    /**
     * Elimina una película de la lista de películas
     */
    private void delMovie() {
        Scanner input = new Scanner(System.in);
        int num;
        if (this.movies.size() > 0) {
            try {
                System.out.println("\nLista de películas: ");
                Collections.sort(this.movies,Multimedia.ComparatorByName);
                printMovies();
                System.out.print("Pelicula para borrar: ");
                num = input.nextInt();
                if (num <= 0 || num >= this.movies.size()) {
                    System.out.println("Número válido. Por favor, introduce un número válido.");
                } else {
                    this.movies.remove(num);
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
     */
    private void delSerie() {
        Scanner input = new Scanner(System.in);
        int num;
        if (this.series.size() > 0) {
            try {
                System.out.println("\nLista de Series: ");

                printSeries();
                System.out.print("Pelicula para borrar: ");
                Collections.sort(this.series,Multimedia.ComparatorByName);
                num = input.nextInt();
                if (num <= 0 || num >= this.series.size()) {
                    System.out.println("Número válido. Por favor, introduce un número válido.");
                } else {
                    this.series.remove(num);
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido. Por favor, introduce un valor válido.");
            }
        }else {
            System.out.println("No hay peliculas en la lsta que puedas borrar");
        }
    }


    /**
     * Nos da la opcion de añadir actores a los productos multimedia de una lista de actores ya creados o
     * crear un añadir un actor nuevo a la lista de actores y, seguidamente, añadirlo al producto multimedia.
     * @param actorsInMultimedia ArrayList de actores en el producto multimedia
     */
    private void addActorSelector(ArrayList<Actor> actorsInMultimedia) {
        Scanner input = new Scanner(System.in);

        int num = 0;

        System.out.println();
        System.out.println();
        System.out.println("* 1 - Añadir actor de la lista de actores");
        System.out.println("* 2 - Añadir nuevo actor");
        System.out.print("Opcion: ");
        num = input.nextInt();
        if (num == 1){
            num = addActorToMultimediaOnList(actorsInMultimedia);
            if (num != -1){
                actorsInMultimedia.add(this.actors.get(num));
            }
        }else if (num == 2){
            addNewActor();
            actorsInMultimedia.add((this.actors.get(this.actors.size()-1)));
        }
    }
    /**
     * Creamos un nuevo actor en la lista de actores disponibles.
     */
    private void addNewActor() {
        Scanner input = new Scanner(System.in);

        int ageActor = 0;
        String nameActor = "", lastNameActor = "";
        Boolean valid = true;

        do {
            try {
                System.out.print("\nNombre del actor (sólo nombre): ");
                nameActor = input.nextLine();
                if (nameActor.length() > 0) {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido.");
                input.nextLine();
            }
        } while (valid == false);
        valid = false;
        do {
            try {
                System.out.print("\nApellido del actor: ");
                lastNameActor = input.nextLine();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido.");
                input.nextLine();
            }
            while (valid == false) ;
            valid = false;
            do {
                try {
                    System.out.print("\nEdad del actor: ");
                    ageActor = input.nextInt();
                    if (ageActor < 0) {
                        System.out.println("La edad no puede ser negativa. Introduce un número válido.");
                        valid = false;
                    }else {
                        valid = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor introducido no válido. Introduce un valor válido.");
                }
            } while (valid == false);

            this.actors.add(new Actor(this.actors.size(), nameActor, lastNameActor, ageActor));
        } while (valid == false);
    }

    /**
     * Método para añadir un actor de la lista de actores ya creados a la pelicula.
     * @param actorsInMovie ArrayList de actores en la pelicula
     * @return int del actor para añadir a la pelicula
     */
    private int addActorToMultimediaOnList(ArrayList<Actor> actorsInMovie) {
        Scanner input = new Scanner(System.in);
        int num;

        try {
            printActor(this.actors);
            System.out.print("Selecciona un actor para la pelicula, o bien -1 para salir: ");
            num = input.nextInt();
            if (this.actors.contains(new Actor(num))) {
                if (actorsInMovie.contains(new Actor(num))) {
                    System.out.println("El actor ya está en la película");
                } else {
                    return num;
                }
            }else if(num == -1){
                System.out.println("Saliendo.");
                return -1;
            }else {
                System.out.println("Introduce un número válido");
            }
        }catch (InputMismatchException e) {
            System.out.println("Valor no válido");
            input.nextLine();
        }
        return -1;
    }
    /**
     * Da las opciones de edicion de un actor en una lista de actores.
     * @param actors ArrayList de actores
     */
    private void editActorSelector(ArrayList<Actor> actors ){
        Scanner input = new Scanner(System.in);

        int num = 0;

        do {
            try {
                System.out.println(actors);;
                System.out.println("\n* 1 - Añadir un actor.");
                System.out.println("* 2 - Editar un actor.");
                System.out.println("* 3 - Eliminar un actor.");
                System.out.println("* 0 - Cancelar.");
                num = input.nextInt();
                switch (num) {
                    case 1:
                        addActorSelector(actors);
                        break;
                    case 2:
                        if (actors.size() > 0) {
                            editActor(actors);
                        }else {
                            System.out.println("No hay actores disponibles.");
                        }
                        break;
                    case 3:
                        if (actors.size() > 0) {
                            delActor(actors);
                        }else {
                            System.out.println("No hay actores disponibles.");
                        }

                }
            }catch (InputMismatchException e){
                System.out.println("Valor no válido. Introduce un valor válido.");
            }

        }while (num == -1);
    }

    /**
     * Editamos un actor de la lista de actores.
     * @param actors ArrayList de actores.
     */
    private void editActor(ArrayList<Actor> actors) {
        Scanner input = new Scanner(System.in);

        int num = 0, age = 0;
        String name = "", lastName = "";
        boolean valid = false;

        do {
            try {
                System.out.println("¿Qué actor quieres editar?");
                for (int i = 0; i < actors.size(); i++) {
                    System.out.println("* " + i + " - " + actors.get(i));
                }
                num = input.nextInt();
                if (num < 0 || num >= actors.size()) {
                    System.out.println("Número no válido. Por favor, elige un número válido.");
                } else {
                    System.out.print("Introduce el nombre (solo el nombre): ");
                    input.nextLine();
                    name = input.nextLine();
                    System.out.print("\nIntroduce el apellido: ");
                    lastName = input.nextLine();
                    do {
                        try {
                            System.out.print("Introduce la edad: ");
                            age = input.nextInt();
                            valid = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Valor no válido. Por favor, introduce un valor válido.");
                        }
                    }while (valid == false);
                }
                actors.get(num).setAge(age);
                actors.get(num).setName(name);
                actors.get(num).setLastName(lastName);
            }catch (InputMismatchException e){
                System.out.println("Valor no válido. Por favor, introduce un valor válido.");
                input.nextLine();
            }catch (NegativeNumberException e){
                System.out.println("Valor no válido. Por favor, introduce un valor positivo");
            }
        }while (valid == false);
    }
    /**
     * Elimina un actor de la lista de actores
     * @param actors ArrayList de actores
     */
    private void delActor(ArrayList<Actor> actors) {
        Scanner input = new Scanner(System.in);
        int num = 0;

        do {
            try {
                System.out.println("¿Qué actor quieres eliminar?");
                printActor(actors);
                num = input.nextInt();
                actors.remove(num);
                System.out.println("Eliminado");
            }catch (InputMismatchException e){
                System.out.println("Valor introducido no válido. Introduce un valor válido ");
            }
        }while (num < 0 || num >= actors.size());
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
     * Usamos el método para crear una fecha de salida a los productos multimedia sin fallos y sin repetir código
     * @return Calendar fecha de estreno
     */
    private static Calendar createDate() {
        Scanner input = new Scanner(System.in);

        int releaseYear = 0, releaseMonth = 0, releaseDay = 0;
        boolean valid = false;

        System.out.println("\nFecha de estreno: ");
        do {
            try {
                System.out.print("Año de estreno (YYYY): ");
                releaseYear = input.nextInt();
                if (releaseYear < 1887) {
                    System.out.println("Numero no válido. El cine, se invento en 1887. El año tiene que ser porsterior al mismo");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido. Por favor, introduce un valor válido");
            }
        } while (releaseYear < 1887);

        do {
            try {
                System.out.print("Mes de estreno(MM): ");
                releaseMonth = input.nextInt();
                if (releaseMonth <= 0 || releaseMonth > 12) {
                    System.out.println("El mes no puede ser mayor que 12 ni menor que 1.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido. Por favor, introduce un valor válido");
            }
        } while (releaseMonth <= 0 || releaseMonth > 12);

        do {
            try {
                System.out.print("Dia de estreno(DD): ");
                releaseDay = input.nextInt();
                if (releaseDay <= 0 || releaseDay > 31) {
                    System.out.println("El dia no puede ser mayor que 31 ni menor que 1.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido. Por favor, introduce un valor válido");
            }
        } while (releaseDay <= 0 || releaseDay > 31);

        return new GregorianCalendar(releaseYear, releaseMonth - 1, releaseDay);
    }


    /**
     * Hellpper para la impresion de peliculas.
     */
    private void printMovies(){

        for (int i = 0; i < this.movies.size() ; i++) {
            System.out.println("* " + i + " - " + movies.get(i));
        }
    }

    /**
     * Hellpper para la impresion de series.
     */
    private void printSeries() {
        for (int i = 0; i < this.series.size() ; i++) {
            System.out.println("* " + i + " - " + series.get(i));
        }
    }

    /**
     * Imprime una lista general de todos los contenidos multimedias que tenemos en nuestro programa
     */
    private void printGenaralList() {
        System.out.println("\n\n\n*********************   PELICULAS   *********************");
        Collections.sort(movies,Multimedia.ComparatorByScore);
        printMovies();
        System.out.println("\n***********************   SERIES   ***********************");
        Collections.sort(series,Multimedia.ComparatorByScore);
        printSeries();

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


    /**
     * Guarda los elementos multimedia y los actores en el fichero para que los cambios en el programa se guarden
     */
    private void saveMultimedia() {
        try {
            ObjectOutputStream peliculas = new ObjectOutputStream( new FileOutputStream("info/peliculas.dat"));
            peliculas.writeObject( this.movies );
            peliculas.close();

            ObjectOutputStream series = new ObjectOutputStream( new FileOutputStream("info/series.dat"));
            series.writeObject( this.series );
            series.close();

            ObjectOutputStream actors = new ObjectOutputStream( new FileOutputStream("info/actors.dat"));
            actors.writeObject( this.actors );
            actors.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga las peliculas desde el fichero en la colecion correspondiente
     */
    private void loadMovies() {
        try {
            ObjectInputStream peliculas = new ObjectInputStream(new FileInputStream("info/peliculas.dat"));
            this.movies = (ArrayList<Movie>)peliculas.readObject();
            peliculas.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga las series desde el fichero en la colecion correspondiente
     */
    private void loadSeries() {
        try {
            ObjectInputStream series = new ObjectInputStream(new FileInputStream("info/series.dat"));
            this.series = (ArrayList<Serie>)series.readObject();
            series.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga los actores desde el fichero en la colecion correspondiente
     */
    private void loadActors() {
        try {
            ObjectInputStream actors = new ObjectInputStream(new FileInputStream("info/actors.dat"));
            this.actors = (ArrayList<Actor>)actors.readObject();
            actors.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
