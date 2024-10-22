// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// using BFS find 1s put to queue change to 0 process it take nbr 1 count increase

// tc-O(m*n) + (m*n) because in first loop we are not callig bfs everytime, imagine if all are 1 then bfs get called only
// once hence 2m*n; for SC-O(min of m,n) because at max q will have as many elemnets as a diagnal
class Solution {
    int m;
    int n;
    int[][] dirs;
    public int numIslands(char[][] grid) {

        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        int count = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){//traverse through matrix. 
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){//look for 1
                    count++;//if 1 found count add
                    //--------bfs----------------
                //     q.add(new int[]{i,j});//add 1 index to queue
                //     grid[i][j] = '0';//make that 1 to 0
                //     while(!q.isEmpty()){ // start bfs 
                //         int[] curr = q.poll();//take out value from q
                //         for(int[] dir : dirs) {//traverse its 4 dir
                //         int r = dir[0] + curr[0];
                //         int c = dir[1] + curr[1];

                //         if(r >=0 && c >= 0 && r< m&& c<n && grid[r][c] == '1'){ //check for inbound

                //         q.add(new int[]{r, c});//add new node to q
                //         grid[r][c] = '0';// keep making them 0
                //         }
                //          }
                //     }
                // }


                //-----------dfs-----------

                dfs(grid,i,j);
            }
        }
        }

        return count;
        
    }
//TC- m*n same as bfs, SC will be m*n imagine in all 1 scenario it will use stack for all 1s, 
// stack will hold all index values using dirs right left up down in worst case
    private void dfs(char[][] grid, int i, int j){
       
       if(i <0 || j< 0 || i>= m || j>= n || grid[i][j] != '1' ) return; 
        grid[i][j] = '0';
        for(int[] dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;

            dfs(grid, r, c);
        }

   }

}