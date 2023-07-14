import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {

    int[][] dirs = new int[][]{{0,1}, {0, -1}, {-1, 0}, {1, 0}};

    //BFS
    //Time Complexity: O(M X N)
    //Space Complexity: O(M X N)
    public int numIslandsBFS(char[][] grid){
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i =0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    queue.offer(i);
                    queue.offer(j);
                    while(!queue.isEmpty()){
                        int r = queue.poll();
                        int c = queue.poll();
                        for(int[] dir: dirs){
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                queue.offer(nr);
                                queue.offer(nc);
                            }
                        }
                    }
                    count++;
                }
            }
        }

        return count;
    }
    //DFS
    //Time Complexity: O(M X N)
    //Space Complexity: O(M X N)
     public int numIslandsDFS(char[][] grid) {
         int count = 0;
         for(int i = 0; i < grid.length; i++){
             for(int j = 0; j < grid[0].length; j++){
                 if(grid[i][j] == '1'){

                     helper(grid, i, j);
                     count++;
                 }
             }
         }

         return count;

     }
     private void helper(char[][] grid, int r, int c){
         //base case
         if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
             return;
         }

         //logic
         grid[r][c] = '0';
         for(int[] dir: dirs){
             helper(grid, r + dir[0], c + dir[1]);
         }
     }
}
