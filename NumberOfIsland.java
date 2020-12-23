/* Time Complexity : O(M*N)
Space Complexity : O(Min(M,N)) 
Idea : Run bfs from first 1 and keep track of visited nodes.
*/
class Solution {
    public int numIslands(char[][] grid) {
        int num_of_Island = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[] visited = new boolean[row*col+1];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1' && !visited[i*col+j]){
                    num_of_Island++;
                    bfs(grid,i,j,visited);
                }
            }
        }
        return num_of_Island;
    }
    
    public void bfs(char[][] grid,int i,int j,boolean[] visited){
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i*col+j] = true;
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r>=0 && c>=0 && r<row && c<col && grid[r][c] == '1' && !visited[r*col + c]){
                    visited[r*col+c] = true;
                    queue.add(new int[]{r,c});
                }
            }
        }
    }
}