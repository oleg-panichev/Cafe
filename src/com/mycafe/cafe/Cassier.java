package com.mycafe.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 18.01.14.
 */
public class Cassier {
    List<Meal> mealList;
    private final int numberOfMeals = 10;

    public Cassier() {
        mealList=new ArrayList<Meal>();
        for (int i=0;i<numberOfMeals;i++)
            mealList.add(new Meal());
    }

    public Meal getMeal() throws InterruptedException {
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
    }
}
