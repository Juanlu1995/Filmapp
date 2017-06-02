package com.Juanlu;

import com.Juanlu.controller.Filmapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Filmapp.run();
//        Calendar releaseDate = new GregorianCalendar();
//        releaseDate = createDate();
//
//        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
//        String fecha = formato.format(releaseDate.getTime());
//        System.out.println(fecha);
    }
/*
    private static Calendar createDate() {
        Scanner input = new Scanner(System.in);

        int releaseYear = 0, releaseMonth = 0, releaseDay = 0;
        boolean valid = false;

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
    }*/
}
