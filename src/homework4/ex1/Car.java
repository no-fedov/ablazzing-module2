package homework4.ex1;

public class Car {
    private String number;

    public Car(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }
}
