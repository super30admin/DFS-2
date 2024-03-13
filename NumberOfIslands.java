/**
The provided Java code defines a Solution class with a numIslands method that utilizes Breadth-First Search (BFS) to count the number of islands in a 2D binary grid. 
The algorithm iterates through each cell in the grid, and when it encounters unvisited land ('1'), it increments the count, enqueues the cell coordinates, and performs BFS to mark the entire island as visited.
 The final count represents the total number of islands, and it is returned as the result.
The time complexity  O(m * n)
The space complexity is O(min(m, n)),
 */
class Solution {
    public int numIslands(char[][] grid) {
         Queue<Integer> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    q.add(i);
                    q.add(j);
                    while(!q.isEmpty()){
                        int cr = q.poll();
                        int cc = q.poll();
                        for(int [] dir:dirs){
                            int nr = dir[0]+cr;
                            int nc = dir[1]+cc;
                            if(nr>=0 && nc>=0 && nr<m && nc<n &&grid[nr][nc] == '1'){
                                q.add(nr);
                                q.add(nc);
                                grid[nr][nc] = '0';

                            }
                        }
                    }
                }
            }
        }
     
        return cnt;
    }
}