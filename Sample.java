## Problem1 (https://leetcode.com/problems/number-of-islands/)

// Time Complexity : 0(m * n)
// Space Complexity : 0(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }        
    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row == m || col < 0 || col == n || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(grid, nr, nc);
        }
    }     
}

## Problem2 (https://leetcode.com/problems/decode-string/)

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int num = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            else if (c == '[') {
                numStack.push(num);
                strStack.push(currString);
                num = 0;
                currString = new StringBuilder();
            }
            else if (c == ']') {
                int times = numStack.pop();
                StringBuilder newString = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    newString.append(currString);
                }
                currString = strStack.pop().append(newString);
            }
            else {
                currString.append(c);
            }
        }
        return currString.toString();   
    }
}