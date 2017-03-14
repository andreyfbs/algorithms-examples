package br.com.sinergiavirtual.algorithms.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountWords {

    public static void main(String[] args) {
        String sentence = "Car Bus Car Test Java";

        String[] words = sentence.split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            if (map.containsKey(word)) {
                Integer count = map.get(word);
                map.put(word, ++count);
            } else {
                map.put(word, 1);
            }
        }

        Map<String, Integer> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEachOrdered(value -> result.put(value.getKey(), value.getValue()));;

        for (String key : result.keySet()) {
            System.out.println(key + " " + map.get(key));
        }


        ValueComparator bvc = new ValueComparator(map);
        Map<String, Integer> sorted_map = new TreeMap<>(bvc);
        sorted_map.putAll(map);

        for (String key : sorted_map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

    }
}

class ValueComparator implements Comparator<String> {
    Map<String, Integer> base;

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

