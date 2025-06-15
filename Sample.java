// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') { // Corrected: compare with character '1'
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        // base condition for boundary checks and water
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') { // Corrected
                                                                                                          // boundary
                                                                                                          // check and
                                                                                                          // water check
            return;
        }
        grid[row][col] = '0'; // Corrected: mark as visited by changing '1' to '0'
        // recursively call in 4 directions
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}

//
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numstack = new Stack<>();
        Stack<StringBuilder> strstack = new Stack<>();
        int num = 0;
        StringBuilder curr = new StringBuilder();
        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numstack.push(num);
                strstack.push(curr);
                num = 0;
                curr = new StringBuilder();
            } else if (c == ']') {
                int k = numstack.pop();
                StringBuilder prev = strstack.pop();
                for (int i = 0; i < k; i++)
                    prev.append(curr); // prev += curr * k
                curr = prev;
            } else {
                curr.append(c);
            }

        }
        return curr.toString();

    }
}