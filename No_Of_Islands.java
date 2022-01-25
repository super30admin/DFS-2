// Time Complexity : for both DFS & BFS Solution: O(mn)
// Space Complexity : for DFS solution, worst case - O(mn), for BFS solution - O(min(m,n))
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class No_Of_Islands {

    int[][] dirs;
    int count; int m; int n;
    public int numIslandsUsingDFS(char[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        count = 0;
        m = grid.length; n = grid[0].length;

        //traverse matrix and call DFS whenever 1 is encountered
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i , j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        //base
        if(r < 0 || c < 0 || r == m || c == n || grid[r][c] == '0') return;

        //logic
        //mutate the element as its visited
        grid[r][c] = '0';

        //iterate on all directions
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc);
        }
    }

    public int numIslandsUsingBFS(char[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        count = 0;
        m = grid.length; n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        //traverse matrix and add position to queue BFS whenever 1 is encountered
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    //bfs
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir: dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];

                            if(nr >= 0 && nc >= 0
                                    && nr < m && nc < n
                                    && grid[nr][nc] == '1'){
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println("Total no. of islands : " + new No_Of_Islands().numIslandsUsingDFS(input));
        System.out.println("Total no. of islands : " + new No_Of_Islands().numIslandsUsingBFS(input));
    }
}
