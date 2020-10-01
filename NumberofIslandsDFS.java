//TC: O(M*N)
//SC: O(M*N)

//Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Depth First Search. 
//During DFS, every visited node should be set as '0' to mark as visited node. 
//Count the number of root nodes that trigger DFS, this number would be the number of islands since each DFS starting at some root identifies an island.

public class NumberofIslandsDFS {
    public static int numIslands(char[][] grid) {
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i , j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private static void dfs(char[][] grid, int r, int c){
        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1'){
            grid[r][c] = '0';
            
            dfs(grid, r+1, c);
            dfs(grid, r-1, c);
            dfs(grid, r, c+1);
            dfs(grid, r, c-1);
        }
    }

    public static void main(String[] args){
        char[][] image = {{'0','0','0'},{'1','0','0'},{'0','1','1'}};
        System.out.println(numIslands(image));

        
    }
}
