package com.Juanlu.controller;

import com.Juanlu.model.Actor;
import com.Juanlu.model.Multimedia;
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
     * Podemos movernos al menu de las peliculas(*1), el de las series(*2), imprimir una lista general
     * de nuestros elementos multimedia (*3) o salir
     *
     *
     * @see #printListToDo()
     * @see #movieMenu()
     * @see #seriesMenu()
     * @see #printGenaralList()
     */

    public void run(){

        int index;

        do {
            printListToDo();
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
     * Nos imprime una lista de las opcines validas que hacer en el programa, así como el número correspondiente
     * de ejecucion de la opcion.
     */
    private static void printListToDo() {
        System.out.println("\n****************   ¿QUÉ QUIERES HACER?   ****************");
        System.out.println("*                    Menu Principal                     *");
        System.out.println("* 1 - Menu Peliculas                                    *");
        System.out.println("* 2 - Menu Series                                       *");
        System.out.println("* 3 - Lista general (por puntuacion)                    *");
        System.out.println("* 4 - Guardar los progresos                             *");
        System.out.println("* 0 - Salir                                             *");
        System.out.println("*                                                       *");
        System.out.println("*********************************************************");
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
            System.out.println("* 3 - Eliminar pelicula                                 *");
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
            System.out.println("* 3 - Eliminar serie                                    *");
            System.out.println("* 0 - Atrás                                             *");
            System.out.println("*                                                       *");
            System.out.println("*********************************************************");

            index = selector();
            switch (index) {
                case 1:
                    printSerieOptions();
                    break;
                case 2:
                    addSerie();
                    break;
                case 3:
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
     * Nos imprime las posibilidades de ordenamiento de las las peliculas, así como el numero correspondiente para
     * acceder a dicha opcion.
     *
     * @see #printMovies(ArrayList)
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

                num = selector();

                switch (num) {
                    case 1:
                        Collections.sort(this.movies, Multimedia.ComparatorByScore);
                        printMovies(this.movies);
                        break;
                    case 2:
                        Collections.sort(this.movies, Multimedia.ComparatorByName);
                        printMovies(this.movies);
                        break;
                    case 3:
                        Collections.sort(this.movies, Multimedia.ComparatorByDate);
                        printMovies(this.movies);
                        break;
                    case 4:
                        Collections.sort(this.movies, Movie.ComparatorByBudget);
                        printMovies(this.movies);
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
    }
    /**
     * Nos imprime las posibilidades de ordenamiento de las las series, así como el numero correspondiente para
     * acceder a dicha opcion.
     *
     * @see #printSeries(ArrayList)
     */
    private void printSerieOptions() {
        int num;
        if (series.size() > 1) {
            do {
                System.out.println("\n**************** ¿Comó quieres Imprimir? ****************");
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
                        Collections.sort(this.series, Multimedia.ComparatorByScore);
                        printSeries(series);
                        break;
                    case 2:
                        Collections.sort(this.series, Multimedia.ComparatorByName);
                        printSeries(series);
                        break;
                    case 3:
                        Collections.sort(this.series, Multimedia.ComparatorByDate);
                        printSeries(series);
                        break;
                    case 4:
                        Collections.sort(this.series, Serie.ComparatosByChaptes);
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
            System.out.println(series.get(0));
        }else {
            System.out.println("No hay series.");
        }
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
                    actorSelector(actorsInMovie);
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
                    actorSelector(actorsInSerie);
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
     * Nos da la opcion de añadir actores a los productos multimedia de una lista de actores ya creados o
     * crear un añadir un actor nuevo a la lista de actores y, seguidamente, añadirlo al producto multimedia.
     * @param actorsInMultimedia ArrayList de actores en el producto multimedia
     */
    private void actorSelector(ArrayList<Actor> actorsInMultimedia) {
        Scanner input = new Scanner(System.in);

        int num = 0;

        System.out.println();
        System.out.println();
        System.out.println("* 1 - Añadir actor de la lista de actores");
        System.out.println("* 2 - Añadir nuevo actor");
        num = input.nextInt();
        if (num == 1){
            num = addActorToMultimediaOnList(actorsInMultimedia);
            if (num != -1){
                actorsInMultimedia.add(this.actors.get(num));
            }
        }else if (num == 2){
            addActor();
            actorsInMultimedia.add((this.actors.get(this.actors.size()-1)));
        }
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
            System.out.print("Selecciona un actor para la pelicula: ");
            num = input.nextInt();
            if (this.actors.contains(new Actor(num))) {
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
     * Elimina una película de la lista de películas
     */
    private void delMovie() {
        Scanner input = new Scanner(System.in);
        int num;
        if (this.movies.size() > 0) {
            try {
                System.out.println("Lista de películas: ");
                Collections.sort(this.movies,Multimedia.ComparatorByName);
                printMovies(this.movies);
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
                System.out.println("Lista de Series: ");

                printSeries(this.series);
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
     * Creamos un nuevo actor en la lista de actores disponibles.
     */
    private void addActor() {
        Scanner input = new Scanner(System.in);

        int ageActor = 0;
        String nameActor = "", lastNameActor = "";
        Boolean valid = true;

        do {
            try {
                System.out.print("Nombre del actor (sólo nombre): ");
                nameActor = input.nextLine();
                if (nameActor.length() > 0) {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido.");
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
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor introducido no válido. Introduce uno válido.");
                }
            } while (valid == false);

            this.actors.add(new Actor(this.actors.size(), nameActor, lastNameActor, ageActor));
        } while (valid == false);
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
     * @param movies ArrayList de peliculas.
     */
    private static void printMovies(ArrayList<Movie> movies){
        for (int i = 0; i < movies.size() ; i++) {
            System.out.println("* " + i + " - " + movies.get(i));
        }
    }

    /**
     * Hellpper para la impresion de series.
     * @param series ArrayList de series.
     */
    private static void printSeries(ArrayList<Serie> series) {
        for (int i = 0; i < series.size() ; i++) {
            System.out.println("* " + i + " - " + series.get(i));
        }
    }

    /**
     * Imprime una lista general de todos los contenidos multimedias que tenemos en nuestro programa
     */
    private void printGenaralList() {
        System.out.println("\n*********************   PELICULAS   *********************");
        printMovies(this.movies);
        System.out.println("\n***********************   SERIES   ***********************");
        printSeries(this.series);
        System.out.println();
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




    public void saveMultimedia() {
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

    public void loadMovies() {
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
    public void loadSeries() {
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
    public void loadActors() {
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
