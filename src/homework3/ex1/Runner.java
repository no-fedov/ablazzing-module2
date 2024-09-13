package homework3.ex1;

import homework3.ex1.fruit.Apple;
import homework3.ex1.fruit.Apricot;

public class Runner {
    public static void main(String[] args) {
        Garden<Apple> appleGarden = () -> new Apple();
        Garden<Apricot> appleApricot = () -> new Apricot();

        Apple apple = appleGarden.growFruit();
        Apricot apricot = appleApricot.growFruit();
    }
}
