package pramp;

/**
 * Created by utkarsh on 17/02/18.
 */

public class BasicRegexParser {

//abbbbcd
//d*ab*c.

//abbbbcd ab*c

  //bbbbcd
  //b*c.

  //   = bbbbcd,c. + cd,c.

//can you hear?

//lost you again.
//lets end it?
//yeah
//thank you for your time.

  //yeah same and thanks will solve in my time.
  //good luck
  //you too
  //ending now

  static class Solution {
    private boolean isMatchRecursiveUtil(char[] text, char[] pattern, int pos1, int pos2) {
      if (pos2 == pattern.length) {
        return text.length == pos1;
      }

      if (pattern[pos2] != '*') {
        if (pos1 < text.length && (text[pos1] == pattern[pos2]) || pattern[pos2] == '.') {
          return isMatchRecursiveUtil(text, pattern, pos1 + 1, pos2 + 1);
        } else {
          return false;
        }
      } else {
        //if we have a***b then skip to the last *
        while (pos2 < pattern.length - 1 && pattern[pos2 + 1] == '*') {
          pos2++;
        }
        pos1--;
        while (pos1 < text.length) {
          if (isMatchRecursiveUtil(text, pattern, pos1 + 1, pos2 + 1)) {
            return true;
          }
          pos1++;
        }
        return false;
      }
    }

    static boolean isMatch(char[] text, char[] pattern, int t, int p) {


      if (p >= pattern.length && t >= text.length) {
        return true;
      }

      if (p >= pattern.length || t >= text.length) {
        return false;
      }

      if (pattern.length == 1 && pattern[p] == '*') {
        return true;
      }
      if (pattern.length == 1 && text.length == 1) {
        if (pattern[p] == text[t] || pattern[p] == '.') {
          return true;
        }

      }


      //bcab  b*b      bcab,b  cab,b
      //case with *

      //bc b*
      if (p < pattern.length - 1 && pattern[p + 1] == '*') {
        //case when phi
        boolean part1 = isMatch(text, pattern, t, p + 2);

        //case when multiple occurrences match
        while (text[t] == pattern[p] || pattern[p] == '.') {
          t++;
        }

        if (t == text.length && p == pattern.length - 2) {
          return true;
        }

        boolean part2 = isMatch(text, pattern, t, p + 2);

        return part1 || part2;

      }
      //case without *
      if (text[t] == pattern[p] || pattern[p] == '.') {
        return isMatch(text, pattern, t + 1, p + 1);
      } else {
        return false;
      }
    }




    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.isMatchRecursiveUtil("cat".toCharArray(), "...".toCharArray(), 0, 0));
      System.out.println(s.isMatchRecursiveUtil("abbbbcd".toCharArray(), "b*c.".toCharArray(), 0, 0));
      System.out.println(s.isMatchRecursiveUtil("aa".toCharArray(), "a".toCharArray(), 0, 0));
      System.out.println(s.isMatchRecursiveUtil("".toCharArray(), "a*".toCharArray(), 0, 0));
      System.out.println(s.isMatchRecursiveUtil("abaa".toCharArray(), "a.*a*".toCharArray(), 0, 0));




    }

  }
}
