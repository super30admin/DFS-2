// Time Complexity :0(mn)
// Space Complexity :0(mn)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: BFS

class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n= grid[0].length;

        Queue<int[]> q= new LinkedList<>();
        int count=0;

        int directions[][]= {{-1,0},{0,-1},{1,0},{0,1}};

        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    q.offer(new int[]{i,j});
                    grid[i][j]='0';

                    while(!q.isEmpty()){
                        int curr[]=q.poll();
                        
                        for(int dir[]:directions){
                            int newR= curr[0]+dir[0];
                            int newC= curr[1]+dir[1];

                            if(newR>=0 && newR<m && newC>=0 && newC<n && grid[newR][newC]=='1'){
                                grid[newR][newC]='0';
                                q.offer(new int[]{newR,newC});
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
}