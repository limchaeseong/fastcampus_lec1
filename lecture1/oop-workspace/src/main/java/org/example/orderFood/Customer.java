package org.example.orderFood;

public class Customer {
    public Cook order(String menuName, Menu menu, Cooking cooking){
        MenuItem menuItem = menu.choose(menuName);
        Cook cook = cooking.makeCook(menuItem);
        return cook;
    }
}
