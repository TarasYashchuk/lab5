package Sweets;
public abstract class Sweets {

    private String name;

    private double weight;

    public Sweets(String name, double weight){
        this.weight = weight;
        this.name = name;
    }
    public abstract double getWeight();

    public abstract double getSugarContent();

}
