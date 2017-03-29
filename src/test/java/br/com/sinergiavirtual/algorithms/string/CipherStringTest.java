package br.com.sinergiavirtual.algorithms.string;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CipherStringTest {

    // a b c d e f g h i j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26

    private CipherString cipherString;

    @Before
    public void setup() {
        cipherString = new CipherString();
    }

    @Test
    public void cipherStringSuccess() throws Exception {

        String inputWord = "abc";
        String cipherWord = "nop";

        String cipherWordResponse = cipherString.cipherString(inputWord);


        Assert.assertThat(cipherWordResponse, Matchers.equalTo(cipherWord));
    }

    @Test
    public void cipherStringSuccessRevertLetters() throws Exception {

        String inputWord = "cba";
        String cipherWord = "pon";

        String cipherWordResponse = cipherString.cipherString(inputWord);


        Assert.assertThat(cipherWordResponse, Matchers.equalTo(cipherWord));
    }

    @Test
    public void cipherStringSuccessEndOfAlphabet() throws Exception {

        String inputWord = "xyz";
        String cipherWord = "klm";

        String cipherWordResponse = cipherString.cipherString(inputWord);


        Assert.assertThat(cipherWordResponse, Matchers.equalTo(cipherWord));
    }

    @Test
    public void cipherStringSuccessWithMoreLettersAndNotAlphabetsLetters() throws Exception {

        String inputWord  = "jfasdf!z cba";
        String cipherWord = "wsnfqs!m pon";

        String cipherWordResponse = cipherString.cipherString(inputWord);


        Assert.assertThat(cipherWordResponse, Matchers.equalTo(cipherWord));
    }


    @Test
    public void cipherStringSuccessInputNull() throws Exception {

        String inputWord = null;

        String cipherWordResponse = cipherString.cipherString(inputWord);

        Assert.assertNull(cipherWordResponse);
    }

}