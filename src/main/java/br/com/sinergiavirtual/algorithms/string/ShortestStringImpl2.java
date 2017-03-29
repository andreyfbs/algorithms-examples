package br.com.sinergiavirtual.algorithms.string;

public class ShortestStringImpl2 extends ShortestString {

    public String shortestSubstrContainingAllChars(String input, String target) {
        int needToFind[] = new int[256];
        int hasFound[] = new int[256];
        int totalCharCount = 0;
        String result = null;

        char[] targetCharArray = target.toCharArray();
        for (int i = 0; i < targetCharArray.length; i++) {
            needToFind[targetCharArray[i]]++;
        }

        char[] inputCharArray = input.toCharArray();
        for (int begin = 0, end = 0; end < inputCharArray.length; end++) {

            if (needToFind[inputCharArray[end]] == 0) {
                continue;
            }

            hasFound[inputCharArray[end]]++;
            if (hasFound[inputCharArray[end]] <= needToFind[inputCharArray[end]]) {
                totalCharCount ++;
            }
            if (totalCharCount == target.length()) {
                while (needToFind[inputCharArray[begin]] == 0
                        || hasFound[inputCharArray[begin]] > needToFind[inputCharArray[begin]]) {

                    if (hasFound[inputCharArray[begin]] > needToFind[inputCharArray[begin]]) {
                        hasFound[inputCharArray[begin]]--;
                    }
                    begin++;
                }

                String substring = input.substring(begin, end + 1);
                if (result == null || result.length() > substring.length()) {
                    result = substring;
                }
            }
        }
        return result;
    }
}
