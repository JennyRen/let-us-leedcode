class Solution {
    /*
    * 解法一： BFS，雖然也能用DFS但是能用bfs 盡量用bfs
    */
    
    private int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        if (grid[0] == null || grid[0].length == 0) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(grid, visited, i, j));
                }
            }
        }
        
        return max;
    }
    
    private int bfs(int[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {i, j});
        int size = 0;
        while (!queue.isEmpty()) {
            int lvl = queue.size();
            for (int l = 0; l < lvl; l++) {
                int[] coor = queue.poll();
                size++;
                for (int[] dir : DIRS) {
                    int x = dir[0] + coor[0];
                    int y = dir[1] + coor[1];
                    if (!isValid(grid, x, y)) continue;
                    if (visited[x][y]) continue;
                    visited[x][y] = true;
                    queue.add(new int[] {x, y});
                }
            }
        }
        
        return size;
    }
    
    private boolean isValid(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m) return false;
        return grid[x][y] == 1;
    }
}