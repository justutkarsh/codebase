package Trie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by utkarsh on 14-09-2016.
 */
public class MostFrequentWords {

    private class Word  {
        String word;
        int freq;
        public Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }


    private int memSize = 100000;//Allowed memory to be used.
    private Word words[] = new Word[memSize];//It is used for keeping words, it serves as heap.
    int ctr = 0;//to keep count of unique words inserted in heap, till heap is full.

    //Used for trie.
    private class Node {
        Map<Character, Node> children;
        boolean isEnd;
        int freq;
        public Node(boolean isEnd) {
            this.children = new HashMap<Character, Node>();
            this.isEnd = isEnd;
            this.freq = 1;
        }
    }

    private Node root = new Node(false);//root for trie
    private static final String FILE_PATH = "/home/ashu/phrases.txt";

    public static void main(String args[]) {
        sampleTest(); //test case written at bottom for memSize of 5 words
        System.out.println("**************************");
        MostFrequentWords mw = new MostFrequentWords();
        try (Stream<String> stream = Files.lines(Paths.get(FILE_PATH))) {
            stream.forEach(s-> {
                String[] words = s.split("\\|");
                for (String word : words) {
                    mw.insert(word.trim());
                }
            });
            Deque<Character> deque = new LinkedList<Character>();
            mw.traverseTrieAndBuildHeap(mw.root, deque);
            for (int i=0;i<mw.ctr;i++) {
                System.out.println(mw.words[i].word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Traverse trie and push elements into minHeap and keep heapifying to get most frequent words.
     * @param p
     * @param deque
     */
    private void traverseTrieAndBuildHeap(Node p, Deque<Character> deque) {
        if (p != null) {
            if (p.isEnd) {
                //keep filling while number of words in Heap is less than memSize
                if (ctr < memSize) {
                    words[ctr] = new Word(getWord(deque), p.freq);
                    ctr++;
                    //when heap is full heapify it
                    if (ctr == memSize) {
                        minHeapify();
                    }
                } else {
                    //insert only if new word's frequency is more than minimum frequency of word in heap
                    if (p.freq > words[0].freq) {
                        words[0] = new Word(getWord(deque), p.freq);
                        minHeapify();
                    }
                }
            }
            for (Character ch : p.children.keySet()) {
                deque.add(ch);
                traverseTrieAndBuildHeap(p.children.get(ch), deque);
            }
            deque.pollLast();
        }
    }

    /**
     * Insert words into Trie.
     * @param word
     */
    private void insert(String word) {
        int n = word.length();
        Node crawl = root;
        for (int i=0;i<n;i++) {
            char ch = word.charAt(i);
            if (crawl.children.get(ch) != null) {
                crawl = crawl.children.get(ch);
                if (i == n-1 && crawl.isEnd) {
                    crawl.freq++;
                }
            } else {
                Node temp = new Node(false);
                crawl.children.put(ch, temp);
                crawl = temp;
            }
        }
        crawl.isEnd = true;
    }

    private void minHeapify() {
        int n = words.length;
        for (int i = n/2;i>=0;i--) {
            minHeap(words,i,n);
        }
    }

    private void minHeap(Word words[], int i, int n) {
        int l = 2*i + 1;
        int r = 2*i + 2;
        int small = i;
        if (l<n && words[small].freq > words[l].freq) {
            small = l;
        }
        if (r<n && words[small].freq > words[r].freq) {
            small = r;
        }
        if (small != i) {
            swap(words, small, i);
            minHeap(words, small, n);
        }
    }

    private void swap(Word words[], int i, int j) {
        Word temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    private String getWord(Deque<Character> deque) {
        StringBuilder sb = new StringBuilder();
        for (char ch : deque) {
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * It tests by taking memory size of 5 words only.
     */
    @SuppressWarnings("unused")
    private static void sampleTest() {
        MostFrequentWords mw = new MostFrequentWords();
        mw.memSize = 5;
        mw.words = new Word[5];

        mw.insert("dog");
        mw.insert("dog");

        mw.insert("cat");
        mw.insert("cat");

        mw.insert("rat");
        mw.insert("rat");
        mw.insert("rat");

        mw.insert("bat");
        mw.insert("bat");
        mw.insert("bat");

        mw.insert("cow");
        mw.insert("cow");
        mw.insert("cow");
        mw.insert("dogs");
        mw.insert("dogs");
        mw.insert("dogs");

        Deque<Character> deque = new LinkedList<Character>();
        mw.traverseTrieAndBuildHeap(mw.root, deque);
        for (Word word : mw.words) {
            System.out.println(word.word);
        }
    }

}
