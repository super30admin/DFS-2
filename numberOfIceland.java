class Solution {
    private class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x= x;
            this.y=y;
        }
    }
    /*Treat given matrix as graph and find no of connected components
    Element with value 1 as vertex and  adjacent vertices with value 1 as neighbors*/
    int [][] dirs;
    int rows, cols;
    public int numIslands(char[][] grid) {
        //edge case
        if(grid == null || grid.length == 0)
            return 0;
        //dirs array
        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        //rows and columns
        rows = grid.length;
        cols = grid[0].length;
        int numOfIslands = 0;
        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
                if(grid[i][j] == '1'){
                    //numIslandsBFSUtil(grid, i, j);
                    numIslandsDFSUtil(grid, i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    //check if x and y is within boundary
    private boolean isValidIndex(int x, int y){
        return x>=0 && x< rows && y>=0 && y< cols;
    }
    /*Time Complexity: O(M*N), where M is number of rows and N is number of columns
      Space Complexity: O(Min(M,N)),  where M is number of rows and N is number of columns. */
    private void numIslandsBFSUtil(char [][]grid, int i, int j){
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(i,j));
        grid[i][j]= '2';
        while(!q.isEmpty()){
            Pair p = q.remove();
            //process all the neighbors of current cell
            for(int [] dir : dirs){
                int newX= p.x + dir[0];
                int newY= p.y + dir[1];
                //check if it is within the range
                if(isValidIndex(newX, newY) && grid[newX][newY] == '1'){
                    q.add(new Pair(newX,newY));
                    grid[newX][newY]= '2';
                }
            }
        }
    }
    /*
    Time Complexity: O(M*N), where M is number of rows and N is number of columns
    Space Complexity: O(M*N),  where M is number of rows and N is number of columns.
    */
    private void numIslandsDFSUtil(char [][]grid, int i, int j){
        if(!isValidIndex(i,j) || grid[i][j] != '1')
            return;
        grid[i][j] = '2';
        //Recursively process neighbors of current cell
        for(int [] dir : dirs){
            int newX= i + dir[0];
            int newY= j + dir[1];
            numIslandsDFSUtil(grid,newX,newY);
        }
    }
}

