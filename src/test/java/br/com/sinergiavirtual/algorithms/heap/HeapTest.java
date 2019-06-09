package br.com.sinergiavirtual.algorithms.heap;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapTest {

    private Heap heap;

    @Before
    public void Setup() {
        heap = new Heap();
    }

    @Test
    public void insertNode() {

        // Arrange
        Integer node = 1;

        // Act
        boolean result = heap.add(node);

        // Assert
        Assert.assertThat(result, Matchers.equalTo(Boolean.TRUE));
    }

    @Test
    public void insertNullNode() {

        // Arrange
        Integer nodeNull = null;

        // Act
        boolean result = heap.add(nodeNull);

        // Assert
        Assert.assertThat(result, Matchers.equalTo(Boolean.FALSE));
    }

    @Test
    public void insert2ElementsAndGet1ElementsNode() {

        // Arrange
        Integer node1 = 1;
        Integer node2 = 2;

        // Act
        heap.add(node1);
        heap.add(node2);

        boolean result1 = heap.contains(node1);
        heap.contains(node2);

        // Assert
        Assert.assertThat(result1, Matchers.equalTo(Boolean.TRUE));
    }

    @Test
    public void insert2ElementsAndGet2ElementsNode() {

        // Arrange
        Integer node1 = 1;
        Integer node2 = 2;

        // Act
        heap.add(node1);
        heap.add(node2);

        heap.contains(node1);
        boolean result2 = heap.contains(node2);

        // Assert
        Assert.assertThat(result2, Matchers.equalTo(Boolean.TRUE));
    }



    @Test
    public void getExistentElement() {

        // Arrange
        Integer node = 1;

        // Act
        heap.add(node);
        boolean result = heap.contains(node);

        // Assert
        Assert.assertThat(result, Matchers.equalTo(Boolean.TRUE));

    }

    @Test
    public void getNotExistentElement() {

        // Arrange
        Integer nodeToInsert = 1;
        Integer nodeToSearch = 2;

        // Act
        heap.add(nodeToInsert);
        boolean result = heap.contains(nodeToSearch);

        // Assert
        Assert.assertThat(result, Matchers.equalTo(Boolean.FALSE));

    }

    @Test
    public void getNotExistentElementEmptyList() {

        // Arrange
        Integer nodeToSearch = 1;

        // Act
        boolean result = heap.contains(nodeToSearch);

        // Assert
        Assert.assertThat(result, Matchers.equalTo(Boolean.FALSE));

    }

    @Test
    public void checkPositionOfTheParent() {

        // Arrange
        int quantityOfElements = 9;
        int parent = 5;
        int child = 2;

        for (int i = 1; i < quantityOfElements -1; i++) {
            heap.add(i);
        }

        // Act
        //Integer positionChild = heap.containsWithPosition(child);
        Integer positionParent = heap.containsWithPosition(child);

        // Assert
        System.out.println(heap.toString());
        Assert.assertThat(positionParent, Matchers.equalTo(parent));
    }
}