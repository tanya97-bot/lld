package org.example;

import org.example.Mobile.Mobile;
import org.example.Mobile.MobileFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Mobile m1 = MobileFactory.getMobile("Samsung");
        Mobile m2 = MobileFactory.getMobile("IPhone");
        Mobile m3 = MobileFactory.getMobile("Heyy");

        System.out.println(m1.modelName);
        System.out.println(m2.modelName);

        try{
            System.out.println(m3.modelName);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}