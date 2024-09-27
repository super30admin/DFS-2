//BFS

class Solution {

    // Time Complexity : 0(m*n) where m is the row and n is the columns
// Space Complexity : For BFS- 0(min(m,n). For DFS- 0(m*n) where m is the row and n is the column
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    public int numIslands(char[][] grid) {
        Queue<int[]> q = new LinkedList<>(); //I declared a queue to store the indices of 1's encountered
        int [][] direction = new int [][]{{1,0}, {0,1}, {-1,0}, {0,-1}}; // direction array to navigate in 4 directions
        int m = grid.length;    //total rows
        int n = grid[0].length;     //total columns
        int islands = 0;        // count the total no. of islands
        for(int i = 0; i < m; i++){     //navigate through each element searching for occurence of 1
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){          //adding the occurence of 1 in queue
                    grid[i][j] = '0';           //changing it to 0 once added in the queue so that we dont revisit it
                    q.add(new int[] {i,j});
                    islands++;                  //incrementing island for occurence of 1
                    while(!q.isEmpty()){
                        int[] current = q.poll();       //removing 1st element from queue
                        for(int [] dir : direction){        //checking for 1's in all 4 directions
                            int r = current[0] + dir[0];
                            int c = current[1] + dir[1];
                            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){//if its a valid index and 1 is found
                                grid[r][c] = '0';       //changing it to 0 so that the index is not repeated and also the while loop wont stop if all surronding areas are water or 0
                                q.add(new int[] {r,c});
                            }
                        }
                    }
                }
            }
        }
        return islands; //returning the total islands found
    }
}

//DFS

class Solution {
    int [][] direction;
    int islands, m, n;
    public int numIslands(char[][] grid) {
        direction = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        islands = 0;
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(char [][] grid, int row, int column){
        if(row < 0 || row == m || column < 0 || column == n || grid[row][column] != '1'){
            return;
        }
        grid[row][column] = '0';
        for(int [] dir: direction){
            int r = row + dir[0];
            int c = column + dir[1];
            dfs(grid, r, c);
        }

    }
}