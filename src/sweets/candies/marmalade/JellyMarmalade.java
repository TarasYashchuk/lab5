package sweets.candies.marmalade;

import sweets.Sweets;

public class JellyMarmalade extends Sweets {
    private double sugarContent;

    public JellyMarmalade(String name, double weight, double sugarContent){
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
                "Тип: фруктовий мармелад" + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}
