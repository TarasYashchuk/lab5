package Sweets;

import Sweets.Candies.Caramel.CaramelCandy;
import Sweets.Candies.Caramel.Gum;
import Sweets.Candies.ChocolateCandy.DarkChocolate;
import Sweets.Candies.ChocolateCandy.MilkChocolate;
import Sweets.Candies.Marmalade.FruitMarmalade;
import Sweets.Candies.Marmalade.JellyMarmalade;
import Sweets.Candies.Popsicles.FruitPopsicles;
import Sweets.Candies.Popsicles.MilkPopsicles;
import Sweets.Other.ChocolateBars.CaramelChocolateBar;
import Sweets.Other.ChocolateBars.NutChocolateBar;
import Sweets.Other.Cookies.ButterCookie;
import Sweets.Other.Cookies.ChocolateCookie;
import Sweets.Other.Gingerbread.HoneyGingerbread;
import Sweets.Other.Gingerbread.OrangeGingerbread;

import java.util.ArrayList;
import java.util.List;

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
}
