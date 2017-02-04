package br.com.sinergiavirtual.algorithms.heap;

import java.util.Arrays;

public class Heap {

    private Integer[] heapData = new Integer[0];
    private Integer size = 0;

    public boolean add(Integer node) {
        if (size == heapData.length) {
            heapData = Arrays.copyOf(heapData, size + 1);
        }
        if (node == null) {
            return false;
        }
        heapData[size] = node;
        size++;
        return true;
    }

    public boolean contains(Integer node) {

        for (Integer data : heapData) {
            if (data.equals(node)) {
                return true;
            }
        }
        return false;
    }
}
