package homework2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LuggageBelt {
    private static final int BAGGAGE_ID_INDEX = 0;
    private static final int BAGGAGE_WEIGHT_INDEX = 1;
    private static final int BELT_SIZE = 10;
    private static final String REGEX_SPLIT = ";";

    private final Queue<Baggage> belt = new LinkedList<>();

    public void handOverBaggage(String fileName) throws URISyntaxException, IOException {
        final File storage = new File(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource(fileName)
        ).toURI());

        try (BufferedReader storageReader = new BufferedReader(new FileReader(storage))) {
            storageReader.readLine();

            while (belt.size() != BELT_SIZE && storageReader.ready()) {
                if (belt.isEmpty()) {
                    System.out.println("Начинатеся загрузка на ленту");
                }
                String[] columns = storageReader.readLine().split(REGEX_SPLIT);
                Baggage baggage = new Baggage(columns[BAGGAGE_ID_INDEX],
                        Double.parseDouble(columns[BAGGAGE_WEIGHT_INDEX]));
                belt.add(baggage);
                if (belt.size() == BELT_SIZE) {
                    System.out.println("Лента загружена, начинается выдача багажа");
                    offloadBelt();
                }
            }

            if (!belt.isEmpty()) {
                offloadBelt();
            }
        }
    }

    private void offloadBelt() {
        while (!belt.isEmpty()) {
            Baggage offloadBaggage = belt.poll();
            System.out.printf("%s - выдан\n", offloadBaggage);
        }
        System.out.println("Лента пустая, закончена выдача багажа");
    }
}
