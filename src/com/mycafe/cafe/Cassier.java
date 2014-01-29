package com.mycafe.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 18.01.14.
 */
public class Cassier implements Runnable {
    Kitchen kitchen;
    private final int numberOfMeals = 10;

    public Cassier() {
        kitchen.prepareOrder();
    }

    public Meal orderMeal(Order order) throws InterruptedException {
        Thread.sleep(1000);
        synchronized (mealList) {
            if (mealList.size()>0) {
                return mealList.remove(0); //mealList.size()-1);
            }
            else {
                System.out.println("No more meals!");
                return null;
            }
        }

        if (mealList.size()<5) {

        }

    }

    @Override
    public void run() {
        synchronized ()
    }
}
