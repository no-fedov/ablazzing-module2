package homework4.ex2;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

public class Runner {
    private static final char LETTER_REFERENCE = 'о';

    public static void main(String[] args) {
        Set<String> words = Set.of("тон", "тополь", "боль", "рой", "стройка");

        Optional<Long> result = words.stream()
                .map(word -> letterCounter(word, LETTER_REFERENCE))
                .reduce(Long::sum);

        System.out.println(result.orElseGet(() -> 0L));
    }

    private static long letterCounter(String word, char letterReference) {
        return Arrays.stream(word.split(""))
                .filter(letter -> letter.charAt(0) == letterReference)
                .count();
    }
}
