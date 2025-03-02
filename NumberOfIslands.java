

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
I iterate over the given matrix. I find the first '1' and start BFS from there, cover all the adjacent '1's close to it.
All the blocks covered are made 0. After BFS ends using outer for loop go to the next 1 and start BFS from there.
Keep a variable for number of islands. Whenever we find a 1 in outer loop, increase this varibale by 1.
*/
/*
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] dirs=new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    //bfs
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j]='0';
                    while(!q.isEmpty()){
                        int[] q1=q.poll();
                        int currx=q1[0];
                        int curry=q1[1];
                        for(int[] dir:dirs){
                            int nx=dir[0]+currx;
                            int ny=dir[1]+curry;
                            if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]=='1'){
                                grid[nx][ny]='0';
                                q.add(new int[]{nx,ny});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
*/
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] dirs=new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(dirs,grid,m,n,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] dirs,char[][] grid,int m, int n, int i, int j){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        for(int[] dir:dirs){
            dfs(dirs,grid,m,n,i+dir[0],j+dir[1]);
        }
    }
}
