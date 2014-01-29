package com.mycafe.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 29.01.14.
 */
public class Cook {
    Kitchen kitchen;

    public List<Meal> prepareMeals(int numOfMeals) throws InterruptedException {
        Thread.sleep(numOfMeals*500);
        List<Meal> meals=new ArrayList<Meal>();
        for (int i=0;i<numOfMeals;i++)
            meals.add(new Meal());
        return meals;
    }

    public List<Meal> prepareMeals(Order order) throws InterruptedException {
        int numOfMeals=order.mealNames.size();
        Thread.sleep(numOfMeals*500);
        List<Meal> meals=new ArrayList<Meal>();
        for (int i=0;i<numOfMeals;i++)
            meals.add(new Meal(order.mealNames.get(i)));
        return meals;
    }
}
