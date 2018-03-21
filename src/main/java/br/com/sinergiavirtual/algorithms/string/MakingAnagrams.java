package br.com.sinergiavirtual.algorithms.string;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {

    public int calculateNumberElementsToDelete(String word1, String word2) {

        Map<Character, Integer> mapOcurrencies = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char keyCharacter = word1.charAt(i);

            mapOcurrencies.computeIfPresent(keyCharacter, (k, v) -> v + 1);

            mapOcurrencies.putIfAbsent(keyCharacter, 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            char keyCharacter = word2.charAt(i);
            if (mapOcurrencies.containsKey(keyCharacter)) {
                mapOcurrencies.put(keyCharacter, mapOcurrencies.get(keyCharacter) - 1);
            } else {
                mapOcurrencies.put(keyCharacter, -1);
            }

        }

        Integer numberCharactersToDelete = 0;
        for (Integer numberOcorrencies : mapOcurrencies.values()) {
            numberCharactersToDelete += Math.abs(numberOcorrencies);
        }

        return numberCharactersToDelete;
    }
}