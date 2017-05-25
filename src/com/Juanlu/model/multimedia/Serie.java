package com.Juanlu.model.multimedia;

import com.Juanlu.model.Actor;
import com.Juanlu.model.Multimedia;
import com.Juanlu.model.NegativeNumberException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

/**
 * Created by juanl on 20/05/2017.
 */
public class Serie extends Multimedia {

    private int seasons;
    private int chapters;


    //Constructores

    /**
     * Constructor designado con todos los parámetros
     * @param puntuacion double puntuación del producto
     * @param releaseDate Date fecha en la cual se estrenó o estrenara el producto
     * @param actors ArrayList de Actors que participan
     * @param director Actor director del producto
     * @param name String nombre del producto
     * @param code int codigo del producto
     * @param seasons int numero de temporadas de la serie
     * @param chapters int numero de capitulos de la serie
     */
    public Serie(Calendar releaseDate,
                 ArrayList<Actor> actors,
                 Actor director,
                 double puntuacion,
                 String name,
                 int code,
                 int seasons,
                 int chapters,
                 Date finishDate) {
        super(releaseDate, actors, puntuacion, name, code);

        try {
            this.setSeasons(seasons);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        } catch (InputMismatchException e){
            e.printStackTrace();
        }
        try{
            this.setChapters(chapters);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        } catch (InputMismatchException e){
            e.printStackTrace();
        }
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
}
