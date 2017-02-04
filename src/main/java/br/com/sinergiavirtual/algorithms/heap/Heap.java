package br.com.sinergiavirtual.algorithms.heap;

import java.util.Arrays;

/**
 * See definition of Heap : http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/heapSort.htm
 */
public class Heap {

    private Integer[] heapData = new Integer[5];
    private Integer size = 0;

    public boolean add(Integer node) {
        // check if parameter is null
        if (node == null) {
            return false;
        }

        // check is full
        if (isFull()) {
            increaseCapacity();
        }

        // Set the new element to last of the Heap
        heapData[size] = node;

        // Increment the size
        size++;

        if (size > 1) {
            // Heapify
            Integer parentNode = (size / 2) -1;
            Integer childNode = size -1;
            while (parentNode != -1 && heapData[parentNode].compareTo(heapData[childNode]) < 0) {
                Integer nodeTemp = heapData[parentNode];
                heapData[parentNode] = heapData[childNode];
                heapData[childNode] = nodeTemp;
                childNode = parentNode;
                parentNode = ((childNode + 1) / 2) - 1;
            }
        }

        return true;
    }

    public boolean contains(Integer node) {

        for (Integer data : heapData) {
            if (node.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public Integer containsWithPosition(Integer node) {
        for (int position = 0; position < heapData.length; position++) {
            if (node.equals(heapData[position])) {
                return position;
            }
        }
        return -1;
    }

    private boolean isFull() {
        if (size == heapData.length) {
            return true;
        } else {
            return false;
        }
    }

    private void increaseCapacity() {
        heapData = Arrays.copyOf(heapData, size + 1);
    }

    @Override
    public String toString() {
        return "Heap{" +
                "heapData=" + Arrays.toString(heapData) +
                ", size=" + size +
                '}';
    }
}