package br.com.sinergiavirtual.algorithms.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MakingAnagramsTest {

    public MakingAnagrams makingAnagrams;

    @Before
    public void setup() {
        makingAnagrams = new MakingAnagrams();
    }

    @Test
    public void calculateNumberElementsToDelete() throws Exception {

        // Arrange
        String word1 = "cde";
        String word2 = "abc";
        Integer numberCharactersToDeleteExpected = 4;

        // Act
        Integer numberCharactersToDeleteOutput = makingAnagrams.calculateNumberElementsToDelete(word1, word2);

        // Assert
        Assert.assertEquals(numberCharactersToDeleteExpected, numberCharactersToDeleteOutput);
    }

    @Test
    public void calculateNumberElementsToDelete_2() throws Exception {

        // Arrange
        String word1 = "a";
        String word2 = "bb";
        Integer numberCharactersToDeleteExpected = 3;

        // Act
        Integer numberCharactersToDeleteOutput = makingAnagrams.calculateNumberElementsToDelete(word1, word2);

        // Assert
        Assert.assertEquals(numberCharactersToDeleteExpected, numberCharactersToDeleteOutput);
    }

    @Test
    public void calculateNumberElementsToDelete_3() throws Exception {

        // Arrange
        String word1 = "jk";
        String word2 = "kj";
        Integer numberCharactersToDeleteExpected = 0;

        // Act
        Integer numberCharactersToDeleteOutput = makingAnagrams.calculateNumberElementsToDelete(word1, word2);

        // Assert
        Assert.assertEquals(numberCharactersToDeleteExpected, numberCharactersToDeleteOutput);
    }

    @Test
    public void calculateNumberElementsToDelete_4() throws Exception {

        // Arrange
        String word1 = "abb";
        String word2 = "bbc";
        Integer numberCharactersToDeleteExpected = 2;

        // Act
        Integer numberCharactersToDeleteOutput = makingAnagrams.calculateNumberElementsToDelete(word1, word2);

        // Assert
        Assert.assertEquals(numberCharactersToDeleteExpected, numberCharactersToDeleteOutput);
    }

    @Test
    public void calculateNumberElementsToDelete_5() throws Exception {

        // Arrange
        String word1 = "mn";
        String word2 = "op";
        Integer numberCharactersToDeleteExpected = 4;

        // Act
        Integer numberCharactersToDeleteOutput = makingAnagrams.calculateNumberElementsToDelete(word1, word2);

        // Assert
        Assert.assertEquals(numberCharactersToDeleteExpected, numberCharactersToDeleteOutput);
    }

    @Test
    public void calculateNumberElementsToDelete_6() throws Exception {

        // Arrange
        String word1 = "imkhnpqnhlvaxlmrsskbyyrhwfvgteubrelgubvdmrdmesfxkpykprunzpustowmvhupkqsyjxmnptkcilmzcinbzjwvxshubeln";
        String word2 = "wfnfdassvfugqjfuruwrdumdmvxpbjcxorettxmpcivurcolxmeagsdundjronoehtyaskpwumqmpgzmtdmbvsykxhblxspgnpgfzydukvizbhlwmaajuytrhxeepvmcltjmroibjsdkbqjnqjwmhsfopjvehhiuctgthrxqjaclqnyjwxxfpdueorkvaspdnywupvmy";
        Integer numberCharactersToDeleteExpected = 102;

        // Act
        Integer numberCharactersToDeleteOutput = makingAnagrams.calculateNumberElementsToDelete(word1, word2);

        // Assert
        Assert.assertEquals(numberCharactersToDeleteExpected, numberCharactersToDeleteOutput);
    }

}