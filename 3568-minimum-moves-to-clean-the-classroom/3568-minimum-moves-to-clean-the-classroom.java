import java.util.*;

class Solution {

    class State {
        int r, c, energy, mask, moves;

        State(int r, int c, int energy, int mask, int moves) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;

        Map<Integer, Integer> litterIndex = new HashMap<>();
        int litterCount = 0;

        // Find start and assign an index to every litter
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    litterIndex.put(i * n + j, litterCount++);
                }
            }
        }

        int targetMask = (1 << litterCount) - 1;

        Queue<State> q = new LinkedList<>();

        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << litterCount];

        q.offer(new State(startR, startC, energy, 0, 0));
        visited[startR][startC][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            State curr = q.poll();

            if (curr.mask == targetMask) {
                return curr.moves;
            }

            for (int d = 0; d < 4; d++) {

                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                char cell = classroom[nr].charAt(nc);

                if (cell == 'X')
                    continue;

                int newEnergy = curr.energy - 1;

                if (newEnergy < 0)
                    continue;

                // Recharge
                if (cell == 'R') {
                    newEnergy = energy;
                }

                int newMask = curr.mask;

                // Collect litter
                if (cell == 'L') {
                    int idx = litterIndex.get(nr * n + nc);
                    newMask |= (1 << idx);
                }

                if (!visited[nr][nc][newEnergy][newMask]) {

                    visited[nr][nc][newEnergy][newMask] = true;

                    q.offer(
                        new State(
                            nr,
                            nc,
                            newEnergy,
                            newMask,
                            curr.moves + 1
                        )
                    );
                }
            }
        }

        return -1;
    }
}