package com.mycafe.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 29.01.14.
 */
public class Kitchen {
    List<Meal> mealList=new ArrayList<Meal>();
    Cook cook;

    public void prepareOrder() {
        mealList.addAll(cook.prepareMeals());
    }

    public void prepareOrder(Order order) {
        mealList.addAll(cook.prepareMeals(order));
    }

}
