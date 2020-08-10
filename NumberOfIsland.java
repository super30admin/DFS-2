//time complexity:O(n) n=> all nodes in the matrix
//space complexity:O(n)
/*Approach
-going through the matrix
-whenever we encounter 1 we will increase our count and using dfs we will go through all its neighbours
and whenever we will get a 0 we will stop
-at the end we will return count
*/
public class NumberOfIsland{
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null || grid.length == 0){return count;}
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    count += dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    
    private int dfs(char[][] grid,int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')return 0;
        grid[i][j] = '0';
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir : dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            dfs(grid,r,c);
        }
        return 1;
    }

    public static void main(String args[]){
        NumberOfIsland obj = new NumberOfIsland();
        System.out.println(obj.numIslands(new char[][]{  {'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}
      }));
    }
}