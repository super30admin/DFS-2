/*
Desc : We iterate through the grid to check if we encounter an island(i.e; 1) if one is encountered
all the connected ones are changed to zero to mark that the island is visited.
Time Complexity : O(n^2)
Space Complexity : O(m*n)
*/

class Solution {
    
    public int numIslands(char[][] grid) {
        //base
        if(grid == null || grid.length==0 || grid[0].length==0 || grid[0]==null) return 0;
        int dirs[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int []> q = new LinkedList<>(); 
        int n = 0;
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    n++;
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int curr[] = q.poll();
                        for(int dir[]:dirs){
                            int r = curr[0]+dir[0];
                            int c = curr[1]+dir[1];
                            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1'){
                                grid[r][c] = '0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return n;
    }
}
