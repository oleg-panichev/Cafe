package com.mycafe.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 29.01.14.
 */
public class Order {
    List<String> mealNames=new ArrayList<String>();

    public Order() {}

    public Order(String... name) {
        for (String n:name)
            mealNames.add(n);
    }
}
