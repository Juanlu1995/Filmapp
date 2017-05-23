package com.Juanlu.model.multimedia;

import com.Juanlu.model.Actor;
import com.Juanlu.model.Multimedia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by juanl on 20/05/2017.
 */
public class Documentary extends Multimedia {

    private String description;


    //Construcore

    /**
     * Constructor designado con todos los parámetros
     * @param releaseDate
     * @param puntuacion double puntuación del producto
     * @param releaseDate Date fecha en la cual se estrenó o estrenara el producto
     * @param actors ArrayList de Actors que participan
     * @param director Actor director del producto
     * @param name String nombre del producto
     * @param code int codigo del producto
     * @param description String tema del que trata el documental
     */
    public Documentary(Calendar releaseDate, ArrayList<Actor> actors, Actor director, double puntuacion, String name, int code, String description) {
        super(releaseDate, actors, director, puntuacion, name, code);
        this.description = description.trim();
    }

    /**
     * Constructor por defecto sin parámetros
     */
    public Documentary() {
        super();
        this.description = "";
    }

    //Accesores


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.trim();
    }
}
