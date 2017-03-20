package br.com.sinergiavirtual.algorithms.permutation;

public class Permutation {

    public static void main(String[] args) {
        String str = "abcd";
        permutation(str);
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println("-------RESP----------: " + prefix);
        }
        else {
            for (int i = 0; i < n; i++) {
                System.out.println("INITIAL: " + i + " N: " + n);
                String head = prefix + str.charAt(i);
                System.out.println("Prefix: " + prefix + " Str: " + str);
                String tail = str.substring(0, i) + str.substring(i + 1, n);
                System.out.println("Head: " + head +  " Tail: " + tail);
                System.out.println("FINAL: " + i + " N: " + n);
                System.out.println("-----------------------");

                permutation(head, tail);
            }

        }
    }

}
