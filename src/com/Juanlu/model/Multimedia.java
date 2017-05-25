package com.Juanlu.model;

import com.Juanlu.model.multimedia.Film;

import java.util.*;

/**
 * Created by juanl on 20/05/2017.
 */
public abstract class Multimedia {
    protected Calendar releaseDate;
    protected ArrayList<Actor> actors;
    protected Actor director;
    protected double score;
    protected String name;
    protected int code;


    //Constructores

    /**
     * Constructor designado con todos los parámetros
     * @param score double puntuación del producto
     * @param releaseDate Date fecha en la cual se estrenó o estrenara el producto
     * @param actors ArrayList de Actors que participan
     * @param director Actor director del producto
     * @param name String nombre del producto
     * @param code int codigo del producto
     */
    public Multimedia(Calendar releaseDate,
                      ArrayList<Actor> actors,
                      Actor director,
                      double score,
                      String name,
                      int code) {
        this.releaseDate = releaseDate;
        this.actors = actors;
        this.score = score;
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
        this.actors = new ArrayList<Actor>();
        this.score = 0.0;
        this.name = "";
        this.director = new Actor();
        this.code = 0;
    }

    public Multimedia(double score) {
        this.releaseDate = new GregorianCalendar();
        this.actors = new ArrayList<Actor>();
        this.score = score;
        this.name = "";
        this.director = new Actor();
        this.code = 0;
        this.score = score;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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

    /**
     * Compara por la puntuacion, para poner la de mayor puntuacion más alto.
     */
    public static Comparator ComparatorByScore = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Multimedia m1 = (Multimedia) o1;
            Multimedia m2 = (Multimedia) o2;

            double result;

            result = m1.getScore() - m2.getScore();

            if (result > 0){
                return -1;
            }else if(result < 0){
                return 1;
            }else {
                return m1.getName().compareToIgnoreCase(m2.getName());
            }
        }
    };

    /**
     *  Comparador por el nombre.
     */
    public static Comparator ComparatorByName = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Multimedia m1 = (Multimedia) o1;
            Multimedia m2 = (Multimedia) o2;

            return m1.getName().compareToIgnoreCase(m2.getName());
        }
    };

    /**
     * Comparador por Fecha. El más nuevo saldrá antes en la ordenación
     */
    public static Comparator ComparatorByDate = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Multimedia m1 = (Multimedia) o1;
            Multimedia m2 = (Multimedia) o2;

            return (int)(m1.getReleaseDate().getTimeInMillis() - m2.getReleaseDate().getTimeInMillis());
        }
    };


    //TODO arreglas toString
    @Override
    public String toString() {
        return "Multimedia{" +
                "releaseDate=" + releaseDate +
                ", actors=" + actors +
                ", director=" + director +
                ", score=" + score +
                ", name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}
