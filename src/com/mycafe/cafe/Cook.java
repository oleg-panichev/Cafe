package com.mycafe.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 29.01.14.
 */
public class Cook implements Runnable {
    Kitchen kitchen;

    public Cook(Kitchen kitchen) {
        this.kitchen=kitchen;
    }

    public List<Meal> prepareMeals() throws InterruptedException {
        Thread.sleep(500);
        List<Meal> meals=new ArrayList<Meal>();
        meals.add(new Meal());
        return meals;
    }

    public List<Meal> prepareMeals(int numOfMeals) throws InterruptedException {
        Thread.sleep(numOfMeals*500);
        List<Meal> meals=new ArrayList<Meal>();
        for (int i=0;i<numOfMeals;i++)
            meals.add(new Meal());
        return meals;
    }

    public List<Meal> prepareMeals(Order order) throws InterruptedException {
        List<Meal> meals=new ArrayList<Meal>();
        synchronized (kitchen.mealList) {
            int numOfMeals=order.mealNames.size();
            Thread.sleep(numOfMeals*500);
            for (int i=0;i<numOfMeals;i++)
                meals.add(new Meal(order.mealNames.get(i)));
            kitchen.mealList.notifyAll();
        }
        return meals;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        kitchen.mealList.add(new Meal());
        //kitchen.mealList.notify();
    }

}
