package org.example.Pizza;

public class CheeseDecorator extends PizzaDecorator {
    private Pizza p;

    public CheeseDecorator(Pizza p){
        this.p =p;
    }
    @Override
    public int cost() {
        return p.cost() + 100;
    }

    @Override
    public String discription() {
        return p.discription() +"with Cheese Topping";
    }
}
