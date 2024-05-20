// Problem 1: https://leetcode.com/problems/number-of-islands/
// Time Complexity : O(m*n) where m is the number of rows and n is the number of columns in the grid
// Space Complexity : O(m*n) where m is the number of rows and n is the number of columns in the grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: I have used DFS to solve this problem. I have used a dirs array to traverse in all 4 directions. I have iterated through the grid and whenever I find a '1', I increment the count and call the dfs function. In the dfs function, I change the value of the cell to '0' and then check in all 4 directions if there is a '1' and call the dfs function recursively. This way I will be able to find the number of islands in the grid.
class Solution {
    int[][] dirs;
    int m, n;

    public int numIslands(char[][] grid) {
        this.dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        this.m = grid.length;
        this.n = grid[0].length;
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

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                dfs(grid, nr, nc);
            }
        }
    }
}

// Problem 2: https://leetcode.com/problems/decode-string/
// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(n) where n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: I have used a
// recursive approach to solve this problem. I have used a global variable i to
// keep track of the index in the string. I have used a while loop to iterate
// through the string. I have used a currNum variable to keep track of the
// number of times the string has to be repeated. I have used a currStr variable
// to keep track of the current string. Whenever I encounter a digit, I multiply
// the currNum by 10 and add the digit to it. If I encounter a '[', I
// recursively call the decodeString function. If I encounter a ']', I return
// the currStr. If I encounter a character, I append it to the currStr. This way
// I will be able to decode the string.
class Solution {
    int i = 0;

    public String decodeString(String s) {
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            } else if (c == '[') {
                String baby = decodeString(s);
                for (int k = 0; k < currNum; k++) {
                    currStr.append(baby);
                }
                currNum = 0;
            } else if (c == ']') {
                return currStr.toString();
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}