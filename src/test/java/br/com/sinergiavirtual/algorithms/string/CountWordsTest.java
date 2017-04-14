package br.com.sinergiavirtual.algorithms.string;

import org.hamcrest.Matchers;
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
    public void countTheWordsSomeWords() {

        // Arrange
        String sentence = "Car Bus Car Test Java";
        String expectedReturn = "{ Car: 2, Test: 1, Java: 1, Bus: 1 }";

        // Act
        String listWordsCount = countWords.countTheWords(sentence);

        // Assert
        Assert.assertThat(listWordsCount, Matchers.equalTo(expectedReturn));
    }

    @Test
    public void countTheWordsWithFullSentence() {

        // Arrange
        String sentence = "practice makes perfect. get perfect by practice. just practice!";
        String expectedReturn = "{ practice: 3, perfect: 2, just: 1, makes: 1, by: 1, get: 1 }";

        // Act
        String listWordsCount = countWords.countTheWords(sentence);

        // Assert
        Assert.assertThat(listWordsCount, Matchers.equalTo(expectedReturn));
    }


}