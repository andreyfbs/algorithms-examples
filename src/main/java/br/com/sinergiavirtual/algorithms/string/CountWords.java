package br.com.sinergiavirtual.algorithms.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Implement a document scanning engine that receives a text document doc
 * and returns a list of all unique words in it and their number of occurrences,
 * sorted by the number of occurrences in descending order.
 *
 Example:
 for doc: "practice makes perfect. get perfect by practice. just practice!"
 the engine returns the list: { practice: 3, perfect: 2,  makes: 1, get: 1, by: 1, just: 1 }.

 The engine should ignore punctuation and white-spaces.
 Find the minimal runtime complexity and analyze it.

 */
public class CountWords {


    private static void firstSolution(String[] args) {

        String word = "practice makes perfect. get perfect by practice. just practice!";
        String[] words = word.trim().split("\\W");

        List<String> listWords = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        TreeMap<Integer, Set<String>> mapWords = new TreeMap<>();
        for(int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letter != ' ' && letter != '!' && letter != '.') {
                builder.append(letter);
            } else {
                if (builder.toString().trim().length() > 0) {
                    listWords.add(builder.toString());
                    /*
                    if (mapWords.containsValue(builder.toString())) {
                        mapWords.get
                    }*/
                }

                builder = new StringBuilder();
            }

            if (i == word.length() - 1) {
                if (builder.toString().trim().length() > 0) {
                    listWords.add(builder.toString());
                }
                builder = new StringBuilder();
            }
        }
    }

    public String countTheWords(String doc) {

        String[] words = getWords(doc);

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if(!checkWordIsEmpty(word)) {
                if (map.containsKey(word)) {
                    Integer count = map.get(word);
                    map.put(word, ++count);
                } else {
                    map.put(word, 1);
                }
            }
        }

        Map<String, Integer> sortedMap = getSortedMap(map);

        return prepareToPrintMap(sortedMap, map);
    }

    private String[] getWords(String doc) {
        //String[] words = doc.split(" ");
        String[] words = doc.trim().split("\\W");
        return words;
    }

    private boolean checkWordIsEmpty(String word) {
        if (word.trim().length() == 0) {
            return true;
        }
        return false;
    }

    private Map<String, Integer> getSortedMap(Map<String, Integer> mapToOrder) {
        ValueComparator bvc = new ValueComparator(mapToOrder);
        Map<String, Integer> sorted_map = new TreeMap<>(bvc);
        sorted_map.putAll(mapToOrder);
        return sorted_map;
    }

    private Map<String, Integer> getSortedMapJava8(Map<String, Integer> mapToOrder) {
        Map<String, Integer> sorted_map = new LinkedHashMap<>();
        mapToOrder.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEachOrdered(value -> sorted_map.put(value.getKey(), value.getValue()));
        return sorted_map;
    }

    private String prepareToPrintMap(Map<String, Integer> mapSorted, Map<String, Integer> map) {
        StringBuilder builderListWords = new StringBuilder("{ ");
        int endOfSet = 0;
        for (String key : mapSorted.keySet()) {
            builderListWords.append(key).append(": ").append(map.get(key));
            if (endOfSet != mapSorted.keySet().size() - 1) {
                builderListWords.append(", ");
            }
            endOfSet++;
        }
        builderListWords.append(" }");
        return builderListWords.toString();
    }

}

class ValueComparator implements Comparator<String> {
    private Map<String, Integer> base;

    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}

