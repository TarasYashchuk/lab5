package Sweets.Other.Gingerbread;

import Sweets.Sweets;

public class OrangeGingerbread extends Sweets {
    private double sugarContent;

    public OrangeGingerbread(String name, double weight, double sugarContent){
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
                "Тип: пряник " + "\n" +
                "Вага: " + getWeight() + "\n" +
                "Вміст цукру: " + getSugarContent() * 100 + "%" + "\n" +
                "------------------------------------------------------------------";
    }
}
