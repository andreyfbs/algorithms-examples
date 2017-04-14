package br.com.sinergiavirtual.algorithms.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Smallest Substring of All Characters
 * Given an array with unique characters arr and a string str,
 * find the smallest substring of str containing all characters of arr.
 *
 * Example:
 * arr: [x,y,z], str: xyyzyzyx
 * result: zyx
 */
public class ShortestString {

    private static Map<Character, Integer> frequency;
    private static Set<Character> charsCovered;
    private static Map<Character, Integer> encountered;
    /**
     * To set the first match index as an intial start point
     */
    private static boolean hasStarted = false;
    private static int currentStartIndex = 0;
    private static int finalStartIndex = 0;
    private static int finalEndIndex = 0;
    private static int minLen = Integer.MAX_VALUE;
    private static int currentLen = 0;
    /**
     * Whether we have already found the match and now looking for other
     * alternatives.
     */
    private static boolean isFound = false;
    private static char currentChar;

    public String shortestSubstrContainingAllChars(String big, String small) {

        if (null == big || null == small || big.isEmpty() || small.isEmpty()) {
            return null;
        }

        frequency = new HashMap<Character, Integer>();
        instantiateFrequencyMap(small);
        charsCovered = new HashSet<>();
        int charsToBeCovered = frequency.size();
        encountered = new HashMap<Character, Integer>();

        for (int i = 0; i < big.length(); i++) {
            currentChar = big.charAt(i);
            if (frequency.containsKey(currentChar) && !isFound) {
                if (!hasStarted && !isFound) {
                    hasStarted = true;
                    currentStartIndex = i;
                }
                updateEncounteredMapAndCharsCoveredSet(currentChar);
                if (charsCovered.size() == charsToBeCovered) {
                    currentLen = i - currentStartIndex;
                    isFound = true;
                    updateMinLength(i);
                }
            } else if (frequency.containsKey(currentChar) && isFound) {
                updateEncounteredMapAndCharsCoveredSet(currentChar);

                    while (currentStartIndex < i) {
                        if (currentChar == big.charAt(currentStartIndex)) {

                        }
                    }

                currentLen = i - currentStartIndex;
                updateMinLength(i);
            }
        }
        System.out.println("start: " + finalStartIndex + " finalEnd : " + finalEndIndex);
        return big.substring(finalStartIndex, finalEndIndex + 1);
    }

    private void updateMinLength(int index) {
        if (minLen > currentLen) {
            minLen = currentLen;
            finalStartIndex = currentStartIndex;
            finalEndIndex = index;
        }

    }

    private void updateEncounteredMapAndCharsCoveredSet(Character currentChar) {
        if (encountered.containsKey(currentChar)) {
            encountered.put(currentChar, encountered.get(currentChar) + 1);
        } else {
            encountered.put(currentChar, 1);
        }

        if (encountered.get(currentChar) >= frequency.get(currentChar)) {
            charsCovered.add(currentChar);
        }
    }

    private void instantiateFrequencyMap(String str) {

        for (char c : str.toCharArray()) {
            if (frequency.containsKey(c)) {
                frequency.put(c, frequency.get(c) + 1);
            } else {
                frequency.put(c, 1);
            }
        }

    }
}
