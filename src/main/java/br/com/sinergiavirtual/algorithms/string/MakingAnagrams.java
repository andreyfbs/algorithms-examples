package br.com.sinergiavirtual.algorithms.string;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {

    public int calculateNumberElementsToDelete(String word1, String word2) {

        Map<Character, Integer> mapOcurrencies1 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char keyCharacter = word1.charAt(i);
            if (mapOcurrencies1.containsKey(keyCharacter)) {
                mapOcurrencies1.put(keyCharacter, mapOcurrencies1.get(keyCharacter) + 1);
            } else {
                mapOcurrencies1.put(keyCharacter, 1);
            }
        }

        Map<Character, Integer> mapOcurrencies2 = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            char keyCharacter = word2.charAt(i);
            if (mapOcurrencies1.containsKey(keyCharacter)) {
                Integer newValue = mapOcurrencies1.get(keyCharacter) - 1;
                if (newValue.equals(0)) {
                    mapOcurrencies1.remove(keyCharacter);
                } else {
                    mapOcurrencies1.put(keyCharacter, newValue);
                }
            } else if  (mapOcurrencies2.containsKey(keyCharacter)) {
                mapOcurrencies2.put(keyCharacter, mapOcurrencies2.get(keyCharacter) + 1);
            } else {
                mapOcurrencies2.put(keyCharacter, 1);
            }

        }

        Integer numberCharactersToDelete = 0;
        for (Integer numberOcorrencies : mapOcurrencies1.values()) {
            numberCharactersToDelete += numberOcorrencies;
        }

        for (Integer numberOcorrencies : mapOcurrencies2.values()) {
            numberCharactersToDelete += numberOcorrencies;
        }

        return numberCharactersToDelete;
    }
}