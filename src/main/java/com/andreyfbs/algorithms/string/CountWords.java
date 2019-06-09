package com.andreyfbs.algorithms.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a text with max length of Integer.MAX_VALUE find the N most frequent words used in the
 * text.
 *
 * Consider word separators between: space, end of line and comma.
 *
 * Input Format
 *
 * Input consists of a string input.
 *
 * Constraints
 * 0 < |s| <= 10^3
 *
 * Each character of s, s[i] E {a-z, A-Z, space}
 *
 * Output Format
 *
 * Output Example: 3=Test,2=Car,1=Dog
 */
public class CountWords {

    /**
     * Giver a String count how many occurrences by word
     */
    public String countWords(String input) {

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        final String[] words = input.split("\\s");
        final StringBuilder output = new StringBuilder();

        final Map<String, Integer> mapWords = new HashMap<>();
        for (String word : words) {
            mapWords.compute(word, (key, value) -> value == null ? 1 : ++value);
        }

        final Map<String, Integer> mapWordsSorted =
                mapWords.entrySet()
                .stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                //.forEachOrdered(value -> mapWordsSorted.put(value.getKey(), value.getValue()));
                .collect(Collectors.toMap(o -> o.getKey(), o -> o.getValue(), (o, o2) -> o2, LinkedHashMap::new));

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
}
