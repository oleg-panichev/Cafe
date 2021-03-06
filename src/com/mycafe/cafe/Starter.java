package com.mycafe.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 18.01.14.
 */
public class Starter {
    public static void main(String[] args) throws InterruptedException {
        Cashier cashier=new Cashier();
        Kitchen kitchen=new Kitchen();

        cashier.setKitchen(kitchen);

        List<Client> clients = new ArrayList<Client>();
        for (int i=0; i<11; i++)
            clients.add(new Client(cashier));
        Thread.sleep(2000);

        for (Client c:clients) {
            (new Thread(c)).start();
        }

        Thread.sleep(10000);
        for (Client c:clients) {
            System.out.println(c.toString());
        }
    }
}
