/**
 * Time complexity:
 * O(2m*n) in both DFS and BFS as we are traversing the grid entirely in the
 * worst case scenario and then again we are checking that if there are
 * more ones or not. Although it seems that it should be O((m*n)^2) but actually its
 * O(2m*n).
 */

/**
 * Space Complexity:
 * It will be O(m*n) in case of DFS
 * In case of BFS it will be O(min(m,n))
 */


/**
 * Approach: We can have both dfs and bfs approach in it as it is a connected
 * component problem, change in one of the cells will have a ripple impact which
 * means it will affect the other cells too. The intution is if we encounter 1
 * it means we have encounter an island and we convert all the other 1s connected
 * to the former as 0s as they all are also the part of that island. Then we look
 * for other 1s in the grid and repeat the same pattern. And whenever we encounter
 * 1 we increase our count by 1.
 */


//DFS Solution
class Solution {
    vector<vector<int>> dirs;
public:
    int numIslands(vector<vector<char>>& grid) {
        dirs = {{0,1},{0,-1}, {1,0}, {-1,0}};
        int r= grid.size();
        int c= grid[0].size();
        int count = 0;
        for(int i =0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, r, c);
                }
            }
        }
        
        return count;
        
    }
    
    private:
    void dfs(vector<vector<char>> &grid, int i, int j, int r, int c){
        //base
        if(i<0 || j <0 || i == r || j == c|| grid[i][j] == '0') return;
        //logic
        grid[i][j] = '0';
        for (auto dir : dirs){
            int nR = i + dir[0];
            int nC = j + dir[1];
            dfs(grid, nR, nC, r, c);
        }
    }
};


//BFS Solution
class Solution {
    vector<vector<int>> dirs;
public:
    int numIslands(vector<vector<char>>& grid) {
        dirs = {{0,1},{0,-1}, {1,0}, {-1,0}};
        int r= grid.size();
        int c= grid[0].size();
        int count = 0;
        queue<vector<int>> q;
        for(int i =0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.push(vector<int> {i,j});
                    grid[i][j] = '0';
                    while(q.empty() == false){
                        vector<int> curr = q.front();
                        q.pop();
                        for(auto dir : dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >= 0 && nc >=0 && nr < r && nc < c && grid[nr][nc] == '1' ){
                                q.push(vector<int> {nr, nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
};