package com.mycafe.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 18.01.14.
 */
public class Cashier implements Runnable {
    Kitchen kitchen;
    private final int numberOfMeals = 10;

    public Cashier() {
    }

    public void setKitchen(Kitchen kitchen) throws InterruptedException {
        this.kitchen=kitchen;
        synchronized (kitchen.mealList) {
            kitchen.prepareOrder(numberOfMeals);
        }
    }

    public Meal orderMeal(Order order) throws InterruptedException {
        Meal meal=null;
        Thread.sleep(1000);

        if (kitchen.mealList.size()<5) {
            //(new Thread(this)).start();
            kitchen.prepareOrder(10);
            //synchronized (kitchen.mealList) { wait(); }
        }

        synchronized (kitchen.mealList) {
            System.out.println("orderMeal:"+kitchen.mealList.size());


            if (kitchen.mealList.size()>0) {
                meal=kitchen.mealList.remove(0);
            }
            else {
                System.out.println("No more meals!");
                return null;
            }
        }
        return meal;
    }

    @Override
    public void run() {
        synchronized (kitchen.mealList) {
            try {
                //kitchen.prepareOrder(10);
                wait();
                System.out.println("New 10 meals has been successfully prepared!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
