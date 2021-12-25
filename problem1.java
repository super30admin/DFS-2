// 200 Number of Islands
// Solved on leetcode
// Time Complexity : O(n*m)
// Space Complexity : O(Minimum(m,n))


class Solution {
    
    class Pair {
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
        
        int getI(){
            return i;
        }
        
        int getJ(){
            return j;
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        
        return count;
    }
    
    private void bfs(char[][] grid,int i,int j){
       int [][] dirs ={{0,-1},{0,1},{1,0},{-1,0}};
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        grid[i][j]='2';
        
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            
            // grid[temp.getI()][temp.getJ()]='2';
            
            for(int [] view: dirs){
                int row= temp.getI() + view[0];
                int col = temp.getJ() + view[1];
                
                if(row>=0 && row <grid.length && col>=0 && col < grid[0].length && grid[row][col]=='1'){
                    grid[row][col]='2';
                    queue.add(new Pair(row,col));
                }
            }
            
        }
        
        
    }
}