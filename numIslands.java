class Solution {
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (grid == null || rows == 0) return 0;
        cols = grid[0].length;
        int islandCount = 0;

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (grid[x][y] == '1') {
                    islandCount++;
                    traverse(grid, x, y);
                }
            }
        }

        return islandCount;
    }

    private void traverse(char[][] grid, int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0') return;

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        grid[x][y] = '0';

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            traverse(grid, newX, newY);
        }
    }
    public static void main(String[] args) {
    char[][] grid = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };
    
    Solution solution = new Solution();
    int result = solution.numIslands(grid);
    System.out.println(result);  // ans: 1
}
}
