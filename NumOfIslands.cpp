// Time Complexity : O(n*m) as we are travellig throught all the elements in the given matrix.
// Space Complexity : O(1) if we do not consider recursive stack. o(n*m) with recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning



class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
       if(grid.size() == 0) return 0;
        
        int count = 0;
        
        for (int i = 0; i <grid.size() ; i++){
            
            for ( int j = 0; j < grid[0].size(); j++){// traversing throught the matrix for all the possible 1's i.e. islands
                if (grid[i][j] == '1'){
                    
                    recurr(grid,i,j); // recursion
                    count +=1; // count of posible islands
                }
            }
        }
        return count;
    }
    
    vector<vector<int>> directions = {{0,1},{0,-1},{1,0},{-1,0}};
    
    void recurr(vector<vector<char>>& grid , int i, int j){
        
        grid[i][j] = '0'; // updating the travelled island to 0 inorder to make sure we do not travel again
        

        for(vector<int> dir:directions){
            
            int r = i + dir[0];
            int c = j + dir[1];
            
            
            if( r>=0 && r<grid.size() && c >=0 && c <grid[0].size() && grid[r][c] == '1'){ // checking out of bounds and also the neighbour island.
                recurr(grid,r,c); // recursion
            }
        }
        
        
    }
};