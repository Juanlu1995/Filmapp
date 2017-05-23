package com.Juanlu.model.multimedia;

import com.Juanlu.model.Actor;
import com.Juanlu.model.Multimedia;
import com.Juanlu.model.NegativeNumberException;

import java.util.*;

/**
 * Created by juanl on 20/05/2017.
 */
public class Film extends Multimedia {

    private double budget;


    //Constructores

    /**
     * Constructor designado con todos los parámetros
     * @param releaseDate Date fecha de inicio de la pelcula
     * @param actors ArrayList de Actors que participan en la pelicula
     * @param director Actor director de la pelicula
     * @param puntuacion double puntuacion de la pelicula
     * @param name String nombre de la pelicula
     * @param code int codigo de la pelicula
     * @param budget double presupuesto de la pelicula
     */
    public Film(Calendar releaseDate,
                ArrayList<Actor> actors,
                Actor director,
                double puntuacion,
                String name, int code,
                double budget) {
        super(releaseDate, actors, director, puntuacion, name, code);

        try {
            this.setBudget( budget );
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor sin parámetros
     */
    public Film() {
        this.budget = 0;
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
}



//Excepciones

