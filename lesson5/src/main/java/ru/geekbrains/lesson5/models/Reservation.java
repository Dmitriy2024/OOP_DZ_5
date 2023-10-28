package ru.geekbrains.lesson5.models;

import java.util.Date;

public class Reservation {

    private static int counter = 1000;
    private final int id;

    private String name;

    public Reservation(Date date, String name) {
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    private Date date;

    {
        id = ++counter;
    }


}
