package br.com.sinergiavirtual.algorithms.string;

import br.com.sinergiavirtual.algorithms.string.PalindromeIndex;
import org.junit.Assert;
import org.junit.Test;

/**
 * 10
 * quyjjdcgsvvsgcdjjyq
 * hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh
 * fgnfnidynhxebxxxfmxixhsruldhsaobhlcggchboashdlurshxixmfxxxbexhnydinfngf
 * bsyhvwfuesumsehmytqioswvpcbxyolapfywdxeacyuruybhbwxjmrrmjxwbhbyuruycaexdwyfpaloyxbcpwsoiqtymhesmuseufwvhysb
 * fvyqxqxynewuebtcuqdwyetyqqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf
 * mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm
 * tpqknkmbgasitnwqrqasvolmevkasccsakvemlosaqrqwntisagbmknkqpt
 * lhrxvssvxrhl
 * prcoitfiptvcxrvoalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp
 * kjowoemiduaaxasnqghxbxkiccikxbxhgqnsaxaaudimeowojk
 * 1
 * 8
 * 33
 * 23
 * 25
 * 44
 * 20
 * -1
 * 14
 * -1
 **/
public class PalindromeIndexTest {

    private PalindromeIndex palindromeIndex = new PalindromeIndex();

    @Test
    public void palindromeIndex() {

        // Arrange
        final String word = "aabccba";
        final int indexExpected = 2;

        // Act
        final int indexReturned = palindromeIndex.palindromeIndex(word);

        // Assert
        Assert.assertEquals(indexExpected, indexReturned);

    }
}