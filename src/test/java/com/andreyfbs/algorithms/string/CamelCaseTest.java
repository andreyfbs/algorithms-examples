package com.andreyfbs.algorithms.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CamelCaseTest {

    private CamelCase camelCase;

    @Before
    public void setup() {
        camelCase = new CamelCase();
    }

    @Test
    public void oneWord() {
        // Arrange
        String input = "car";
        int expectedOutput = 1;

        // Act
        int output = camelCase.totalWordsByCamelCase(input);

        // Assert
        Assert.assertEquals(expectedOutput, output);
    }

    @Test
    public void nullInput() {
        // Arrange
        String input = null;
        int expectedOutput = 0;

        // Act
        int output = camelCase.totalWordsByCamelCase(input);

        // Assert
        Assert.assertEquals(expectedOutput, output);
    }

    @Test
    public void twoWords() {
        // Arrange
        String input = "carTest";
        int expectedOutput = 2;

        // Act
        int output = camelCase.totalWordsByCamelCase(input);

        // Assert
        Assert.assertEquals(expectedOutput, output);
    }

    @Test
    public void threeWords() {
        // Arrange
        String input = "carTesCcar";
        int expectedOutput = 3;

        // Act
        int output = camelCase.totalWordsByCamelCase(input);

        // Assert
        Assert.assertEquals(expectedOutput, output);
    }

}