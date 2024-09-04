package org.example.Pizza;

public class Farmhouse extends Pizza{


    @Override
    public int cost() {
        return 300;
    }

    @Override
    public String discription() {
        return "Farmhouse pizza";
    }
}
