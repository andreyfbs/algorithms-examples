package br.com.sinergiavirtual.algorithms.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountWords {

    public String countTheWords(String doc) {

        String[] words = doc.split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                Integer count = map.get(word);
                map.put(word, ++count);
            } else {
                map.put(word, 1);
            }
        }

        Map<String, Integer> sortedMap = getSortedMap(map);

        return prepareToPrintMap(sortedMap, map);
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

