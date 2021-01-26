// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count=count+1;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid,int i,int j){
        if(i<0 || i>=grid.length ||j<0 || j>=grid[0].length || grid[i][j]!='1'){
            return;
        }
        grid[i][j]='2';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        
    }
}


//BFS
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        Queue<int[]> qu=new LinkedList<int[]>();
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count=count+1;
                    qu.add(new int[]{i,j});
                    while(!qu.isEmpty()){
                        int size=qu.size();
                        for(int k=0;k<size;k++){
                            int[] curr=qu.remove();
                            for(int[] dir:dirs){
                                int row=curr[0]+dir[0];
                                int col=curr[1]+dir[1];
                                if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]=='1'){
                                    qu.add(new int[]{row,col});
                                    grid[row][col]='2';
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}