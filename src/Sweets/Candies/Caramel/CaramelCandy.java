package Sweets.Candies.Caramel;

import Sweets.Sweets;

public class CaramelCandy extends Sweets {

    private double sugarContent;

    public CaramelCandy(String name, double weight, double sugarContent){
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
