// have to find a way that you don't put the duplicates in, here i'm putting '0' the moment i visit a 1 so that we keep track of visited 
// idea is to perform BFS on every occurance of 1 inside the BFS we are making every adjacent 1 as 0 
// this way we can accurately identify the island
// in BFS the type of elements in Queue can be array, or you can use two Queues for row and column
//  tc: o(m * n)
// consider case of [1 1 1 
//                   1 1 1 
//                   1 1 1] and
//                    1
//                    1
//                    1
 //                   1
 //  because at any given time the no. of elements in queue is  MIN of o(m, n) sc is -> MIN of o(m, n)
 // we can see that overall BFS approach is better. interms of space complexity BFS is better and in terms of tc dfs and bfs approaches have same
 
class Solution {
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        int total = 0;
        dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    q.add(new int[] {i, j});
                    grid[i][j] = '0';
                    total++; //observe that we increment total here itself
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        for(int[] dir : dirs) {
                            int r = dir[0] + cur[0];
                            int c = dir[1] + cur[1];
                            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                                grid[r][c] = '0';
                                q.add(new int[] {r, c});
                            }
                     }
                    }
                }
            }
        }
        return total;
    }
}