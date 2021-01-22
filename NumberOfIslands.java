// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : To find all the islands, i.e groups of "1", put all the indices of "1" in a queue. While queue is not empty and the element is not visited, for each "1" in the queue, perform a DFS to find its neighbors and mark all neighbors "2", which signifies that the location is visited and then increment the count. This will find all the distinct "1" groups/island.

public class NumberOfIslands {
    int m; int n;
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        
        m = grid.length;
        n = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1')
                    q.add(new int[]{i, j});
            }
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            if(grid[curr[0]][curr[1]] != '2'){
                count = count + 1;
                dfs(grid, curr[0] ,curr[1]);
            }
        }
          
        return count;
    }
                              
    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || row == m || col < 0 || col == n || grid[row][col] == '2' || grid[row][col] == '0')
            return;
        
        grid[row][col] = '2';
        
        dfs(grid, row, col+1);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row-1, col);
    }
}
