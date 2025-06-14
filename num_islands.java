// time complexity -> O(m*n)
// Space Complexity -> O(m*n)
class Solution {
    public int numIslands(char[][] grid) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    helper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void helper(char[][] grid, int r, int c){
        //base case
        if(grid[r][c] == '0') return;
        grid[r][c] = '0';
        // logic
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] dir : dirs){
            int newR = r + dir[0];
            int newC = c + dir[1];
            if(newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length){
                helper(grid, newR,newC);
            }
        }
    }
}
