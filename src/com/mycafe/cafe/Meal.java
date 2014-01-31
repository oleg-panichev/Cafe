package com.mycafe.cafe;

import java.util.Random;

/**
 * Created by oleg on 18.01.14.
 */
public class Meal {
    String title;
    private static int mealNum=0;

    public Meal() {
        synchronized (this)
        {
            title = "Meal "+mealNum;
            mealNum++;
        }
    }

    public Meal(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
