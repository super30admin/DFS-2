import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '2';
                    q.add(new int[]{i, j});

                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1') {
                                grid[nr][nc] = '2';
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}