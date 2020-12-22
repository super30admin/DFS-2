/*
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        
        rows = len(grid)
        cols = len(grid[0])
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        
        
        def dfs(grid, row, col):
            if row > rows - 1 or row < 0 or col > cols - 1 or col < 0 or grid[row][col] == "2" or grid[row][col] == "0":
                return
            
            grid[row][col] = "2"
            for r,c in dirs:
                newRow = row + r
                newCol = col + c
                dfs(grid, newRow, newCol)
                
        count = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == "1":
                    count += 1
                    dfs(grid, i, j)
                    
        return count



class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        
        rows = len(grid)
        cols = len(grid[0])
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        q = collections.deque()
        count = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == "1":
                    count += 1
                    grid[i][j] = '2'
                    q.append((i,j))
                    while len(q) > 0:
                        curRow, curCol = q.popleft()
                        for r,c in dirs:
                            newRow = r + curRow
                            newCol = c + curCol
                            if newRow >= 0 and newRow < rows and newCol >= 0 and newCol < cols and grid[newRow][newCol] == '1':
                                grid[newRow][newCol] = '2'
                                q.append((newRow, newCol))
                    
        return count
*/

/*
class Solution {
    int rows, cols;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int row, int col){
        if (row < 0 || row > rows -1 || col < 0 || col > cols-1 || grid[row][col] != '1')
            return;
        
        grid[row][col] = '2';
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] d: dirs){
            int newRow = row + d[0];
            int newCol = col + d[1];
            dfs(grid, newRow, newCol);
        }
        
    }
}
*/

// Time Complexity : O(rows * cols)
// Space Complexity : O(min(rows, cols)) as at one point of time there will only be min(rows, cols) present inside queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I maintained a queue and started bfs with first 1 

class Solution {
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        Queue <int[]> q = new LinkedList<>();
        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (grid[i][j] == '1'){
                    grid[i][j] = '2';
                    q.add(new int[]{i,j});
                    count ++;
                    while (!q.isEmpty()){
                        int[] cur = q.poll();
                        for (int[] d:dirs){
                            int newRow = cur[0] + d[0];
                            int newCol = cur[1] + d[1];
                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1'){
                                grid[newRow][newCol] = '2';
                                q.add(new int[]{newRow, newCol});
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
    
    
}