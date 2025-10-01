/*
- Connected Components so you can either use DFS or BFS for counting the number of islands
- Approach1: BFS
- We scan the grid to find the first land cell
- Once we find the land cell, we use BFS to find all connected land cell as we want to count that as 1 island and mark them as visited so we dont count them again

TC: O(m*n) -> iterate over all the elements in the grid
SC: O(min(m*n)) -> queue to maintain 1s
*/

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // first land cells found
                if(grid[i][j] == '1'){
                    count++;
                    //mark as visited
                    grid[i][j] = '0';

                    q.add(new int[]{i,j});

                    // get all the connected components of the land cell and mark them as visited and consider them as one island
                    while(!q.isEmpty()){
                        int[] curr = q.poll();

                        for(int[] dir : dirs){
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];

                            if(r >= 0 && c>= 0 && r < m && c < n && grid[r][c] == '1'){
                                grid[r][c] ='0';
                                q.add(new int[]{r,c});
                            }  
                        } 
                    }
                }
            }
        }
        return count;
    }
}