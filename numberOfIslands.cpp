// Time Complexity : O(m*n) Need to iterate over the matrix to find teh 1s
// Space Complexity : O(m*n) All numbers could be 1 - we will have all elements in the system stack (or queue in BFS)
// Did this code successfully run on Leetcode : Yes

//Approach 1: DFS

class Solution {
public:
    vector<vector<int>> dirs;
    int result;
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size() == 0)
            return 0;
        
        dirs = vector<vector<int>> ({{-1, 0}, {1, 0}, {0, -1}, {0, 1}});
        result = 0;
        
        //iterating over the grid to find the 1s
        //calling DFS to convert all the 1s to 0s and recursively flip more 1s
        for(int i=0; i<grid.size(); i++)
            for(int j=0; j<grid[0].size(); j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(grid, i, j);
                }
                    
            }
        return result;
    }
private:
    void dfs(vector<vector<char>>& grid, int row, int col){
        //base
        if(grid[row][col] == '0') return;

        //action 
        grid[row][col] = '0';
        //recurse
        for(auto dir:dirs){
            int new_row = row + dir[0];
            int new_col = col + dir[1];
            if(new_row >= 0 && new_row < grid.size() && new_col >= 0 && new_col < grid[0].size() && grid[new_row][new_col] == '1')
                dfs(grid, new_row, new_col);
        }

    }
};


//Approach 2: BFS

// Note: Mark the node that you push into the queue as soon as you visit it and not when you are popping it 
// This is because the same node is being pushed by its neighbours and that increases exponentially 
// One cell cause 2 copies of neighbours, and then 4 copies of neighbours of neighbors etc


class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size() == 0) return 0;
        int result = 0;
        queue<pair<int,int>> q;
        vector<vector<int>> dirs({{-1, 0}, {1, 0}, {0, -1}, {0, 1}});
        int m = grid.size();
        int n = grid[0].size();

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '0';
                    result ++;
                    
                    q.push({i,j});
                    while(!q.empty()){
                        auto coordinates = q.front();
                        q.pop();
                        for(auto dir:dirs){
                            int new_row = coordinates.first + dir[0];
                            int new_col = coordinates.second + dir[1];
                            if(new_row >= 0 && new_row < m && new_col >= 0 && new_col < n && grid[new_row][new_col] == '1' ){
                                grid[new_row][new_col] = '0';
                                q.push({new_row, new_col});
                            }
                                
                        }
                    }
                }
            }
        return result;
    }
};


