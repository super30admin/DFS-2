// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    int idx;

    public String decodeString(String s) {
        int currVal = 0;
        StringBuilder currString = new StringBuilder();

        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                currVal = 10 * currVal + c - '0';
                idx++;
            } else if (c == '[') {
                idx++;
                String temp = decodeString(s);
                for (int i = 0; i < currVal; i++)
                    currString.append(temp);
                currVal = 0;
            } else if (c == ']') {
                idx++;
                return currString.toString();

            } else if (Character.isLetter(c)) {
                currString.append(c);
                idx++;
            }

        }
        return currString.toString();
    }
}

//-----------------------------------

class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        int m = grid.length;
        int n = grid[0].length;
        int numOfIslands = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(grid, i, j, dirs);
                }

        return numOfIslands;
    }

    private void dfs(char[][] grid, int r, int c, int[][] dirs) {
        // base
        if (r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length - 1 || grid[r][c] == '0')
            return;

        // logic
        grid[r][c] = '0';
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc, dirs);
        }
    }
}

//-------------------------------------