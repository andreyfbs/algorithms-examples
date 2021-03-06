package br.com.sinergiavirtual.algorithms.dictionary;

import java.util.*;

/**
 *
 * Given a dictionary, write a function to flatten it.
 * Consider the following input/output scenario for better understanding:
 *
 Input:

 {
 'Key1': '1',
 'Key2': {
 'a' : '2',
 'b' : '3',
 'c' : {
 'd' : '3',
 'e' : '1'
 }
 }
 }

 Output:

 {
 'Key1': '1',
 'Key2.a': '2',
 'Key2.b' : '3',
 'Key2.c.d' : '3',
 'Key2.c.e' : '1'
 }

 */
public class FlattenDictionary {

    public static void main(String[] args) {

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
