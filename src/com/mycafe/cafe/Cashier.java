package com.mycafe.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 18.01.14.
 */
public class Cashier implements Runnable {
    Kitchen kitchen;
    private final int numberOfMeals = 10;

    public Cashier() throws InterruptedException {
        kitchen.prepareOrder(numberOfMeals);
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen=kitchen;
    }

    public Meal orderMeal(Order order) throws InterruptedException {
        Meal meal=null;
        Thread.sleep(1000);
        synchronized (kitchen.mealList) {
            if (kitchen.mealList.size()>0) {
                meal=kitchen.mealList.remove(0); //mealList.size()-1);
            }
            else {
                System.out.println("No more meals!");
                return null;
            }
        }

        if (kitchen.mealList.size()<5) {
            kitchen.prepareOrder(numberOfMeals);
            (new Thread(this)).start();
        }
        return meal;
    }

    @Override
    public void run() {
        synchronized (kitchen.mealList) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
