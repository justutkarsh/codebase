package datastructures;

import java.util.HashMap;

/*
 *        D
 *        o   n
 g    l    t
 l
 */
public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode('0', false);
	}

	void insert(String word) {
		TrieNode crawl = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (crawl.children.containsKey(ch)) {
				crawl = crawl.children.get(ch);
			} else {
				crawl.children.put(ch, new TrieNode());
			    if (i == word.length() - 1)
					crawl.end = true;
				crawl = crawl.children.get(ch);
			}

			
		}

	}

	Boolean search(String word) {
		TrieNode crawl = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (crawl.children.get(ch) == null)
				return false;
			else {
				if (i == word.length() - 1 && crawl.end)
					return true;
				crawl = crawl.children.get(ch);
			}
			
		}
		return false;
	}

	class TrieNode {
		public TrieNode(Character c, boolean b) {
			this.end = b;
			children=new HashMap<Character,TrieNode>();
		}

		public TrieNode() {
			children=new HashMap<Character,TrieNode>();
			end=false;
		}
		HashMap<Character, TrieNode> children;
		Boolean end;
	}

public static void main(String[] args) {
	Trie trie= new Trie();
	trie.insert("Dog");
	trie.insert("Dolly");
	trie.insert("Dog");
	
	//trie.search("Doggy");
	System.out.println(trie.search("Dog"));
	System.out.println(trie.search("Doggy"));
	System.out.println(trie.search("Dolly"));
	
}
}