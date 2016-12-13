package com.abbhasin.ds;

import java.util.stream.Stream;

public class Trie {

	public void insert(TrieNode node, String word) {
		for (int i = 0; i < word.length(); i++) {
			char currentLetter = word.charAt(i);

			if (node.children[currentLetter - 'a'] == null) {
				node.children[currentLetter - 'a'] = new TrieNode(currentLetter);
			}

			node = node.children[currentLetter - 'a'];
			if (i == word.length() - 1) {
				node.isLeaf = true;
			}
		}
	}

	public boolean search(TrieNode node, String word) {
		for (int i = 0; i < word.length(); i++) {
			char currentLetter = word.charAt(i);
			if (node.children[currentLetter - 'a'] == null) {
				return false;
			}
			node = node.children[currentLetter - 'a'];
		}
		return node.isLeaf;
	}

	public void delete(TrieNode node, String word) {
		delete(node, word, 0);
	}

	private TrieNode delete(TrieNode node, String word, int i) {
		if (i == word.length()) {
			boolean atLeastOneChildPresent = Stream.of(node.children).anyMatch(child -> child != null);
			if (atLeastOneChildPresent) {
				node.isLeaf = false;
			} else {
				return null;
			}
		}

		node.children[i] = delete(node.children[i], word, i + 1);
		if (node.children[i] == null && !node.isLeaf) {
			return null;
		}
		return node;
	}

	public boolean startsWith(TrieNode node, String prefix) {
		for (int i = 0; i < prefix.length(); i++) {
			char currentLetter = prefix.charAt(i);
			if (node.children[currentLetter - 'a'] == null)
				return false;
			node = node.children[currentLetter - 'a'];
		}
		return true;
	}

	public static class TrieNode {
		public char c;
		public TrieNode[] children;
		public boolean isLeaf;

		public TrieNode(char c) {
			this.c = c;
			children = new TrieNode[26];
		}
	}

}
