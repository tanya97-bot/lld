package org.example.Mobile;

public class MobileFactory {

    public static Mobile getMobile(String mob){
        switch (mob){
            case "IPhone" : return new IPhone();
            case "Redmi"  : return new Redmi();
            case "Samsung" : return new Samsung();
        }
        return null;
    }
}
