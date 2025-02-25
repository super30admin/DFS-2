class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> queue= new LinkedList<>();
        int m = grid.length;
        int n= grid[0].length;
        int count =0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='0') continue;
                if(grid[i][j]=='2') continue;
                if(grid[i][j]=='1') count++;
                queue.add(new int[]{i,j});

                while(!queue.isEmpty()){
                    int[] curr= queue.poll();
                    for(int[] dir:dirs){
                        int nr= curr[0]+dir[0];
                        int nc= curr[1]+dir[1];
                        if(nr>=0 && nr< m && nc >=0 && nc<n && grid[nr][nc]=='1'){
                            grid[nr][nc]='2';
                            queue.add(new int[]{nr,nc});
                        }
                    }
                }

            }
        }
        return count;
    }
}