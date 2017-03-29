package br.com.sinergiavirtual.algorithms.permutation;

import br.com.sinergiavirtual.algorithms.string.ShortestString;
import br.com.sinergiavirtual.algorithms.string.ShortestStringImpl2;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestStringTest {

    @Test
    public void shortestSubstrContainingAllChars() throws Exception {
        ShortestString shortestString = new ShortestStringImpl2();

        String result = shortestString.shortestSubstrContainingAllChars("acbbaca", "aba");
        assertThat(result, Matchers.equalTo("baca"));

        result = shortestString.shortestSubstrContainingAllChars("acbbADOBECODEBANCaca", "ABC");
        assertThat(result, Matchers.equalTo("BANC"));

        result = shortestString.shortestSubstrContainingAllChars("this is a test string", "tist");
        assertThat(result, Matchers.equalTo("t stri"));

        result = shortestString.shortestSubstrContainingAllChars("cacd", "cd");
        assertThat(result, Matchers.equalTo("cd"));
    }
}