package companies.olacabs;

import java.util.Arrays;

public class AmazingCharacters {

  public static int getNumberOfReplacementsRequired(String str) {
    int totalReplacements = 0;
    int currCount = 0;
    Character prevChar = null;
    for (int i = 0; i < str.length(); i++) {
      Character c = str.charAt(i);
      if (c.equals(prevChar)) {
        currCount++;
        if (i == str.length() - 1) { // edge case
// calculate the replacements required
          int r = (currCount + 1) / 2;
          totalReplacements += r;
        }
      } else {
// calculate the replacements required
        int r = (currCount + 1) / 2;
        totalReplacements += r;
        currCount = 0;
      }

      prevChar = c;
    }
    return totalReplacements;
  }

  public static int[] findReplacements(String[] words) {
    int[] replacements = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      replacements[i] = getNumberOfReplacementsRequired(words[i]);
    }

    return replacements;
  }

  public static void main(String[] args) {
    String[] words = {"aab", "abba", "abcaa", "a", "aa", "aaa", "aaaa", "aaaaa", "aaaabb"};
    System.out.println(Arrays.asList(findReplacements(words)));
  }
}