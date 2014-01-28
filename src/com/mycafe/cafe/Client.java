package com.mycafe.cafe;

import java.util.Random;

/**
 * Created by oleg on 18.01.14.
 */
public class Client implements Runnable {
    String name;
    Meal meal = null;
    Cassier c;

    public Client(Cassier c) {
        Random rnd = new Random();
        name = "Client "+(rnd.nextInt(89)+10);
        this.c=c;
    }

    public Client(String name, Cassier c) {
        this.name=name;
        this.c=c;
    }

    public void orderMeal() throws InterruptedException {

    }

    @Override
    public String toString() {
        if (meal!=null)
            return name+" "+meal.toString();
        else
            return name+" no meal =(";
    }

    @Override
    public void run() {
        try {
            meal = c.getMeal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
