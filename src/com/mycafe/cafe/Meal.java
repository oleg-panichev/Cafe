package com.mycafe.cafe;

import java.util.Random;

/**
 * Created by oleg on 18.01.14.
 */
public class Meal {
    String title;
    private static int mealNum=0;

    public Meal() {
        Random rnd = new Random();
        //title = "Meal "+(rnd.nextInt(89)+10);
        title = "Meal "+mealNum;
        mealNum++;
    }

    public Meal(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
