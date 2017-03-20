package br.com.sinergiavirtual.algorithms.dictionary;

import java.util.*;

public class FlattenDictionary {


    public static void main(String[] args) {

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
    public static void main2(String[] args) {

        Map<String, Object> dictionary = new HashMap<>();
        Map<String, Object> mapKeyC = new HashMap<>();
        mapKeyC.put("d", "3");
        mapKeyC.put("e", "1");

        Map<String, Object> mapKey2 = new HashMap<>();
        mapKey2.put("a", "2");
        mapKey2.put("b", "3");
        mapKey2.put("c", mapKeyC);

        dictionary.put("key2", mapKey2);
        dictionary.put("key1", "1");

        Map<String, Object> flatDictionary = new HashMap<>();
        flattenDictonary("", dictionary, flatDictionary);

        System.out.print(flatDictionary);


    }

    public static void flattenDictonary(String initialKey, Map<String, Object> dictionary, Map<String, Object> flatDictionary) {
        for (String key: dictionary.keySet()) {
            Object value = dictionary.get(key);
            if (checkIsCollection(value)) {
                Map<String, Object> mapDictionary = (Map<String, Object>) value;
                    if (initialKey == null || initialKey == "") {
                        flattenDictonary(key, mapDictionary, flatDictionary);
                    } else {
                        flattenDictonary(initialKey + '.' + key, mapDictionary, flatDictionary);
                    }
            } else {
                if (initialKey == null || initialKey == "") {
                    flatDictionary.put(key, value);
                } else {
                    flatDictionary.put(initialKey + '.' + key, value);

                }
            }

        }
    }

    public static boolean checkIsCollection(Object value) {
        if (value instanceof Map) {
            return true;
        } else {
            return false;
        }
    }

}
