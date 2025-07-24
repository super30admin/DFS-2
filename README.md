# DFS-2

## Problem1 (https://leetcode.com/problems/number-of-islands/)
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
	1.	Iterate through the grid, and whenever we find '1', increment the island count.
	2.	Call DFS to mark all connected '1's as visited (turn them into '#' or any other marker).
	3.	DFS explores all 4 directions recursively and marks the island visited

class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }
    public void dfs(char[][] grid, int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='#' || grid[row][col]=='0') return;

        grid[row][col]='#';
        int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir : direction){
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(grid, r, c);
        }
    }
}

## Problem2 (https://leetcode.com/problems/decode-string/)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
	1.	Traverse the string, and use two stacks : one for numbers and one for substrings.
	2.	On [, push current number and string onto their stacks and reset; on ], pop and repeat the substring accordingly.
	3.	We will build the final decoded string by appending characters and repeated patterns in the correct order.

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> sStack = new Stack<>();

        StringBuilder str = new StringBuilder();
        int currNum = 0;

        for (char c : s.toCharArray()) {
            
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            }

            else if (c == '[') {
                numStack.push(currNum);
                sStack.push(str);
                currNum = 0;
                str = new StringBuilder();
            }


            else if (c == ']') {
                int times = numStack.pop();
                StringBuilder temp = str;
                str = sStack.pop();

                while (times-- > 0) {
                    str.append(temp);
                }
            }

            else {
                str.append(c);
            }
        }

        return str.toString();
    }
}