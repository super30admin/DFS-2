// Time Complexity : O(mn)+O(mn) =O(mn)
// Space Complexity :O( min(m,n) ) -> max at Diagonal
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Using BFS: Queue
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; //rows
        int n = grid[0].length; //columns
        int[][] dirs = new int[][]{{0,1}, {0,-1} , {1,0}, {-1,0}};
        int count=0;
        Queue<int []> q= new LinkedList<>();
        for (int i =0 ; i<m;i++){ //O(mn)
            for (int j=0 ; j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    q = new LinkedList<>(); //creating new queue each time for each new group/islands
                    q.add(new int[]{i,j}); //adding inital '1' loaction 
                    grid[i][j] ='0'; 
                    while(!q.isEmpty()){ //O(mn)
                        int[] curr = q.poll();
                        for (int[] dir:dirs){
                            int nr = curr[0]+dir[0];
                            int nc = curr[1]+dir[1];
                            if( nr>=0 && nc >=0 && nr < m && nc < n && grid[nr][nc]=='1'){
                                q.add(new int[]{nr,nc}); // adding connecting '1' to above location/ Neighboring 1's : island
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
    return count;
    }
}


// Time Complexity : O(mn) + O(mn) = O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Using DFS
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; //rows
        int n = grid[0].length; //columns
        int[][] dirs = new int[][]{{0,1}, {0,-1} , {1,0}, {-1,0}};
        int count=0;
        Queue<int []> q= new LinkedList<>();
        for (int i =0 ; i<m;i++){ // O(mn)
            for (int j=0 ; j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i,j,dirs,m,n);
                }
            }
        }
    return count;
    }

    private void dfs(char[][] grid, int i , int j , int[][] dirs, int m, int n){ // O(mn)
        //base 
        if(i<0 || j<0 || i==m ||j==n || grid[i][j]=='0' ) return; //inbounds

        //logic
        grid[i][j]='0';
        for (int[] dir : dirs){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            dfs(grid, nr,nc,dirs,m,n);
        }

    }
}