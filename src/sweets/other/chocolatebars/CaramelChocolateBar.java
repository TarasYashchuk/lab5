package sweets.other.chocolatebars;

import sweets.Sweets;

public class CaramelChocolateBar extends Sweets {
    private double sugarContent;

    public CaramelChocolateBar(String name, double weight, double sugarContent){
        super(name,weight,sugarContent);
        this.sugarContent = sugarContent;
    }

    @Override
    public double getSugarContent() {
        return  sugarContent;
    }

    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "Назва цукерки: " + getName() + "\n" +
                "Тип: шоколадний батончик " + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}
