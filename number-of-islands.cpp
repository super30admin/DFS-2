//Time complexity = O(n)
//Space O(max(r,c)) r-num of rows, c-num of columns
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int r = grid.size(), c = grid[0].size();
        int cnt = 0;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
    
    void dfs(vector<vector<char>>& grid, int r, int c){
        
        vector<vector<int>> dir {{1,0},{0,1},{-1,0},{0,-1}};
        stack<pair<int,int>> st;
        
        st.push(make_pair(r,c));
        
        while(!st.empty()){
            pair<int,int> p = st.top();
            st.pop();
            grid[p.first][p.second] = '0';
            for(auto d:dir){
                int x = p.first + d[0];
                int y = p.second + d[1];
                if(x>=0 && x<grid.size() && y>=0 && y<grid[0].size() && grid[x][y] == '1'){
                    grid[x][y] = '0';
                    st.push(make_pair(x,y));
                }
            }
            
            
        }
        return;
    }
};