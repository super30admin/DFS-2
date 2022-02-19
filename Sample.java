//number of islands
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int result;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        result = 0;
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '2';
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }
    int[][] dirs = {{0,1}, {0,-1},{-1,0},{1,0}};
    private void dfs(char[][] grid, int row, int column) {
        int r = row;
        int c = column;
        for(int[] dir : dirs) {
            int nR = dir[0] + r;
            int nC = dir[1] + c;
            if(nR >= 0 && nC >= 0 && nR < m && nC < n && grid[nR][nC] == '1') {
                grid[nR][nC] = '2';
                dfs(grid, nR, nC);
            }
        }
    }
}

//decode string
// Time Complexity : O(k*N)
// Space Complexity : O(k*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        
        int num = 0;
        StringBuilder currentString = new StringBuilder();
        
        Stack<Integer> numberStack = new Stack();
        Stack<StringBuilder> stringStack = new Stack();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if(c == '[') {
                numberStack.push(num);
                stringStack.push(currentString);
                
                num = 0;
                currentString = new StringBuilder();
                
                
            } else if(c == ']') {
                int times = numberStack.pop();
                StringBuilder newString = new StringBuilder();
                
                for(int k = 0; k < times; k++) {
                    newString.append(currentString);
                }
                StringBuilder parent = stringStack.pop();
                currentString = parent.append(newString);
            } else {
                currentString = currentString.append(c);
            }
        }
        return currentString.toString();
    }
}