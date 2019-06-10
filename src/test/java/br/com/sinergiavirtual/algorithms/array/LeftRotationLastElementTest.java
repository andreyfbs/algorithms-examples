package br.com.sinergiavirtual.algorithms.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 1 2 3 4 5
 * 1 2 3 5 4
 * 1 2 5 3 4
 * 1 5 2 3 4
 * d = 6
 */
public class LeftRotationLastElementTest {

    private LeftRotationLastElement leftRotationLastElement = new LeftRotationLastElement();

    @Test
    public void rotLeftSimpleRotation() {
        // Arrange
        final int[] arrayParamater = {1, 2, 3, 4, 5};
        final int numberOfRotation = 4;
        final int[] arrayExpected = {5, 1, 2, 3, 4};


        // Act
        final int[] arrayReturned = leftRotationLastElement.rotLeft(arrayParamater, numberOfRotation);

        // Assert
        Assert.assertArrayEquals(arrayExpected, arrayReturned);

        Assert.assertTrue(Arrays.equals(arrayExpected, arrayReturned));
    }

    @Test
    public void rotLeftNoneRotation() {
        // Arrange
        final int[] arrayParamater = {1, 2, 3, 4, 5};
        final int numberOfRotation = 5;
        final int[] arrayExpected = {1, 2, 3, 4, 5};


        // Act
        final int[] arrayReturned = leftRotationLastElement.rotLeft(arrayParamater, numberOfRotation);

        // Assert
        Assert.assertArrayEquals(arrayExpected, arrayReturned);

        Assert.assertTrue(Arrays.equals(arrayExpected, arrayReturned));
    }


    @Test
    public void rotLeftGreaterThanSize() {
        // Arrange
        final int[] arrayParamater = {1, 2, 3, 4, 5};
        final int numberOfRotation = 8;
        final int[] arrayExpected = {1, 5, 2, 3, 4};


        // Act
        final int[] arrayReturned = leftRotationLastElement.rotLeft(arrayParamater, numberOfRotation);

        // Assert
        Assert.assertArrayEquals(arrayExpected, arrayReturned);

        Assert.assertTrue(Arrays.equals(arrayExpected, arrayReturned));
    }

    @Test
    public void rotLeftGreaterThanSizeNoShift() {
        // Arrange
        final int[] arrayParamater = {1, 2, 3, 4, 5};
        final int numberOfRotation = 10;
        final int[] arrayExpected = {1, 2, 3, 4, 5};


        // Act
        final int[] arrayReturned = leftRotationLastElement.rotLeft(arrayParamater, numberOfRotation);

        // Assert
        Assert.assertArrayEquals(arrayExpected, arrayReturned);

        Assert.assertTrue(Arrays.equals(arrayExpected, arrayReturned));
    }


}