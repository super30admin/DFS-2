/*

Intuition: Consider the problem as a connected component problem. This problem can be done in both bfs and dfs manner.
To avoid visiting a node again, change its state.
//////////////////////////////
BFS Time Complexity: O(2*MxN) = O(MxN) 
BFS Space Complexity: O(min(row, cols))
//////////////////////////////
DFS Time Complexity: 
DFS Space Complexity:

*/
//BFS
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        
        int islands = 0;
        vector <pair<int,int>> queue; 
        vector <vector<int>> dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        
        int rows = grid.size();
        int cols = grid[0].size();
        cout <<rows << cols;
        for (int i = 0; i < rows; i++){
            for(int j = 0; j <cols; j++){
                cout << grid[i][j]<< endl;
                if (grid[i][j] == '1'){                    
                    islands += 1;
                    grid[i][j] = '0';
                    queue.push_back({i,j});
                    while (queue.size() != 0){
                    
                        pair <int, int> currentIsland = queue.front();
                        queue.erase(queue.begin());
                        int currentI = currentIsland.first;
                        int currentJ = currentIsland.second;
                        
                        for (auto dir: dirs){
                            int newI = currentI + dir[0];
                            int newJ = currentJ + dir[1];
                            if (newI >= 0 and newI < rows and newJ >=0 and newJ <cols and grid[newI][newJ] == '1' ){
                                  
                                grid[newI][newJ] = '0';
                                queue.push_back({newI,newJ});
                            }
                        }
                    
                    }
                
                }
            
            }
        
        }
        
        
        
        return islands;
        
    }
};

//DFS
class Solution {
public:
    vector <vector<int>> dirs;
    int numIslands(vector<vector<char>>& grid) {
        int islands = 0;
        dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        
        int rows = grid.size();
        int cols = grid[0].size();
        cout <<rows << cols;
        for (int i = 0; i < rows; i++){
            for(int j = 0; j <cols; j++){
                cout << grid[i][j]<< endl;
                if (grid[i][j] == '1'){                    
                    islands += 1;
                    grid[i][j] = '0';
                    dfs(grid, i, j,  rows,  cols);
                    
                
                }
            
            }
        
        }
        
        return islands;
        
    }
    
    void dfs(vector<vector<char>>& grid, int currI, int currJ, int rows, int cols){

        for (auto dir: dirs){
            int newI = currI + dir[0];
            int newJ = currJ + dir[1];
            if (newI >= 0 and newI < rows and newJ >=0 and newJ <cols and grid[newI][newJ] == '1' ){
                grid[newI][newJ] = '0';
                dfs(grid, newI, newJ, rows, cols);
            }
        }

    
    }
};