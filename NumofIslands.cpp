class Solution {
    vector<pair<int,int>>dirs{{-1,0},{0,-1},{1,0},{0,1}};
    void DFS(vector<vector<char>>& grid,int i , int j)
    {
        //base condition
        if(i <0 || j<0 || i>=grid.size() || j>=grid[0].size() ||grid[i][j]!='1')
            return;

        grid[i][j] = '0';
        //logic
        for(auto [dr,dc]: dirs)
        {
            int newr = i + dr;
            int newc = j + dc;
            DFS(grid,newr,newc);
        }
        return;
    }
public:
    int numIslands(vector<vector<char>>& grid) {
        int result =0;

        for(int i = 0; i < grid.size(); i++)
        {
            for(int j = 0; j< grid[0].size();j++)
            {
                if(grid[i][j]=='1')
                {
                    DFS(grid,i,j);
                    result++;
                }
            }
        }
        return result;
    }
};
//Time complexity O(mxn)
//space complexity O(mxn)
