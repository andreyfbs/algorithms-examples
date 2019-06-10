package com.andreyfbs.algorithms.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Given a text with max length of Integer.MAX_VALUE find the N most frequent words used in the
 * text.
 * <p>
 * Consider word separators between: space, end of line and comma.
 * <p>
 * Input Format
 * <p>
 * Input consists of a string input.
 * <p>
 * Constraints
 * 0 < |s| <= 10^3
 * <p>
 * Each character of s, s[i] E {a-z, A-Z, space}
 * <p>
 * Output Format
 * <p>
 * Output Example: 3=Test,2=Car,1=Dog
 */
public class CountWords {

    /**
     * Given a String count how many occurrences by word
     */
    public String countWords(String input) {

        // Basic validation
        if (input == null || input.trim().isEmpty() || input.length() > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }

        // Prepare the structure to count the words
        final String[] words = input.split("[\\s,\\n]");
        final Map<String, Integer> mapWords = new HashMap<>();
        for (String word : words) {
            if (!isSpace(word)) {
                validateWord(word);
                mapWords.compute(word, (key, value) -> value == null ? 1 : ++value);
            }
        }

        // Sort the occurrences values
        final Map<String, Integer> mapWordsSorted =
                mapWords.entrySet()
                        .stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                        //.forEachOrdered(value -> mapWordsSorted.put(value.getKey(), value.getValue()));
                        .collect(Collectors.toMap(o -> o.getKey(), o -> o.getValue(), (o, o2) -> o2, LinkedHashMap::new));

        // Prepare the output
        final StringBuilder output = new StringBuilder();
        int count = 0;
        for (Map.Entry<String, Integer> word : mapWordsSorted.entrySet()) {
            count++;
            output.append(word.getValue()).append("=").append(word.getKey());
            if (count < mapWordsSorted.size()) {
                output.append(",");
            }
        }
        return output.toString();
    }

    private boolean isSpace(String word) {
        return word.trim().isEmpty();
    }

    private void validateWord(String word) {
        final String pattern = "[a-zA-Z\\s,]+";
        if (!Pattern.matches(pattern, word)) {
            throw new IllegalArgumentException();
        }

    }
}
