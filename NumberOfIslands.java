//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class NumberOfIslands {
    int count;
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

    public int numIslands(char[][] grid) {
        this.count = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i< grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    grid[i][j] = 0;
                    q.offer(new int[]{i,j});

                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        int x = curr[0];
                        int y = curr[1];

                        for(int[] dir: dirs) {
                            int newX = dir[0] + x;
                            int newY = dir[1] + y;

                            if(newX >= 0 && newY >= 0 && newX <= grid.length - 1 && newY <= grid[0].length-1 && grid[newX][newY] != '0') {
                                q.offer(new int[]{newX,newY});
                                grid[newX][newY] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
