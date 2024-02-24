// Time Complexity : O(m*n)
//Space Complexity : O(m*n)

class Solution {
    public int numIslands(char[][] grid) {
        Queue<int []> queue = new LinkedList<>();
        if(grid.length == 0) {
            return 0;
        }
        int [][]dirs = {{0,1},{0,-1}, {1,0}, {-1,0}};
        int count =0;
        for(int i =0; i<grid.length;i++) {
            for(int j =0; j<grid[0].length;j++) {
                if(grid[i][j] == '1') {
                      queue.add(new int[] {i,j});
                      grid[i][j] = '0';
                      count++;
                }
                while(!queue.isEmpty()) {
                int []curr = queue.poll();
                for(int []dir : dirs) {
                    int r = curr[0]+dir[0];
                    int c = curr[1]+dir[1];
                    if(r >=0 && c>=0 && c<grid[0].length && r<grid.length && grid[r][c] == '1') {
                        grid[r][c] = '0';
                        queue.add(new int[] {r,c});
                    }
                }

            }
        }
        }
        return count;
    }
}