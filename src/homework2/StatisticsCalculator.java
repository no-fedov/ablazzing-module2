package homework2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static homework2.BaggageCategory.*;

public class StatisticsCalculator {
    private static final int BAGGAGE_WEIGHT_INDEX = 1;
    private static final String REGEX_SPLIT = ";";
    private static final BigDecimal LOW_WEIGHT_LIMIT = new BigDecimal(5);
    private static final BigDecimal MIDDLE_WEIGHT_LIMIT = new BigDecimal(10);

    private final Map<BaggageCategory, BigDecimal> statistic = new HashMap<>();

    public Map<BaggageCategory, BigDecimal> calculateStatistic(String fileName) throws URISyntaxException, IOException {
        final File storage = new File(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource(fileName)
        ).toURI());

        try (BufferedReader storageReader = new BufferedReader(new FileReader(storage))) {
            storageReader.readLine();

            while (storageReader.ready()) {
                String[] columns = storageReader.readLine().split(REGEX_SPLIT);
                BigDecimal baggageWeight = new BigDecimal(columns[BAGGAGE_WEIGHT_INDEX]);

                if (baggageWeight.compareTo(LOW_WEIGHT_LIMIT) < 0) {
                    statistic.put(LIGHT, statistic.getOrDefault(LIGHT, BigDecimal.ZERO).add(baggageWeight));
                } else if (baggageWeight.compareTo(MIDDLE_WEIGHT_LIMIT) < 0) {
                    statistic.put(MIDDLE, statistic.getOrDefault(MIDDLE, BigDecimal.ZERO).add(baggageWeight));
                } else {
                    statistic.put(HEAVY, statistic.getOrDefault(HEAVY, BigDecimal.ZERO).add(baggageWeight));
                }
            }
        }
        return new HashMap<>(statistic);
    }
}
