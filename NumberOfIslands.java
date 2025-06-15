// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : iterate through the entrie matrix and if any cell has 1, find all neighbors that are 1s 
// (traverse using bfs (can do using dfs too), maintain a queue and add locations of 1s to queue, after 
// adding to queue make it a 1). Return the number of times we perform bfs/dfs, that's the number of islands  
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length, cols = grid[0].length;
        int directions[][] = new int[][]{{-1,0}, {0, 1}, {1,0}, {0,-1}};
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    Queue<Integer> q = new LinkedList<Integer>();
                    q.add(i);
                    q.add(j);
                    count++;
                    while(!q.isEmpty()){
                        int currRow = q.poll();
                        int currCol = q.poll();
                        for(int dir[]: directions){
                            int newRow = dir[0]+currRow;
                            int newCol = dir[1]+currCol;
                            if(newRow>=0 && newCol>=0 && newRow<rows && newCol<cols && grid[newRow][newCol]=='1'){
                                q.add(newRow);
                                q.add(newCol);
                                grid[newRow][newCol] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
