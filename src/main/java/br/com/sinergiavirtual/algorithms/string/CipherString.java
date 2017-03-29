package br.com.sinergiavirtual.algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a simple cipher that will take a string and replace each letter in the range a-z with the corresponding character 13 steps along the alphabet.
 */
public class CipherString {

    private static final int stepsAlong = 13;

    private char[] arrayAlphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String cipherString(String input) {

        if (input == null) {
            return null;
        }

        // Store in Map the alphabet as the key and the index of the letters as the value
        Map<Character, Integer> mapAlphabet = new HashMap<>();
        for (int i = 0; i < arrayAlphabet.length; i++) {
            mapAlphabet.put(arrayAlphabet[i], i + 1);
        }

        StringBuilder cipheredOutput = new StringBuilder();

        // For each letter of the input, find out the corresponding ciphered letter
        for (int i = 0; i < input.length(); i++) {
            char letterFromCipher = input.charAt(i);

            final char letterToCipher;
            if (mapAlphabet.get(letterFromCipher) != null) {
                final int indexLetterFromCipher = mapAlphabet.get(letterFromCipher);
                // Check the index to replace the letter
                final int indexLetterToCipher = calculeIndexToReplace(indexLetterFromCipher);

                // With the new index, you can retrieve the letter key through of the index value
                letterToCipher = getKeyByValue(mapAlphabet, indexLetterToCipher);
            } else {
                // If it can't find in the alphabet, keep the same character
                letterToCipher = letterFromCipher;
            }
            // append the ciphered letter in the String Build
            cipheredOutput.append(letterToCipher);
        }
        return cipheredOutput.toString();
    }

    private int calculeIndexToReplace(int indexFrom) {
        int indexLetterToCipher = indexFrom + stepsAlong;

        if (indexLetterToCipher > arrayAlphabet.length) {
            indexLetterToCipher = stepsAlong - (arrayAlphabet.length - indexFrom);
        }
        return indexLetterToCipher;
    }

    private Character getKeyByValue(Map<Character, Integer> map, Integer value) {

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}