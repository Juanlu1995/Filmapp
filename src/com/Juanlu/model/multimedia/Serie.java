package com.Juanlu.model.multimedia;

import com.Juanlu.model.Actor;
import com.Juanlu.model.Multimedia;
import com.Juanlu.model.NegativeNumberException;

import java.io.Serializable;
import java.util.*;

/**
 * Created by juanl on 20/05/2017.
 */
public class Serie extends Multimedia implements Serializable{

    private static final long serialVersionUID = 1223558925138969029L;


    private int seasons;
    private int chapters;


    //Constructores

    /**
     * Constructor designado con todos los parámetros
     * @param puntuacion double puntuación del producto
     * @param releaseDate Date fecha en la cual se estrenó o estrenara el producto
     * @param actors ArrayList de Actors que participan
     * @param name String nombre del producto
     * @param code int codigo del producto
     * @param seasons int numero de temporadas de la serie
     * @param chapters int numero de capitulos de la serie
     */
    public Serie(Calendar releaseDate,
                 ArrayList<Actor> actors,
                 double puntuacion,
                 String name,
                 int code,
                 int seasons,
                 int chapters){
        super(releaseDate, actors, puntuacion, name, code);

        this.seasons = seasons;
        this.chapters = chapters;
    }


    public Serie() {
        super();
        this.seasons = 0;
        this.chapters = 0;
    }


    //Accesores


    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) throws NegativeNumberException{
        if (seasons < 0 ){
            throw new NegativeNumberException("Negative Number");
        }else {
            this.seasons = seasons;
        }
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) throws NegativeNumberException {

        if (chapters < 0) {
            throw new NegativeNumberException("Negative number");
        } else {
            this.chapters = chapters;
        }
    }


    //Comparadores
    public static Comparator ComparatosByChaptes = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Serie s1 = (Serie) o1;
            Serie s2 = (Serie) o2;

            int rest = s1.getChapters() - s2.getChapters();

            if (rest != 0){
                return rest;
            }else {
                return (int)(s1.getReleaseDate().getTimeInMillis() - s2.getReleaseDate().getTimeInMillis());
            }
        }
    };

    @Override
    public String toString() {
        return super.toString()+
                "\nTemporadas: " + seasons +
                "Capítulos: " + chapters;
    }




}
