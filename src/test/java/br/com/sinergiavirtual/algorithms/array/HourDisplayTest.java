package br.com.sinergiavirtual.algorithms.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HourDisplayTest {

    @Test
    public void calculateChange4th() throws Exception {

        // Arrange
        final int a = 1;
        final int b = 8;
        final int c = 3;
        final int d = 2;
        final int e = 6;
        final int f = 4;
        final int[] arrayExpected = new int[] { 1, 2, 3, 6, 4, 8 };

        // Act
        HourDisplay hourDisplay = new HourDisplay();
        final String arrayResultString = hourDisplay.calculateShortestTimeDisplay(a, b, c, d, e, f);

        // Assert
        Assert.assertEquals(Arrays.toString(arrayExpected), arrayResultString);

    }

    @Test
    public void calculateChange4thWithZeros() throws Exception {

        // Arrange
        final int a = 0;
        final int b = 7;
        final int c = 0;
        final int d = 9;
        final int e = 0;
        final int f = 4;
        final int[] arrayExpected = new int[] { 0, 0, 0, 7, 4, 9 };

        // Act
        HourDisplay hourDisplay = new HourDisplay();
        final String arrayResultString = hourDisplay.calculateShortestTimeDisplay(a, b, c, d, e, f);

        // Assert
        Assert.assertEquals(Arrays.toString(arrayExpected), arrayResultString);
    }

    @Test
    public void calculateInitWith2() throws Exception {

        // Arrange
        final int a = 9;
        final int b = 7;
        final int c = 2;
        final int d = 5;
        final int e = 2;
        final int f = 4;
        final int[] arrayExpected = new int[] { 2, 2, 4, 7, 5, 9 };

        // Act
        HourDisplay hourDisplay = new HourDisplay();
        final String arrayResultString = hourDisplay.calculateShortestTimeDisplay(a, b, c, d, e, f);

        // Assert
        Assert.assertEquals(Arrays.toString(arrayExpected), arrayResultString);

    }

}

