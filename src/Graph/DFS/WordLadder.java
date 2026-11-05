package Graph.DFS;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                // Compare against every remaining word in the set
                Iterator<String> it = wordSet.iterator();
                while (it.hasNext()) {
                    String word = it.next();
                    if (differsByOne(current, word)) {
                        if (word.equals(endWord)) return level + 1;
                        queue.offer(word);
                        it.remove();
                    }
                }
            }
            level++;
        }
        return 0;
    }

    private boolean differsByOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
