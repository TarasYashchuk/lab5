package Sweets.Other.Cookies;

import Sweets.Sweets;

public class ChocolateCookie extends Sweets {
    private double sugarContent;

    public ChocolateCookie(String name, double weight, double sugarContent){
        super(name,weight);
        this.sugarContent = sugarContent;
    }


    @Override
    public double getWeight() {
        return getWeight();
    }

    @Override
    public double getSugarContent() {
        return  getSugarContent();
    }
}
