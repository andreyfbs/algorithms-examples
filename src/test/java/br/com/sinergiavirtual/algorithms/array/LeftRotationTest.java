package br.com.sinergiavirtual.algorithms.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LeftRotationTest {

    private LeftRotation leftRotation = new LeftRotation();

    @Test
    public void rotLeftSimpleRotation() {
        // Arrange
        final int[] arrayParamater = {1, 2, 3, 4, 5};
        final int numberOfRotation = 4;
        final int[] arrayExpected = {5, 1, 2, 3, 4};


        // Act
        final int[] arrayReturned = leftRotation.rotLeft(arrayParamater, numberOfRotation);

        // Assert
        Assert.assertArrayEquals(arrayExpected, arrayReturned);

        Assert.assertTrue(Arrays.equals(arrayExpected, arrayReturned));
    }


}