class Solution {
    public int numIslands(char[][] grid) {
        //for all 1's in matrix
        //perform bfs and increase count
        //in bfs set 1's to 0
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    Queue<int []> q = new LinkedList<>();
                    q.add(new int[] {i,j});
                    grid[i][j]= '0';
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int [] d: dir){
                            int nr = d[0] + curr[0];
                            int nc = d[1] + curr[1];
                            if(nr>=0 && nc >=0 && nr< m && nc < n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int[] {nr,nc});
                            }
                        }
                        
                    }
                }
            }
        }
        return count;
    }
}