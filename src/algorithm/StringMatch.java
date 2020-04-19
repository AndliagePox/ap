/*
 * Author: Andliage Pox
 * Date: 2020-04-17
 */

package algorithm;

public class StringMatch {
    public static void main(String[] args) {
        int stringCount = 1000, times = 10, matchCount = 0;
        String[] strings = new String[stringCount];
        String[] patterns = new String[stringCount];
        for (int i = 0; i < stringCount; i++) {
            strings[i] = generateRandomString(10000, 50000);
            patterns[i] = generateRandomString(3000, 30000);
        }
        long ts, te;

        ts = System.currentTimeMillis();
        for (int t = 0; t < times; t++) {
            for (int i = 0; i < stringCount; i++) {
                if (strings[i].contains(patterns[i])) matchCount++;
            }
        }
        te = System.currentTimeMillis();
        System.out.println("[System contain] time: " + (te - ts) + " ms, match rate: " + matchCount / times + " / " + stringCount);

        matchCount = 0;
        ts = System.currentTimeMillis();
        for (int t = 0; t < times; t++) {
            for (int i = 0; i < stringCount; i++) {
                if (kmpMatch(strings[i], patterns[i])) matchCount++;
            }
        }
        te = System.currentTimeMillis();
        System.out.println("[KMP Match] time: " + (te - ts) + " ms, match rate: " + matchCount / times + " / " + stringCount);

        matchCount = 0;
        ts = System.currentTimeMillis();
        for (int t = 0; t < times; t++) {
            for (int i = 0; i < stringCount; i++) {
                if (bfMatch(strings[i], patterns[i])) matchCount++;
            }
        }
        te = System.currentTimeMillis();
        System.out.println("[BF Match] time: " + (te - ts) + " ms, match rate: " + matchCount / times + " / " + stringCount);
    }

    private static String generateRandomString(int minLength, int maxLength) {
        char[] chars = new char[(int) (Math.random() * (maxLength - minLength) + minLength + 1)];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (3 * Math.random() + 65);
        }
        return new String(chars);
    }

    private static boolean kmpMatch(String string, String pattern) {
        if (string.length() < pattern.length()) return false;

        char[] pc = pattern.toCharArray();
        char[] sc = string.toCharArray();

        int[] next = new int[pc.length];
        next[0] = -1;
        next[1] = 0;
        int n = 0, k = -1;
        while (n < pc.length - 1) {
            if (k == -1 || pc[n] == pc[k]) {
                next[++n] = ++k;
            } else {
                k = next[k];
            }
        }

        int i = 0, j = 0;
        while (i < sc.length && j < pc.length) {
            if (j == -1 || sc[i] == pc[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        return j == pc.length;
    }

    private static boolean bfMatch(String string, String pattern) {
        char[] sc = string.toCharArray();
        char[] pc = pattern.toCharArray();

        int i = 0, j = 0;
        while (i < sc.length && j < pc.length) {
            if (sc[i] == pc[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        return j == pc.length;
    }
}
