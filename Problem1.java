// Time Complexity : O(N * M), where N is the number of rows and M is the number of columns in the grid
// Space Complexity : O(N * M), for the queue used in BFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



//I use a queue to perform BFS and explore all connected land cells starting from each unvisited land cell.
//I increment the island count whenever I encounter a new unvisited land cell.
//I mark a cell as visited by setting its value to '0', preventing it from being counted again.


class Solution {
    //BFS
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        int dirs[][]=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        Queue<int[]> q=new LinkedList<>();
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    q.add(new int[]{i,j});
                    grid[i][j]='0';

                    while(!q.isEmpty()){
                        int[] curr=q.remove();
                        for(int dir[]:dirs){
                            int r=curr[0]+dir[0];
                            int c=curr[1]+dir[1];
                            if(r>=0&&c>=0&&r<n&&c<m&&grid[r][c]=='1'){
                                q.add(new int[]{r,c});
                                grid[r][c]='0';
                            }
                        }
                    }
                }
                
            }
        }
        return count;
    }
}