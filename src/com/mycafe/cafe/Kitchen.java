package com.mycafe.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 29.01.14.
 */
public class Kitchen {
    List<Meal> mealList=new ArrayList<Meal>();
    Cook cook;

    public void prepareOrder() throws InterruptedException {
        mealList.addAll(cook.prepareMeals());
    }

    public void prepareOrder(Order order) throws InterruptedException {
        mealList.addAll(cook.prepareMeals(order));
    }

}
