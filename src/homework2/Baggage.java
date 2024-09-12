package homework2;

public class Baggage {
    private final String id;
    private final double weight;

    public Baggage(String id, double weight) {
        if (id == null || id.isBlank() || weight <= 0) {
            throw new RuntimeException("Ошибка инициальизации багажа");
        }
        this.id = id;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return '\'' + id + '\'';
    }
}
