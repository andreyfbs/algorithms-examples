package br.com.sinergiavirtual.algorithms.string;

import org.junit.Assert;
import org.junit.Test;

public class PangramsTest {

    private Pangrams palindromeIndex = new Pangrams();

    @Test
    public void pangramsIsOne() {

        // Arrange
        final String word = "We promptly judged antique ivory buckles for the next prize";
        final String resultExpected = "pangram";

        // Act
        final String resultReturned = palindromeIndex.pangrams(word);

        // Assert
        Assert.assertEquals(resultExpected, resultReturned);
    }

    @Test
    public void pangramsIsNotOne() {

        // Arrange
        final String word = "We promptly judged antique ivory buckles for the prize";
        final String resultExpected = "not pangram";

        // Act
        final String resultReturned = palindromeIndex.pangrams(word);

        // Assert
        Assert.assertEquals(resultExpected, resultReturned);
    }

}