package graph;

import java.util.*;

/**
 * @author ginga
 * @since 27/4/2023 下午9:49
 */
public class Sword108 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> notVis = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) return 0;
        int len = 2;
        Set<String> lessWords = new HashSet<>(Collections.singleton(beginWord));
        Set<String> moreWords = new HashSet<>(Collections.singleton(endWord));
        notVis.remove(endWord);

        while (!lessWords.isEmpty() && !moreWords.isEmpty()) {
            if (lessWords.size() > moreWords.size()) {
                Set<String> tmp = lessWords;
                lessWords = moreWords;
                moreWords = tmp;
            }
            Set<String> middle = new HashSet<>();

            for (String word : lessWords) {
                final List<String> neighbors = getNeighbors(word);

                for (String neighbor : neighbors) {
                    if (moreWords.contains(neighbor)) { // 两个集合相遇
                        return len;
                    }

                    if (notVis.contains(neighbor)) {
                        middle.add(neighbor);
                        notVis.remove(neighbor);
                    }
                }
            }

            len++;
            lessWords = middle;
        }

        return 0;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<>();
        final char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (old != c) {
                    chars[i] = c;
                    neighbors.add(new String(chars));
                }
            }

            chars[i] = old;
        }
        return neighbors;
    }
}
