package homework1.ex1;

import homework1.ex1.animal.Bird;
import homework1.ex1.animal.Dog;
import homework1.ex1.animal.Tiger;

public class Runner {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Dog dog = new Dog();
        Bird bird = new Bird();

        Zoo<Tiger, Dog, Bird> zoo = new Zoo<>(tiger, dog, bird);

        zoo.getFirstAnimal().growl();
        zoo.getSecondAnimal().bark();
        zoo.getThirdAnimal().fly();
    }
}
