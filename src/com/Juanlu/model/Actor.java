package com.Juanlu.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Objects;

/**
 * Created by juanl on 20/05/2017.
 */
public class Actor implements Serializable{
    private static final long serialVersionUID = -1127679897910856261L;

    private int code;
    private String name;
    private String lastName;
    private int age;


    //Constructores

    /**
     * Constructor designado con todos los parámetros
     * @param code int codigo del actor
     * @param name String nombre
     * @param lastName String apellido
     * @param age Date fecha de nacimeinto
     */
    public Actor(int code,
                 String name,
                 String lastName,
                 int age) {
        name = (Character.toUpperCase(name.charAt(0)) + name.substring(1,name.length()));
        lastName = (Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1,lastName.length()));

        this.code = code;
        this.name = name.trim();
        this.lastName = lastName.trim();
        this.age = age;
    }

    /**
     * Constructor designado con un parámetro
     * @param code int codigo del actor
     */
    public Actor(int code) {
        this.code = code;
        this.name = "";
        this.lastName = "";
        this.age = 0;
    }

    /**
     * Constructor por defecto sin parámetros
     */
    public Actor() {
        this.code = 0000;
        this.name = "";
        this.lastName = "";
        this.age = 0;
    }



    //Accesores


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

    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws NegativeNumberException {
        if (age < 0){
            throw new NegativeNumberException();
        }else {
            try{
                this.age = age;
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
        Actor act = (Actor) obj;

        return  Objects.equals(this.getCode(), act.getCode());

    }



    //TODO arreglar el toString. No se distinguen cuando empieza un actor y otro.
    @Override
    public String toString() {
        String completeName = name + " " + lastName;
        return  "\n\t\t\tNombre: " + completeName +
                ", edad: " + age;
    }
}
