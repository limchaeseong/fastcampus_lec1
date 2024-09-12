package org.example.orderFood;

public class Cooking {
    public Cook makeCook(MenuItem menuItem) {
        //return new Cook("돈까스",5000); // 하드코딩 제거

        return new Cook(menuItem);
    }
}
