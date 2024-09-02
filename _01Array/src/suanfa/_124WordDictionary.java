package suanfa;

public class _124WordDictionary {

    private TrieNode root;

    public _124WordDictionary() {
        root = new TrieNode();
    }

    /**
     * 添加一个单词到字典树中
     * @param word 单词
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * 查找是否存在某个模式的单词
     * @param word 模式
     * @return 是否存在匹配的单词
     */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);
        if (c != '.') {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            return searchHelper(word, index + 1, node.children[c - 'a']);
        } else {
            for (TrieNode child : node.children) {
                if (child != null && searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Trie 节点定义
    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    // 测试方法
    public static void main(String[] args) {
        _124WordDictionary wordDictionary = new _124WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad")); // 输出 false
        System.out.println(wordDictionary.search("bad")); // 输出 true
        System.out.println(wordDictionary.search(".ad")); // 输出 true
        System.out.println(wordDictionary.search("b..")); // 输出 true
    }
}
