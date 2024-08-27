import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水
 * 平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 */
public class WordSearchII {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private Set<String> foundWords = new HashSet<>();
    private TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            addWordToTrie(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return new ArrayList<>(foundWords);
    }

    private void dfs(char[][] board, int row, int col, TrieNode node) {
        int m = board.length;
        int n = board[0].length;
        
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }
        
        char c = board[row][col];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        
        node = node.children[c - 'a'];
        if (node.word != null) {
            foundWords.add(node.word);
        }
        
        board[row][col] = '#'; // 标记为已访问
        for (int[] direction : DIRECTIONS) {
            dfs(board, row + direction[0], col + direction[1], node);
        }
        board[row][col] = c; // 恢复原始字符
    }

    private void addWordToTrie(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.word = word;
    }

    private static class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            this.children = new TrieNode[26];
            this.word = null;
        }
    }

    public static void main(String[] args) {
        // 测试数据
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};

        // 输出结果
        List<String> result = new WordSearchII().findWords(board, words);
        System.out.println(result); // 输出 [eat, oat, pea]
    }
}
