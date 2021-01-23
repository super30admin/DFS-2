// Time Complexity : The time complexity is O(m*n) where m is the number of rows and n is the number of columns.
// Space Complexity : The space complexity is O(m*n) where m is the number of rows and n is the number of columns.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {

        if(grid == null || grid[0] == null){
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int count=0;

        for(int i=0;i<rows;i++){

            for(int j=0;j<columns;j++){

                if(grid[i][j] == '1'){
                    // 1 bfs represents 1 island
                    bfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;

    }

    public void bfs(char[][] grid,int i,int j){

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        q.offer(j);
        grid[i][j] = '2';

        // traverse through all the 4 neighbours of an island
        while(!q.isEmpty()){

            int row = q.poll();
            int column = q.poll();

            for(int[] dir:dirs){

                int newRow = row + dir[0];
                int newColumn = column + dir[1];

                if(newRow >=0 && newRow < grid.length && newColumn >=0 && newColumn <  grid[0].length && grid[newRow][newColumn] == '1'){
                    q.offer(newRow);
                    q.offer(newColumn);
                    grid[newRow][newColumn] = '2';
                }
            }

        }

    }
}