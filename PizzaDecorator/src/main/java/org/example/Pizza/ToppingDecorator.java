package org.example.Pizza;

public class ToppingDecorator extends PizzaDecorator {

    private Pizza p;

    public ToppingDecorator(Pizza p){
        this.p =p;
    }
    @Override
    public int cost() {
        return p.cost() + 50;
    }

    @Override
    public String discription() {
        return p.discription() +" Extra toppings";
    }

}
