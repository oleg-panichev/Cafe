package com.mycafe.cafe;

import java.util.Random;

/**
 * Created by oleg on 18.01.14.
 */
public class Client implements Runnable {
    String name;
    Meal meal = null;
    Cashier cashier;

    public Client(Cashier cashier) {
        Random rnd = new Random();
        name = "Client "+(rnd.nextInt(89)+10);
        this.cashier=cashier;
    }

    public Client(String name, Cashier cashier) {
        this.name=name;
        this.cashier=cashier;
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
            meal=cashier.orderMeal(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
