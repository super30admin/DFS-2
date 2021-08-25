class Solution {
    public int numIslands(char[][] grid) {
        //We need to initiate a BFS from all land pieces
        // so that land gets accumulated together.
        int islands = 0;
        //base case
        if(grid==null || grid.length==0){
            return islands;
        }
        
        //Logic
        Queue<int[]> q = new LinkedList<>();
        //Detect first 1's/Land 
        int r = grid.length;
        int c = grid[0].length;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]=='1'){
                    islands++;
                    grid[i][j]='0';
                    q.add(new int[] {i,j});
                    while(!q.isEmpty()){
                        // islands++;
                        int s = q.size();
                        for(int k=0; k<s; k++){
                            int[] coords = q.poll();
                            //Now check the neighbors to find out 1's or 0's
                            for(int[] dir : dirs){
                                int row = coords[0]+dir[0];
                                int col = coordsa[1]+dir[1];
                                if(row>=0 && col>=0 && row<r && col<c && grid[row][col]=='1'){
                                    q.add(new int[] {row,col});
                                    grid[row][col]='0';
                                }
                              }
                        }
                    }
                }
            }
        }
        return islands;
    }
}