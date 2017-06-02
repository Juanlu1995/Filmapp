package com.Juanlu.model.multimedia;

import com.Juanlu.model.Actor;
import com.Juanlu.model.Multimedia;
import com.Juanlu.model.NegativeNumberException;

import java.util.*;

/**
 * Created by juanl on 20/05/2017.
 */
public class Movie extends Multimedia{

    private double budget;


    //Constructores

    /**
     * Constructor designado con todos los parámetros
     * @param releaseDate Date fecha de inicio de la pelcula
     * @param actors ArrayList de Actors que participan en la pelicula
     * @param puntuacion double score de la pelicula
     * @param name String nombre de la pelicula
     * @param code int codigo de la pelicula
     * @param budget double presupuesto de la pelicula
     */
    public Movie(Calendar releaseDate,
                 ArrayList<Actor> actors,
                 double puntuacion,
                 String name,
                 int code,
                 double budget) {
        super(releaseDate, actors, puntuacion, name, code);

        try {
            this.setBudget( budget );
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor sin parámetros
     */
    public Movie() {
        super();
        this.budget = 0;
    }

    public Movie(double score) {
        super(score);
        budget = 0;
    }

    //Accesores

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) throws NegativeNumberException {
        Scanner input = new Scanner(System.in);



        if( budget < 0 ){
            throw new NegativeNumberException("Negative Budget");
        }else{
            try {
                this.budget = budget;
            }catch (InputMismatchException e){
                e.printStackTrace();
            }
        }
    }


    //Comparadores

    public static Comparator ComparatorByBudget = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Movie f1 = (Movie) o1;
            Movie f2 = (Movie) o2;

            double rest = f1.getBudget() - f2.getBudget();

            if (rest > 0){
                return -1;
            }else if (rest < 0){
                return 1;
            }else {
                return (int)(f1.getReleaseDate().getTimeInMillis() - f2.getReleaseDate().getTimeInMillis());
            }
        }
    };


    @Override
    public String toString() {
        return super.toString() +
                "Presupuesto: " + budget;
    }

}

