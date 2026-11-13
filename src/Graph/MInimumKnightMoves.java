package Graph;

import java.util.*;

public class Solution {

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (!(obj instanceof Pair)) return false;

            Pair p = (Pair) obj;

            return first == p.first && second == p.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public int minKnightMoves(int x, int y) {

        int[][] knightMoves = {
                {1, 2}, {1, -2},
                {-1, 2}, {-1, -2},
                {2, 1}, {2, -1},
                {-2, 1}, {-2, -1}
        };

        Queue<Pair> q = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();

        Pair start = new Pair(0, 0);

        q.offer(start);
        visited.add(start);

        int chances = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                Pair cur = q.poll();

                if (cur.first == x && cur.second == y) {
                    return chances;
                }

                for (int i = 0; i < knightMoves.length; ++i) {

                    int curx = cur.first + knightMoves[i][0];
                    int cury = cur.second + knightMoves[i][1];

                    Pair curPair = new Pair(curx, cury);

                    if (visited.contains(curPair)) {
                        continue;
                    }

                    visited.add(curPair);
                    q.offer(curPair);
                }
            }

            chances++;
        }

        return -1;
    }
}