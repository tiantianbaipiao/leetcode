package suanfa;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 假设 beginWord 和 endWord 是有效的（即在字典中存在），并且 endWord 不等于 beginWord。
 */
public class _47LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0; // 如果目标单词不在字典中，则无法转换
        }

        Set<String> visited = new HashSet<>(); // 已访问的单词集合
        Queue<String> queue = new LinkedList<>(); // 存储待访问单词的队列
        queue.offer(beginWord);
        visited.add(beginWord);
        int step = 1; // 转换步数

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历当前层的所有单词
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // 尝试所有可能的变换
                for (String nextWord : getNextWords(currentWord, wordList)) {
                    if (nextWord.equals(endWord)) {
                        return step + 1; // 找到了目标单词
                    }
                    if (!visited.contains(nextWord)) {
                        queue.offer(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            step++; // 每遍历完一层，转换步数加一
        }

        return 0; // 如果没有找到路径，则返回 0
    }

    private List<String> getNextWords(String word, List<String> wordList) {
        List<String> nextWords = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (String nextWord : wordList) {
            char[] nextChars = nextWord.toCharArray();
            int diffCount = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != nextChars[i]) {
                    diffCount++;
                }
                if (diffCount > 1) break; // 如果超过一个字符不同，则跳出循环
            }
            if (diffCount == 1) {
                nextWords.add(nextWord);
            }
        }
        return nextWords;
    }
}
