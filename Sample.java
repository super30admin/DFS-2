//PROBLEM 1
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {

    private int m;

    private int n;

    public int numIslands(char[][] grid) {

        //edge case

        m = grid.length;

        if(grid == null || m == 0) return 0;

        n = grid[0].length;

        int count = 0;

 

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(grid[i][j] == '1'){

                    count++;    

                    dfs(grid, i, j);

                }

            }

        }

        return count;

    }

    private void dfs (char[][] grid, int i, int j){

        // base case

        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;

        int[][] dirs = new int [][] {{0,1},{1,0}, {-1,0},{0,-1}};

        grid[i][j] = '0';

        for(int[] dir: dirs){

            int r = i+dir[0];

            int c = j+dir[1];

             dfs(grid,r,c);

        }

    }

}

//PROBLEM 2
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    int position = 0;
    public String decodeString(String s) {
       return recursive(s);
    }

    private String recursive(String s){
        StringBuilder result = new StringBuilder();
        int num = 0;

        while (position < s.length()) {
            char ch = s.charAt(position);

            if (Character.isDigit(ch)) {
                num = num * 10 + Character.getNumericValue(ch);
                position++;
            } else if (ch == '[') {
                position++; 
                String encoded_string = recursive(s); 
                int count = num;
                 while (count > 0) {
                      result.append(encoded_string); 
                      count--;
                 }
                num = 0; 
            } else if (ch == ']') {
                position++; 
                return result.toString();
            } else {
                result.append(ch);
                position++;
            }
         }
         return result.toString();
    }
}