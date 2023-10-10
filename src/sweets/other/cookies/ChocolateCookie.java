package sweets.other.cookies;

import sweets.Sweets;

public class ChocolateCookie extends Sweets {
    private double sugarContent;

    public ChocolateCookie(String name, double weight, double sugarContent){
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
                "Тип: печиво" + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%";
    }
}
