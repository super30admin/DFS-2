/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(1) - no extra space
 * Idea:
 * 1. Visit every point. Proceed dfs if '1' (island) alonf 4 directtions. 
 * 2. Mark visited point as '0'. Increment count for every newly visited island
 * 3. return result
 * 
 * Leetcode: Yes
 */


class CountIslands {

    public int numIslands(char[][] grid) {

        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i,j);
                }
                
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        // base
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] == '0') return;

        grid[i][j] = '0';
        
        // dfs to 4 dirs
        dfs(grid, i+1, j); 
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);  
    }   
}

class Solution {
    public static void main(String[] args){
        System.out.println("Count Islands");
        CountIslands obj = new CountIslands();
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
        };

        System.out.println(obj.numIslands(grid));
    }   
}