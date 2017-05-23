package com.Juanlu.model;

import java.util.*;

/**
 * Created by juanl on 20/05/2017.
 */
public abstract class Multimedia {
    protected Calendar releaseDate;
    protected ArrayList<Actor> actors;
    protected Actor director;
    protected double puntuacion;
    protected String name;
    protected int code;


    //Constructores

    /**
     * Constructor designado con todos los parámetros
     * @param puntuacion double puntuación del producto
     * @param releaseDate Date fecha en la cual se estrenó o estrenara el producto
     * @param actors ArrayList de Actors que participan
     * @param director Actor director del producto
     * @param name String nombre del producto
     * @param code int codigo del producto
     */
    public Multimedia(Calendar releaseDate,
                      ArrayList<Actor> actors,
                      Actor director,
                      double puntuacion,
                      String name,
                      int code) {
        this.releaseDate = releaseDate;
        this.actors = actors;
        this.puntuacion = puntuacion;
        this.name = name.trim();
        this.code = code;
        this.director = director;
    }

    /**
     * Constructor por defecto sin parámetros.
     * Las fechas de inicio y fin son la misma, osea ser, la fecha en la que se ha creado el dato multimedia
     */
    public Multimedia(){
        this.releaseDate = new GregorianCalendar();
        //TODO
        this.actors = new ArrayList<Actor>();
        this.puntuacion = 0.0;
        this.name = "";
        this.director = new Actor();
        this.code = 0;
    }




    //Accesores

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public Actor getDirector() {
        return director;
    }

    public void setDirector(Actor director) {
        this.director = director;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) throws NegativeNumberException {
        if (code < 0) {
            throw new NegativeNumberException();
        } else {
            try {
                this.code = code;
            }catch (InputMismatchException e){
                e.printStackTrace();
            }
        }
    }



    //Comparadores

    @Override
    public boolean equals(Object obj) {

        // Self check
        if ( this == obj ) { return true; }

        // null check
        if ( obj == null) { return false; }

        //type check and cast
        if ( this.getClass() != obj.getClass() ) { return false; }

        // field comparison
        Multimedia mult = (Multimedia) obj;

        return  Objects.equals(this.getCode(), mult.getCode());

    }

}
