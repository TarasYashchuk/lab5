package sweets;

import sweets.candies.caramel.*;
import sweets.candies.chocolatecandy.*;
import sweets.candies.marmalade.*;
import sweets.candies.popsicles.*;
import sweets.other.chocolatebars.*;
import sweets.other.cookies.*;
import sweets.other.gingerbread.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Sweets {

    private String name;

    private double weight;

    private double sugarContent;

    public Sweets(String name, double weight, double sugarContent){
        this.weight = weight;
        this.name = name;
        this.sugarContent = sugarContent;
    }
    public String getName(){
        return name;
    }

    public double getSugarContent(){
        return sugarContent;
    }

    public double getWeight() {
        return weight;
    }
    public static List<Sweets> getSweetsList() {

        List<Sweets> sweets = new ArrayList<>();

        sweets.add(new CaramelCandy("Карамельна мелодія", 25.0, 0.2));
        sweets.add(new Gum("Золотий шарм", 15.0, 0.4));

        sweets.add(new DarkChocolate("Шоколадний розкіш", 40.0, 0.25));
        sweets.add(new MilkChocolate("Кокосова мрія", 35.0, 0.5));

        sweets.add(new FruitMarmalade("Фруктовий експрес", 10.0, 0.3));
        sweets.add(new JellyMarmalade("Сонячні мармелади", 10.0, 0.4));

        sweets.add(new FruitPopsicles("Апельсиновий відпочинок", 15.0, 0.6));
        sweets.add(new MilkPopsicles("Молочний куш", 10.0, 0.6));

        sweets.add(new CaramelChocolateBar("Шоколадний спокусник", 70.0, 0.5));
        sweets.add(new NutChocolateBar("Горішкова феєрія", 65.0, 0.4));

        sweets.add(new ButterCookie("Вишукана ніжність", 30.0, 0.6));
        sweets.add(new ChocolateCookie("Шоколадний трепет", 45.0, 0.7));

        sweets.add(new HoneyGingerbread("Медова кульбаба", 55.0, 0.3));
        sweets.add(new OrangeGingerbread("Мандаринова історія", 50.0, 0.4));

        return sweets;
    }
    public static List<Sweets> getGiftList() {
        List<Sweets> gift = new ArrayList<>();
        return gift;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweets sweets = (Sweets) o;
        return Double.compare(sweets.weight, weight) == 0 &&
                Double.compare(sweets.sugarContent, sugarContent) == 0 &&
                Objects.equals(name, sweets.name);
    }
}
