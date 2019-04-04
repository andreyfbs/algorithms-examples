package br.com.sinergiavirtual.algorithms.string;

import org.junit.Assert;
import org.junit.Test;

public class AlternatingCharactersTest {

    private AlternatingCharacters alternatingCharacters = new AlternatingCharacters();

    @Test
    public void alternatingCharactersZeroDeletions() {

        // Arrange
        String input = "ABAB";
        int valueExpected = 0;

        // Act
        int valueReturned = alternatingCharacters.alternatingCharacters(input);

        // Assert
        Assert.assertEquals(valueExpected, valueReturned);

    }

    @Test
    public void alternatingCharactersOneCharacter() {

        // Arrange
        String input = "A";
        int valueExpected = 0;

        // Act
        int valueReturned = alternatingCharacters.alternatingCharacters(input);

        // Assert
        Assert.assertEquals(valueExpected, valueReturned);

    }


    @Test
    public void alternatingCharactersSomeDeletations() {

        // Arrange
        String input = "ABAAB";
        int valueExpected = 1;

        // Act
        int valueReturned = alternatingCharacters.alternatingCharacters(input);

        // Assert
        Assert.assertEquals(valueExpected, valueReturned);

    }

    @Test
    public void alternatingCharacters4A() {

        // Arrange
        String input = "AAAA";
        int valueExpected = 3;

        // Act
        int valueReturned = alternatingCharacters.alternatingCharacters(input);

        // Assert
        Assert.assertEquals(valueExpected, valueReturned);

    }

    @Test
    public void alternatingCharacters5B() {

        // Arrange
        String input = "BBBBB";
        int valueExpected = 4;

        // Act
        int valueReturned = alternatingCharacters.alternatingCharacters(input);

        // Assert
        Assert.assertEquals(valueExpected, valueReturned);

    }

    @Test
    public void alternatingCharactersSameSequence() {

        // Arrange
        String input = "AAABBB";
        int valueExpected = 4;

        // Act
        int valueReturned = alternatingCharacters.alternatingCharacters(input);

        // Assert
        Assert.assertEquals(valueExpected, valueReturned);

    }

    @Test
    public void alternatingCharactersOthersLetters() {

        // Arrange
        String input = "AACBB";
        int valueExpected = 0;

        // Act
        int valueReturned = alternatingCharacters.alternatingCharacters(input);

        // Assert
        Assert.assertEquals(valueExpected, valueReturned);

    }




}