package com.Juanlu.controller;

import com.Juanlu.model.Actor;
import com.Juanlu.model.multimedia.Documentary;
import com.Juanlu.model.multimedia.Film;
import com.Juanlu.model.multimedia.Serie;

import java.util.ArrayList;
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

        int index;
        do {
            printListToDo();
            try {
                index = input.nextInt();
            }catch (InputMismatchException e){
                e.printStackTrace();
                index = -1;
            }
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
//                    printListMultimediaOptions(films,series,documentarys);
                   case 0:
                    System.out.println("Bye!");
                       break;

                    default:
                        System.out.println("Numero no valido. Introduce por favor un numero válido");
                        break;
            }
        }while (index != 0);
       // actors.add(new Actor(codigoValido(actors),"Ben","Affleck",44));

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

    }

    //TODO queda por hacer el switch y las opciones de cada uno (Peliculas), así como comentarios
    private static void filmMenu(ArrayList<Film> films, ArrayList<Actor> actors) {
        Scanner input = new Scanner(System.in);
        int index;

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
            try {
                index = input.nextInt();
            }catch (InputMismatchException e){
                e.printStackTrace();
                index = -1;
            }
        }while (index != 0);
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
        System.out.println("* 4 - Lista general (por puntuacion)                    *");
        System.out.println("* 5 - Lista general (otro orden)                        *");
        System.out.println("* 0 - Salir                                             *");
        System.out.println("*                                                       *");
        System.out.println("*********************************************************");

    }


    
    
    //Helppers

    private static int codigoValido(ArrayList<Actor> actors){
        if (actors.size() == 0){
            return 0;
        }
        for (int i = 0; i < actors.size(); i++) {
            if (!actors.contains(new Actor(i))){
                return i;
            }
        }
        return actors.size();
    }


}
