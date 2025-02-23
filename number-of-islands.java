// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:BFS approach, here first start from where i encounter 1 by inserting them into queue ,incrementing count and making corresponding positin as 2 to make visited,parallely while queue is not empty i am just taking adjacent ones and making them as 2 as well to mark them visited as we did in outer loop.

class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int count=0;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    q.add(new int[]{i,j});
                    count++;
                    grid[i][j]='2';
                    while(!q.isEmpty()){
                        int[] current =q.poll();
                        for(int[] dir:dirs){
                            int nr=current[0]+dir[0];
                            int nc=current[1]+dir[1];
                            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1'){
                                q.add(new int[]{nr,nc});
                                grid[nr][nc]='2';
                            }

                        }

                    }
                }
            }
        }
        return count;
    }
}



// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:DFS approach here i start recursion where find 1 then increment count and call recursive function to check adjacents and make them as vissible ,i reapte same process for all chars to find islands.


class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    helper(grid,i,j,dirs);
                }
            }
        }
          return count;
    }
        public void helper(char[][]grid,int i,int j,int[][] dirs){
            if(i<0 || i==grid.length || j<0 || j==grid[0].length || grid[i][j] != '1')return;
            grid[i][j] = '2';
            for(int[] dir:dirs){
                int nr=i+dir[0];
                int nc=j+dir[1];
               helper(grid,nr,nc,dirs);
            }
        }
}