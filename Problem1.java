// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem1 {
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int islands = 0;
        if(grid == null ) return islands;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    grid[i][j] ='2';
                    islands++;
                    dfsHelper(grid,i,j);
                }
            }
        }
        return islands;
    }

    //TC:O(M*N)
    //SC:O(M*N)
    public void bfsHelper(char[][] grid,int i,int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});

        while(!q.isEmpty()){

            int size = q.size();
            for(int k=0;k<size;k++){
                int[]  curr = q.poll();
                for(int[] dir:dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] !='2'){

                        if(grid[r][c] == '1'){
                            q.add(new int[]{r,c});
                        }
                        grid[r][c] = '2';
                    }
                }
            }

        }
    }
    //TC:O(M*N)
    //SC:O(M*N)
    public void dfsHelper(char[][] grid,int i,int j) {


        for(int[] dir:dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] =='1'){

                grid[r][c] = '2';
                dfsHelper(grid,r,c);
            }
        }

    }
}