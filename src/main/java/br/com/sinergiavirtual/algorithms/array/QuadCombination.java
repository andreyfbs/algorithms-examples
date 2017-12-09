package br.com.sinergiavirtual.algorithms.array;


import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Quad Combination
 *
 * Given an array of numbers arr and a number S, find 4 different numbers in arr that sum up to S.
 *
 * Write a function that gets arr and S and returns an array with 4 indices of such numbers in arr,
 * or null if no such combination exists. Explain and code the most efficient calculateShortestTimeDisplay possible, and
 * analyze its runtime and space complexity.
 *
 * Hints & Tips The array is not sorted, and may hold any real number (positive, negative, zero,
 * integer or fraction)
 *
 * Any calculateShortestTimeDisplay of more than O(n2) is not efficient enough. Please rate your peer feedback
 * accordingly.
 *
 * If you peer can't even think of the naive calculateShortestTimeDisplay, ask how can you check all numbers in arr to
 * come up with a calculateShortestTimeDisplay.
 *
 * If your peer can't improve the naive calculateShortestTimeDisplay, ask how can you use a pre-computation to save some
 * work and improve efficiency. If that doesn't help, ask how would a list of all pairs by their sum
 * help to solve, and then ask how can such a list be calculated and stored.
 *
 * Make sure that your peer's calculateShortestTimeDisplay handles the case in which pairSum == S-pairSum correctly.
 */
public class QuadCombination {

    public int[] calculeCombination(int[] array, int valueSum) {

        // Iterate through array to find the sums of the all possible Pairs
        Map<Integer, List<Pair<Integer, Integer>>> mapPairs = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int pairSum = array[i] + array[j];

                if (mapPairs.containsKey(pairSum)) {
                    // If the sum is already in the Map, add to the Pair to the List
                    List<Pair<Integer, Integer>> pairSumList = mapPairs.get(pairSum);
                    pairSumList.add(Pair.of(i, j));
                } else {
                    // Else, create the List of Pairs and put the sum in the Map
                    List<Pair<Integer, Integer>> pairSumList = new ArrayList<>();
                    pairSumList.add(Pair.of(i, j));
                    mapPairs.put(array[i] + array[j], pairSumList);
                }
            }
        }


        Set<Integer> sumPairsSet = mapPairs.keySet();
        for (Integer sumPairs : sumPairsSet) {
            int subtractionSumSecondPair = valueSum - sumPairs;

            // Check If pairSum = valueSum-pairSum
            if (sumPairsSet.contains(subtractionSumSecondPair)) {
                // Iterate the both List of the 2 sums
                for (Pair<Integer, Integer> pairSum : mapPairs.get(sumPairs)) {
                    for (Pair<Integer, Integer> pair2Sum : mapPairs.get(subtractionSumSecondPair)) {

                        // Create the array with the 4 indexes of the 2 pairs
                        int[] arrayIndexes = new int[]{pairSum.getLeft(), pairSum.getRight(), pair2Sum.getLeft(), pair2Sum.getRight()};

                        // Check if there are some duplicate index
                        if (checkIndexAreUnique(arrayIndexes)) {
                            return arrayIndexes;
                        }
                    }
                }
            }
        }
        return null;
    }

    private boolean checkIndexAreUnique(int[] arrayIndexes) {
        Set<Integer> uniqueElementsSet = new HashSet<>();
        for (int index : arrayIndexes) {
            uniqueElementsSet.add(index);
        }
        if (uniqueElementsSet.size() == arrayIndexes.length) {
            return true;
        } else {
            return false;
        }
    }
}