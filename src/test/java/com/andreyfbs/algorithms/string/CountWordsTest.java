package com.andreyfbs.algorithms.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountWordsTest {

    private CountWords countWords;

    @Before
    public void setup() {
        countWords = new CountWords();
    }

    @Test
    public void oneWord() {
        // Arrange
        String input = "car";
        String expectedOutput = "1=car";

        // Act
        String output = countWords.countWords(input);

        // Assert
        Assert.assertEquals(expectedOutput, output);
    }

    @Test
    public void twoWords() {
        // Arrange
        String input = "car bird";
        String expectedOutput = "1=car,1=bird";

        // Act
        String output = countWords.countWords(input);

        // Assert
        Assert.assertEquals(expectedOutput, output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputNull() {
        // Arrange
        String input = null;

        // Act
        countWords.countWords(input);

        // Assert
        // Exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputEmpty() {
        // Arrange
        String input = "  ";

        // Act
        countWords.countWords(input);

        // Assert
        // Exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputIllegalCharacter() {
        // Arrange
        String input = "test ! test";

        // Act
        countWords.countWords(input);

        // Assert
        // Exception
    }


    @Test
    public void moreThanOneOccurrence() {
        // Arrange
        String input = "bird car bird car car";
        String expectedOutput = "3=car,2=bird";

        // Act
        String output = countWords.countWords(input);

        // Assert
        Assert.assertEquals(expectedOutput, output);
    }

    @Test
    public void longText() {
        // Arrange
        String input = "Given a text with max length of Integer, find the k most frequent words on the text Consider word separators between continues the text in the,next line";
        String expectedOutput = "4=the,3=text,1=next,1=a,1=Consider,1=in,1=max,1=line,1=Given,1=words,1=frequent,1=length,1=k,1=most,1=Integer,1=with,1=find,1=of,1=continues,1=separators,1=word,1=between,1=on";
        // Act
        String output = countWords.countWords(input);

        // Assert
        Assert.assertEquals(expectedOutput, output);
    }


}