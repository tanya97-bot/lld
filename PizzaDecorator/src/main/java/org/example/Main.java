package org.example;

import org.example.Pizza.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Pizza margerita =  new ToppingDecorator(new CheeseDecorator(new Farmhouse()));
        Pizza farmouse = new ToppingDecorator(new CheeseDecorator(new Farmhouse()));

        System.out.println(margerita.discription() +" "+margerita.cost() +" "+ farmouse.cost()) ;
    }
}