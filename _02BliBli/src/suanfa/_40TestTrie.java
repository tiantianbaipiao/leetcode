package suanfa;

class TrieNode {
  // 初始化孩子节点为 null
  TrieNode[] children = new TrieNode[26];
  // 标记该节点是否为单词的结尾
  boolean isEndOfWord;
}
class Trie {

  private TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (current.children[c - 'a'] == null) {
        current.children[c - 'a'] = new TrieNode();
      }
      current = current.children[c - 'a'];
    }
    current.isEndOfWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (current.children[c - 'a'] == null) {
        return false;
      }
      current = current.children[c - 'a'];
    }
    return current.isEndOfWord;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode current = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (current.children[c - 'a'] == null) {
        return false;
      }
      current = current.children[c - 'a'];
    }
    return true;
  }
}
