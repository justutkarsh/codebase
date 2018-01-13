package companies.sigmoid;

/**
 * Created by utkarsh on 23-08-2016.
 * /* suppose a string abca
 * Find the minimum no. of insertions needed to make it a palindrome
 * abca
 * <p>
 * 1 insertion needed b  abcba
 */
public class MinimumNumberOfInsertionsPalindrome {

    public static void main(String[] args) {
        Solution s = new Solution();

        String s1 = "sldjf";
//        s1.to
        System.out.println(s.minInsertions("aa".toCharArray(), 0, "aa".length() - 1));
        System.out.println(s.minInsertions("aba".toCharArray(), 0, "aba".length() - 1));
        System.out.println(s.minInsertions("aad".toCharArray(), 0, "aad".length() - 1));
        System.out.println(s.minInsertions("abc".toCharArray(), 0, "abc".length() - 1));

        System.out.println(s.minInsertionsString("abc".toCharArray(), 0, "abc".length() - 1).palindrome);


    }

    static class Solution {


        public int minInsertions(char[] buffer, int l, int h) {
            if (l > h) return Integer.MAX_VALUE;
            if (l == h) return 0;
            if (l + 1 == h) {
                return buffer[l] == buffer[h] ? 0 : 1;
            }
            return (buffer[l] == buffer[h]) ? minInsertions(buffer, l + 1, h - 1) :
                    Math.min(minInsertions(buffer, l, h - 1), minInsertions(buffer, l + 1, h)) + 1;

        }


        static class RS {
            String palindrome;
            int insertions;

            public RS(String palindrome, int insertions) {
                this.palindrome = palindrome;
                this.insertions = insertions;
            }
        }

        public RS minInsertionsString(char[] buffer, int l, int h) {
            if (l > h) return new RS("", Integer.MAX_VALUE);
            if (l == h) return new RS(Character.toString(buffer[l]), 0);
            if (l + 1 == h) {
                return buffer[l] == buffer[h] ?
                        new RS(new String(buffer, l, 2), 0) :
                        new RS(new String(buffer, l, 2) + buffer[l], 1);
            }

            if (buffer[l] == buffer[h]) return minInsertionsString(buffer, l + 1, h - 1);
            else {

                RS left = minInsertionsString(buffer, l, h - 1);
                RS right = minInsertionsString(buffer, l + 1, h);

                if (left.insertions > right.insertions) {
                    return new RS(buffer[l] + right.palindrome + buffer[l], right.insertions + 1);

                } else
                    return new RS(buffer[h] + left.palindrome + buffer[h], left.insertions + 1);
            }


        }
    }
}






