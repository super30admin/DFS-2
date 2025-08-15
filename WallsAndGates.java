
//BFS Solution
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

class Solution {
    int[][] dirs = {{1,0}, {0,1},{-1,0},{0,-1}};
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int[] dir: dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];

                if(nr >= 0 && nr < m && nc >=0 && nc < n && rooms[nr][nc] == 2147483647){
                    q.add(new int[]{nr, nc});
                    rooms[nr][nc] = rooms[curr[0]][curr[1]] +1;
                    

                }
            }
        } 
    }
}

//DFS Solution - Gives Time Limit Exceeded
//BFS is naturally suited for shortest path problems because it explores level-by-level (distance-by-distance).
//DFS, on the other hand, dives deep into one path, which often isn't the shortest.

class Solution {
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j] == 0){
                    dfs(rooms, i, j, 0);
                }
            }
        } 
    }

    public void dfs(int[][] rooms, int r, int c, int distance){
        if(r <0 || r>=rooms.length || c <0 || c>=rooms[0].length)
            return;

        if(rooms[r][c] < distance)
            return;

        rooms[r][c] = distance;

        for(int[] dir : dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            dfs(rooms, nr, nc, distance+1);
        }
    } 
}