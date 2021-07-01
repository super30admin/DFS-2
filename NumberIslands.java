/*SC, TC  - O(M*N)
 *
 * */


class Solution {
    int m = 0 ;
    int n = 0 ;
     boolean[][] visited ;
    int[][] dirs = new int [][] {{0,-1}, {-1,0} , {0,1}, {1,0}};
    Queue<int[]> queue = new LinkedList<>();
    public int numIslands(char[][] grid) {
        // BFS
        int count = 0 ;
        m = grid.length;
        n= grid[0].length;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0 ;  i < grid.length; i++){
            for (int j = 0 ; j < grid[0].length;  j++){
                if ((grid[i][j]  == '1') && (visited[i][j] == false)){
                    visited[i][j] = true;
                    queue.add(new int[]{i,j});
                    bfs(grid, queue, i,j);

                    count +=1;
                }
            }

        }
        return count;


    }


    public void bfs(char[][] grid, Queue<int[]> queue , int i, int j){


       while(!queue.isEmpty()){
           int[] curr = queue.poll();
        for (int[] dir : dirs){
            int nr = curr[0] + dir[0];
            int nc = curr[1] + dir[1];
            if (nr < m  && nc < n && nr >= 0 && nc >= 0 && visited[nr][nc] == false && grid[nr][nc] == '1'){
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});


            }
        }
        }


    }
}
