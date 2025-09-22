class Solution {
    int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1},     // Rook
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1}    // Bishop
    };

    List<List<List<int[]>>> allPaths = new ArrayList<>();
    int count = 0;

    public int countCombinations(String[] pieces, int[][] positions) {
        int n = pieces.length;

        // Step 1: Generate all movement paths for each piece
        for (int i = 0; i < n; i++) {
            String type = pieces[i];
            int[] pos = positions[i];
            List<List<int[]>> paths = new ArrayList<>();
            paths.add(List.of(new int[][]{pos})); // Stay still

            for (int[] dir : getDirs(type)) {
                List<int[]> path = new ArrayList<>();
                int r = pos[0], c = pos[1];

                for (int step = 1; step < 8; step++) {
                    r += dir[0];
                    c += dir[1];

                    if (r < 1 || r > 8 || c < 1 || c > 8) break;

                    path.add(new int[]{r, c});
                    paths.add(new ArrayList<>(path));
                }
            }
            allPaths.add(paths);
        }

        // Step 2: Backtracking (DFS) to simulate every combination
        backtrack(new ArrayList<>(), 0);
        return count;
    }

    void backtrack(List<List<int[]>> current, int index) {
        if (index == allPaths.size()) {
            if (isValid(current)) count++;
            return;
        }

        for (List<int[]> path : allPaths.get(index)) {
            current.add(path);
            backtrack(current, index + 1);
            current.remove(current.size() - 1);
        }
    }

    boolean isValid(List<List<int[]>> paths) {
        int maxTime = 0;
        for (List<int[]> path : paths) {
            maxTime = Math.max(maxTime, path.size());
        }

        // Simulate second-by-second
        Set<String> seen = new HashSet<>();
        for (int t = 0; t <= maxTime; t++) {
            seen.clear();
            for (List<int[]> path : paths) {
                int[] pos = t < path.size() ? path.get(t) : path.get(path.size() - 1);
                String key = pos[0] + "," + pos[1];
                if (!seen.add(key)) return false;
            }
        }
        return true;
    }

    List<int[]> getDirs(String piece) {
        List<int[]> dirs = new ArrayList<>();

        if (piece.equals("rook") || piece.equals("queen")) {
            dirs.add(new int[]{-1, 0});
            dirs.add(new int[]{1, 0});
            dirs.add(new int[]{0, -1});
            dirs.add(new int[]{0, 1});
        }
        if (piece.equals("bishop") || piece.equals("queen")) {
            dirs.add(new int[]{-1, -1});
            dirs.add(new int[]{-1, 1});
            dirs.add(new int[]{1, -1});
            dirs.add(new int[]{1, 1});
        }
        return dirs;
    }
}