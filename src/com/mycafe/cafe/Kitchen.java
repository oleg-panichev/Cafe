package com.mycafe.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 29.01.14.
 */
public class Kitchen  {
    List<Meal> mealList=new ArrayList<Meal>();
    List<Cook> cooks=new ArrayList<>();

    public Kitchen() {
        cooks.add(new Cook());
        cooks.add(new Cook());
    }

    public Kitchen(List<Cook> cooks) {
        this.cooks.addAll(cooks);
    }

    public void prepareOrder(int numOfMeals) throws InterruptedException {
        synchronized (this.mealList) {
            for(int i=0;i<numOfMeals;i++) {
                (new Thread(cooks.get(i%cooks.size()))).start();
            }
            this.mealList.notifyAll();
        }
    }
}
