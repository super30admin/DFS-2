//Que : Count no of islands 
//TC:  O(m*n)
//SC: O(m*n)
//Idea: Do DFS traversal wherever we find a 1, the no of disconnected 1s will be equal to no of times we do a depth first search




class Solution {
public:
    int m,n;
    
    
    int numIslands(vector<vector<char>>& grid) {
        int count=0;
        m = grid.size();
        n = grid[0].size();
        
        for(int i=0; i< m; i++){
            for(int j=0; j< n ; j++){
              
                if(grid[i][j] == '1'){
                    cout<< "starting dfs " << i << j <<endl;
                    dfs(grid,i,j);
                    count ++;
                }    
            }
        }
       return count;
    }

   
    void dfs(vector<vector<char>> &grid, int row, int col){
        
       
        grid[row][col] = '2';
        if( row >= 0 && row < m && col-1 >=0 && col-1 <n && grid[row][col-1] == '1'  ){
            dfs( grid,row, col-1 );
        }
        if( row >= 0 && row < m && col+1 >=0 && col+1 <n && grid[row][col+1] == '1'  ){
            dfs( grid,row, col+1 );
        }
        if( row-1 >= 0 && row-1 < m && col >=0 && col <n && grid[row-1][col] == '1'  ){
            dfs( grid,row-1, col );
        }
        if( row+1 >= 0 && row+1 < m && col >=0 && col <n && grid[row+1][col] == '1'  ){
            dfs( grid,row+1, col );
        }
    }
    
    
};


