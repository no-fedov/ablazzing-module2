package homework1.ex1;

import homework1.ex1.animal.Animal;

public class Zoo<T extends Animal, Y extends Animal, U extends Animal> {
    private T firstAnimal;
    private Y secondAnimal;
    private U thirdAnimal;

    public Zoo(T firstAnimal, Y secondAnimal, U thirdAnimal) {
        this.firstAnimal = firstAnimal;
        this.secondAnimal = secondAnimal;
        this.thirdAnimal = thirdAnimal;
    }

    public T getFirstAnimal() {
        return firstAnimal;
    }

    public Y getSecondAnimal() {
        return secondAnimal;
    }

    public U getThirdAnimal() {
        return thirdAnimal;
    }
}
