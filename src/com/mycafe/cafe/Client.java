package com.mycafe.cafe;

import java.util.Random;

/**
 * Created by oleg on 18.01.14.
 */
public class Client implements Runnable {
    String name;
    Meal meal = null;
    Cassier cassier;

    public Client(Cassier cassier) {
        Random rnd = new Random();
        name = "Client "+(rnd.nextInt(89)+10);
        this.cassier=cassier;
    }

    public Client(String name, Cassier cassier) {
        this.name=name;
        this.cassier=cassier;
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
            Order o=new Order("Pelmeni","Vodka");
            meal = cassier.orderMeal(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
