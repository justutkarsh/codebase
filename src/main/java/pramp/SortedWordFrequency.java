package pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by utkarsh on 10-09-2016.
 */
/*
for doc: "practice makes perfect. get perfect by practice. just practice!"
the engine returns the list: { practice: 3, perfect: 2,  makes: 1, get: 1, by: 1, just: 1 }.
 */
public class SortedWordFrequency {
    public static void main(String[] args) {
        String doc = "practice makes perfect. get perfect by practice. just practice!";
        char []docArray = doc.toCharArray();

    }

    /*
      for efficient Storage Use datastructures.trie & Heap if we need to get at the most finite top words
      for optimal time we can use Heap and map to store words.

     */



    public Map<String, Integer> sortedWordFrequency(char[] buffer) {
        Map<String, Integer> result = new HashMap<>();

        Integer wordstart = null, wordend = 0;
        for (int i = 0; i < buffer.length; i++) {
            if ((buffer[i]) == ' ') {
                if (wordstart != null) {
                    insert(buffer, wordstart, i - 1);
                    wordstart = null;
                }

            } else if (i == buffer.length - 1) {
                if (wordstart != null)
                    insert(buffer, wordstart, i);

            } else if (wordstart == null)
                wordstart = i;
        }

        return result;
    }

    private void insert(char[] buffer, Integer wordstart, int i) {
    }
}
